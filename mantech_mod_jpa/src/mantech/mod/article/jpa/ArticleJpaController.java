/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mantech.mod.article.jpa;

import java.sql.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import mantech.mod.article.entity.Article;
import mantech.mod.article.jpa.exceptions.NonexistentEntityException;
import mantech.mod.article.jpa.exceptions.PreexistingEntityException;

/**
 *
 * @author NGUYEN
 */
public class ArticleJpaController {

    final String collectNewsArticleQuery = "Article.collectNewsArticle";
    final String findByIdQuery = "Article.findById";
    final String findByArticleQuery = "Article.findByArticle";
    final String findByLikeArticleQuery = "Article.findByLikeArticle";
    final String findByLikeArticleContantQuery = "Article.findByLikeArticleContant";
    final String findByCreatedDateQuery = "Article.findByCreatedDate";
    final String findBetweenCreatedDateQuery = "Article.findBetweenCreatedDate";
    final String findAfterCreatedDate = "Article.findAfterCreatedDate";
    final String findByRateQuery = "Article.findByRate";
    final String findByHigherRateQuery = "Article.findByHigherRate";
    final String findByThumbnailQuery = "Article.findByThumbnail";

    public ArticleJpaController() {
        emf = Persistence.createEntityManagerFactory("mantech_mod_jpaPU");
    }

    public ArticleJpaController(EntityManagerFactory entityManagerFactory) {
        this.emf = entityManagerFactory;
        ;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    private void create(Article article) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(article);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findArticle(article.getId()) != null) {
                throw new PreexistingEntityException("Article " + article + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    private void edit(Article article) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            article = em.merge(article);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = article.getId();
                if (findArticle(id) == null) {
                    throw new NonexistentEntityException("The article with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    private void destroy(Integer id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Article article;
            try {
                article = em.getReference(Article.class, id);
                article.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The article with id " + id + " no longer exists.", enfe);
            }
            em.remove(article);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    private List<Article> findArticleEntities() {
        return findArticleEntities(true, -1, -1);
    }

    public List<Article> findArticleEntities(int maxResults, int firstResult) {
        return findArticleEntities(false, maxResults, firstResult);
    }

    private List<Article> findArticleEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Article.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    private Article findArticle(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Article.class, id);
        } finally {
            em.close();
        }
    }

    public int getArticleCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Article> rt = cq.from(Article.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

    public boolean createNewArticle(Article article) {
        boolean check = false;
        try {
            this.create(article);
            check = true;
        } catch (PreexistingEntityException ex) {
            check = false;
            ex.printStackTrace();
        } catch (Exception ex) {
            check = false;
            ex.printStackTrace();
        }
        return check;
    }

    public boolean editArticle(Article article) {
        boolean check = false;
        try {
            if (article.getRate() > 0) {
                this.edit(article);
                check = true;
            }
        } catch (NonexistentEntityException ex) {
            check = false;
            ex.printStackTrace();
        } catch (Exception ex) {
            check = false;
            ex.printStackTrace();
        }
        return check;
    }

    public Article findById(int id) {
        Article article = null;

        int i = (Integer) id;
        if (i > 0) {
            article = this.findArticle(i);
        }
        return article;
    }

    public List<Article> findByLikeArticle(String articleTitle) {
        List<Article> listArticle = null;
        EntityManager em = this.getEntityManager();
        if (articleTitle != null || !articleTitle.isEmpty()) {
            Query query = em.createNamedQuery(this.findByLikeArticleQuery);
            String parameter = "%" + articleTitle + "%";
            query.setParameter("article", parameter);

            listArticle = query.getResultList();

        }

        return listArticle;
    }

    public List<Article> findLikeArticleContent(String contentString) {
        List<Article> list = null;
        if (contentString != null || !contentString.isEmpty()) {

            EntityManager em = this.getEntityManager();
            Query query = em.createNamedQuery(this.findByLikeArticleContantQuery);
            String paramater = "%" + contentString + "%";
            query.setParameter("contentString", paramater);

            list = query.getResultList();
        }
        return list;
    }

    public List<Article> findByRate(int rate) {
        List<Article> list = null;
        if (rate > 0) {
            EntityManager em = this.getEntityManager();
            Query query = em.createNamedQuery(this.findByRateQuery);
            query.setParameter("rate", rate);

            list = query.getResultList();
        }
        return list;
    }

    public List<Article> findByHigherRate(int rate) {
        List<Article> list = null;
        if (rate > 0) {
            EntityManager em = this.getEntityManager();
            Query query = em.createNamedQuery(this.findByHigherRateQuery);
            query.setParameter("rate", rate);

            list = query.getResultList();
        }
        return list;
    }

    public List<Article> findByCreatedDate(Date createDate) {
        List<Article> list = null;
        if (createDate != null) {
            EntityManager em = this.getEntityManager();
            Query query = em.createNamedQuery(this.findByCreatedDateQuery);
            query.setParameter("createdDate", createDate);

            list = query.getResultList();
        }
        return list;
    }

    public List<Article> findBetweenCreatedDate(Date date1, Date date2) {
        List<Article> list = null;
        if (date1 != null && date2 != null) {
            if (date1.before(date2)) {
                EntityManager em = this.getEntityManager();
                Query query = em.createNamedQuery(this.findBetweenCreatedDateQuery);
                query.setParameter("date1", date1);
                query.setParameter("date2", date2);

                list = query.getResultList();
            }
        }
        return list;
    }

    public List<Article> findByAfterCreatedDate(Date date) {
        List<Article> list = null;
        if (date != null) {
            EntityManager em = this.getEntityManager();
            Query query = em.createNamedQuery(this.findAfterCreatedDate);
            query.setParameter("createdDate", date);

            list = query.getResultList();
        }
        return list;
    }

    public List<Article> collectNewsArticle() {

        EntityManager em = this.getEntityManager();

        Query query = em.createNamedQuery(this.collectNewsArticleQuery);
        List<Article> list = query.getResultList();

        return list;
    }

    public boolean removeArticle(int articleId) {
        boolean check = false;
        try {
            if (articleId > 0) {
                this.destroy(articleId);
                check = true;
            }
        } catch (NonexistentEntityException ex) {
            check = false;
            ex.printStackTrace();
        }
        return check;
    }
}
