/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mantech.mod.report;

import java.util.ArrayList;
import java.util.List;
import mantech.mod.report.dal.DepartmentReportJpaController;
import mantech.mod.report.entity.DepartmentReport;

/**
 *
 * @author NGUYEN
 */
public class TestDepartmentReportDocument {

    public static void main(String[] args) {
        List<DepartmentReport> list = new ArrayList<DepartmentReport>();
        DepartmentReportJpaController controller = new DepartmentReportJpaController();
        list = controller.findAll();

        DepartmentReportDocument document = new DepartmentReportDocument();
        document.covertListToDRDateSource(list);
        document.build();
    }
}
