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
import mantech.mod.complaint.entity.Complaint;
import mantech.mod.complaint.entity.Technician;
import mantech.mod.complaint.entity.Category;
import mantech.mod.complaint.jpa.exceptions.NonexistentEntityException;
import mantech.mod.complaint.jpa.exceptions.PreexistingEntityException;

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

    public void create(Complaint complaint) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Technician technician = complaint.getTechnician();
            if (technician != null) {
                technician = em.getReference(technician.getClass(), technician.getId());
                complaint.setTechnician(technician);
            }
            Category category = complaint.getCategory();
            if (category != null) {
                category = em.getReference(category.getClass(), category.getId());
                complaint.setCategory(category);
            }
            em.persist(complaint);
            if (technician != null) {
                technician.getComplaintList().add(complaint);
                technician = em.merge(technician);
            }
            if (category != null) {
                category.getComplaintList().add(complaint);
                category = em.merge(category);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findComplaint(complaint.getId()) != null) {
                throw new PreexistingEntityException("Complaint " + complaint + " already exists.", ex);
            }
            throw ex;
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
            Technician technicianOld = persistentComplaint.getTechnician();
            Technician technicianNew = complaint.getTechnician();
            Category categoryOld = persistentComplaint.getCategory();
            Category categoryNew = complaint.getCategory();
            if (technicianNew != null) {
                technicianNew = em.getReference(technicianNew.getClass(), technicianNew.getId());
                complaint.setTechnician(technicianNew);
            }
            if (categoryNew != null) {
                categoryNew = em.getReference(categoryNew.getClass(), categoryNew.getId());
                complaint.setCategory(categoryNew);
            }
            complaint = em.merge(complaint);
            if (technicianOld != null && !technicianOld.equals(technicianNew)) {
                technicianOld.getComplaintList().remove(complaint);
                technicianOld = em.merge(technicianOld);
            }
            if (technicianNew != null && !technicianNew.equals(technicianOld)) {
                technicianNew.getComplaintList().add(complaint);
                technicianNew = em.merge(technicianNew);
            }
            if (categoryOld != null && !categoryOld.equals(categoryNew)) {
                categoryOld.getComplaintList().remove(complaint);
                categoryOld = em.merge(categoryOld);
            }
            if (categoryNew != null && !categoryNew.equals(categoryOld)) {
                categoryNew.getComplaintList().add(complaint);
                categoryNew = em.merge(categoryNew);
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
            Technician technician = complaint.getTechnician();
            if (technician != null) {
                technician.getComplaintList().remove(complaint);
                technician = em.merge(technician);
            }
            Category category = complaint.getCategory();
            if (category != null) {
                category.getComplaintList().remove(complaint);
                category = em.merge(category);
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
