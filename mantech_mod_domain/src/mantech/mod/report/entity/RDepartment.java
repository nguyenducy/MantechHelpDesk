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
@Table(name = "RDepartment", catalog = "Mantech", schema = "dbo")
@NamedQueries({
    @NamedQuery(name = "RDepartment.findAll", query = "SELECT r FROM RDepartment r"),
    @NamedQuery(name = "RDepartment.findByDepartment", query = "SELECT r FROM RDepartment r WHERE r.department = :department"),
    @NamedQuery(name = "RDepartment.findByFullName", query = "SELECT r FROM RDepartment r WHERE r.fullName = :fullName"),
    @NamedQuery(name = "RDepartment.findByCreatedDate", query = "SELECT r FROM RDepartment r WHERE r.createdDate = :createdDate"),
    @NamedQuery(name = "RDepartment.findByCompletedDate", query = "SELECT r FROM RDepartment r WHERE r.completedDate = :completedDate"),
    @NamedQuery(name = "RDepartment.findByCategory", query = "SELECT r FROM RDepartment r WHERE r.category = :category"),
    @NamedQuery(name = "RDepartment.findByTechnician", query = "SELECT r FROM RDepartment r WHERE r.technician = :technician")})
public class RDepartment implements Serializable {
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "Department", nullable = false, length = 50)
    private String department;
    @Basic(optional = false)
    @Column(name = "FullName", nullable = false, length = 100)
    private String fullName;
    @Basic(optional = false)
    @Column(name = "CreatedDate", nullable = false, length = 10)
    private String createdDate;
    @Column(name = "CompletedDate", length = 10)
    private String completedDate;
    @Basic(optional = false)
    @Column(name = "Category", nullable = false, length = 50)
    private String category;
    @Basic(optional = false)
    @Column(name = "Technician", nullable = false, length = 50)
    private String technician;

    public RDepartment() {
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

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public String getCompletedDate() {
        return completedDate;
    }

    public void setCompletedDate(String completedDate) {
        this.completedDate = completedDate;
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

}
