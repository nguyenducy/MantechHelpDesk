/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mantech.mod.article.biz;


import java.sql.Date;
import java.util.List;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import mantech.mod.article.entity.Article;
import mantech.mod.article.jpa.ArticleJpaController;

/**
 *
 * @author Administrator
 */
@Stateless(name = "AdminArticleBiz", mappedName = "ejb/mantech/saigon/AdminArticleBiz")
@Remote(mantech.mod.article.api.biz.ArticleBiz.class)
public class ArticleBiz implements mantech.mod.article.api.biz.ArticleBiz {

    final String entityManagerFactoryString = "mantech_mod_jpaPU";
    ArticleJpaController articleJpa = null;
    EntityManagerFactory entityManagerFactory = null;

    public ArticleBiz() {
        this.entityManagerFactory = Persistence.createEntityManagerFactory(entityManagerFactoryString);

    }

    @Override
    public boolean createNewArticle(Article article) {
        this.articleJpa = new ArticleJpaController(entityManagerFactory);

        boolean check = false;
        if (article != null) {
            check = articleJpa.createNewArticle(article);
        }
        return check;
    }

    @Override
    public boolean editArticle(Article article) {
        this.articleJpa = new ArticleJpaController(entityManagerFactory);

        Article a = findById(article.getId());

        a.setArticle(article.getArticle());
        a.setContent(article.getContent());
        a.setThumbnail(article.getThumbnail());
        
        boolean check = false;
        if (a != null) {
            check = articleJpa.editArticle(a);
        }
        return check;
    }

    @Override
    public boolean removeArticle(int articleId) {
        this.articleJpa = new ArticleJpaController(entityManagerFactory);
        boolean check = false;
        if (articleId > 0) {
            check = articleJpa.removeArticle(articleId);
        }
        return check;
    }

    @Override
    public Article findById(int id) {
        this.articleJpa = new ArticleJpaController(entityManagerFactory);
        Article article = null;
        if (id > 0) {
            article = articleJpa.findById(id);
        }
        return article;
    }

    @Override
    public List<Article> findByLikeArticle(String articleTitle) {
        List<Article> listArticle = null;
        this.articleJpa = new ArticleJpaController(entityManagerFactory);
        if (!articleTitle.isEmpty() || articleTitle != null) {
            listArticle = articleJpa.findByLikeArticle(articleTitle);
        }
        return listArticle;
    }

    @Override
    public List<Article> findLikeArticleContent(String contentString) {
        List<Article> listArticle = null;
        this.articleJpa = new ArticleJpaController(entityManagerFactory);
        if (!contentString.isEmpty() || contentString != null) {
            listArticle = articleJpa.findLikeArticleContent(contentString);
        }
        return listArticle;
    }

    @Override
    public List<Article> findByRate(int rate) {
        List<Article> listArticle = null;
        this.articleJpa = new ArticleJpaController(entityManagerFactory);
        if (rate > 0) {
            listArticle = articleJpa.findByRate(rate);
        }
        return listArticle;
    }

    @Override
    public List<Article> findByHigherRate(int rate) {
        List<Article> listArticle = null;
        this.articleJpa = new ArticleJpaController(entityManagerFactory);
        if (rate > 0) {
            listArticle = articleJpa.findByHigherRate(rate);
        }
        return listArticle;
    }

    @Override
    public List<Article> findByCreatedDate(Date createDate) {
        List<Article> listArticle = null;
        this.articleJpa = new ArticleJpaController(entityManagerFactory);
        if (createDate != null) {
            listArticle = articleJpa.findByCreatedDate(createDate);
        }
        return listArticle;
    }

    @Override
    public List<Article> findBetweenCreatedDate(Date date1, Date date2) {
        List<Article> listArticle = null;
        this.articleJpa = new ArticleJpaController(entityManagerFactory);
        if (date1 != null && date2 != null) {
            if (date1.before(date2)) {
                listArticle = articleJpa.findBetweenCreatedDate(date1, date2);
            }
        }
        return listArticle;
    }

    @Override
    public List<Article> findByAfterCreatedDate(Date date) {
        List<Article> listArticle = null;
        this.articleJpa = new ArticleJpaController(entityManagerFactory);
        if (date != null) {
            listArticle = articleJpa.findByAfterCreatedDate(date);
        }
        return listArticle;
    }

    @Override
    public List<Article> collectNewsArticle() {
        List<Article> listArticle = null;
        this.articleJpa = new ArticleJpaController(entityManagerFactory);

        listArticle = articleJpa.collectNewsArticle();

        return listArticle;
    }
}
