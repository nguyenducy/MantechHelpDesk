/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mantech.mod.article.biz;

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
public class AdminArticleBizTest {

    public AdminArticleBizTest() {
    }
    static AdminArticleBiz adminArticleBiz;

    @BeforeClass
    public static void setUpClass() throws Exception {
        adminArticleBiz = new AdminArticleBiz();
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Test
    public void testCreateNewArticle() throws Exception {
        Date date = new Date(System.currentTimeMillis());

        Article article = new Article();
        article.setArticle("So Dac Biet");
        article.setContent("So Dac Biet@gmaasdasdasdasd");
        article.setCreatedDate(date);
        article.setRate(4);
        article.setThumbnail("asdjahsdjahsdjas");
        boolean check = adminArticleBiz.createNewArticle(article);

        Assert.assertTrue("Test Them Article Khong Thanh Cong", check);
    }

    @Test
    public void testEditArticle() throws Exception {
        int id = idArticle(adminArticleBiz.collectNewsArticle());

        Article articleFirst = adminArticleBiz.findById(id);

        Article articleUpdate = adminArticleBiz.findById(id);
        articleUpdate.setArticle("nguyen hoang trung tin");
        articleUpdate.setContent("da update duoc roi");
        //articleUpdate.setCreatedDate(Date.valueOf("2012-12-12"));
        articleUpdate.setRate(1);
        articleUpdate.setThumbnail("jsdkfjskdfjsdkfjsdkfjsdkf");

        boolean check = adminArticleBiz.editArticle(articleUpdate);

        Article articleSecond = adminArticleBiz.findById(id);

        Assert.assertTrue("Update Khong Thanh Cong: " + check, check);
        Assert.assertNotSame("Update Khong Thanh Cong", articleFirst, articleSecond);
    }
   
    @Test
    public void testFindById() throws Exception {
        int id = idArticle(adminArticleBiz.collectNewsArticle());
        Article articleFirst = adminArticleBiz.findById(id);

        Assert.assertNotNull("TIm Kiem By Id Khong Thanh Cong", articleFirst);
    }

    @Test
    public void testFindByLikeArticle() throws Exception {

        List<Article> articleList = adminArticleBiz.findByLikeArticle("ha");

        int count = articleList.size();
        System.out.println("So luong: " + count);
        Assert.assertNotNull("TIm Kiem By Like Article Khong Thanh Cong", articleList);
    }

    @Test
    public void testFindLikeArticleContent() throws Exception {

        List<Article> articleList = adminArticleBiz.findLikeArticleContent("ha");

        int count = articleList.size();
        System.out.println("So luong: " + count);
        Assert.assertNotNull("Tim Kiem By Like Article va Content Khong Thanh Cong", articleList);
    }

    @Test
    public void testFindByRate() throws Exception {

        List<Article> articleList = adminArticleBiz.findByRate(4);

        int count = articleList.size();
        System.out.println("So luong: " + count);
        Assert.assertNotNull("Tim Kiem By Rate Khong Thanh Cong", articleList);
    }

    @Test
    public void testFindByHigherRate() throws Exception {

        List<Article> articleList = adminArticleBiz.findByHigherRate(3);

        int count = articleList.size();
        System.out.println("So luong: " + count);
        Assert.assertNotNull("Tim Kiem By HigherRate Khong Thanh Cong", articleList);
    }

    @Test
    public void testFindByCreatedDate() throws Exception {

        List<Article> articleList = adminArticleBiz.findByCreatedDate(Date.valueOf("2012-02-22"));

        int count = articleList.size();
        System.out.println("So luong: " + count);
        Assert.assertNotNull("Tim Kiem By CreateDate Khong Thanh Cong", articleList);
    }

    @Test
    public void testFindBetweenCreatedDate() throws Exception {

        List<Article> articleList = adminArticleBiz.findBetweenCreatedDate(Date.valueOf("2012-01-01"), Date.valueOf("2012-02-22"));

        int count = articleList.size();
        System.out.println("So luong: " + count);
        Assert.assertNotNull("Tim Kiem By BetweenCreateDate Khong Thanh Cong", articleList);
    }

    @Test
    public void testFindByAfterCreatedDate() throws Exception {

        List<Article> articleList = adminArticleBiz.findByAfterCreatedDate(Date.valueOf("2012-01-01"));

        int count = articleList.size();
        System.out.println("So luong: " + count);
        Assert.assertNotNull("Tim Kiem By AfterCreateDate Khong Thanh Cong", articleList);
    }

    @Test
    public void testCollectNewsArticle() throws Exception {

        List<Article> articleList = adminArticleBiz.collectNewsArticle();

        int count = articleList.size();
        System.out.println("So luong: "+count);
        Assert.assertNotNull("Collect New Article Khong Thanh Cong", articleList);
    }
//     @Test
//    public void testRemoveArticle() throws Exception {
//
//        int id = idArticle(adminArticleBiz.collectNewsArticle());
//        boolean check = adminArticleBiz.removeArticle(id);
//
//        Assert.assertTrue("Remove Khong Thanh Cong: " + check, check);
//    }
    private int idArticle(List<Article> articles){
        int id=0;
        for (Article article : articles) {
            if(id<article.getId()){
                id = article.getId();
            }
        }
        return id;
    }
}
