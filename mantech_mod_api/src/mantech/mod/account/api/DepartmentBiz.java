/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mantech.mod.account.api;

import java.util.List;
import mantech.mod.account.entity.Department;

/**
 *
 * @author NDC
 */
public interface DepartmentBiz {

    boolean create(Department department);

    boolean edit(Department department);

    boolean remove(int id);

    Department find(int id);

    List<Department> findAll();

    List<Department> find(int length, int start);
}
