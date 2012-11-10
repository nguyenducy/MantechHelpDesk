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
public interface AccountBiz {

    boolean create(Account account);

    boolean edit(Account account);

    boolean remove(int id);

    List<Account> findAll();

    Account checkLogin(String username, String password);

    boolean usernameAvailable(String username);

    List<Account> find(int length, int start);

    boolean changePassword(String username, String newPass);

    Account findByID(int id);
}
