/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mantech.mod.article.ejb;

import java.util.List;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import mantech.mod.article.entity.Article;
import mantech.mod.article.jpa.ArticleJpaController;

/**
 *
 * @author Administrator
 */
@Stateless(name = "ArticleBiz", mappedName = "ejb/mantech/saigon/ArticleBiz")
@Remote(mantech.mod.article.api.ArticleBiz.class)
public class ArticleBizImpl implements mantech.mod.article.api.ArticleBiz {

    @Override
    public boolean createNewArticle(Article article) {
        try {
            ArticleJpaController controller = new ArticleJpaController();
            controller.create(article);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean editArticle(Article article) {
        try {
            ArticleJpaController controller = new ArticleJpaController();
            controller.edit(article);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean removeArticle(int articleId) {
        try {
            ArticleJpaController controller = new ArticleJpaController();
            controller.destroy(articleId);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Article findById(int id) {
        try {
            ArticleJpaController controller = new ArticleJpaController();
            return controller.findArticle(id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Article> collectNewsArticle() {
        List<Article> list=null;
        try {
            ArticleJpaController controller = new ArticleJpaController();
            list = controller.listArticle();
        } catch (Exception e) {
            e.printStackTrace();
            
        }finally{
            return  list;
        }
    }
}
