/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mantech.mod.article.servlet;

import java.io.File;
import java.io.IOException;
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
@WebServlet(name = "deleteArticleServlet", urlPatterns = "/deleteArticle")
public class DeleteArticleServlet extends HttpServlet {

    @EJB(lookup = "ejb/mantech/saigon/AdminArticleBiz")
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
        response.setContentType("text/html;charset=UTF-8");

        String url = request.getContextPath() + "/loadCollectArticle";

        final int idArticle = Integer.parseInt(request.getParameter(Parameter.ARTICLE_ID));
        HttpSession session = request.getSession();
        Article article = articleBiz.findById(idArticle);

        String filePath = getServletContext().getRealPath("/") + "imagesThumb\\" + article.getThumbnail();
        String s = getServletContext().getContextPath();
        boolean checkDelete = articleBiz.removeArticle(idArticle);
        if (checkDelete) {
            //session.setAttribute("deleteArticle", "success");
            this.deleteFile(filePath);
            response.sendRedirect(url);
        } else {
            session.setAttribute("deleteArticle", "fail");
        }
    }

    private boolean deleteFile(String filePath) {
        boolean check = false;
        
        File f = new File(filePath);
            check = f.delete();
        if (check) {
            System.out.println("Delete File Thanh Cong");
        } else {
            System.out.println("Delete Khong Thanh Cong");
        }
        return check;
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
