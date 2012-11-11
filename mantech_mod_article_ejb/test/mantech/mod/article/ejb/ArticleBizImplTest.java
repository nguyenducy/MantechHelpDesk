/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mantech.mod.article.ejb;

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
public class ArticleBizImplTest {

    public ArticleBizImplTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Test
    public void testCreateNewArticle() throws Exception {
    }

    @Test
    public void testEditArticle() throws Exception {
    }

    @Test
    public void testRemoveArticle() throws Exception {
    }

    @Test
    public void testFindById() throws Exception {
    }

    @Test
    public void testCollectNewsArticle() throws Exception {
       ArticleBizImpl bizImpl = new ArticleBizImpl();
        List<Article> result = bizImpl.collectNewsArticle();
        for (Article a : result) {
            System.out.println(a.getId());
        }
        assertNotNull(result);
    }

}