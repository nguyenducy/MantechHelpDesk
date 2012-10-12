/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mantech.mod.article.jpa;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import mantech.mod.article.api.dal.AdminFAQDal;
import mantech.mod.article.entity.Faq;
import mantech.mod.article.jpa.exceptions.NonexistentEntityException;

/**
 *
 * @author NGUYEN
 */
public class FaqJpaController implements AdminFAQDal {

    final String findAllQuery = "Faq.findAll";
    final String findByIdQuery = "Faq.findById";
    final String findQuestionQuery = "Faq.findQuestion";

    public FaqJpaController() {
        emf = Persistence.createEntityManagerFactory("mantech_mod_jpaPU");
    }

    public FaqJpaController(EntityManagerFactory entityManagerFactory) {
        this.emf = entityManagerFactory;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    private void create(Faq faq) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(faq);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    private void edit(Faq faq) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            faq = em.merge(faq);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = faq.getId();
                if (findFaq(id) == null) {
                    throw new NonexistentEntityException("The faq with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    private void destroy(Integer id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Faq faq;
            try {
                faq = em.getReference(Faq.class, id);
                faq.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The faq with id " + id + " no longer exists.", enfe);
            }
            em.remove(faq);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    private List<Faq> findFaqEntities() {
        return findFaqEntities(true, -1, -1);
    }

    public List<Faq> findFaqEntities(int maxResults, int firstResult) {
        return findFaqEntities(false, maxResults, firstResult);
    }

    private List<Faq> findFaqEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Faq.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    private Faq findFaq(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Faq.class, id);
        } finally {
            em.close();
        }
    }

    public int getFaqCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Faq> rt = cq.from(Faq.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

    public boolean createFAQ(Faq faq) {
        boolean check = false;
        try {
            this.create(faq);
            check = true;
        } catch (Exception ex) {
            check = false;
            ex.printStackTrace();
        }
        return check;
    }

    public boolean editFAQ(Faq faq) {
        boolean check = false;
        try {
            this.edit(faq);
            check = true;
        } catch (NonexistentEntityException ex) {
            check = false;
            ex.printStackTrace();
        } catch (Exception ex) {
            check = false;
            ex.printStackTrace();
        }
        return check;
    }

    public boolean removeFAQ(int faqId) {
        boolean check = false;
        try {
            this.destroy(faqId);
            check = true;
        } catch (NonexistentEntityException ex) {
            check = false;
            ex.printStackTrace();
        }
        return check;
    }

    public Faq findFAQById(int fqaId) {
        Faq faq = null;
        if (fqaId > 0) {
            faq = this.findFaq(fqaId);
        }
        return faq;
    }

    public List<Faq> listAllFAQ() {
        List<Faq> faqs = this.findFaqEntities();
        return faqs;
    }

    public List<Faq> findQuestion(String question) {
        List<Faq> listFaq = null;
        if(question!=null && !question.isEmpty()){
           EntityManager em = this.getEntityManager();
           
           Query query = em.createNamedQuery(this.findQuestionQuery);
           String parameterQuestion = "%"+question+"%";
           query.setParameter("question", parameterQuestion);

           listFaq = query.getResultList();
        }
        return listFaq;
    }
}
