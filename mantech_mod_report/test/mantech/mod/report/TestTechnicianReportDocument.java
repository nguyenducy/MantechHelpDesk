/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mantech.mod.report;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import mantech.mod.report.entity.TechnicianReport;

/**
 *
 * @author NGUYEN
 */
public class TestTechnicianReportDocument {

    public static void main(String[] args){
        List list = new ArrayList();
        list.add(new TechnicianReport("Celestine Bastion", new Date(2012, 2, 8),
                new Date(2012, 6, 24), "Morgana Mayers", "Software", 137));

        list.add(new TechnicianReport("Morgana Mayers", new Date(2012, 3, 9), new Date(2012, 5, 3),
                "Hugo Bullard", "Hardware", 55));

        TechnicianReportDocument document = new TechnicianReportDocument();
        document.covertListToDRDateSource(list);
        document.build();
    }

}
