/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mantech.mod.complaint.ejb;

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
public class CategoryBizImplTest {

    public CategoryBizImplTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Test
    public void testCreate() throws Exception {
    }

    @Test
    public void testEdit() throws Exception {
        CategoryBizImpl bizImpl = new CategoryBizImpl();
        Category c = bizImpl.find(3);
        c.setName("Hardware");
        c.setDescription("Problems about hardware");
        boolean result = bizImpl.edit(c);
        assertTrue(result);
    }

    @Test
    public void testRemove() throws Exception {
    }

    @Test
    public void testFind_int() throws Exception {
        CategoryBizImpl bizImpl = new CategoryBizImpl();
        Category result = bizImpl.find(3);
        assertNotNull(result);
    }

    @Test
    public void testFindAll() throws Exception {
        CategoryBizImpl bizImpl = new CategoryBizImpl();
        List<Category> result = bizImpl.findAll();
        assertNotNull(result);
    }

    @Test
    public void testFind_int_int() throws Exception {
    }

}