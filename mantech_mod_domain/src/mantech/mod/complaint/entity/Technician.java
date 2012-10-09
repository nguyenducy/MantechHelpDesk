/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mantech.mod.complaint.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author NGUYEN
 */
@Entity
@Table(name = "Technician", catalog = "Mantech", schema = "dbo")
@NamedQueries({
    @NamedQuery(name = "Technician.findAll", query = "SELECT t FROM Technician t"),
    @NamedQuery(name = "Technician.findById", query = "SELECT t FROM Technician t WHERE t.id = :id"),
    @NamedQuery(name = "Technician.findByName", query = "SELECT t FROM Technician t WHERE t.name = :name"),
    @NamedQuery(name = "Technician.findByAddress", query = "SELECT t FROM Technician t WHERE t.address = :address"),
    @NamedQuery(name = "Technician.findByTelephone", query = "SELECT t FROM Technician t WHERE t.telephone = :telephone"),
    @NamedQuery(name = "Technician.findByImage", query = "SELECT t FROM Technician t WHERE t.image = :image")})
public class Technician implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID", nullable = false)
    private Integer id;
    @Basic(optional = false)
    @Column(name = "Name", nullable = false, length = 50)
    private String name;
    @Column(name = "Address", length = 100)
    private String address;
    @Basic(optional = false)
    @Column(name = "Telephone", nullable = false, length = 15)
    private String telephone;
    @Column(name = "Image", length = 50)
    private String image;
    @OneToMany(mappedBy = "technician", fetch = FetchType.LAZY)
    private List<Complaint> complaintList;

    public Technician() {
    }

    public Technician(Integer id) {
        this.id = id;
    }

    public Technician(Integer id, String name, String telephone) {
        this.id = id;
        this.name = name;
        this.telephone = telephone;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public List<Complaint> getComplaintList() {
        return complaintList;
    }

    public void setComplaintList(List<Complaint> complaintList) {
        this.complaintList = complaintList;
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
        if (!(object instanceof Technician)) {
            return false;
        }
        Technician other = (Technician) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mantech.mod.complaint.entity.Technician[id=" + id + "]";
    }

}
