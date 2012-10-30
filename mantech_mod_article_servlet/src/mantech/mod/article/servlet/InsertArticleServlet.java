/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mantech.mod.article.servlet;


import java.io.IOException;
import java.sql.Date;
import java.util.Hashtable;
import java.util.UUID;
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
import mantech.mod.util.FileUpload;

/**
 *
 * @author hoangvu
 */
@WebServlet(name = "InsertArticleServlet", urlPatterns = "/insertArticleServlet")
public class InsertArticleServlet extends HttpServlet {

    @EJB(lookup = "ejb/mantech/saigon/AdminArticleBiz")
    private AdminArticleBizInterface articleBiz;

    @Override
    protected void doGet(HttpServletRequest hsr, HttpServletResponse hsr1) throws ServletException, IOException {
        Insert(hsr, hsr1);
    }

    @Override
    protected void doPost(HttpServletRequest hsr, HttpServletResponse hsr1) throws ServletException, IOException {
        Insert(hsr, hsr1);
    }

    public void Insert(HttpServletRequest request, HttpServletResponse response) {
        final String url = request.getContextPath() + "/loadCollectArticle";
        final String uploadFolder = getServletContext().getRealPath("/")+"imagesThumb";

        final String rename = UUID.randomUUID().toString();;

        System.out.println("File Upload folder: "+uploadFolder);
        FileUpload fileUpload = new FileUpload(uploadFolder, request, rename);
        
        Hashtable parameter = fileUpload.getParameter();

        final String articleTitle = (String) parameter.get(Parameter.ARTICLE_TITLE);
        final String articleContent =(String) parameter.get(Parameter.ARTICLE_CONTENT);

        final String thumbnail = fileUpload.getFileName();

        HttpSession session = request.getSession();
        Date dateCreate = new Date(System.currentTimeMillis());

        Article article = new Article();

        article.setArticle(articleTitle);
        article.setContent(articleContent);
        article.setRate(0);
        article.setThumbnail(thumbnail);
        article.setCreatedDate(dateCreate);

        if (articleBiz.createNewArticle(article)) {
            try {
                //session.setAttribute("insertArticle", "success");         
                fileUpload.save();

                response.sendRedirect(url);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        } else {
            session.setAttribute("insertArticle", "fail");
        }
    }
}
