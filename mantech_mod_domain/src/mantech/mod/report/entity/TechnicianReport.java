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
    private String createdDate;
    private String completedDate;
    private String fullName;
    private String category;
    private String timeTaken;

    public TechnicianReport() {
    }

    public TechnicianReport(String technician, String createdDate, String completedDate, String fullName, String category, String timeTaken) {
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
