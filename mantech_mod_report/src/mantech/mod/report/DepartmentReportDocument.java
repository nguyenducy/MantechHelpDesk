/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mantech.mod.report;

import net.sf.dynamicreports.report.constant.PageOrientation;
import java.util.Date;
import net.sf.dynamicreports.report.constant.HorizontalAlignment;
import net.sf.dynamicreports.report.constant.PageType;
import java.util.List;
import mantech.mod.report.entity.DepartmentReport;
import net.sf.dynamicreports.report.builder.column.TextColumnBuilder;
import net.sf.dynamicreports.report.datasource.DRDataSource;
import net.sf.jasperreports.engine.JRDataSource;
import static net.sf.dynamicreports.report.builder.DynamicReports.*;

/**
 *
 * @author NGUYEN
 */
public class DepartmentReportDocument extends AbstractReportDocument{

    private DRDataSource dataSource;
    
    @Override
    public void build() {
        try {
            //Column
            TextColumnBuilder<String> departmentColumn = col.column("Department", "department", type.stringType());
            TextColumnBuilder<String> fullnameColumn = col.column("Full Name", "fullname", type.stringType());
            TextColumnBuilder<String> createdDateColumn = col.column("Created Date", "createdDate", type.stringType());
            TextColumnBuilder<String> completedDateColumn = col.column("Completed Date", "completedDate", type.stringType());
            TextColumnBuilder<String> technicianColumn = col.column("Technician", "technician", type.stringType());
            TextColumnBuilder<String> categoryColumn = col.column("Category", "category", type.stringType());
            TextColumnBuilder<String> timeTakenColumn = col.column("Time Taken", "timeTaken", type.stringType());

            report()
                    .setPageFormat(PageType.A4, PageOrientation.LANDSCAPE)
                    .columns(departmentColumn, fullnameColumn, createdDateColumn, completedDateColumn, categoryColumn, technicianColumn, timeTakenColumn)
                    .setColumnTitleStyle(columnTitleStyle)
                    .highlightDetailEvenRows()
                    .title(cmp.horizontalList().add(cmp.image("images/report.jpg").setDimension(80, 80),
                    cmp.text("Department Report").setStyle(titleStyle).setHorizontalAlignment(HorizontalAlignment.LEFT)))
                    .pageFooter(cmp.pageXofY(), cmp.currentDate())
                    .setDataSource(dataSource)
                    .show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public JRDataSource covertListToDRDateSource(List list) {
        dataSource = new DRDataSource("department","technician", "createdDate", "completedDate","fullname", "category", "timeTaken");
        for (DepartmentReport dr : (List<DepartmentReport>)list) {
            dataSource.add(dr.getDepartment(), dr.getTechnician(), dr.getCreatedDate(),
                    dr.getCompletedDate(), dr.getFullName(),
                    dr.getCategory(), dr.getTimeTaken());
        }
        return dataSource;
    }

}
