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
import mantech.mod.report.entity.CategoryReport;

/**
 *
 * @author NGUYEN
 */
public class CategoryReportJpaController {

    public List<CategoryReport> findAll() {
        List<CategoryReport> list = new ArrayList<CategoryReport>();
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://localhost:1433;database=Mantech";
            String user = "mantech";
            String password = "123";
            Connection con = DriverManager.getConnection(url, user, password);
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery("SELECT * FROM RCategory");
            while (rs.next()) {
                CategoryReport cr = new CategoryReport();
                cr.setCategory(rs.getString(1));
                cr.setCreatedDate(rs.getString(2));
                cr.setCompletedDate(rs.getString(3));
                cr.setNote(rs.getString(4));
                cr.setFullName(rs.getString(5));
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
