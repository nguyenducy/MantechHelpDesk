/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mantech.mod.account.dal;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import mantech.mod.account.entity.Profile;
import mantech.mod.complaint.entity.Category;

/**
 *
 * @author HoangVu
 */
public class Update {
   public  Update(){

   }
   private Connection getConnection(){
       Connection c = null;
        try {
            
            SQLServerDataSource dataSource = new SQLServerDataSource();

            dataSource.setDatabaseName("Mantech");
            dataSource.setPortNumber(1433);
            dataSource.setServerName("localhost");

            c = dataSource.getConnection("mantech", "123");

        } catch (SQLException ex) {
            Logger.getLogger(Update.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            return c;
        }
   }
   public boolean UpdateTechnicant(Profile profile){
       boolean check = false;
       Connection c = getConnection();
        try {
            
            PreparedStatement prePairStm = c.prepareStatement("update [Profile] set [Address] =?, DepartmentID=?, Email=?, FullName=?,Telephone=? where ID = ?");
            prePairStm.setString(1, profile.getAddress());
            prePairStm.setInt(2, profile.getDepartment().getId());
            prePairStm.setString(3, profile.getEmail());
            prePairStm.setString(4, profile.getFullName());
            prePairStm.setString(5, profile.getTelephone());
            prePairStm.setInt(6, profile.getId());

            if (prePairStm.executeUpdate()>0){
                check = true;
            }
            System.out.println("return "+check);
        } catch (SQLException ex) {
            check = false;
            ex.printStackTrace();
        }finally{
            try {
                c.close();
                
            } catch (SQLException ex) {
                Logger.getLogger(Update.class.getName()).log(Level.SEVERE, null, ex);
            }
            return check;
        }
   }
   public boolean UpdateCategory(Category category){
       boolean check = false;
       Connection c = getConnection();
       try {

            PreparedStatement prePairStm = c.prepareStatement("update Category set [Description]=?,Name=? where ID=?");
            prePairStm.setString(1, category.getDescription());
            prePairStm.setString(2, category.getName());
            prePairStm.setInt(3, category.getId());

            if (prePairStm.executeUpdate()>0){
                check = true;
            }
            System.out.println("return "+check);
        } catch (SQLException ex) {
            check = false;
            ex.printStackTrace();
        }finally{
            try {
                c.close();

            } catch (SQLException ex) {
                Logger.getLogger(Update.class.getName()).log(Level.SEVERE, null, ex);
            }
            return check;
        }
       
   }
}
