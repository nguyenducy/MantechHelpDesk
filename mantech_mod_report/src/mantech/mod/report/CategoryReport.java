/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mantech.mod.report;

import net.sf.dynamicreports.report.constant.HorizontalAlignment;
import net.sf.dynamicreports.report.constant.PageType;
import net.sf.dynamicreports.report.constant.PageOrientation;
import java.util.Date;
import java.util.List;
import net.sf.dynamicreports.report.builder.column.TextColumnBuilder;
import net.sf.dynamicreports.report.builder.style.StyleBuilder;
import net.sf.jasperreports.engine.JRDataSource;
import static net.sf.dynamicreports.report.builder.DynamicReports.*;

/**
 *
 * @author NGUYEN
 */
public class CategoryReport extends AbstractReport {

    private JRDataSource dataSource;

    @Override
    public void build() {
        try {
            //Column
            TextColumnBuilder<String> departmentColumn = col.column("Department", "department", type.stringType());
            TextColumnBuilder<String> fullnameColumn = col.column("Full Name", "fullname", type.stringType());
            TextColumnBuilder<Date> createdDateColumn = col.column("Created Date", "createddDate", type.dateType());
            TextColumnBuilder<Date> completedDateColumn = col.column("Completed Date", "completedDate", type.dateType());
            TextColumnBuilder<String> technicianColumn = col.column("Technician", "technician", type.stringType());
            TextColumnBuilder<String> categoryColumn = col.column("Category", "category", type.stringType());
            TextColumnBuilder<Integer> timeTakenColumn = col.column("Time Taken", "timeTaken", type.integerType());

            report()
                    .setPageFormat(PageType.A4, PageOrientation.LANDSCAPE)
                    .columns(departmentColumn, fullnameColumn, createdDateColumn, completedDateColumn, categoryColumn, technicianColumn, timeTakenColumn)
                    .setColumnTitleStyle(columnTitleStyle)
                    .highlightDetailEvenRows()
                    .groupBy(departmentColumn)
                    .title(cmp.horizontalList().add(cmp.image(getClass().getResourceAsStream("../images/report.jpg")).setDimension(80, 80),
                    cmp.text("Category Report").setStyle(titleStyle).setHorizontalAlignment(HorizontalAlignment.LEFT)))
                    .pageFooter(cmp.pageXofY(), cmp.currentDate())
                    .setDataSource(dataSource)
                    .show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public JRDataSource covertListToDRDateSource(List list) {
        for (Object object : list) {

        }
        return dataSource;
    }
}
