/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mantech.mod.article.jpa;

import java.sql.Date;
import java.util.List;
import mantech.mod.article.entity.Article;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Administrator
 */
public class ArticleJpaControllerTest {

    public ArticleJpaControllerTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Test
    public void testFindArticleEntities() {

    }

    @Test
    public void testCreateNewArticle() {
        ArticleJpaController articleJpaController = new ArticleJpaController();
        Article article = new Article();
        article.setArticle("hoangvu");
        article.setContent("hoangvubrvt@gmaasdasdasdasd");
        article.setCreatedDate(Date.valueOf("2012-02-22"));
        article.setRate(4);
        article.setThumbnail("asdjahsdjahsdjas");
        boolean check = articleJpaController.createNewArticle(article);

        Assert.assertTrue("Test Them Article Khong Thanh Cong", check);
    }

    @Test
    public void testEditArticle() {
        ArticleJpaController articleJpaController = new ArticleJpaController();
        Article articleFirst = articleJpaController.findById(23);

        Article articleUpdate = articleJpaController.findById(23);
        articleUpdate.setArticle("nguyen hoang trung tin");
        articleUpdate.setContent("da update duoc roi");
        articleUpdate.setCreatedDate(Date.valueOf("2012-12-12"));
        articleUpdate.setRate(1);

        boolean check = articleJpaController.editArticle(articleUpdate);

        Article articleSecond = articleJpaController.findById(23);

        Assert.assertTrue("Update Khong Thanh Cong: "+check,check);
        Assert.assertNotSame("Update Khong Thanh Cong", articleFirst, articleSecond);

    }

    @Test
    public void testRemoveArticle() {
        
//        ArticleJpaController articleJpaController = new ArticleJpaController();
//        boolean check = articleJpaController.removeArticle(22);
//
//        Assert.assertTrue("Remove Khong Thanh Cong: "+check,check);
        //Da Test Thanh Cong
    }

    @Test
    public void testFindById() {
        ArticleJpaController articleJpaController = new ArticleJpaController();
        Article articleFirst = articleJpaController.findById(23);
        
        Assert.assertNotNull("TIm Kiem By Id Khong Thanh Cong", articleFirst);
    }

    @Test
    public void testFindByLikeArticle() {
        ArticleJpaController articleJpaController = new ArticleJpaController();
        List<Article> articleList = articleJpaController.findByLikeArticle("ha");

        int count = articleList.size();
        System.out.println("So luong: "+count);
        Assert.assertNotNull("TIm Kiem By Like Article Khong Thanh Cong", articleList);
    }

    @Test
    public void testFindLikeArticleContent() {
        ArticleJpaController articleJpaController = new ArticleJpaController();
        List<Article> articleList = articleJpaController.findLikeArticleContent("ha");

        int count = articleList.size();
        System.out.println("So luong: "+count);
        Assert.assertNotNull("Tim Kiem By Like Article va Content Khong Thanh Cong", articleList);
    }

    @Test
    public void testFindByRate() {
        ArticleJpaController articleJpaController = new ArticleJpaController();
        List<Article> articleList = articleJpaController.findByRate(4);

        int count = articleList.size();
        System.out.println("So luong: "+count);
        Assert.assertNotNull("Tim Kiem By Rate Khong Thanh Cong", articleList);
    }

    @Test
    public void testFindByHigherRate() {
        ArticleJpaController articleJpaController = new ArticleJpaController();
        List<Article> articleList = articleJpaController.findByHigherRate(3);

        int count = articleList.size();
        System.out.println("So luong: "+count);
        Assert.assertNotNull("Tim Kiem By HigherRate Khong Thanh Cong", articleList);
    }

    @Test
    public void testFindByCreatedDate() {
        ArticleJpaController articleJpaController = new ArticleJpaController();
        List<Article> articleList = articleJpaController.findByCreatedDate(Date.valueOf("2012-02-22"));

        int count = articleList.size();
        System.out.println("So luong: "+count);
        Assert.assertNotNull("Tim Kiem By CreateDate Khong Thanh Cong", articleList);
    }

    @Test
    public void testFindBetweenCreatedDate() {
        ArticleJpaController articleJpaController = new ArticleJpaController();
        List<Article> articleList = articleJpaController.findBetweenCreatedDate(Date.valueOf("2012-01-01"),Date.valueOf("2012-02-22"));

        int count = articleList.size();
        System.out.println("So luong: "+count);
        Assert.assertNotNull("Tim Kiem By BetweenCreateDate Khong Thanh Cong", articleList);
    }

    @Test
    public void testFindByAfterCreatedDate() {
        ArticleJpaController articleJpaController = new ArticleJpaController();
        List<Article> articleList = articleJpaController.findByAfterCreatedDate(Date.valueOf("2012-01-01"));

        int count = articleList.size();
        System.out.println("So luong: "+count);
        Assert.assertNotNull("Tim Kiem By AfterCreateDate Khong Thanh Cong", articleList);
    }

    @Test
    public void testCollectNewsArticle() {
        ArticleJpaController articleJpaController = new ArticleJpaController();
        List<Article> articleList = articleJpaController.collectNewsArticle();

        int count = articleList.size();
        System.out.println("So luong: "+count);
        Assert.assertNotNull("Collect New Article Khong Thanh Cong", articleList);
    }

}