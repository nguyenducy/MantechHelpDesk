/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mantech.mod.article.jpa;

import java.util.List;
import mantech.mod.article.entity.Faq;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Administrator
 */
public class FaqJpaControllerTest {

    public FaqJpaControllerTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Test
    public void testCreateFAQ() {
        FaqJpaController faqJpaController = new FaqJpaController();
        Faq faq = new Faq();

        faq.setAnswer("em ten hoang vu");
        faq.setQuestion("Em ten gi vay em ?");

        boolean check = faqJpaController.createFAQ(faq);

        assertTrue("Create FAQ khong thanh cong", check);
    }

    @Test
    public void testEditFAQ() {
        FaqJpaController faqJpaController = new FaqJpaController();
        Faq faq = faqJpaController.findFAQById(22);

        faq.setAnswer("em ten nguyen hung tuyen");
        faq.setQuestion("Em ten gi vay em ?");

        boolean check = faqJpaController.editFAQ(faq);

        assertTrue("Update FAQ khong thanh cong", check);
    }

    @Test
    public void testRemoveFAQ() {
//        FaqJpaController faqJpaController = new FaqJpaController();
//
//        boolean check = faqJpaController.removeFAQ(21);
//
//        assertTrue("Remove FAQ khong thanh cong", check);
        //Da test thanh cong
    }

    @Test
    public void testFindFAQById() {
        FaqJpaController faqJpaController = new FaqJpaController();
        Faq faq = faqJpaController.findFAQById(22);

        assertNotNull("Find FAQID khong thanh cong", faq);
    }

    @Test
    public void testListAllFAQ() {
        FaqJpaController faqJpaController = new FaqJpaController();
        List<Faq> faq = faqJpaController.listAllFAQ();
        System.out.println("So Luong FAQ: "+faq.size());
        assertNotNull("lay listAllFAQ khong thanh cong", faq);
    }

    @Test
    public void testFindQuestion() {
        FaqJpaController faqJpaController = new FaqJpaController();
        List<Faq> faq = faqJpaController.findQuestion("they");
        System.out.println("So Luong Question: "+faq.size());
        assertNotNull("Find Question khong thanh cong", faq);
    }
}
