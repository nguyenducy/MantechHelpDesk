/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mantech.mod.report;

import java.util.ArrayList;
import java.util.List;
import mantech.mod.report.dal.CategoryReportJpaController;
import mantech.mod.report.entity.CategoryReport;

/**
 *
 * @author NGUYEN
 */
public class TestCategoryReportDocument {

    public static void main(String[] arg){
        List<CategoryReport> list = new ArrayList<CategoryReport>();
        CategoryReportJpaController controller = new CategoryReportJpaController();
        list = controller.findAll();
        CategoryReportDocument document = new CategoryReportDocument();
        document.covertListToDRDateSource(list);
        document.build();
    }
}
