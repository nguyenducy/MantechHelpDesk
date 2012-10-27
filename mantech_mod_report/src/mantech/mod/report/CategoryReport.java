/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mantech.mod.report;

import java.util.List;
import net.sf.jasperreports.engine.JRDataSource;

/**
 *
 * @author NGUYEN
 */
public class CategoryReport extends AbstractReport{

    @Override
    public void build(){
        try {
            //Style
            StyleBuilder boldStyle = stl.style().bold();
            StyleBuilder boldCenteredStyle = stl.style(boldStyle).setHorizontalAlignment(HorizontalAlignment.CENTER);
            StyleBuilder columnTitleStyle = stl.style(boldCenteredStyle).setBorder(stl.pen1Point()).setBackgroundColor(Color.LIGHT_GRAY);
            StyleBuilder titleStyle = stl.style(boldCenteredStyle).setVerticalAlignment(VerticalAlignment.MIDDLE).setFontSize(15);

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
                    .setDataSource(createDataSource())
                    .show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public JRDataSource covertListToDRDateSource(List list) {
        throw new UnsupportedOperationException("Not supported yet.");
    }


}
