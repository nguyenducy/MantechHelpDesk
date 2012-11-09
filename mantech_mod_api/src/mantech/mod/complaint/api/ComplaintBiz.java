/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mantech.mod.complaint.api;

import java.util.List;
import mantech.mod.complaint.entity.Complaint;

/**
 *
 * @author NDC
 */
public interface ComplaintBiz {

    boolean create(Complaint complaint);

    boolean edit(Complaint complaint);

    boolean remove(int id);

    Complaint find(int id);

    List<Complaint> findAll();

    List<Complaint> find(int length, int start);

    List<Complaint> findPendingOnly();

    List<Complaint> findByTechnicianIDAndNotCompleted(int id);

    boolean updateIssued(int id, int technicianID);

    boolean updateCompleted(int id);
}
