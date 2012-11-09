/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mantech.mod.complaint.ejb;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import mantech.mod.complaint.api.ComplaintBiz;
import mantech.mod.complaint.entity.Complaint;
import mantech.mod.complaint.jpa.ComplaintJpaController;

/**
 *
 * @author NGUYEN
 */
@Stateless(name = "ComplaintBiz", mappedName = "ejb/mantech/saigon/ComplaintBiz")
@Remote(mantech.mod.complaint.api.ComplaintBiz.class)
public class ComplaintBizImpl implements ComplaintBiz {

    @Override
    public boolean create(Complaint complaint) {
        try {
            ComplaintJpaController controller = new ComplaintJpaController();
            controller.create(complaint);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean edit(Complaint complaint) {
        try {
            ComplaintJpaController controller = new ComplaintJpaController();
            controller.edit(complaint);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean remove(int id) {
        try {
            ComplaintJpaController controller = new ComplaintJpaController();
            controller.destroy(id);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Complaint find(int id) {
        try {
            ComplaintJpaController controller = new ComplaintJpaController();
            return controller.findComplaint(id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Complaint> findAll() {
        try {
            ComplaintJpaController controller = new ComplaintJpaController();
            return controller.findComplaintEntities();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Complaint> find(int length, int start) {
        try {
            ComplaintJpaController controller = new ComplaintJpaController();
            return controller.findComplaintEntities(length, start);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean updateIssued(int id, int technicianID) {
        try {
            Complaint c = this.find(id);
            c.setIssued(true);
            c.setTechnicianID(technicianID);
            return this.edit(c);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean updateCompleted(int id) {
        try {
            java.util.Date d = new java.util.Date();
            int y = d.getYear();
            int m = d.getMonth();
            int dd = d.getDate();
            Date date = new Date(y, m, dd);

            Complaint c = this.find(id);
            c.setCompleted(true);
            c.setCompletedDate(date);
            return this.edit(c);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<Complaint> findPendingOnly() {
        try {
            List<Complaint> listAll = this.findAll();
            List<Complaint> newList = new ArrayList<Complaint>();
            for (Complaint c : listAll) {
                boolean issued = c.getIssued();
                boolean completed = c.getCompleted();
                if (!issued && !completed) {
                    newList.add(c);
                }
            }
            return newList;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    
    @Override
    public List<Complaint> findByTechnicianIDAndNotCompleted(int id) {
        try {
            List<Complaint> listAll = findAll();
            List<Complaint> newList = new ArrayList<Complaint>();
            for (Complaint c : listAll) {
                int technicianID = c.getTechnicianID();
                boolean completed = c.getCompleted();
                if (technicianID == id && !completed) {
                    newList.add(c);
                }
            }
            return newList;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


}
