/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mantech.mod.report;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import mantech.mod.report.entity.DetailReport;

/**
 *
 * @author NGUYEN
 */
public class TestDetailReportDocument {

    public static void main(String[] args){
        List list = new ArrayList();
        list.add(new DetailReport(1, new Date(2012, 8, 2)));
        DetailReportDocument document = new DetailReportDocument();
        document.covertListToDRDateSource(list);
        document.build();
    }
}
