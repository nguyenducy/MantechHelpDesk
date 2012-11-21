/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mantech.mod.account.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import mantech.mod.account.entity.Job;
import mantech.mod.account.entity.Profile;
import java.util.ArrayList;
import java.util.List;
import mantech.mod.account.jpa.exceptions.IllegalOrphanException;
import mantech.mod.account.jpa.exceptions.NonexistentEntityException;

/**
 *
 * @author NGUYEN
 */
public class JobJpaController {

    public JobJpaController() {
        emf = Persistence.createEntityManagerFactory("mantech_mod_jpaPU");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Job job) {
        if (job.getProfileList() == null) {
            job.setProfileList(new ArrayList<Profile>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<Profile> attachedProfileList = new ArrayList<Profile>();
            for (Profile profileListProfileToAttach : job.getProfileList()) {
                profileListProfileToAttach = em.getReference(profileListProfileToAttach.getClass(), profileListProfileToAttach.getId());
                attachedProfileList.add(profileListProfileToAttach);
            }
            job.setProfileList(attachedProfileList);
            em.persist(job);
            for (Profile profileListProfile : job.getProfileList()) {
                Job oldJobOfProfileListProfile = profileListProfile.getJob();
                profileListProfile.setJob(job);
                profileListProfile = em.merge(profileListProfile);
                if (oldJobOfProfileListProfile != null) {
                    oldJobOfProfileListProfile.getProfileList().remove(profileListProfile);
                    oldJobOfProfileListProfile = em.merge(oldJobOfProfileListProfile);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Job job) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Job persistentJob = em.find(Job.class, job.getId());
            List<Profile> profileListOld = persistentJob.getProfileList();
            List<Profile> profileListNew = job.getProfileList();
            List<String> illegalOrphanMessages = null;
            for (Profile profileListOldProfile : profileListOld) {
                if (!profileListNew.contains(profileListOldProfile)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Profile " + profileListOldProfile + " since its job field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            List<Profile> attachedProfileListNew = new ArrayList<Profile>();
            for (Profile profileListNewProfileToAttach : profileListNew) {
                profileListNewProfileToAttach = em.getReference(profileListNewProfileToAttach.getClass(), profileListNewProfileToAttach.getId());
                attachedProfileListNew.add(profileListNewProfileToAttach);
            }
            profileListNew = attachedProfileListNew;
            job.setProfileList(profileListNew);
            job = em.merge(job);
            for (Profile profileListNewProfile : profileListNew) {
                if (!profileListOld.contains(profileListNewProfile)) {
                    Job oldJobOfProfileListNewProfile = profileListNewProfile.getJob();
                    profileListNewProfile.setJob(job);
                    profileListNewProfile = em.merge(profileListNewProfile);
                    if (oldJobOfProfileListNewProfile != null && !oldJobOfProfileListNewProfile.equals(job)) {
                        oldJobOfProfileListNewProfile.getProfileList().remove(profileListNewProfile);
                        oldJobOfProfileListNewProfile = em.merge(oldJobOfProfileListNewProfile);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = job.getId();
                if (findJob(id) == null) {
                    throw new NonexistentEntityException("The job with id " + id + " no longer exists.");
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
            Job job;
            try {
                job = em.getReference(Job.class, id);
                job.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The job with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            List<Profile> profileListOrphanCheck = job.getProfileList();
            for (Profile profileListOrphanCheckProfile : profileListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Job (" + job + ") cannot be destroyed since the Profile " + profileListOrphanCheckProfile + " in its profileList field has a non-nullable job field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            em.remove(job);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Job> findJobEntities() {
        return findJobEntities(true, -1, -1);
    }

    public List<Job> findJobEntities(int maxResults, int firstResult) {
        return findJobEntities(false, maxResults, firstResult);
    }

    private List<Job> findJobEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Job.class));
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

    public Job findJob(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Job.class, id);
        } finally {
            em.close();
        }
    }

    public int getJobCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Job> rt = cq.from(Job.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

}
