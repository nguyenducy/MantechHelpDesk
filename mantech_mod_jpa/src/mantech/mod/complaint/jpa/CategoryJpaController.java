/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mantech.mod.complaint.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import mantech.mod.complaint.entity.Category;
import mantech.mod.complaint.entity.Complaint;
import java.util.ArrayList;
import java.util.List;
import mantech.mod.complaint.jpa.exceptions.IllegalOrphanException;
import mantech.mod.complaint.jpa.exceptions.NonexistentEntityException;

/**
 *
 * @author NGUYEN
 */
public class CategoryJpaController {

    public CategoryJpaController() {
        emf = Persistence.createEntityManagerFactory("mantech_mod_jpaPU");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Category category) {
        if (category.getComplaintList() == null) {
            category.setComplaintList(new ArrayList<Complaint>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<Complaint> attachedComplaintList = new ArrayList<Complaint>();
            for (Complaint complaintListComplaintToAttach : category.getComplaintList()) {
                complaintListComplaintToAttach = em.getReference(complaintListComplaintToAttach.getClass(), complaintListComplaintToAttach.getId());
                attachedComplaintList.add(complaintListComplaintToAttach);
            }
            category.setComplaintList(attachedComplaintList);
            em.persist(category);
            for (Complaint complaintListComplaint : category.getComplaintList()) {
                Category oldCategoryOfComplaintListComplaint = complaintListComplaint.getCategory();
                complaintListComplaint.setCategory(category);
                complaintListComplaint = em.merge(complaintListComplaint);
                if (oldCategoryOfComplaintListComplaint != null) {
                    oldCategoryOfComplaintListComplaint.getComplaintList().remove(complaintListComplaint);
                    oldCategoryOfComplaintListComplaint = em.merge(oldCategoryOfComplaintListComplaint);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Category category) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Category persistentCategory = em.find(Category.class, category.getId());
            List<Complaint> complaintListOld = persistentCategory.getComplaintList();
            List<Complaint> complaintListNew = category.getComplaintList();
            List<String> illegalOrphanMessages = null;
            for (Complaint complaintListOldComplaint : complaintListOld) {
                if (!complaintListNew.contains(complaintListOldComplaint)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Complaint " + complaintListOldComplaint + " since its category field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            List<Complaint> attachedComplaintListNew = new ArrayList<Complaint>();
            for (Complaint complaintListNewComplaintToAttach : complaintListNew) {
                complaintListNewComplaintToAttach = em.getReference(complaintListNewComplaintToAttach.getClass(), complaintListNewComplaintToAttach.getId());
                attachedComplaintListNew.add(complaintListNewComplaintToAttach);
            }
            complaintListNew = attachedComplaintListNew;
            category.setComplaintList(complaintListNew);
            category = em.merge(category);
            for (Complaint complaintListNewComplaint : complaintListNew) {
                if (!complaintListOld.contains(complaintListNewComplaint)) {
                    Category oldCategoryOfComplaintListNewComplaint = complaintListNewComplaint.getCategory();
                    complaintListNewComplaint.setCategory(category);
                    complaintListNewComplaint = em.merge(complaintListNewComplaint);
                    if (oldCategoryOfComplaintListNewComplaint != null && !oldCategoryOfComplaintListNewComplaint.equals(category)) {
                        oldCategoryOfComplaintListNewComplaint.getComplaintList().remove(complaintListNewComplaint);
                        oldCategoryOfComplaintListNewComplaint = em.merge(oldCategoryOfComplaintListNewComplaint);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = category.getId();
                if (findCategory(id) == null) {
                    throw new NonexistentEntityException("The category with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws IllegalOrphanException, NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Category category;
            try {
                category = em.getReference(Category.class, id);
                category.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The category with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            List<Complaint> complaintListOrphanCheck = category.getComplaintList();
            for (Complaint complaintListOrphanCheckComplaint : complaintListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Category (" + category + ") cannot be destroyed since the Complaint " + complaintListOrphanCheckComplaint + " in its complaintList field has a non-nullable category field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            em.remove(category);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Category> findCategoryEntities() {
        return findCategoryEntities(true, -1, -1);
    }

    public List<Category> findCategoryEntities(int maxResults, int firstResult) {
        return findCategoryEntities(false, maxResults, firstResult);
    }

    private List<Category> findCategoryEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Category.class));
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

    public Category findCategory(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Category.class, id);
        } finally {
            em.close();
        }
    }

    public int getCategoryCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Category> rt = cq.from(Category.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

}
