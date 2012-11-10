/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mantech.mod.admin.web.account.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Hashtable;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mantech.mod.account.api.AccountBiz;
import mantech.mod.account.api.ProfileBiz;
import mantech.mod.account.entity.Account;
import mantech.mod.account.entity.Department;
import mantech.mod.account.entity.Job;
import mantech.mod.account.entity.Profile;
import mantech.mod.account.entity.Role;
import mantech.mod.util.FileUpload;

/**
 *
 * @author NGUYEN
 */
public class InsertAccountServlet extends HttpServlet {

    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String uploadFolder = getServletContext().getRealPath("images\\profiles");
        FileUpload fileUpload = null;
        String name = UUID.randomUUID().toString();
        InitialContext context = null;
        try {
            fileUpload = new FileUpload(uploadFolder, request, name);
            Hashtable parameter = fileUpload.getParameter();
            String username = (String) parameter.get("username");
            String password = (String) parameter.get("password");
            String role = (String) parameter.get("role");
            String fullname = (String) parameter.get("fullName");
            String address = (String) parameter.get("address");
            String email = (String) parameter.get("email");
            String telephone = (String) parameter.get("telephone");
            String department = (String) parameter.get("department");
            String image = fileUpload.getFileName();
            context = new InitialContext();
            ProfileBiz biz = (ProfileBiz) context.lookup("ejb/mantech/saigon/ProfileBiz");
            AccountBiz accountBiz = (AccountBiz) context.lookup("ejb/mantech/saigon/AccountBiz");
            Profile p = new Profile();
            p.setAddress(address);
            p.setDepartment(new Department(Integer.parseInt(department)));
            p.setEmail(email);
            p.setFullName(fullname);
            p.setImage(image);
            p.setJob(new Job(1));
            p.setTelephone(telephone);
            if (biz.create(p)) {
                Profile temp = biz.find(image);
                Account a = new Account();
                a.setUsername(username);
                a.setPassword(password);
                a.setRole(new Role(Integer.parseInt(role)));
                a.setProfile(new Profile(temp.getId()));
                if (accountBiz.create(a)) {
                    fileUpload.save();
                    out.println("<h4 class='alert_info'>Created Successfully!</h4>");
                }
            } else {
                out.println("<h4 class='alert_info'>Created Faily!</h4>");
            }

        } catch (NamingException ex) {
            ex.printStackTrace();
        } finally {
            out.close();
            try {
                context.close();
            } catch (NamingException ex) {
                ex.printStackTrace();
            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
