/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mantech.mod.account.ejb;

import java.util.List;
import mantech.mod.account.entity.Account;
import mantech.mod.account.entity.Profile;
import mantech.mod.account.entity.Role;
import mantech.mod.account.jpa.AccountJpaController;
import mantech.mod.complaint.entity.Complaint;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author NGUYEN
 */
public class TestAccountBizImpl {

    AccountBizImpl bizImpl = new AccountBizImpl();

    public TestAccountBizImpl() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {

    }


    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Test
    public void testCheckLoginOk() {
        Account actual = bizImpl.checkLogin("admin", "admin");
        Account exceptd = new Account(1, "admin", "admin");
        assertEquals(exceptd, actual);
    }

    

    @Test
    public void testUsernameAvailableOk(){
        boolean r = bizImpl.usernameAvailable("admin");
        assertTrue(r);
    }

    @Test
    public void testUsernameUnvailable(){
        boolean r = bizImpl.usernameAvailable("unvaiblable");
        assertTrue(!r);
    }

    @Test
    public void testChangePassword(){
        boolean changePassword = bizImpl.changePassword("demo", "demo");
        assertTrue(changePassword);
    }

  
}
