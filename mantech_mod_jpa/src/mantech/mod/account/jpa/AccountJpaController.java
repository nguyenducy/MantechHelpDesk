/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mantech.mod.account.jpa;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import mantech.mod.account.entity.Account;
import mantech.mod.account.entity.Role;
import mantech.mod.account.entity.Profile;
import mantech.mod.account.jpa.exceptions.NonexistentEntityException;
import mantech.mod.account.jpa.exceptions.PreexistingEntityException;

/**
 *
 * @author NGUYEN
 */
public class AccountJpaController {

    public AccountJpaController() {
        emf = Persistence.createEntityManagerFactory("mantech_mod_jpaPU");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Account account) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Role role = account.getRole();
            if (role != null) {
                role = em.getReference(role.getClass(), role.getId());
                account.setRole(role);
            }
            Profile profile = account.getProfile();
            if (profile != null) {
                profile = em.getReference(profile.getClass(), profile.getId());
                account.setProfile(profile);
            }
            em.persist(account);
            if (role != null) {
                role.getAccountList().add(account);
                role = em.merge(role);
            }
            if (profile != null) {
                profile.getAccountList().add(account);
                profile = em.merge(profile);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findAccount(account.getId()) != null) {
                throw new PreexistingEntityException("Account " + account + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Account account) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Account persistentAccount = em.find(Account.class, account.getId());
            Role roleOld = persistentAccount.getRole();
            Role roleNew = account.getRole();
            Profile profileOld = persistentAccount.getProfile();
            Profile profileNew = account.getProfile();
            if (roleNew != null) {
                roleNew = em.getReference(roleNew.getClass(), roleNew.getId());
                account.setRole(roleNew);
            }
            if (profileNew != null) {
                profileNew = em.getReference(profileNew.getClass(), profileNew.getId());
                account.setProfile(profileNew);
            }
            account = em.merge(account);
            if (roleOld != null && !roleOld.equals(roleNew)) {
                roleOld.getAccountList().remove(account);
                roleOld = em.merge(roleOld);
            }
            if (roleNew != null && !roleNew.equals(roleOld)) {
                roleNew.getAccountList().add(account);
                roleNew = em.merge(roleNew);
            }
            if (profileOld != null && !profileOld.equals(profileNew)) {
                profileOld.getAccountList().remove(account);
                profileOld = em.merge(profileOld);
            }
            if (profileNew != null && !profileNew.equals(profileOld)) {
                profileNew.getAccountList().add(account);
                profileNew = em.merge(profileNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = account.getId();
                if (findAccount(id) == null) {
                    throw new NonexistentEntityException("The account with id " + id + " no longer exists.");
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
            Account account;
            try {
                account = em.getReference(Account.class, id);
                account.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The account with id " + id + " no longer exists.", enfe);
            }
            Role role = account.getRole();
            if (role != null) {
                role.getAccountList().remove(account);
                role = em.merge(role);
            }
            Profile profile = account.getProfile();
            if (profile != null) {
                profile.getAccountList().remove(account);
                profile = em.merge(profile);
            }
            em.remove(account);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Account> findAccountEntities() {
        return findAccountEntities(true, -1, -1);
    }

    public List<Account> findAccountEntities(int maxResults, int firstResult) {
        return findAccountEntities(false, maxResults, firstResult);
    }

    private List<Account> findAccountEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Account.class));
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

    public Account findAccount(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Account.class, id);
        } finally {
            em.close();
        }
    }

    public int getAccountCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Account> rt = cq.from(Account.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

}
