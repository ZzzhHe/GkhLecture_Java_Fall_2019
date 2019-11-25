package Faction;

import com.orsoncharts.Chart3D;
import com.orsoncharts.Chart3DFactory;
import com.orsoncharts.Chart3DPanel;
import com.orsoncharts.data.category.CategoryDataset3D;
import com.orsoncharts.data.category.StandardCategoryDataset3D;
import com.orsoncharts.label.StandardCategoryItemLabelGenerator;
import com.orsoncharts.plot.CategoryPlot3D;
import com.orsoncharts.renderer.category.BarRenderer3D;
import com.orsoncharts.style.StandardChartStyle;
import org.jfree.chart.title.TextTitle;

import javax.swing.*;
import java.awt.*;
import java.util.LinkedHashMap;
import java.util.Set;

//利用Orson Chart 画出3D图像

public class BarChart extends JFrame{
    //Chart3DPanel 用来接收图像并显示
    private Chart3DPanel C3P;

    //构造函数
    public BarChart(LinkedHashMap aWords) {
        //dataSet 接收信息
        CategoryDataset3D dataSet = getDataSet(aWords);
        String title = "存在感统计柱状图";

        //创建3D柱状图
        Chart3D chart = Chart3DFactory.createBarChart(
                title,
                "Characters",
                dataSet,
                "出场人物",
                "月亮与六便士",
                "人物存在感/次数"
        );

        //设置字体格式
        Font font = new Font("宋体", Font.BOLD, 12);

        //设置标题 获取标题信息，并设置标题字体
        chart.setTitle(title);
        TextTitle textTitle = new TextTitle(title);
        textTitle.setFont(font);

        //设置表格界面格式
        StandardChartStyle scs = new StandardChartStyle();
        scs.setAxisLabelFont(font);
        scs.setAxisTickLabelFont(font);
        scs.setStandardColors(new Color(45, 94, 190));//设置柱状颜色

        //设置标签
        CategoryPlot3D plot = (CategoryPlot3D) chart.getPlot();
        BarRenderer3D br = (BarRenderer3D) plot.getRenderer();
        br.setItemLabelGenerator(new StandardCategoryItemLabelGenerator());


        //绑定Chart与表格界面格式
        chart.setStyle(scs);

        //把Chart绑定在Panel上
        C3P = new Chart3DPanel(chart);

        //添加Panel控件，并设置为可见
        this.add(C3P);
        this.setVisible(true);


        //保存图像

    }

    //获取柱状图数据
    public static CategoryDataset3D getDataSet(LinkedHashMap aWords) {
        StandardCategoryDataset3D defaultDataset = new StandardCategoryDataset3D();
        Set<String> s = aWords.keySet();
        String[] arrayS = s.toArray(new String[s.size()]);
//        toArray()返回的类型时 Object [] 所以会报错，要把s.toArray()-->s.toArray(new String[s.size()])
        for (int i = 0; i < aWords.size(); i++) {
            defaultDataset.setValue((int) aWords.get(arrayS[i]), arrayS[i], arrayS[i],"");
        }
        return defaultDataset;
    }

}

