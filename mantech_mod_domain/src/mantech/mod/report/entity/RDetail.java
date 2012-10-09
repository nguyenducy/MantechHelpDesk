/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mantech.mod.report.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author NGUYEN
 */
@Entity
@Table(name = "RDetail", catalog = "Mantech", schema = "dbo")
@NamedQueries({
    @NamedQuery(name = "RDetail.findAll", query = "SELECT r FROM RDetail r"),
    @NamedQuery(name = "RDetail.findById", query = "SELECT r FROM RDetail r WHERE r.id = :id"),
    @NamedQuery(name = "RDetail.findByCreatedDate", query = "SELECT r FROM RDetail r WHERE r.createdDate = :createdDate"),
    @NamedQuery(name = "RDetail.findByIssued", query = "SELECT r FROM RDetail r WHERE r.issued = :issued"),
    @NamedQuery(name = "RDetail.findByPending", query = "SELECT r FROM RDetail r WHERE r.pending = :pending"),
    @NamedQuery(name = "RDetail.findByCompleted", query = "SELECT r FROM RDetail r WHERE r.completed = :completed"),
    @NamedQuery(name = "RDetail.findByCompletedDate", query = "SELECT r FROM RDetail r WHERE r.completedDate = :completedDate"),
    @NamedQuery(name = "RDetail.findByNote", query = "SELECT r FROM RDetail r WHERE r.note = :note"),
    @NamedQuery(name = "RDetail.findByCategory", query = "SELECT r FROM RDetail r WHERE r.category = :category"),
    @NamedQuery(name = "RDetail.findByTechnician", query = "SELECT r FROM RDetail r WHERE r.technician = :technician"),
    @NamedQuery(name = "RDetail.findByEmployee", query = "SELECT r FROM RDetail r WHERE r.employee = :employee"),
    @NamedQuery(name = "RDetail.findByDepartment", query = "SELECT r FROM RDetail r WHERE r.department = :department")})
public class RDetail implements Serializable {
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "ID", nullable = false)
    private int id;
    @Basic(optional = false)
    @Column(name = "CreatedDate", nullable = false, length = 10)
    private String createdDate;
    @Basic(optional = false)
    @Column(name = "Issued", nullable = false)
    private boolean issued;
    @Basic(optional = false)
    @Column(name = "Pending", nullable = false)
    private boolean pending;
    @Basic(optional = false)
    @Column(name = "Completed", nullable = false)
    private boolean completed;
    @Column(name = "CompletedDate", length = 10)
    private String completedDate;
    @Column(name = "Note", length = 1000)
    private String note;
    @Basic(optional = false)
    @Column(name = "Category", nullable = false, length = 50)
    private String category;
    @Basic(optional = false)
    @Column(name = "Technician", nullable = false, length = 50)
    private String technician;
    @Basic(optional = false)
    @Column(name = "Employee", nullable = false, length = 100)
    private String employee;
    @Basic(optional = false)
    @Column(name = "Department", nullable = false, length = 50)
    private String department;

    public RDetail() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public boolean getIssued() {
        return issued;
    }

    public void setIssued(boolean issued) {
        this.issued = issued;
    }

    public boolean getPending() {
        return pending;
    }

    public void setPending(boolean pending) {
        this.pending = pending;
    }

    public boolean getCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public String getCompletedDate() {
        return completedDate;
    }

    public void setCompletedDate(String completedDate) {
        this.completedDate = completedDate;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getTechnician() {
        return technician;
    }

    public void setTechnician(String technician) {
        this.technician = technician;
    }

    public String getEmployee() {
        return employee;
    }

    public void setEmployee(String employee) {
        this.employee = employee;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

}
