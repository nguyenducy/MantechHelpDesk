/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mantech.mod.article.api;

import java.util.List;
import mantech.mod.article.entity.Article;

/**
 *
 * @author NDC
 */
public interface AdminArticleBiz {

    void create(Article article);

    void edit(Article article);

    void remove(Article article);

    Article find(Object id);

    List<Article> findAll();
}
