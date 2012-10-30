/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mantech.mod.complaint.api;

import java.util.List;
import mantech.mod.complaint.entity.Technician;

/**
 *
 * @author NDC
 */
public interface TechnicianBiz {

    void create(Technician technician);

    void edit(Technician technician);

    void remove(Technician technician);

    Technician find(Object id);

    List<Technician> findAll();

    List<Technician> findAllComplaint();

    List<Technician> searchNewComplaint();

    List<Technician> searchTopComplaint();

    boolean updateComplainIssued(String id);

    boolean updateComplainPending(String id);
}
