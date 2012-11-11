/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mantech.mod.report.dal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import mantech.mod.report.entity.DepartmentReport;

/**
 *
 * @author NGUYEN
 */
public class DepartmentReportJpaController {

    public List<DepartmentReport> findAll() {
        List<DepartmentReport> list = new ArrayList<DepartmentReport>();
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://localhost:1433;database=Mantech";
            String user = "mantech";
            String password = "123";
            Connection con = DriverManager.getConnection(url, user, password);
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery("SELECT * FROM RDepartment");
            while (rs.next()) {
                DepartmentReport cr = new DepartmentReport();
                cr.setDepartment(rs.getString(1));
                cr.setFullName(rs.getString(2));
                cr.setCreatedDate(rs.getString(3));
                cr.setCompletedDate(rs.getString(4));
                cr.setCategory(rs.getString(5));
                cr.setTechnician(rs.getString(6));
                cr.setTimeTaken(rs.getString(7));
                list.add(cr);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
