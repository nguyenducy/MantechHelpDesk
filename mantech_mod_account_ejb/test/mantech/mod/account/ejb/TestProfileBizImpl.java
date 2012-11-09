/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mantech.mod.account.ejb;

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
public class TestProfileBizImpl {

    public TestProfileBizImpl() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Test
    public void testFindTechnician_Ok(){
        ProfileBizImpl bizImpl = new ProfileBizImpl();
        List<Profile> result = bizImpl.findTechnician();
        Profile p = result.get(0);

        assertNotNull(result);
        assertEquals("Technician", p.getJob().getJob());
    }
}