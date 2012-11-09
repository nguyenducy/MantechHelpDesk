/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mantech.mod.web.complaint.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import mantech.mod.account.api.AccountBiz;
import mantech.mod.account.entity.Account;
import mantech.mod.account.entity.Profile;
import mantech.mod.complaint.api.ComplaintBiz;
import mantech.mod.complaint.entity.Category;
import mantech.mod.complaint.entity.Complaint;
import mantech.mod.session.SessionName;

/**
 *
 * @author NGUYEN
 */
public class InsertComplaintServlet extends HttpServlet {

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
        HttpSession session = request.getSession(true);
        Object idObject = session.getValue(SessionName.ID_CURRENT_USER);
        String backto = request.getParameter("return");
        String url = request.getContextPath() + backto;
//        int category = Integer.parseInt(request.getParameter("category"));
        String category = request.getParameter("category");
        String note = request.getParameter("note");
        InitialContext context = null;
        try {
            if (idObject == null) {
                out.println("Please login");
                out.println("<a href='" + url + "'>Back to</a>");
            } else {
                int id = Integer.parseInt(idObject.toString());
                context = new InitialContext();
                ComplaintBiz biz = (ComplaintBiz) context.lookup("ejb/mantech/saigon/ComplaintBiz");
                AccountBiz accountBiz = (AccountBiz) context.lookup("ejb/mantech/saigon/AccountBiz");
                Profile p = accountBiz.findByID(id).getProfile();
                Date d = new Date();
                int y = d.getYear();
                int m = d.getMonth();
                int dd = d.getDate();
                java.sql.Date date = new java.sql.Date(y, m, dd);
                Complaint c = new Complaint();
                c.setCategory(new Category(Integer.parseInt(category)));
                c.setProfile(p);
                c.setCreatedDate(date);
                c.setPending(true);
                c.setIssued(false);
                c.setCompleted(false);
                c.setNote(note);
                if (biz.create(c)) {
                    out.println("Created Successfully");
                }else{
                    out.println("Created Faily");
                }
            }
        } catch (NamingException ex) {
            ex.printStackTrace();
        } finally {
            out.close();
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
