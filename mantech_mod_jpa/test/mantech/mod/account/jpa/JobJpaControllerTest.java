/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mantech.mod.account.jpa;

import java.util.List;
import mantech.mod.account.entity.Job;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author NGUYEN
 */
public class JobJpaControllerTest {

    public JobJpaControllerTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    /**
     * Test of getEntityManager method, of class JobJpaController.
     */
    @Test
    public void testGetEntityManager() {
    }

    /**
     * Test of create method, of class JobJpaController.
     */
    @Test
    public void testCreate() {
    }

    /**
     * Test of edit method, of class JobJpaController.
     */
    @Test
    public void testEdit() throws Exception {
    }

    /**
     * Test of destroy method, of class JobJpaController.
     */
    @Test
    public void testDestroy() throws Exception {
    }

    /**
     * Test of findJobEntities method, of class JobJpaController.
     */
    @Test
    public void testFindJobEntitiesOk() {
        JobJpaController  controller = new JobJpaController();
        List<Job> result = controller.findJobEntities();

        assertNotNull(result);
    }

    /**
     * Test of findJobEntities method, of class JobJpaController.
     */
    @Test
    public void testFindJobEntities_int_int() {
    }

    /**
     * Test of findJob method, of class JobJpaController.
     */
    @Test
    public void testFindJob() {
        
    }

    /**
     * Test of getJobCount method, of class JobJpaController.
     */
    @Test
    public void testGetJobCount() {
    }

}