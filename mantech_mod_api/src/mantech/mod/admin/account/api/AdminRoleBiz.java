/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mantech.mod.admin.account.api;

import java.util.List;
import mantech.mod.account.entity.Role;

/**
 *
 * @author NDC
 */
public interface AdminRoleBiz {

    void create(Role role);

    void edit(Role role);

    void remove(Role role);

    Role find(Object id);

    List<Role> findAll();
}
