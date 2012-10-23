/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mantech.mod.article.servlet;

import java.io.IOException;
import java.sql.Date;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import mantech.mod.article.api.biz.AdminArticleBizInterface;
import mantech.mod.article.entity.Article;
import mantech.mod.article.parameter.ParameterArticle.Parameter;

/**
 *
 * @author hoangvu
 */
@WebServlet(name = "insertArticleServlet", urlPatterns = "/insertArticle")
public class InsertArticleServlet extends HttpServlet {

    @EJB(lookup="ejb/mantech/saigon/AdminArticleBiz")
    private AdminArticleBizInterface articleBiz;
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        final String articleTitle = request.getParameter(Parameter.ARTICLE_TITLE);
        final String articleContent = request.getParameter(Parameter.ARTICLE_CONTENT);
        final String thumbnail = request.getParameter(Parameter.ARTICLE_THUMBNAIL);

        HttpSession session = request.getSession();
        Date dateCreate = new Date(System.currentTimeMillis());
        
        response.setContentType("text/html;charset=UTF-8");
        Article article = null;

        article.setArticle(articleTitle);
        article.setContent(articleContent);
        article.setRate(0);
        article.setThumbnail(thumbnail);
        article.setCreatedDate(dateCreate);

       

       if(articleBiz.createNewArticle(article)){
            session.setAttribute("insertArticle", "success");
       }else{
            session.setAttribute("insertArticle", "fail");
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