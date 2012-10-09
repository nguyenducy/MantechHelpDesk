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
import mantech.mod.account.entity.Account;
import java.util.ArrayList;
import java.util.List;
import mantech.mod.account.entity.Profile;
import mantech.mod.account.jpa.exceptions.IllegalOrphanException;
import mantech.mod.account.jpa.exceptions.NonexistentEntityException;
import mantech.mod.account.jpa.exceptions.PreexistingEntityException;

/**
 *
 * @author NGUYEN
 */
public class ProfileJpaController {

    public ProfileJpaController() {
        emf = Persistence.createEntityManagerFactory("mantech_mod_jpaPU");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Profile profile) throws PreexistingEntityException, Exception {
        if (profile.getAccountList() == null) {
            profile.setAccountList(new ArrayList<Account>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Department department = profile.getDepartment();
            if (department != null) {
                department = em.getReference(department.getClass(), department.getId());
                profile.setDepartment(department);
            }
            List<Account> attachedAccountList = new ArrayList<Account>();
            for (Account accountListAccountToAttach : profile.getAccountList()) {
                accountListAccountToAttach = em.getReference(accountListAccountToAttach.getClass(), accountListAccountToAttach.getId());
                attachedAccountList.add(accountListAccountToAttach);
            }
            profile.setAccountList(attachedAccountList);
            em.persist(profile);
            if (department != null) {
                department.getProfileList().add(profile);
                department = em.merge(department);
            }
            for (Account accountListAccount : profile.getAccountList()) {
                Profile oldProfileOfAccountListAccount = accountListAccount.getProfile();
                accountListAccount.setProfile(profile);
                accountListAccount = em.merge(accountListAccount);
                if (oldProfileOfAccountListAccount != null) {
                    oldProfileOfAccountListAccount.getAccountList().remove(accountListAccount);
                    oldProfileOfAccountListAccount = em.merge(oldProfileOfAccountListAccount);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findProfile(profile.getId()) != null) {
                throw new PreexistingEntityException("Profile " + profile + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Profile profile) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Profile persistentProfile = em.find(Profile.class, profile.getId());
            Department departmentOld = persistentProfile.getDepartment();
            Department departmentNew = profile.getDepartment();
            List<Account> accountListOld = persistentProfile.getAccountList();
            List<Account> accountListNew = profile.getAccountList();
            List<String> illegalOrphanMessages = null;
            for (Account accountListOldAccount : accountListOld) {
                if (!accountListNew.contains(accountListOldAccount)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Account " + accountListOldAccount + " since its profile field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            if (departmentNew != null) {
                departmentNew = em.getReference(departmentNew.getClass(), departmentNew.getId());
                profile.setDepartment(departmentNew);
            }
            List<Account> attachedAccountListNew = new ArrayList<Account>();
            for (Account accountListNewAccountToAttach : accountListNew) {
                accountListNewAccountToAttach = em.getReference(accountListNewAccountToAttach.getClass(), accountListNewAccountToAttach.getId());
                attachedAccountListNew.add(accountListNewAccountToAttach);
            }
            accountListNew = attachedAccountListNew;
            profile.setAccountList(accountListNew);
            profile = em.merge(profile);
            if (departmentOld != null && !departmentOld.equals(departmentNew)) {
                departmentOld.getProfileList().remove(profile);
                departmentOld = em.merge(departmentOld);
            }
            if (departmentNew != null && !departmentNew.equals(departmentOld)) {
                departmentNew.getProfileList().add(profile);
                departmentNew = em.merge(departmentNew);
            }
            for (Account accountListNewAccount : accountListNew) {
                if (!accountListOld.contains(accountListNewAccount)) {
                    Profile oldProfileOfAccountListNewAccount = accountListNewAccount.getProfile();
                    accountListNewAccount.setProfile(profile);
                    accountListNewAccount = em.merge(accountListNewAccount);
                    if (oldProfileOfAccountListNewAccount != null && !oldProfileOfAccountListNewAccount.equals(profile)) {
                        oldProfileOfAccountListNewAccount.getAccountList().remove(accountListNewAccount);
                        oldProfileOfAccountListNewAccount = em.merge(oldProfileOfAccountListNewAccount);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = profile.getId();
                if (findProfile(id) == null) {
                    throw new NonexistentEntityException("The profile with id " + id + " no longer exists.");
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
            Profile profile;
            try {
                profile = em.getReference(Profile.class, id);
                profile.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The profile with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            List<Account> accountListOrphanCheck = profile.getAccountList();
            for (Account accountListOrphanCheckAccount : accountListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Profile (" + profile + ") cannot be destroyed since the Account " + accountListOrphanCheckAccount + " in its accountList field has a non-nullable profile field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Department department = profile.getDepartment();
            if (department != null) {
                department.getProfileList().remove(profile);
                department = em.merge(department);
            }
            em.remove(profile);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Profile> findProfileEntities() {
        return findProfileEntities(true, -1, -1);
    }

    public List<Profile> findProfileEntities(int maxResults, int firstResult) {
        return findProfileEntities(false, maxResults, firstResult);
    }

    private List<Profile> findProfileEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Profile.class));
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

    public Profile findProfile(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Profile.class, id);
        } finally {
            em.close();
        }
    }

    public int getProfileCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Profile> rt = cq.from(Profile.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

}
