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
public interface CategoryBiz {

    boolean create(Category category);

    boolean edit(Category category);

    boolean remove(int id);

    Category find(int id);

    List<Category> findAll();

    List<Category> find(int length, int start);

     boolean UpdateCategory(Category category);

}
