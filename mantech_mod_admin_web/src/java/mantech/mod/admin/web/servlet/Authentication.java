/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mantech.mod.admin.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import mantech.mod.account.api.AccountBiz;
import mantech.mod.account.api.ProfileBiz;
import mantech.mod.account.entity.Account;

/**
 *
 * @author NGUYEN
 */
public class Authentication extends HttpServlet {

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
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        InitialContext context = null;
        try {
            context = new InitialContext();
            AccountBiz biz = (AccountBiz) context.lookup("ejb/mantech/saigon/AccountBiz");
            if (biz.usernameAvailable(username)) {
                Account a = biz.checkLogin(username, password);
                if (a != null) {
                    String name = a.getProfile().getFullName();
                    HttpSession session = request.getSession();
                    session.putValue("username", name);
                    session.putValue("idCurrentUser", a.getId().toString());
                    if (a.getRole().getRole().equalsIgnoreCase("admin")) {
                        response.sendRedirect("index.jsp");
                    } else if (a.getRole().getRole().equalsIgnoreCase("technician")) {
                        response.sendRedirect("Technician/CompletedForm.jsp");
                    } else {
                        response.sendRedirect("login.html");
                    }
                } else {
                    response.sendRedirect("login.html");
                }
            } else {
                response.sendRedirect("login.html");
            }

        } catch (Exception e) {
            e.printStackTrace();
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
