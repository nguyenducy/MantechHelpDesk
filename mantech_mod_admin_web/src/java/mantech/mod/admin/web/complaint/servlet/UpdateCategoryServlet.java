/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mantech.mod.admin.web.complaint.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mantech.mod.complaint.api.CategoryBiz;
import mantech.mod.complaint.entity.Category;

/**
 *
 * @author NGUYEN
 */
public class UpdateCategoryServlet extends HttpServlet {

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
        String id = request.getParameter("id");
        String category = request.getParameter("category");
        String description = request.getParameter("description");
        InitialContext context = null;
        try {
            context = new InitialContext();
            CategoryBiz biz = (CategoryBiz) context.lookup("ejb/mantech/saigon/CategoryBiz");
            Category c = biz.find(Integer.parseInt(id));
            c.setName(category);
            c.setDescription(description);
            if (biz.UpdateCategory(c)) {
                out.println("<h4 class='alert_info'>Updated Successfully</h4>");
            } else {
                out.println("<h4 class='alert_info'>Updated Faily</h4>");
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
