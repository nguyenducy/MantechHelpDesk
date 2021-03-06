/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mantech.mod.admin.web.faq.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.Hashtable;
import java.util.UUID;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mantech.mod.article.api.ArticleBiz;
import mantech.mod.article.entity.Article;
import mantech.mod.util.FileUpload;

/**
 *
 * @author NGUYEN
 */
public class InsertArticleServlet extends HttpServlet {

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
        String uploadFolder = getServletContext().getRealPath("\\ImageArticle");
        //String uploadFolder = "C:\\Mantech\\images\\Articles";
  

        FileUpload fileUpload = null;
        String name = UUID.randomUUID().toString();
        InitialContext context = null;
        try {
            fileUpload = new FileUpload(uploadFolder, request, name);
            Hashtable parameter = fileUpload.getParameter();
            String article = (String) parameter.get("article");
            String content = (String) parameter.get("content");
            String rate = (String) parameter.get("rate");
            String thumbnails = request.getContextPath()+"/ImageArticle/"+fileUpload.getFileName();
            thumbnails.replaceAll("/", "//");
            String thumbnail =  fileUpload.getFileName();
            System.out.println("Thumbnail: "+thumbnails);

            context = new InitialContext();
            
            ArticleBiz biz = (ArticleBiz) context.lookup("ejb/mantech/saigon/ArticleBiz");

            Article a = new Article();
            a.setArticle(article);
            a.setContent(content);
            java.util.Date d = new java.util.Date();
            int y = d.getYear();
            int m = d.getMonth();
            int dd = d.getDate();
            Date date = new Date(y, m, dd);
            a.setCreatedDate(date);
            a.setRate(Integer.parseInt(rate));
            a.setThumbnail(thumbnails);
            if (biz.createNewArticle(a)) {
                fileUpload.save();
                out.println("<h4 class='alert_info'>Created Successsfull</h4>");
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
