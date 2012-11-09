/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mantech.mod.account.ejb;

import java.util.List;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import mantech.mod.account.api.DepartmentBiz;
import mantech.mod.account.entity.Department;
import mantech.mod.account.jpa.DepartmentJpaController;

/**
 *
 * @author NGUYEN
 */
@Stateless(name = "DepartmentBiz", mappedName = "ejb/mantech/saigon/DepartmentBiz")
@Remote(mantech.mod.account.api.DepartmentBiz.class)
public class DepartmentBizImpl implements DepartmentBiz{

    @Override
    public boolean create(Department department) {
        try {
            DepartmentJpaController controller = new DepartmentJpaController();
            controller.create(department);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean edit(Department department) {
        try {
            DepartmentJpaController controller = new DepartmentJpaController();
            controller.edit(department);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean remove(int id) {
        try {
            DepartmentJpaController controller = new DepartmentJpaController();
            controller.destroy(id);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Department find(int id) {
        try {
            DepartmentJpaController controller = new DepartmentJpaController();
            return controller.findDepartment(id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Department> findAll() {
        try {
            DepartmentJpaController controller = new DepartmentJpaController();
            return controller.findDepartmentEntities();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Department> find(int length, int start) {
        try {
            DepartmentJpaController controller = new DepartmentJpaController();
            return controller.findDepartmentEntities(length, start);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


}
