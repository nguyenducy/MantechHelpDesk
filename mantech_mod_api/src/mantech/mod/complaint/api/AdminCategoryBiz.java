/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mantech.mod.complaint.api;

import java.util.List;
import mantech.mod.complaint.entity.Category;

/**
 *
 * @author NDC
 */
public interface AdminCategoryBiz {

    void create(Category category);

    void edit(Category category);

    void remove(Category category);

    Category find(Object id);

    List<Category> findAll();

    Category searchByName(String name);
}
