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
import mantech.mod.account.entity.Department;
import mantech.mod.account.entity.Profile;
import java.util.ArrayList;
import java.util.List;
import mantech.mod.account.jpa.exceptions.IllegalOrphanException;
import mantech.mod.account.jpa.exceptions.NonexistentEntityException;

/**
 *
 * @author NGUYEN
 */
public class DepartmentJpaController {

    public DepartmentJpaController() {
        emf = Persistence.createEntityManagerFactory("mantech_mod_jpaPU");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Department department) {
        if (department.getProfileList() == null) {
            department.setProfileList(new ArrayList<Profile>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<Profile> attachedProfileList = new ArrayList<Profile>();
            for (Profile profileListProfileToAttach : department.getProfileList()) {
                profileListProfileToAttach = em.getReference(profileListProfileToAttach.getClass(), profileListProfileToAttach.getId());
                attachedProfileList.add(profileListProfileToAttach);
            }
            department.setProfileList(attachedProfileList);
            em.persist(department);
            for (Profile profileListProfile : department.getProfileList()) {
                Department oldDepartmentOfProfileListProfile = profileListProfile.getDepartment();
                profileListProfile.setDepartment(department);
                profileListProfile = em.merge(profileListProfile);
                if (oldDepartmentOfProfileListProfile != null) {
                    oldDepartmentOfProfileListProfile.getProfileList().remove(profileListProfile);
                    oldDepartmentOfProfileListProfile = em.merge(oldDepartmentOfProfileListProfile);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Department department) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Department persistentDepartment = em.find(Department.class, department.getId());
            List<Profile> profileListOld = persistentDepartment.getProfileList();
            List<Profile> profileListNew = department.getProfileList();
            List<String> illegalOrphanMessages = null;
            for (Profile profileListOldProfile : profileListOld) {
                if (!profileListNew.contains(profileListOldProfile)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Profile " + profileListOldProfile + " since its department field is not nullable.");
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
            department.setProfileList(profileListNew);
            department = em.merge(department);
            for (Profile profileListNewProfile : profileListNew) {
                if (!profileListOld.contains(profileListNewProfile)) {
                    Department oldDepartmentOfProfileListNewProfile = profileListNewProfile.getDepartment();
                    profileListNewProfile.setDepartment(department);
                    profileListNewProfile = em.merge(profileListNewProfile);
                    if (oldDepartmentOfProfileListNewProfile != null && !oldDepartmentOfProfileListNewProfile.equals(department)) {
                        oldDepartmentOfProfileListNewProfile.getProfileList().remove(profileListNewProfile);
                        oldDepartmentOfProfileListNewProfile = em.merge(oldDepartmentOfProfileListNewProfile);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = department.getId();
                if (findDepartment(id) == null) {
                    throw new NonexistentEntityException("The department with id " + id + " no longer exists.");
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
            Department department;
            try {
                department = em.getReference(Department.class, id);
                department.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The department with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            List<Profile> profileListOrphanCheck = department.getProfileList();
            for (Profile profileListOrphanCheckProfile : profileListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Department (" + department + ") cannot be destroyed since the Profile " + profileListOrphanCheckProfile + " in its profileList field has a non-nullable department field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            em.remove(department);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Department> findDepartmentEntities() {
        return findDepartmentEntities(true, -1, -1);
    }

    public List<Department> findDepartmentEntities(int maxResults, int firstResult) {
        return findDepartmentEntities(false, maxResults, firstResult);
    }

    private List<Department> findDepartmentEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Department.class));
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

    public Department findDepartment(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Department.class, id);
        } finally {
            em.close();
        }
    }

    public int getDepartmentCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Department> rt = cq.from(Department.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

}
