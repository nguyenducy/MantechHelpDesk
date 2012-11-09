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
public interface FAQBiz {

    boolean createFAQ(Faq faq);

    boolean editFAQ(Faq faq);

    boolean removeFAQ(int faqId);

    Faq findFAQById(int fqaId);

    List<Faq> listAllFAQ();

    List<Faq> findQuestion(String question);
}
