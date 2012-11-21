/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mantech.mod.admin.web.account.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Hashtable;
import java.util.UUID;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mantech.mod.account.api.ProfileBiz;
import mantech.mod.account.entity.Department;
import mantech.mod.account.entity.Job;
import mantech.mod.account.entity.Profile;
import mantech.mod.util.FileUpload;

/**
 *
 * @author NGUYEN
 */
public class InsertTechnicianServlet extends HttpServlet {

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
        String uploadFolder = getServletContext().getRealPath("//ImageProfile");
        FileUpload fileUpload = null;
        String name = UUID.randomUUID().toString();
        InitialContext context = null;
        try {
            fileUpload = new FileUpload(uploadFolder, request, name);
            Hashtable parameter = fileUpload.getParameter();
            //Retrieve parameter
            String fullName = (String) parameter.get("fullName");
            String address = (String) parameter.get("address");
            String telephone = (String) parameter.get("telephone");
            String email = (String) parameter.get("email");
            String department = (String) parameter.get("department");
            String image = fileUpload.getFileName();
            //Create a instance of InitialContext
            context = new InitialContext();
            //Create a instance of ProfileBiz to create new technician
            ProfileBiz biz = (ProfileBiz) context.lookup("ejb/mantech/saigon/ProfileBiz");
            //Create new technician
            Profile p = new Profile();
            p.setFullName(fullName);
            p.setDepartment(new Department(Integer.parseInt(department)));
            p.setAddress(address);
            p.setTelephone(telephone);
            p.setEmail(email);
            p.setImage(image);
            p.setJob(new Job(2));
            if (biz.create(p)) {
                fileUpload.save();
                out.println("<h4 class='alert_info'>Created Successfully!</h4>");
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
