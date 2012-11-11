/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mantech.mod.article.jpa;

import java.util.List;
import mantech.mod.article.entity.Article;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author NGUYEN
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
    public void testGetEntityManager() {
    }

    @Test
    public void testCreate() {
    }

    @Test
    public void testEdit() throws Exception {
    }

    @Test
    public void testDestroy() throws Exception {
    }

    @Test
    public void testFindArticleEntities_0args() {
        ArticleJpaController controller = new ArticleJpaController();
        List<Article> result = controller.findArticleEntities();
        for (Article a : result) {
            System.out.println(a.getId());
        }
        assertNotNull(result);
    }

    @Test
    public void testFindArticleEntities_int_int() {
    }

    @Test
    public void testFindArticle() {
    }

    @Test
    public void testGetArticleCount() {
    }

}