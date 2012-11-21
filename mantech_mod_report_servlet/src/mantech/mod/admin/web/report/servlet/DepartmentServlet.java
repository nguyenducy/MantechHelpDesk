/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mantech.mod.admin.web.report.servlet;

import java.awt.Color;
import static net.sf.dynamicreports.report.builder.DynamicReports.*;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.sf.dynamicreports.report.builder.column.TextColumnBuilder;
import net.sf.dynamicreports.report.builder.style.StyleBuilder;
import net.sf.dynamicreports.report.constant.HorizontalAlignment;
import net.sf.dynamicreports.report.constant.PageOrientation;
import net.sf.dynamicreports.report.constant.PageType;
import net.sf.dynamicreports.report.constant.VerticalAlignment;
import net.sf.dynamicreports.report.exception.DRException;
import until.Connect;

/**
 *
 * @author NDC
 */
@WebServlet(name="DepartmentServlet",urlPatterns="/departmentServlet")
public class DepartmentServlet extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest req, HttpServletResponse resp)
    throws ServletException, IOException {
       resp.setContentType("application/pdf");
       
        OutputStream out = resp.getOutputStream();

        Connect con = new Connect();
        StyleBuilder boldStyle = stl.style().bold();
        StyleBuilder fontStyle = stl.style().setFontSize(35).setAlignment(HorizontalAlignment.CENTER, VerticalAlignment.TOP);
        StyleBuilder boldCenteredStyle = stl.style(boldStyle).setHorizontalAlignment(HorizontalAlignment.CENTER);
        StyleBuilder columnTitleStyle = stl.style(boldCenteredStyle).setBorder(stl.pen1Point()).setBackgroundColor(Color.LIGHT_GRAY);
        TextColumnBuilder<String> CategoryName = col.column("CategoryName", "CategoryName", type.stringType());
        TextColumnBuilder<String> EmployeeName = col.column("EmployeeName", "EmployeeName", type.stringType());
     //   TextColumnBuilder<String> DepartmentName = col.column("DepartmentName", "DepartmentName", type.stringType());
        TextColumnBuilder<Date> CreatedDate = col.column("CreatedDate", "CreatedDate", type.dateType());
        TextColumnBuilder<Date> CompletedDate = col.column("CompletedDate", "CompletedDate", type.dateType());
       // TextColumnBuilder<String> TechnicianName = col.column("TechnicianName", "TechnicianName", type.stringType());
        TextColumnBuilder<Integer> TimeTaken = col.column("TimeTaken", "TimeTaken", type.integerType());
        try {
            report() //.setColumnTitleStyle(null)
                    .setPageFormat(PageType.A4, PageOrientation.LANDSCAPE)
                    .setColumnTitleStyle(columnTitleStyle).highlightDetailEvenRows()
                    .columns(CategoryName, EmployeeName,  CreatedDate, CompletedDate, TimeTaken)
                    .title(cmp.text("Department Report").setStyle(fontStyle))
                    .pageFooter(cmp.pageXofY().setStyle(boldCenteredStyle))
                    .pageFooter(cmp.text("Date:"))
                    .pageFooter(cmp.currentDate())
                    .setDataSource("Select * from R_DepartmentReport order by DepartmentName ", con.Getconnet())
                    .toPdf(out);
        } catch (DRException e) {
            e.printStackTrace();
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
