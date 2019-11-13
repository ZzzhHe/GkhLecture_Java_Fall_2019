package Faction;

import org.jfree.chart.*;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.servlet.ServletUtilities;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.CategoryRangeInfo;
import org.jfree.data.category.DefaultCategoryDataset;

import java.awt.*;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

public class BarChart {

    public static void Bar_Chart(LinkedHashMap aWords) {
        System.out.println("打印柱状图");
        DefaultCategoryDataset dataset = getDataSet(aWords);
        JFreeChart chart = ChartFactory.createBarChart3D(
                "小说存在感柱状图",
                "人物",
                "出现次数/次",
                dataset,
                PlotOrientation.VERTICAL,
                true,
                false,
                false
        );
        System.out.println("开始打印了吗");
//解决表格中的汉字问题
        CategoryPlot plot = chart.getCategoryPlot();
        CategoryAxis domainAxis = plot.getDomainAxis();
        ValueAxis rAxis = plot.getRangeAxis();
        chart.getRenderingHints().put(RenderingHints.KEY_TEXT_ANTIALIASING,
                RenderingHints.VALUE_TEXT_ANTIALIAS_OFF);

        // TODO: 2019/11/13
//              1.图标已经成功生成，但是中间的汉字无法显示

        StandardChartTheme standardChartTheme = new StandardChartTheme("CN");

        standardChartTheme.setExtraLargeFont(new Font("隶书", Font.BOLD, 20));

        standardChartTheme.setRegularFont(new Font("宋书", Font.PLAIN, 20));

        standardChartTheme.setLargeFont(new Font("宋书", Font.PLAIN, 20));

        ChartFactory.setChartTheme(standardChartTheme);

        writeChartToImage (chart);

        ChartFrame pieFrame = new ChartFrame("XXX",chart);
        pieFrame.pack();
        pieFrame.setVisible(true);

    }

    public static DefaultCategoryDataset getDataSet(LinkedHashMap aWords) {
        DefaultCategoryDataset defaultDataset = new DefaultCategoryDataset();
        Set<String> s = aWords.keySet();
        String[] arrayS = s.toArray(new String[s.size()]);
//        toArray()返回的类型时 Object [] 所以会报错，要把s.toArray()-->s.toArray(new String[s.size()])
        for (int i = 0; i < aWords.size(); i++) {
            defaultDataset.setValue((int) aWords.get(arrayS[i]), "人物出现次数", arrayS[i]);
        }
        return defaultDataset;
    }

    public static void writeChartToImage( JFreeChart chart ) {
        FileOutputStream fos_jpg = null;
        try {
            fos_jpg = new FileOutputStream("C:\\Users\\wohez\\IdeaProjects\\TermProject\\fos_jpg.jpg");
            ChartUtilities.writeChartAsJPEG(fos_jpg,1,chart,400,300,null);

        } catch (Exception e) {

            e.printStackTrace();

            try {
                fos_jpg.close();
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        }

    }
}

/*String fileName = ServletUtilities.saveChartAsJPEG(fcbarChart, 700, 500, null);
        return fileName;*/