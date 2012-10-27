/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mantech.mod.report;

import net.sf.dynamicreports.report.constant.VerticalAlignment;
import java.awt.Color;
import net.sf.dynamicreports.report.constant.HorizontalAlignment;
import java.util.List;
import net.sf.dynamicreports.report.builder.style.StyleBuilder;
import net.sf.jasperreports.engine.JRDataSource;
import static net.sf.dynamicreports.report.builder.DynamicReports.*;

/**
 *
 * @author NGUYEN
 */
public abstract class AbstractReportDocument {

    public final static StyleBuilder boldStyle = stl.style().bold();
    public final static StyleBuilder boldCenteredStyle = stl.style(boldStyle).setHorizontalAlignment(HorizontalAlignment.CENTER);
    public final static StyleBuilder columnTitleStyle = stl.style(boldCenteredStyle).setBorder(stl.pen1Point()).setBackgroundColor(Color.LIGHT_GRAY);
    public final static StyleBuilder titleStyle = stl.style(boldCenteredStyle).setVerticalAlignment(VerticalAlignment.MIDDLE).setFontSize(15);
    

    public abstract void build();

    public abstract JRDataSource covertListToDRDateSource(List list);
}
