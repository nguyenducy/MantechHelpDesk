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
public class DetailReport implements Serializable {

    private int id;
    private Date createdDate;
    private boolean pending;
    private boolean issued;
    private boolean completed;
    private Date completedDate;
    private String note;
    private String category;
    private String technician;
    private String employee;
    private String department;
    private int timeTaken;

    public DetailReport() {
    }

    public DetailReport(int id, Date createdDate, boolean pending, boolean issued, boolean completed, Date completedDate, String note, String category, String technician, String employee, String department, int timeTaken) {
        this.id = id;
        this.createdDate = createdDate;
        this.pending = pending;
        this.issued = issued;
        this.completed = completed;
        this.completedDate = completedDate;
        this.note = note;
        this.category = category;
        this.technician = technician;
        this.employee = employee;
        this.department = department;
        this.timeTaken = timeTaken;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
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

    public String getEmployee() {
        return employee;
    }

    public void setEmployee(String employee) {
        this.employee = employee;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isIssued() {
        return issued;
    }

    public void setIssued(boolean issued) {
        this.issued = issued;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public boolean isPending() {
        return pending;
    }

    public void setPending(boolean pending) {
        this.pending = pending;
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
