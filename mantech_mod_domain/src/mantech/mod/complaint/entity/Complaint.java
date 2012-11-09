/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mantech.mod.complaint.entity;

import java.io.Serializable;
import java.sql.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import mantech.mod.account.entity.Job;
import mantech.mod.account.entity.Profile;

/**
 *
 * @author NGUYEN
 */
@Entity
@Table(name = "Complaint", catalog = "Mantech", schema = "dbo")
@NamedQueries({
    @NamedQuery(name = "Complaint.findAll", query = "SELECT c FROM Complaint c"),
    @NamedQuery(name = "Complaint.findById", query = "SELECT c FROM Complaint c WHERE c.id = :id"),
    @NamedQuery(name = "Complaint.findByCreatedDate", query = "SELECT c FROM Complaint c WHERE c.createdDate = :createdDate"),
    @NamedQuery(name = "Complaint.findByIssued", query = "SELECT c FROM Complaint c WHERE c.issued = :issued"),
    @NamedQuery(name = "Complaint.findByPending", query = "SELECT c FROM Complaint c WHERE c.pending = :pending"),
    @NamedQuery(name = "Complaint.findByCompleted", query = "SELECT c FROM Complaint c WHERE c.completed = :completed"),
    @NamedQuery(name = "Complaint.findByCompletedDate", query = "SELECT c FROM Complaint c WHERE c.completedDate = :completedDate"),
    @NamedQuery(name = "Complaint.findByNote", query = "SELECT c FROM Complaint c WHERE c.note = :note")})
public class Complaint implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Integer id;
    @JoinColumn(name = "CategoryID", referencedColumnName = "ID", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Category category;
    @JoinColumn(name = "ProfileID", referencedColumnName = "ID", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Profile profile;
    @Basic(optional = false)
    @Column(name = "CreatedDate", nullable = false, length = 10)
    private Date createdDate;
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
    private Date completedDate;
    @Column(name = "TechnicianID", nullable = true)
    private Integer technicianID;
    @Column(name = "Note", length = 1000)
    private String note;

    public Complaint() {
    }

    public Complaint(Integer id) {
        this.id = id;
    }

    public Complaint(Integer id, Date createdDate, boolean issued, boolean pending, boolean completed) {
        this.id = id;
        this.createdDate = createdDate;
        this.issued = issued;
        this.pending = pending;
        this.completed = completed;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
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

    public Date getCompletedDate() {
        return completedDate;
    }

    public void setCompletedDate(Date completedDate) {
        this.completedDate = completedDate;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public int getTechnicianID() {
        return technicianID;
    }

    public void setTechnicianID(int technicianID) {
        this.technicianID = technicianID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Complaint)) {
            return false;
        }
        Complaint other = (Complaint) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mantech.mod.complaint.entity.Complaint[id=" + id + "]";
    }
}
