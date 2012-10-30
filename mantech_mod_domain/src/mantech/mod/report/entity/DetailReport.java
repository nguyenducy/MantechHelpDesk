/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mantech.mod.report.entity;

import java.util.Date;

/**
 *
 * @author NGUYEN
 */
public class DetailReport {

    private int id;
    private Date createdDate;

    public DetailReport() {
    }

    public DetailReport(int id, Date createdDate) {
        this.id = id;
        this.createdDate = createdDate;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
