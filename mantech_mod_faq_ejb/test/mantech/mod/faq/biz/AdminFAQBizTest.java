/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mantech.mod.faq.biz;

import mantech.mod.article.api.FAQBiz;
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
public class AdminFAQBizTest {

    public AdminFAQBizTest() {
    }
    static FAQBiz afaqBiz = null;

    @BeforeClass
    public static void setUpClass() throws Exception {
        afaqBiz = new mantech.mod.faq.biz.FAQBiz() {};
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Test
    public void testCreateFAQ() throws Exception {

        Faq faq = new Faq();

        faq.setAnswer("em ten hoang vu");
        faq.setQuestion("Em ten gi vay em ?");

        boolean check = afaqBiz.createFAQ(faq);

        assertTrue("Create FAQ khong thanh cong", check);
    }

    @Test
    public void testEditFAQ() throws Exception {
        int id = idFAQ(afaqBiz.listAllFAQ());

        Faq faq = afaqBiz.findFAQById(id);

        faq.setAnswer("em ten nguyen hung tuyen");
        faq.setQuestion("Em ten gi vay em ?");

        boolean check = afaqBiz.editFAQ(faq);

        assertTrue("Update FAQ khong thanh cong", check);
    }

   
    @Test
    public void testFindFAQById() throws Exception {
        List<Faq> list = afaqBiz.listAllFAQ();
        int id = idFAQ(list);
        Faq faq = afaqBiz.findFAQById(id);

        assertNotNull("Find FAQID khong thanh cong", faq);
    }

    @Test
    public void testListAllFAQ() throws Exception {

        List<Faq> faq = afaqBiz.listAllFAQ();
        System.out.println("So Luong FAQ: "+faq.size());
        assertNotNull("lay listAllFAQ khong thanh cong", faq);
    }

    @Test
    public void testFindQuestion() throws Exception {

        List<Faq> faq = afaqBiz.findQuestion("they");
        System.out.println("So Luong Question tim duoc: "+faq.size());
        assertNotNull("Find Question khong thanh cong", faq);
    }

     @Test
    public void testRemoveFAQ() throws Exception {

        int id = idFAQ(afaqBiz.listAllFAQ());

        boolean check = afaqBiz.removeFAQ(id);

        assertTrue("Remove FAQ khong thanh cong", check);
    }

    private int idFAQ(List<Faq> faqs){
        int i =0;
        for (Faq faq : faqs) {
            if(i<faq.getId()){
                i = faq.getId();
            }
        }
        return i;
    }

}
