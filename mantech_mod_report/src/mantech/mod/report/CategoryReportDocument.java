/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mantech.mod.report;

import java.util.Date;
import net.sf.dynamicreports.report.datasource.DRDataSource;
import net.sf.dynamicreports.report.constant.HorizontalAlignment;
import net.sf.dynamicreports.report.constant.PageType;
import net.sf.dynamicreports.report.constant.PageOrientation;
import java.util.List;
import mantech.mod.report.entity.CategoryReport;
import net.sf.dynamicreports.report.builder.column.TextColumnBuilder;
import net.sf.jasperreports.engine.JRDataSource;
import static net.sf.dynamicreports.report.builder.DynamicReports.*;

/**
 *
 * @author NGUYEN
 */
public class CategoryReportDocument extends AbstractReportDocument {

    private DRDataSource dataSource;

    @Override
    public void build() {
        try {
            //Column
            TextColumnBuilder<String> categoryColumn = col.column("Category", "category", type.stringType());
            TextColumnBuilder<String> createdDateColumn = col.column("Created Date", "createdDate", type.stringType());
            TextColumnBuilder<String> completedDateColumn = col.column("Completed Date", "completedDate", type.stringType());
            TextColumnBuilder<String> noteColumn = col.column("Note", "note", type.stringType());
            TextColumnBuilder<String> fullnameColumn = col.column("Full Name", "fullname", type.stringType());
            TextColumnBuilder<String> technicianColumn = col.column("Technician", "technician", type.stringType());
            TextColumnBuilder<String> timeTakenColumn = col.column("Time Taken", "timeTaken", type.stringType());

            report().setPageFormat(PageType.A4, PageOrientation.LANDSCAPE).columns(categoryColumn, createdDateColumn, completedDateColumn, noteColumn, fullnameColumn, technicianColumn, timeTakenColumn).setColumnTitleStyle(columnTitleStyle).highlightDetailEvenRows().groupBy(categoryColumn).title(cmp.horizontalList().add(cmp.image("images/report.jpg").setDimension(80, 80),
                    cmp.text("Category Report").setStyle(titleStyle).setHorizontalAlignment(HorizontalAlignment.LEFT))).pageFooter(cmp.pageXofY(), cmp.currentDate()).setDataSource(dataSource).show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public JRDataSource covertListToDRDateSource(List list) {
        dataSource = new DRDataSource("category", "createdDate", "completedDate", "note", "fullname", "technician", "timeTaken");
        for (CategoryReport cr : (List<CategoryReport>) list) {
            dataSource.add(cr.getCategory(), cr.getCreatedDate(), cr.getCompletedDate(), cr.getNote(), cr.getFullName(), cr.getTechnician(), cr.getTimeTaken());
        }
        return dataSource;
    }
}
