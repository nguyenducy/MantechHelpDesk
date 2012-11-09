/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mantech.mod.complaint.ejb;

import java.util.List;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import mantech.mod.complaint.api.CategoryBiz;
import mantech.mod.complaint.entity.Category;
import mantech.mod.complaint.jpa.CategoryJpaController;

/**
 *
 * @author NGUYEN
 */
@Stateless(name = "CategoryBiz", mappedName = "ejb/mantech/saigon/CategoryBiz")
@Remote(mantech.mod.complaint.api.CategoryBiz.class)
public class CategoryBizImpl implements CategoryBiz {

    @Override
    public boolean create(Category category) {
        try {
            CategoryJpaController controller = new CategoryJpaController();
            controller.create(category);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean edit(Category category) {
        try {
            CategoryJpaController controller = new CategoryJpaController();
            controller.edit(category);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean remove(int id) {
        try {
            CategoryJpaController controller = new CategoryJpaController();
            controller.destroy(id);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Category find(int id) {
        try {
            CategoryJpaController controller = new CategoryJpaController();
            return controller.findCategory(id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Category> findAll() {
        try {
            CategoryJpaController controller = new CategoryJpaController();
            return controller.findCategoryEntities();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Category> find(int length, int start) {
        try {
            CategoryJpaController controller = new CategoryJpaController();
            return controller.findCategoryEntities(length, start);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    
}
