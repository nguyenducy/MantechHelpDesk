/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mantech.mod.complaint.jpa;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import mantech.mod.complaint.entity.Category;
import mantech.mod.account.entity.Profile;
import mantech.mod.complaint.entity.Complaint;
import mantech.mod.complaint.jpa.exceptions.NonexistentEntityException;

/**
 *
 * @author NGUYEN
 */
public class ComplaintJpaController {

    public ComplaintJpaController() {
        emf = Persistence.createEntityManagerFactory("mantech_mod_jpaPU");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Complaint complaint) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Category category = complaint.getCategory();
            if (category != null) {
                category = em.getReference(category.getClass(), category.getId());
                complaint.setCategory(category);
            }
            Profile profile = complaint.getProfile();
            if (profile != null) {
                profile = em.getReference(profile.getClass(), profile.getId());
                complaint.setProfile(profile);
            }
            em.persist(complaint);
            if (category != null) {
                category.getComplaintList().add(complaint);
                category = em.merge(category);
            }
            if (profile != null) {
                profile.getComplaintList().add(complaint);
                profile = em.merge(profile);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Complaint complaint) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Complaint persistentComplaint = em.find(Complaint.class, complaint.getId());
            Category categoryOld = persistentComplaint.getCategory();
            Category categoryNew = complaint.getCategory();
            Profile profileOld = persistentComplaint.getProfile();
            Profile profileNew = complaint.getProfile();
            if (categoryNew != null) {
                categoryNew = em.getReference(categoryNew.getClass(), categoryNew.getId());
                complaint.setCategory(categoryNew);
            }
            if (profileNew != null) {
                profileNew = em.getReference(profileNew.getClass(), profileNew.getId());
                complaint.setProfile(profileNew);
            }
            complaint = em.merge(complaint);
            if (categoryOld != null && !categoryOld.equals(categoryNew)) {
                categoryOld.getComplaintList().remove(complaint);
                categoryOld = em.merge(categoryOld);
            }
            if (categoryNew != null && !categoryNew.equals(categoryOld)) {
                categoryNew.getComplaintList().add(complaint);
                categoryNew = em.merge(categoryNew);
            }
            if (profileOld != null && !profileOld.equals(profileNew)) {
                profileOld.getComplaintList().remove(complaint);
                profileOld = em.merge(profileOld);
            }
            if (profileNew != null && !profileNew.equals(profileOld)) {
                profileNew.getComplaintList().add(complaint);
                profileNew = em.merge(profileNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = complaint.getId();
                if (findComplaint(id) == null) {
                    throw new NonexistentEntityException("The complaint with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Complaint complaint;
            try {
                complaint = em.getReference(Complaint.class, id);
                complaint.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The complaint with id " + id + " no longer exists.", enfe);
            }
            Category category = complaint.getCategory();
            if (category != null) {
                category.getComplaintList().remove(complaint);
                category = em.merge(category);
            }
            Profile profile = complaint.getProfile();
            if (profile != null) {
                profile.getComplaintList().remove(complaint);
                profile = em.merge(profile);
            }
            em.remove(complaint);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Complaint> findComplaintEntities() {
        return findComplaintEntities(true, -1, -1);
    }

    public List<Complaint> findComplaintEntities(int maxResults, int firstResult) {
        return findComplaintEntities(false, maxResults, firstResult);
    }

    private List<Complaint> findComplaintEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Complaint.class));
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

    public Complaint findComplaint(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Complaint.class, id);
        } finally {
            em.close();
        }
    }

    public int getComplaintCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Complaint> rt = cq.from(Complaint.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

}
