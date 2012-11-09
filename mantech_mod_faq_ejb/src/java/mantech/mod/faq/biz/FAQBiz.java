/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mantech.mod.faq.biz;

import java.util.List;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import mantech.mod.article.entity.Faq;
import mantech.mod.article.jpa.FaqJpaController;

/**
 *
 * @author Administrator
 */
@Stateless(name = "FAQBiz", mappedName = "ejb/mantech/saigon/FAQBiz")
@Remote(mantech.mod.article.api.FAQBiz.class)
public class FAQBiz implements mantech.mod.article.api.FAQBiz {

    final String entityManagerString = "mantech_mod_jpaPU";
    EntityManagerFactory entityManagerFactory = null;
    //AdminFAQDalInterface fAQJpa = null;
    FaqJpaController fAQJpa=null;
    public FAQBiz() {
        this.entityManagerFactory = Persistence.createEntityManagerFactory(entityManagerString);

    }

    @Override
    public boolean createFAQ(Faq faq) {
        this.fAQJpa = new FaqJpaController(entityManagerFactory);
        boolean check = false;
        if (faq != null) {
            check = fAQJpa.createFAQ(faq);
        }
        return check;
    }

    @Override
    public boolean editFAQ(Faq faq) {
        this.fAQJpa = new FaqJpaController(entityManagerFactory);
        boolean check = false;
        if (faq != null) {
            check = fAQJpa.editFAQ(faq);
        }
        return check;
    }

    @Override
    public boolean removeFAQ(int faqId) {
        this.fAQJpa = new FaqJpaController(entityManagerFactory);
        boolean check = false;
        if (faqId > 0) {
            check = fAQJpa.removeFAQ(faqId);
        }
        return check;
    }

    @Override
    public Faq findFAQById(int fqaId) {
        this.fAQJpa = new FaqJpaController(entityManagerFactory);
        Faq faq = null;
        if (fqaId > 0) {
            faq = fAQJpa.findFAQById(fqaId);
        }
        return faq;
    }

    @Override
    public List<Faq> listAllFAQ() {
        this.fAQJpa = new FaqJpaController(entityManagerFactory);
        List<Faq> faqList = null;

        faqList = fAQJpa.listAllFAQ();

        return faqList;
    }

    @Override
    public List<Faq> findQuestion(String question) {
        this.fAQJpa = new FaqJpaController(entityManagerFactory);
        List<Faq> faqList = null;
        if (!question.isEmpty() || question != null) {
            faqList = fAQJpa.findQuestion(question);
        }
        return faqList;
    }
}
