package Faction3;

import Faction.FileLoader;
import com.orsoncharts.Chart3DPanel;
import org.jfree.chart.*;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.PieLabelLinkStyle;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.title.LegendTitle;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import util.MyMap;
import util.colorSet;

import java.awt.*;
import java.io.File;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

public class PieChart {
    private Chart3DPanel C3P;
    public PieChart(LinkedHashMap lmp) {
        DefaultPieDataset dataset = new DefaultPieDataset();
        Set<String> StringSet = lmp.keySet();
        String[] ArrayString = StringSet.toArray(new String[StringSet.size()]);


        PieDataset dataSet = getDataSet(lmp);
        String title = "人物亲密度饼状图";
        JFreeChart chart = ChartFactory.createRingChart(
                title,
                dataSet,
                true,
                false,
                false
        );

        Font font = new Font("宋体", Font.BOLD,16);
        TextTitle textTitle = new TextTitle(title);
        textTitle.setFont(font);
        chart.setTitle(textTitle);
        chart.setTextAntiAlias(false);

        LegendTitle lt = chart.getLegend();
        lt.setItemFont(font);

        StandardChartTheme sct = new StandardChartTheme("CN");
        sct.setLargeFont(font);
        sct.setRegularFont(font);
        sct.setExtraLargeFont(font);
//        CategoryPlot plot = chart.getCategoryPlot();
//        CategoryAxis categoryAxis = plot.getDomainAxis();

        PiePlot plot = (PiePlot) chart.getPlot();
        plot.setLabelFont(font);
        plot.setLabelGap(0.02D);
        plot.setLabelGenerator(new StandardPieSectionLabelGenerator(
                "{0} {2}",
                NumberFormat.getNumberInstance(),
                new DecimalFormat("0.00%")));
        int c = 0;
        for(int i = 0; i < ArrayString.length; i++)
        {
            String str = ArrayString[i];
            c++;
            plot.setSectionPaint(str, colorSet.RandedColor(c));
        }
        ChartFactory.setChartTheme(sct);


        writeChartToImage(chart);

        ChartFrame pieFrame = new ChartFrame("饼状图",chart);
        pieFrame.pack();
        pieFrame.setVisible(true);

    }


    public PieDataset getDataSet(LinkedHashMap lmp){
         DefaultPieDataset dataset = new DefaultPieDataset();
         Set<String> StringSet = lmp.keySet();
          String[] ArrayString = StringSet.toArray(new String[StringSet.size()]);
        for(int i = 1; i < ArrayString.length; i++)
          {
              String str = ArrayString[i];
              dataset.setValue(str,(int)lmp.get(str));
          }
        return dataset;
    }

    public static void writeChartToImage( JFreeChart chart ) {
        File f_jpg = null;
        try {
            f_jpg = new File("C:\\Users\\wohez\\IdeaProjects\\TermProject\\PieGraph.jpg");
            ChartUtils.saveChartAsJPEG(f_jpg,1.0f,chart,1500,800,null);

        } catch (Exception e) {

            e.printStackTrace();
        }

    }
}
