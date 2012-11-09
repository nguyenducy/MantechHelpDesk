/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mantech.mod.account.api;

import java.util.List;
import mantech.mod.account.entity.Role;

/**
 *
 * @author NDC
 */
public interface RoleBiz {

    boolean create(Role role);

    boolean edit(Role role);

    boolean remove(int id);

    List<Role> findAll();

    List<Role> find(int length, int start);
}
