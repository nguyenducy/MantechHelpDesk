/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mantech.mod.account.api;

import java.util.List;
import mantech.mod.account.entity.Account;

/**
 *
 * @author NDC
 */
public interface AdminAccountBiz {

    void create(Account account);

    void edit(Account account);

    void remove(Account account);

    Account find(Object id);

    List<Account> findAll();

    Account checkLogin(String username, String password);

    List<Account> findByRole(String roleId);
    // Updapte role admin or user

    boolean unvailableAccount(String id);
}
