/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mantech.mod.account.ejb;

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
public class JobBizImplTest {

    public JobBizImplTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Test
    public void testFindAll() throws Exception {
        JobBizImpl bizImpl = new JobBizImpl();
        List<Job> result = bizImpl.findAll();
        for (Job j : result) {
            System.out.println(j.getId());
        }
        assertNotNull(result);
    }

}