package Faction2;

import java.awt.*;
import java.io.File;
import java.util.LinkedHashMap;
import java.util.Set;

import org.jfree.chart.*;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.labels.ItemLabelAnchor;
import org.jfree.chart.labels.ItemLabelPosition;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.StandardBarPainter;
import org.jfree.chart.title.TextTitle;
import org.jfree.chart.ui.TextAnchor;
import org.jfree.data.category.DefaultCategoryDataset;
import util.colorSet;


public class Graph{

    //根据密度画出人物密度图
    public Graph(LinkedHashMap<Integer,Integer> lhm){
        //获取数据
        DefaultCategoryDataset dcd = getDataSet(lhm);

        //把人物密度信息用arrayI保存
        Set<Integer> s = lhm.keySet();
        Integer[] arrayI = s.toArray(new Integer[s.size()]);

        //画图
        String title = "人物密度图";
        JFreeChart chart = ChartFactory.createBarChart(
                title,
                "Characters",
                "times",
                dcd,
                PlotOrientation.VERTICAL,
                false,
                false,
                false
        );

        //设置字体格式
        Font font = new Font("宋体", Font.BOLD, 12);

        //获取标题信息并设置标题字体
        TextTitle textTitle = new TextTitle(title);
        chart.setTitle(textTitle);
        textTitle.setFont(font);

        chart.setTextAntiAlias(false);

        //设置图表格式
        StandardChartTheme sct = new StandardChartTheme("CN");
        //设置字体
        sct.setRegularFont(font);
        sct.setLargeFont(font);

        //绑定
        ChartFactory.setChartTheme(sct);

        //获得图像信息，并设置
        CategoryPlot plot = chart.getCategoryPlot();
        CategoryAxis categoryAxis = plot.getDomainAxis();
        // 设置横轴显示标签的字体
        categoryAxis.setLabelFont(font);
        categoryAxis.setTickLabelFont(font);

        //柱状图渲染器
        BarRenderer br = (BarRenderer) plot.getRenderer();
        br.setIncludeBaseInRange(true);
        br.setBarPainter(new StandardBarPainter());
        // 标签生成器
        br.setDefaultItemLabelGenerator(new StandardCategoryItemLabelGenerator());
        br.setDefaultItemLabelsVisible(true);

        //设置柱状图间距和宽度
//        br.setItemMargin(0.1F);
//        br.setMaximumBarWidth(0.9);

        //对每个series设置颜色
        for(int i = 0; i < s.size(); i++)
        {
            br.setSeriesPaint(i,colorSet.setColor((int)lhm.get(arrayI[i])));
        }

        //显示出柱状图 在JFrame中
        ChartFrame pieFrame = new ChartFrame("存在感柱状图",chart);
        pieFrame.pack();
        pieFrame.setVisible(true);

        //保存柱状图
        writeChartToImage (chart);
    }

    //获取信息存入dataSet
    public static DefaultCategoryDataset getDataSet(LinkedHashMap aWords) {
        DefaultCategoryDataset defaultDataset = new DefaultCategoryDataset();

        //用Set存储key
        Set<Integer> s = aWords.keySet();
        Integer[] arrayI = s.toArray(new Integer[s.size()]);
//        toArray()返回的类型时 Object [] 所以会报错，要把s.toArray()-->s.toArray(new String[s.size()])

        //setValue的同时也要设置series，为之后的颜色设置做准备
        for (Integer i = 0; i < aWords.size(); i++) {
            int tt = arrayI[i] + 1;
            defaultDataset.setValue(( int )aWords.get(arrayI[i]), i.toString(), "第"+tt+"部分");
        }

        return defaultDataset;
    }

    //保存图片
    public static void writeChartToImage( JFreeChart chart ) {
        File f_jpg = null;
        try {
            f_jpg = new File("C:\\Users\\wohez\\IdeaProjects\\TermProject\\Graph.jpg");
            ChartUtils.saveChartAsJPEG(f_jpg,1.0f,chart,1500,800,null);

        } catch (Exception e) {

            e.printStackTrace();
        }

    }

}



