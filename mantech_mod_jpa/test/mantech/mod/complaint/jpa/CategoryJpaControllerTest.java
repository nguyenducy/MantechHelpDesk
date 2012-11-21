/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mantech.mod.complaint.jpa;

import java.util.List;
import mantech.mod.complaint.entity.Category;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author NGUYEN
 */
public class CategoryJpaControllerTest {

    public CategoryJpaControllerTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Test
    public void testGetEntityManager() {
    }

    @Test
    public void testCreate() {
    }

    @Test
    public void testEdit() throws Exception {
        CategoryJpaController controller = new CategoryJpaController();
        Category c = controller.findCategory(3);
        c.setName("Hardware");
        c.setDescription("Problems about hardwares");
        controller.edit(c);
        Category result = controller.findCategory(3);
        System.out.println(result.getDescription());

        Category expected = new Category(3);
        expected.setName("Hardware");
        expected.setDescription("Problems about hardwares");
        System.out.println(expected.getDescription());
       
    }

    @Test
    public void testDestroy() throws Exception {
    }

    @Test
    public void testFindCategoryEntities_0args() {
    }

    @Test
    public void testFindCategoryEntities_int_int() {
    }

    @Test
    public void testFindCategory() {
        CategoryJpaController controller = new CategoryJpaController();
        List<Category> result = controller.findCategoryEntities();

        assertNotNull(result);
    }

    @Test
    public void testGetCategoryCount() {
    }

}