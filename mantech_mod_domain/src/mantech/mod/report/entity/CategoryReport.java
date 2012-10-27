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
public class CategoryReport implements Serializable {

    private String category;
    private Date createdDate;
    private Date completedDate;
    private String note;
    private String fullName;
    private String technician;
    private int timeTaken;

    public CategoryReport() {
    }

    public CategoryReport(String category, Date createdDate, Date completedDate, String note, String fullName, String technician, int timeTaken) {
        this.category = category;
        this.createdDate = createdDate;
        this.completedDate = completedDate;
        this.note = note;
        this.fullName = fullName;
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

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
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
