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
@Table(name = "RTechnician", catalog = "Mantech", schema = "dbo")
@NamedQueries({
    @NamedQuery(name = "RTechnician.findAll", query = "SELECT r FROM RTechnician r"),
    @NamedQuery(name = "RTechnician.findByTechnician", query = "SELECT r FROM RTechnician r WHERE r.technician = :technician"),
    @NamedQuery(name = "RTechnician.findByCreatedDate", query = "SELECT r FROM RTechnician r WHERE r.createdDate = :createdDate"),
    @NamedQuery(name = "RTechnician.findByCompletedDate", query = "SELECT r FROM RTechnician r WHERE r.completedDate = :completedDate"),
    @NamedQuery(name = "RTechnician.findByFullName", query = "SELECT r FROM RTechnician r WHERE r.fullName = :fullName"),
    @NamedQuery(name = "RTechnician.findByCategory", query = "SELECT r FROM RTechnician r WHERE r.category = :category")})
public class RTechnician implements Serializable {
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "Technician", nullable = false, length = 50)
    private String technician;
    @Basic(optional = false)
    @Column(name = "CreatedDate", nullable = false, length = 10)
    private String createdDate;
    @Column(name = "CompletedDate", length = 10)
    private String completedDate;
    @Basic(optional = false)
    @Column(name = "FullName", nullable = false, length = 100)
    private String fullName;
    @Basic(optional = false)
    @Column(name = "Category", nullable = false, length = 50)
    private String category;

    public RTechnician() {
    }

    public String getTechnician() {
        return technician;
    }

    public void setTechnician(String technician) {
        this.technician = technician;
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

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

}
