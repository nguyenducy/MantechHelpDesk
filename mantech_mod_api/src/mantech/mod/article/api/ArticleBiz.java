/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mantech.mod.article.api;

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

    List<Article> collectNewsArticle();
}
