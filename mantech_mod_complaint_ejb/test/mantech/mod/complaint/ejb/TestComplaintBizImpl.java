/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mantech.mod.complaint.ejb;

import java.sql.Date;
import java.util.List;
import junit.framework.TestCase;
import mantech.mod.complaint.entity.Complaint;

/**
 *
 * @author NGUYEN
 */
public class TestComplaintBizImpl extends TestCase {

    ComplaintBizImpl bizImpl;

    @Override
    protected void setUp() throws Exception {
        bizImpl = new ComplaintBizImpl();
    }

    public void testUpdateIssued() {
        int id = 1;
        int technician = 2;
        boolean r = bizImpl.updateIssued(id, technician);
        Complaint result = bizImpl.find(id);

        Complaint expected = new Complaint();
        expected.setTechnicianID(technician);

        assertTrue(r);
        assertEquals(expected.getTechnicianID(), result.getTechnicianID());
    }

    public void testUpdateCompleted() {
        int id = 1;
        boolean r = bizImpl.updateCompleted(id);
        Complaint result = bizImpl.find(id);

        Complaint expected = new Complaint();
        java.util.Date d = new java.util.Date();
        int y = d.getYear();
        int m = d.getMonth();
        int dd = d.getDate();
        Date date = new Date(y, m, dd);
        expected.setCompletedDate(date);

        assertTrue(r);
        assertEquals(expected.getCompletedDate(), result.getCompletedDate());
    }

    public void testFindPendingJust(){
        List<Complaint> result = bizImpl.findPendingOnly();
        assertNotNull(result);
    }
}
