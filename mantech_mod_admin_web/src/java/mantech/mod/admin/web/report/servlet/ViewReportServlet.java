/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mantech.mod.admin.web.report.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mantech.mod.report.CategoryReportDocument;
import mantech.mod.report.DepartmentReportDocument;
import mantech.mod.report.dal.CategoryReportJpaController;
import mantech.mod.report.dal.DepartmentReportJpaController;
import mantech.mod.report.entity.CategoryReport;
import mantech.mod.report.entity.DepartmentReport;

/**
 *
 * @author NGUYEN
 */
public class ViewReportServlet extends HttpServlet {

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

        try {
            int type = Integer.parseInt(request.getParameter("type"));
            switch (type) {
                case 1:
                    buildCategoryReport();
                    break;
                default:
                    buildDepartmentReport();
                    break;
            }
            response.sendRedirect("Reports/ViewReport.jsp");
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

    private void buildCategoryReport() {
        try {
            List<CategoryReport> list = new ArrayList<CategoryReport>();
            CategoryReportJpaController controller = new CategoryReportJpaController();
            list = controller.findAll();
            CategoryReportDocument document = new CategoryReportDocument();
            document.covertListToDRDateSource(list);
            document.build();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void buildDepartmentReport() {
        try {
            List<DepartmentReport> list = new ArrayList<DepartmentReport>();
            DepartmentReportJpaController controller = new DepartmentReportJpaController();
            list = controller.findAll();
            DepartmentReportDocument document = new DepartmentReportDocument();
            document.covertListToDRDateSource(list);
            document.build();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
