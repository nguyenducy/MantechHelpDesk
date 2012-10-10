/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mantech.mod.admin.account.api;

import java.util.List;
import mantech.mod.account.entity.Department;

/**
 *
 * @author NDC
 */
public interface AdminDepartmentBiz {

    void create(Department department);

    void edit(Department department);

    void remove(Department department);

    Department find(Object id);

    List<Department> findAll();
}
