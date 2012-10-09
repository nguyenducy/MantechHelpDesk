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
@Table(name = "RCategory", catalog = "Mantech", schema = "dbo")
@NamedQueries({
    @NamedQuery(name = "RCategory.findAll", query = "SELECT r FROM RCategory r"),
    @NamedQuery(name = "RCategory.findByCategory", query = "SELECT r FROM RCategory r WHERE r.category = :category"),
    @NamedQuery(name = "RCategory.findByCreatedDate", query = "SELECT r FROM RCategory r WHERE r.createdDate = :createdDate"),
    @NamedQuery(name = "RCategory.findByCompletedDate", query = "SELECT r FROM RCategory r WHERE r.completedDate = :completedDate"),
    @NamedQuery(name = "RCategory.findByNote", query = "SELECT r FROM RCategory r WHERE r.note = :note"),
    @NamedQuery(name = "RCategory.findByFullName", query = "SELECT r FROM RCategory r WHERE r.fullName = :fullName"),
    @NamedQuery(name = "RCategory.findByTechnician", query = "SELECT r FROM RCategory r WHERE r.technician = :technician")})
public class RCategory implements Serializable {
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "Category", nullable = false, length = 50)
    private String category;
    @Basic(optional = false)
    @Column(name = "CreatedDate", nullable = false, length = 10)
    private String createdDate;
    @Column(name = "CompletedDate", length = 10)
    private String completedDate;
    @Column(name = "Note", length = 1000)
    private String note;
    @Basic(optional = false)
    @Column(name = "FullName", nullable = false, length = 100)
    private String fullName;
    @Basic(optional = false)
    @Column(name = "Technician", nullable = false, length = 50)
    private String technician;

    public RCategory() {
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
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

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
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

}
