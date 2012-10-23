/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mantech.mod.FAQ.servlet;

import java.io.IOException;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import mantech.mod.FAQ.parameter.ParameterFAQ.Parameter;
import mantech.mod.article.api.biz.AdminFAQBizInterface;
import mantech.mod.article.entity.Faq;

/**
 *
 * @author hoangvu
 */
@WebServlet(name="FindFAQByQuestionServlet", urlPatterns="/findFAQByQuestion")
public class FindFAQByQuestionServlet extends HttpServlet {

    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @EJB(lookup = "ejb/mantech/saigon/AdminFAQBiz")
    private AdminFAQBizInterface faqBizz;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        HttpSession session = request.getSession();
        final String searchString = request.getParameter(Parameter.FAQ_SEARCH);
        List<Faq> listFAQ = faqBizz.findQuestion(searchString);
        if (listFAQ.size()>0 || listFAQ!=null) {
            session.setAttribute("listQuestionFAQ",listFAQ);
        } else {
            session.setAttribute("listQuestionFAQ", "fail");
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
