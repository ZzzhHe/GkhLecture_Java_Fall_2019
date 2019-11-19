package Faction2;

import javax.imageio.ImageIO;
import javax.lang.model.element.Name;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.LinkedHashMap;
import util.colorSet;


public class Graph extends JFrame {
    private static final int sx = 40;
    private static final int sy = 80;
    private static final int w = 40;
    private static final int rw = 400;


    // TODO: 2019/11/18
//        实现用颜色深浅表示密度，最好是用方块的形式
    private Graphics g;
    public PanelPaint pp = new PanelPaint();

    public Graph()  {
        super("密度图");
        this.add(pp);
        setBounds(200, 200, 500, 300);
        setVisible(true);
        g = this.getGraphics();
        repaint();
        try {
            Thread.sleep(2000);
            BufferedImage screencapture = new Robot().createScreenCapture(
                    new Rectangle( 230, 230, 450, 250 ));
            ImageIO.write(screencapture,"JPEG",new File("Graph.jpg"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }





    public static void main(String[] args) {
        new Graph();
    }
}


    class PanelPaint extends JPanel {
        private static final int sx = 40;
        private static final int sy = 80;
        private static final int w = 40;
        private static final int rw = 400;


        public void paint(Graphics g) {

            super.paint(g);
            Graphics2D g2d = (Graphics2D) g;
            Graphics2D g2d2 = (Graphics2D) g;

            g2d.setStroke(new BasicStroke(4.0F));
            g2d.setColor(Color.PINK);


            for (int i = 0; i < 11; i++) {
                g2d.drawLine(sx + (i * w), sy, sx + (i * w), sy + 80);
            }
            for (int i = 0; i < 3; i++) {
                g2d.drawLine(sx, sy + (i * w), sx + rw, sy + (i * w));
            }



            // TODO: 2019/11/18
//                    创造函数，传递参数，接收参数，转换颜色，setColor
//              1.创造函数
//              2.传递参数，在paint()函数中调用函数
//              3.接受参数，获得参数 章节数？出现次数？
//              4.把出现次数传入颜色函数，得到RGB对应的颜色

            LinkedHashMap lmp = Search.DensitySearch(Faction2.name);
            for(int i = 0; i < 20; i++)
            {
                int times = 0;
                try {
                    times = (Integer)lmp.get(i);
                    System.out.println(times+"啊");
                }catch (Exception e )
                {
                    e.printStackTrace();
                }
                // TODO: 2019/11/19
//                    颜色的设计不够美丽
//                    传出的RGB到底是什么形式
//                    如何保存图像
                g2d2.setStroke(new BasicStroke(38.0F));
                g2d2.setColor(colorSet.setColor(times));
                if( i < 10)
                {
                    g2d2.drawLine(sx + w  / 2 + w * i , sy + w / 2  , sx + w / 2 + w * i, sy + 20);
                }
                else if ( i >= 10)
                {
                    g2d2.drawLine(sx + w  / 2 + w * ( i - 10 ) , sy + w / 2 + 40, sx + w / 2 + w * (i - 10), sy + 60);
                }
            }
        }
    }

/*
class PaintColor {
    private static final int sx = 40;
    private static final int sy = 80;
    private static final int w = 40;
    private static final int rw = 400;

    private Graphics g;


    public static void paintRec(int i, int times) {
        try {
            Graphics2D g2d = (Graphics2D) g;
            g2d.setStroke(new BasicStroke(40.0F));
            g2d.setColor(Color.PINK);
            g2d.drawLine(sx + (i * w), sy, sx + (i * w), sy + 80);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
*/



