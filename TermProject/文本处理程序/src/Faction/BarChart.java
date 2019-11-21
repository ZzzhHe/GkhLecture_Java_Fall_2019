package Faction;

import org.jfree.chart.*;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.title.LegendTitle;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.category.DefaultCategoryDataset;

import java.awt.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

// TODO: 2019/11/21
//      尝试使用Orson Chart构造三地图

public class BarChart {

    public static <BarRenderer3D> void Bar_Chart(LinkedHashMap aWords) {
        DefaultCategoryDataset dataSet= getDataSet(aWords);
        String title = "存在感统计柱状图";
        JFreeChart chart = ChartFactory.createBarChart(
                title,
                "Characters",
                "times",
                dataSet,
                PlotOrientation.VERTICAL,
                true,
                false,
                false
        );
        // TODO: 2019/11/13
//              1.图标已经成功生成，但是中间的汉字无法显示
//              2.把保存在本地的图片上传到服务器(文件夹)

        Font font = new Font("宋体", Font.BOLD, 18);
        TextTitle textTitle = new TextTitle(title);
        textTitle.setFont(font);
        chart.setTitle(textTitle);
        chart.setTextAntiAlias(false);


/*        StandardChartTheme standardChartTheme = new StandardChartTheme("CN");

        standardChartTheme.setExtraLargeFont(new Font("宋体", Font.BOLD, 10));

        standardChartTheme.setRegularFont(new Font("宋体", Font.PLAIN, 10));

        standardChartTheme.setLargeFont(new Font("宋体", Font.PLAIN, 10));*/

//        ChartFactory.setChartTheme(standardChartTheme);
        /*---------------------------------------------------------------------*/

        chart.setBackgroundPaint(new Color(255, 255, 255));
        // 设置图例字体
        LegendTitle legend = chart.getLegend(0);
        legend.setItemFont(new Font("宋体", Font.TRUETYPE_FONT, 10));
        // 获得柱状图的Plot对象
        CategoryPlot plot = chart.getCategoryPlot();
        BarRenderer3D customBarRenderer = (BarRenderer3D) plot.getRenderer();
        // 取得横轴
        CategoryAxis categoryAxis = plot.getDomainAxis();
        // 设置横轴显示标签的字体
        categoryAxis.setLabelFont(new Font("宋体", Font.BOLD, 12));
        // 设置横轴标记的字体
        categoryAxis.setTickLabelFont(new Font("宋休", Font.TRUETYPE_FONT, 12));
        // 取得纵轴
        NumberAxis numberAxis = (NumberAxis) plot.getRangeAxis();
        // 设置纵轴显示标签的字体
        numberAxis.setLabelFont(new Font("宋体", Font.BOLD, 12));
        numberAxis.setTickLabelFont(new Font("宋体", Font.PLAIN, 9));
//        customBarRenderer.setBase(new StandardCategoryItemLabelGenerator());// 显示每个柱的数值
//        customBarRenderer.setBaseItemLabelsVisible(true);
        // 注意：此句很关键，若无此句，那数字的显示会被覆盖，给人数字没有显示出来的问题
//        customBarRenderer.setBasePositiveItemLabelPosition(
//                new ItemLabelPosition(ItemLabelAnchor.OUTSIDE12, TextAnchor.BASELINE_CENTER));

/*----------------------------------------------------------------------------------------------------*/


        writeChartToImage (chart);

        ChartFrame pieFrame = new ChartFrame("存在感柱状图",chart);
        pieFrame.pack();
        pieFrame.setVisible(true);

    }

    public static DefaultCategoryDataset getDataSet(LinkedHashMap aWords) {
        DefaultCategoryDataset defaultDataset = new DefaultCategoryDataset();
        Set<String> s = aWords.keySet();
        String[] arrayS = s.toArray(new String[s.size()]);
//        toArray()返回的类型时 Object [] 所以会报错，要把s.toArray()-->s.toArray(new String[s.size()])
        for (int i = 0; i < aWords.size(); i++) {
            defaultDataset.setValue((int) aWords.get(arrayS[i]), "出现次数", arrayS[i]);
        }
        return defaultDataset;
    }

    public static void writeChartToImage( JFreeChart chart ) {
        File f_jpg = null;
        try {
            f_jpg = new File("C:\\Users\\wohez\\IdeaProjects\\TermProject\\BarGraph.jpg");
            ChartUtils.saveChartAsJPEG(f_jpg,1.0f,chart,1500,800,null);

        } catch (Exception e) {

            e.printStackTrace();
        }

    }
}

/*String fileName = ServletUtilities.saveChartAsJPEG(fcbarChart, 700, 500, null);
        return fileName;*/