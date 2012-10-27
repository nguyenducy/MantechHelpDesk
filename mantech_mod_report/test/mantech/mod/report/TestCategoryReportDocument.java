/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mantech.mod.report;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import mantech.mod.report.entity.CategoryReport;

/**
 *
 * @author NGUYEN
 */
public class TestCategoryReportDocument {

    public static void main(String[] arg){
        List list = new ArrayList();
        list.add(new CategoryReport("Software", new Date(2012, 2, 8),
                new Date(2012, 6, 24), "protostar reaches the gas and a USD33.12 the in After capture Through",
                "Morgana Mayers", "Celestine Bastion", 137));
        list.add(new CategoryReport("Hardware", new Date(2012, 3, 9), 
                new Date(2012, 5, 3), "protostar reaches the gas and a USD33.12 the in After capture Through",
                "Hugo Bullard", "Nancy Ramsey", 55));
        CategoryReportDocument document = new CategoryReportDocument();
        document.covertListToDRDateSource(list);
        document.build();
    }
}
