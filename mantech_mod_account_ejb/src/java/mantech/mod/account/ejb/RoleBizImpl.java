/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mantech.mod.account.ejb;

import java.util.List;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import mantech.mod.account.api.RoleBiz;
import mantech.mod.account.entity.Role;
import mantech.mod.account.jpa.RoleJpaController;

/**
 *
 * @author NGUYEN
 */
@Stateless(name = "RoleBiz", mappedName = "ejb/mantech/saigon/RoleBiz")
@Remote(mantech.mod.account.api.RoleBiz.class)
public class RoleBizImpl implements RoleBiz {

    @Override
    public boolean create(Role role) {
        try {
            RoleJpaController controller = new RoleJpaController();
            controller.create(role);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean edit(Role role) {
        try {
            RoleJpaController controller = new RoleJpaController();
            controller.edit(role);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean remove(int id) {
        try {
            RoleJpaController controller = new RoleJpaController();
            controller.destroy(id);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<Role> findAll() {
        try {
            RoleJpaController controller = new RoleJpaController();
            return controller.findRoleEntities();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Role> find(int length, int start) {
        try {
            RoleJpaController controller = new RoleJpaController();
            return controller.findRoleEntities(length, start);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
