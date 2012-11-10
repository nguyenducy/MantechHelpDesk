/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mantech.mod.account.jpa;

import java.util.List;
import mantech.mod.account.entity.Profile;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author NGUYEN
 */
public class ProfileJpaControllerTest {

    public ProfileJpaControllerTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    /**
     * Test of getEntityManager method, of class ProfileJpaController.
     */
    @Test
    public void testGetEntityManager() {
    }

    /**
     * Test of create method, of class ProfileJpaController.
     */
    @Test
    public void testCreate() {
       
    }

    /**
     * Test of edit method, of class ProfileJpaController.
     */
    @Test
    public void testEdit() throws Exception {
    }

    /**
     * Test of destroy method, of class ProfileJpaController.
     */
    @Test
    public void testDestroy() throws Exception {
    }

    /**
     * Test of findProfileEntities method, of class ProfileJpaController.
     */
    @Test
    public void testFindProfileEntities_Ok() {
        ProfileJpaController controller = new ProfileJpaController();
        List<Profile> result = controller.findProfileEntities();

        assertNotNull(result);
    }

    /**
     * Test of findProfileEntities method, of class ProfileJpaController.
     */
    @Test
    public void testFindProfileEntities_int_int() {
    }

    /**
     * Test of findProfile method, of class ProfileJpaController.
     */
    @Test
    public void testFindProfile() {
    }

    /**
     * Test of getProfileCount method, of class ProfileJpaController.
     */
    @Test
    public void testGetProfileCount() {
    }

}