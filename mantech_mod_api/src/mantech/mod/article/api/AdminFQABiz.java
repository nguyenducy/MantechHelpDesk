/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mantech.mod.article.api;

import java.util.List;
import mantech.mod.article.entity.Faq;

/**
 *
 * @author NDC
 */
public interface AdminFQABiz {

    void create(Faq faq);
    void edit(Faq faq);
    void remove(Faq faq);
    Faq find(Object id);
    List<Faq> findAll();
    
}
