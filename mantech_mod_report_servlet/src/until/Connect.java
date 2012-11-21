/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package until;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author NDC
 */
public class Connect {

    Connection con = null;
    public Connection Getconnet(){
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                        String url = "jdbc:sqlserver://localhost:1433;databasename=Mantech";
                        Connection con = DriverManager.getConnection(url, "mantech", "123");
                       return con;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
