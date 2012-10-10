/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mantech.mod.admin.complaint.api;

import java.util.List;
import mantech.mod.complaint.entity.Complaint;

/**
 *
 * @author NDC
 */
public interface AdminComplaintBiz {

    void create(Complaint complaint);

    void edit(Complaint complaint);

    void remove(Complaint complaint);

    Complaint find(Object id);

    List<Complaint> findAll();

    boolean updateComplaintIssued(String id);

    boolean updateComplaintPending(String id);

    boolean updateComplaintCompleted(String id);

    Complaint searchByCatagory(String categoryName);

    Complaint searchByDepartment(String departmentName);

    Complaint searchByTechnician(String technicianName);

    Complaint searchByProfile(String name);
}
