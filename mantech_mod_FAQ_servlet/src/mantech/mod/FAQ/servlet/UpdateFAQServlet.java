/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mantech.mod.FAQ.servlet;

import java.io.IOException;
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
@WebServlet(name="UpdateFAQServlet", urlPatterns="/updateFAQ")
public class UpdateFAQServlet extends HttpServlet {

    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @EJB(lookup = "ejb/mantech/saigon/AdminFAQBiz")
    private AdminFAQBizInterface faqBizz;
    private final String SUCCESS = "success";
    private final String FAIL = "fail";
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();

        final String url = request.getContextPath()+"/loadFAQ";
        
        final int id = Integer.parseInt(request.getParameter(Parameter.FAQ_ID));
        final String question = request.getParameter(Parameter.FAQ_QUESTION);
        final String answer = request.getParameter(Parameter.FAQ_ANSWER);
        Faq faq = new Faq();

        faq.setId(id);
        faq.setAnswer(answer);
        faq.setQuestion(question);
        boolean check = faqBizz.editFAQ(faq);
        if(check){
            //session.setAttribute("updateFAQ", SUCCESS);
            response.sendRedirect(url);
        }else{
            session.setAttribute("updateFAQ", FAIL);
            response.sendRedirect(url);
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
