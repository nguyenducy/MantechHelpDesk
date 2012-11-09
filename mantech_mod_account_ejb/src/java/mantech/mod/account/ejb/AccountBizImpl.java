/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mantech.mod.account.ejb;

import java.util.List;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import mantech.mod.account.api.AccountBiz;
import mantech.mod.account.entity.Account;
import mantech.mod.account.jpa.AccountJpaController;

/**
 *
 * @author NGUYEN
 */
@Stateless(name = "AccountBiz", mappedName = "ejb/mantech/saigon/AccountBiz")
@Remote(mantech.mod.account.api.AccountBiz.class)
public class AccountBizImpl implements AccountBiz {

    @Override
    public boolean create(Account account) {
        try {
            AccountJpaController controller = new AccountJpaController();
            controller.create(account);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean edit(Account account) {
        try {
            AccountJpaController controller = new AccountJpaController();
            controller.edit(account);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean remove(int id) {
        try {
            AccountJpaController controller = new AccountJpaController();
            controller.destroy(id);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<Account> findAll() {
        try {
            AccountJpaController controller = new AccountJpaController();
            return controller.findAccountEntities();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Account checkLogin(String username, String password) {
        try {
            AccountJpaController controller = new AccountJpaController();
            return controller.findAccountByUserNameAndPassword(username, password);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean usernameAvailable(String username) {
        try {
            AccountJpaController controller = new AccountJpaController();
            controller.findAccountByUserName(username);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<Account> find(int length, int start) {
        try {
            AccountJpaController controller = new AccountJpaController();
            return controller.findAccountEntities(length, start);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean changePassword(String username, String newPass) {
        try {
            AccountJpaController controller = new AccountJpaController();
            Account a = controller.findAccountByUserName(username);
            a.setPassword(newPass);
            controller.edit(a);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Account findByID(int id) {
        try {
            AccountJpaController controller = new AccountJpaController();
            return controller.findAccount(id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
