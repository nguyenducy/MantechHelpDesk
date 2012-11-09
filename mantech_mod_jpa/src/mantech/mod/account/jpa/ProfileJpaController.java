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
import mantech.mod.account.entity.Job;
import mantech.mod.account.entity.Account;
import java.util.ArrayList;
import java.util.List;
import mantech.mod.account.entity.Profile;
import mantech.mod.account.jpa.exceptions.IllegalOrphanException;
import mantech.mod.account.jpa.exceptions.NonexistentEntityException;
import mantech.mod.complaint.entity.Complaint;

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

    public void create(Profile profile) {
        if (profile.getAccountList() == null) {
            profile.setAccountList(new ArrayList<Account>());
        }
        if (profile.getComplaintList() == null) {
            profile.setComplaintList(new ArrayList<Complaint>());
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
            Job job = profile.getJob();
            if (job != null) {
                job = em.getReference(job.getClass(), job.getId());
                profile.setJob(job);
            }
            List<Account> attachedAccountList = new ArrayList<Account>();
            for (Account accountListAccountToAttach : profile.getAccountList()) {
                accountListAccountToAttach = em.getReference(accountListAccountToAttach.getClass(), accountListAccountToAttach.getId());
                attachedAccountList.add(accountListAccountToAttach);
            }
            profile.setAccountList(attachedAccountList);
            List<Complaint> attachedComplaintList = new ArrayList<Complaint>();
            for (Complaint complaintListComplaintToAttach : profile.getComplaintList()) {
                complaintListComplaintToAttach = em.getReference(complaintListComplaintToAttach.getClass(), complaintListComplaintToAttach.getId());
                attachedComplaintList.add(complaintListComplaintToAttach);
            }
            profile.setComplaintList(attachedComplaintList);
            em.persist(profile);
            if (department != null) {
                department.getProfileList().add(profile);
                department = em.merge(department);
            }
            if (job != null) {
                job.getProfileList().add(profile);
                job = em.merge(job);
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
            for (Complaint complaintListComplaint : profile.getComplaintList()) {
                Profile oldProfileOfComplaintListComplaint = complaintListComplaint.getProfile();
                complaintListComplaint.setProfile(profile);
                complaintListComplaint = em.merge(complaintListComplaint);
                if (oldProfileOfComplaintListComplaint != null) {
                    oldProfileOfComplaintListComplaint.getComplaintList().remove(complaintListComplaint);
                    oldProfileOfComplaintListComplaint = em.merge(oldProfileOfComplaintListComplaint);
                }
            }
            em.getTransaction().commit();
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
            Job jobOld = persistentProfile.getJob();
            Job jobNew = profile.getJob();
            List<Account> accountListOld = persistentProfile.getAccountList();
            List<Account> accountListNew = profile.getAccountList();
            List<Complaint> complaintListOld = persistentProfile.getComplaintList();
            List<Complaint> complaintListNew = profile.getComplaintList();
            List<String> illegalOrphanMessages = null;
            for (Account accountListOldAccount : accountListOld) {
                if (!accountListNew.contains(accountListOldAccount)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Account " + accountListOldAccount + " since its profile field is not nullable.");
                }
            }
            for (Complaint complaintListOldComplaint : complaintListOld) {
                if (!complaintListNew.contains(complaintListOldComplaint)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Complaint " + complaintListOldComplaint + " since its profile field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            if (departmentNew != null) {
                departmentNew = em.getReference(departmentNew.getClass(), departmentNew.getId());
                profile.setDepartment(departmentNew);
            }
            if (jobNew != null) {
                jobNew = em.getReference(jobNew.getClass(), jobNew.getId());
                profile.setJob(jobNew);
            }
            List<Account> attachedAccountListNew = new ArrayList<Account>();
            for (Account accountListNewAccountToAttach : accountListNew) {
                accountListNewAccountToAttach = em.getReference(accountListNewAccountToAttach.getClass(), accountListNewAccountToAttach.getId());
                attachedAccountListNew.add(accountListNewAccountToAttach);
            }
            accountListNew = attachedAccountListNew;
            profile.setAccountList(accountListNew);
            List<Complaint> attachedComplaintListNew = new ArrayList<Complaint>();
            for (Complaint complaintListNewComplaintToAttach : complaintListNew) {
                complaintListNewComplaintToAttach = em.getReference(complaintListNewComplaintToAttach.getClass(), complaintListNewComplaintToAttach.getId());
                attachedComplaintListNew.add(complaintListNewComplaintToAttach);
            }
            complaintListNew = attachedComplaintListNew;
            profile.setComplaintList(complaintListNew);
            profile = em.merge(profile);
            if (departmentOld != null && !departmentOld.equals(departmentNew)) {
                departmentOld.getProfileList().remove(profile);
                departmentOld = em.merge(departmentOld);
            }
            if (departmentNew != null && !departmentNew.equals(departmentOld)) {
                departmentNew.getProfileList().add(profile);
                departmentNew = em.merge(departmentNew);
            }
            if (jobOld != null && !jobOld.equals(jobNew)) {
                jobOld.getProfileList().remove(profile);
                jobOld = em.merge(jobOld);
            }
            if (jobNew != null && !jobNew.equals(jobOld)) {
                jobNew.getProfileList().add(profile);
                jobNew = em.merge(jobNew);
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
            for (Complaint complaintListNewComplaint : complaintListNew) {
                if (!complaintListOld.contains(complaintListNewComplaint)) {
                    Profile oldProfileOfComplaintListNewComplaint = complaintListNewComplaint.getProfile();
                    complaintListNewComplaint.setProfile(profile);
                    complaintListNewComplaint = em.merge(complaintListNewComplaint);
                    if (oldProfileOfComplaintListNewComplaint != null && !oldProfileOfComplaintListNewComplaint.equals(profile)) {
                        oldProfileOfComplaintListNewComplaint.getComplaintList().remove(complaintListNewComplaint);
                        oldProfileOfComplaintListNewComplaint = em.merge(oldProfileOfComplaintListNewComplaint);
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
            List<Complaint> complaintListOrphanCheck = profile.getComplaintList();
            for (Complaint complaintListOrphanCheckComplaint : complaintListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Profile (" + profile + ") cannot be destroyed since the Complaint " + complaintListOrphanCheckComplaint + " in its complaintList field has a non-nullable profile field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Department department = profile.getDepartment();
            if (department != null) {
                department.getProfileList().remove(profile);
                department = em.merge(department);
            }
            Job job = profile.getJob();
            if (job != null) {
                job.getProfileList().remove(profile);
                job = em.merge(job);
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
