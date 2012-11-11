/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mantech.mod.report.entity;

import java.io.Serializable;

/**
 *
 * @author NGUYEN
 */
public class DepartmentReport implements Serializable {

    private String department;
    private String fullName;
    private String createdDate;
    private String completedDate;
    private String category;
    private String technician;
    private String timeTaken;

    public DepartmentReport() {
    }

    public DepartmentReport(String department, String fullName, String createdDate, String completedDate, String category, String technician, String timeTaken) {
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

    public String getCompletedDate() {
        return completedDate;
    }

    public void setCompletedDate(String completedDate) {
        this.completedDate = completedDate;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public String getTimeTaken() {
        return timeTaken;
    }

    public void setTimeTaken(String timeTaken) {
        this.timeTaken = timeTaken;
    }
}
