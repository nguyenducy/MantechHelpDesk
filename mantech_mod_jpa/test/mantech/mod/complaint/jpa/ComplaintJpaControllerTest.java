/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mantech.mod.complaint.jpa;

import java.util.List;
import mantech.mod.complaint.entity.Complaint;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author NGUYEN
 */
public class ComplaintJpaControllerTest {

    public ComplaintJpaControllerTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    /**
     * Test of getEntityManager method, of class ComplaintJpaController.
     */
    @Test
    public void testGetEntityManager() {
    }

    /**
     * Test of create method, of class ComplaintJpaController.
     */
    @Test
    public void testCreate() {
    }

    /**
     * Test of edit method, of class ComplaintJpaController.
     */
    @Test
    public void testEdit() throws Exception {
    }

    /**
     * Test of destroy method, of class ComplaintJpaController.
     */
    @Test
    public void testDestroy() throws Exception {
    }

    /**
     * Test of findComplaintEntities method, of class ComplaintJpaController.
     */
    @Test
    public void testFindComplaintEntities_Ok() {
        ComplaintJpaController controller = new ComplaintJpaController();
        List<Complaint> result = controller.findComplaintEntities();

        assertNotNull(result);
    }

    /**
     * Test of findComplaintEntities method, of class ComplaintJpaController.
     */
    @Test
    public void testFindComplaintEntities_int_int() {
    }

    /**
     * Test of findComplaint method, of class ComplaintJpaController.
     */
    @Test
    public void testFindComplaint() {
    }

    /**
     * Test of getComplaintCount method, of class ComplaintJpaController.
     */
    @Test
    public void testGetComplaintCount() {
    }

}