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
import mantech.mod.complaint.entity.Complaint;
import java.util.ArrayList;
import java.util.List;
import mantech.mod.complaint.entity.Technician;
import mantech.mod.complaint.jpa.exceptions.NonexistentEntityException;

/**
 *
 * @author NGUYEN
 */
public class TechnicianJpaController {

    public TechnicianJpaController() {
        emf = Persistence.createEntityManagerFactory("mantech_mod_jpaPU");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Technician technician) {
        if (technician.getComplaintList() == null) {
            technician.setComplaintList(new ArrayList<Complaint>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<Complaint> attachedComplaintList = new ArrayList<Complaint>();
            for (Complaint complaintListComplaintToAttach : technician.getComplaintList()) {
                complaintListComplaintToAttach = em.getReference(complaintListComplaintToAttach.getClass(), complaintListComplaintToAttach.getId());
                attachedComplaintList.add(complaintListComplaintToAttach);
            }
            technician.setComplaintList(attachedComplaintList);
            em.persist(technician);
            for (Complaint complaintListComplaint : technician.getComplaintList()) {
                Technician oldTechnicianOfComplaintListComplaint = complaintListComplaint.getTechnician();
                complaintListComplaint.setTechnician(technician);
                complaintListComplaint = em.merge(complaintListComplaint);
                if (oldTechnicianOfComplaintListComplaint != null) {
                    oldTechnicianOfComplaintListComplaint.getComplaintList().remove(complaintListComplaint);
                    oldTechnicianOfComplaintListComplaint = em.merge(oldTechnicianOfComplaintListComplaint);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Technician technician) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Technician persistentTechnician = em.find(Technician.class, technician.getId());
            List<Complaint> complaintListOld = persistentTechnician.getComplaintList();
            List<Complaint> complaintListNew = technician.getComplaintList();
            List<Complaint> attachedComplaintListNew = new ArrayList<Complaint>();
            for (Complaint complaintListNewComplaintToAttach : complaintListNew) {
                complaintListNewComplaintToAttach = em.getReference(complaintListNewComplaintToAttach.getClass(), complaintListNewComplaintToAttach.getId());
                attachedComplaintListNew.add(complaintListNewComplaintToAttach);
            }
            complaintListNew = attachedComplaintListNew;
            technician.setComplaintList(complaintListNew);
            technician = em.merge(technician);
            for (Complaint complaintListOldComplaint : complaintListOld) {
                if (!complaintListNew.contains(complaintListOldComplaint)) {
                    complaintListOldComplaint.setTechnician(null);
                    complaintListOldComplaint = em.merge(complaintListOldComplaint);
                }
            }
            for (Complaint complaintListNewComplaint : complaintListNew) {
                if (!complaintListOld.contains(complaintListNewComplaint)) {
                    Technician oldTechnicianOfComplaintListNewComplaint = complaintListNewComplaint.getTechnician();
                    complaintListNewComplaint.setTechnician(technician);
                    complaintListNewComplaint = em.merge(complaintListNewComplaint);
                    if (oldTechnicianOfComplaintListNewComplaint != null && !oldTechnicianOfComplaintListNewComplaint.equals(technician)) {
                        oldTechnicianOfComplaintListNewComplaint.getComplaintList().remove(complaintListNewComplaint);
                        oldTechnicianOfComplaintListNewComplaint = em.merge(oldTechnicianOfComplaintListNewComplaint);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = technician.getId();
                if (findTechnician(id) == null) {
                    throw new NonexistentEntityException("The technician with id " + id + " no longer exists.");
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
            Technician technician;
            try {
                technician = em.getReference(Technician.class, id);
                technician.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The technician with id " + id + " no longer exists.", enfe);
            }
            List<Complaint> complaintList = technician.getComplaintList();
            for (Complaint complaintListComplaint : complaintList) {
                complaintListComplaint.setTechnician(null);
                complaintListComplaint = em.merge(complaintListComplaint);
            }
            em.remove(technician);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Technician> findTechnicianEntities() {
        return findTechnicianEntities(true, -1, -1);
    }

    public List<Technician> findTechnicianEntities(int maxResults, int firstResult) {
        return findTechnicianEntities(false, maxResults, firstResult);
    }

    private List<Technician> findTechnicianEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Technician.class));
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

    public Technician findTechnician(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Technician.class, id);
        } finally {
            em.close();
        }
    }

    public int getTechnicianCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Technician> rt = cq.from(Technician.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

}
