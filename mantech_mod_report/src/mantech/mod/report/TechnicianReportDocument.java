/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mantech.mod.report;

import net.sf.dynamicreports.report.constant.HorizontalAlignment;
import net.sf.dynamicreports.report.constant.PageType;
import net.sf.dynamicreports.report.constant.PageOrientation;
import java.util.Date;
import net.sf.dynamicreports.report.builder.column.TextColumnBuilder;
import java.util.List;
import mantech.mod.report.entity.TechnicianReport;
import net.sf.dynamicreports.report.datasource.DRDataSource;
import net.sf.jasperreports.engine.JRDataSource;
import static net.sf.dynamicreports.report.builder.DynamicReports.*;

/**
 *
 * @author NGUYEN
 */
public class TechnicianReportDocument extends AbstractReportDocument {

    private DRDataSource dataSource;

    @Override
    public void build() {
        try {
           
            //Column
            TextColumnBuilder<String> technicianColumn = col.column("Technician", "technician", type.stringType());
            TextColumnBuilder<Date> createdDateColumn = col.column("Created Date", "createdDate", type.dateType());
            TextColumnBuilder<Date> completedDateColumn = col.column("Completed Date", "completedDate", type.dateType());
            TextColumnBuilder<String> fullnameColumn = col.column("Full Name", "fullName", type.stringType());    
            TextColumnBuilder<String> categoryColumn = col.column("Category", "category", type.stringType());
            TextColumnBuilder<Integer> timeTakenColumn = col.column("Time Taken", "timeTaken", type.integerType());

            report()
                    .setPageFormat(PageType.A4, PageOrientation.LANDSCAPE)
                    .columns(technicianColumn, createdDateColumn, completedDateColumn, fullnameColumn, categoryColumn, timeTakenColumn)
                    .setColumnTitleStyle(columnTitleStyle)
                    .highlightDetailEvenRows()
                    .groupBy(technicianColumn)
                    .title(cmp.horizontalList().add(cmp.image("images/report.jpg").setDimension(80, 80),
                    cmp.text("Technician Report").setStyle(titleStyle).setHorizontalAlignment(HorizontalAlignment.LEFT)))
                    .pageFooter(cmp.pageXofY(), cmp.currentDate())
                    .setDataSource(dataSource)
                    .show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public JRDataSource covertListToDRDateSource(List list) {
        dataSource = new DRDataSource("technician", "createdDate", "completedDate", "fullName", "category", "timeTaken");
        for (TechnicianReport tr : (List<TechnicianReport>)list) {
            dataSource.add(tr.getTechnician(), tr.getCreatedDate(),
                    tr.getCompletedDate(), tr.getFullName(),
                    tr.getCategory(), tr.getTimeTaken());
        }
        return dataSource;
    }
}
