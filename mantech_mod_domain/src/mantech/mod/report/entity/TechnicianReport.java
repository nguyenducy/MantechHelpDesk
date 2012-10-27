/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mantech.mod.report.entity;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author NGUYEN
 */
public class TechnicianReport implements Serializable {

    private String technician;
    private Date createdDate;
    private Date completedDate;
    private String fullName;
    private String category;
    private int timeTaken;

    public TechnicianReport() {
    }

    public TechnicianReport(String technician, Date createdDate, Date completedDate, String fullName, String category, int timeTaken) {
        this.technician = technician;
        this.createdDate = createdDate;
        this.completedDate = completedDate;
        this.fullName = fullName;
        this.category = category;
        this.timeTaken = timeTaken;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Date getCompletedDate() {
        return completedDate;
    }

    public void setCompletedDate(Date completedDate) {
        this.completedDate = completedDate;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getTechnician() {
        return technician;
    }

    public void setTechnician(String technician) {
        this.technician = technician;
    }

    public int getTimeTaken() {
        return timeTaken;
    }

    public void setTimeTaken(int timeTaken) {
        this.timeTaken = timeTaken;
    }
}
