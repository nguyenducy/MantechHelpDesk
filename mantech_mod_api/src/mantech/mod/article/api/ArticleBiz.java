/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mantech.mod.article.api.biz;

import java.sql.Date;
import java.util.List;
import mantech.mod.article.entity.Article;

/**
 *
 * @author NDC
 */
public interface ArticleBiz {

    boolean createNewArticle(Article article);

    boolean editArticle(Article article);

    boolean removeArticle(int articleId);

    Article findById(int id);

    //List<Article> findAll();

    //Tim kiem Article Title voi tu khoa gan dung.
    List<Article> findByLikeArticle(String articleTitle);

    //Tim kiem Article voi noi dung va title co tu khoa contentString
    List<Article> findLikeArticleContent(String contentString);

    //Tim kiem Article voi chinh xac rate
    List<Article> findByRate(int rate);

    //TIm kiem Article voi rate lon hon rate nhap vao
    List<Article> findByHigherRate(int rate);

    //Tim kiem Article voi ngay tao Article
    List<Article> findByCreatedDate(Date createDate);

    //Tim kiem Article voi nhung ngay khoang tu date1 den date2
    List<Article> findBetweenCreatedDate(Date date1, Date date2);

    //Tim kiem Article voi nhung ngay tre hon date
    List<Article> findByAfterCreatedDate(Date date);

    //Lay toan bo Article duoc sap xep theo nhung ngay som nhat
    List<Article> collectNewsArticle();
}
