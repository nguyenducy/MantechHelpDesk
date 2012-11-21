/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mantech.mod.account.ejb;

import java.util.List;
import mantech.mod.account.entity.Department;
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
    public void testFindTechnician_Ok() {
        ProfileBizImpl bizImpl = new ProfileBizImpl();
        List<Profile> result = bizImpl.findTechnician();
        Profile p = result.get(0);

        assertNotNull(result);
        assertEquals("Technician", p.getJob().getJob());
    }

//    @Test
//    public void testCreate_NoImage(){
//        ProfileBizImpl bizImpl = new ProfileBizImpl();
//        Profile p = new Profile();
//        p.setFullName("technician_demo");
//        p.setAddress("123 abc");
//        p.setDepartment(new Department(1));
//        p.setEmail("demo@gmail.com");
//        p.setTelephone("123456789");
//        p.setJob(new Job(2));
//        boolean result = bizImpl.create(p);
//
//        assertTrue(result);
//    }
    @Test
    public void testFindImage() {
        ProfileBizImpl bizImpl = new ProfileBizImpl();
        String image = "567f038c-db63-41cf-a638-b5a8e07a0584.jpg";
        Profile find = bizImpl.find(image);
        assertNotNull(find);
    }

    @Test
    public void testEdit_ok(){
        ProfileBizImpl bizImpl = new ProfileBizImpl();
        Profile p = bizImpl.find(200);
        p.setDepartment(new Department(1));
        boolean result = bizImpl.edit(p);
        assertTrue(result);
    }
}
