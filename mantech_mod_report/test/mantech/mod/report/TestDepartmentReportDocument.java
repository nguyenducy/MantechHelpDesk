/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mantech.mod.report;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import mantech.mod.report.entity.DepartmentReport;

/**
 *
 * @author NGUYEN
 */
public class TestDepartmentReportDocument {

    public static void main(String[] args) {
        List list = new ArrayList();
        list.add(new DepartmentReport("Human Resources", "Morgana Mayers", new Date(2012, 2, 8), new Date(2012, 6, 24), "Software", "Celestine Bastionn", 137));
        list.add(new DepartmentReport("Learning Services", "Hugo Bullard",new Date(2012, 3, 9), new Date(2012, 5, 3), "Hardware", "Nancy Ramsey", 55));

        DepartmentReportDocument document = new DepartmentReportDocument();
        document.covertListToDRDateSource(list);
        document.build();
    }
}
