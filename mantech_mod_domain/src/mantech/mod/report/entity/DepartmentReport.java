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
public class DepartmentReport implements Serializable {

    private String department;
    private String fullName;
    private Date createdDate;
    private Date completedDate;
    private String category;
    private String technician;
    private int timeTaken;

    public DepartmentReport() {
    }

    public DepartmentReport(String department, String fullName, Date createdDate, Date completedDate, String category, String technician, int timeTaken) {
        this.department = department;
        this.fullName = fullName;
        this.createdDate = createdDate;
        this.completedDate = completedDate;
        this.category = category;
        this.technician = technician;
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

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
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
