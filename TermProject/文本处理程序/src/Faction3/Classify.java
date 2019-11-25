package Faction3;

import Faction.FileLoader;
import Faction2.Search;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

//分类功能
public class Classify extends JFrame {

    private Graphics g;
    public PanelPaint pp = new PanelPaint();
    //把不同的人物分成不同的类

    public Classify() {
        super("分类图");

        //添加控件
        this.add(pp);

        //设置界面
        setBounds(50, 50, 1800, 1000);
        setVisible(true);


        //画图准备，repaint()调用画图工具
        g = this.getGraphics();

        //用BufferedImage接收图像
        BufferedImage bi = new BufferedImage(pp.getWidth(),pp.getHeight(),BufferedImage.TYPE_INT_RGB);

        //建立PanelPaint 与 BufferedImage的关系
        pp.paint(bi.getGraphics());

        //创建文件，保存图片
        File file = new File("Classify.jpg");
        try {
            ImageIO.write(bi, "jpg", file);
        } catch (Exception e) {
            e.printStackTrace();
        }





    }

    public List<List<String>> Compute(List<String> names) {
        List<List<String>> ClassList = new ArrayList<List<String>>();
        //用左 中 右三个List分别保存三个类别的人物
        List<String> LeftList = new ArrayList<String>();
        List<String> MidList = new ArrayList<String>();
        List<String> RightList = new ArrayList<String>();

        //对人物进行遍历，并判断他们属于哪一类
        for (int i = 1; i < names.size(); i++) {
            String name = names.get(i);
            //获取人物的密度
            LinkedHashMap<Integer, Integer> lmp = Search.DensitySearch(name);

            //用左 中 右三个部分分别保存，人物在全文的三个部分出现的次数
            //并比较大小
            int LeftPart = lmp.get(0) + lmp.get(1) + lmp.get(2) + lmp.get(3);
            int MidPart = lmp.get(4) + lmp.get(5) + lmp.get(6);
            int RightPart = lmp.get(7) + lmp.get(8) + lmp.get(9);

            //人物在三个部分中的哪一个部分出现次数最多，就加入哪一个类
            if (LeftPart > MidPart && LeftPart > RightPart) {
                LeftList.add(name);
            }
            if (MidPart > LeftPart && MidPart > RightPart) {
                MidList.add(name);
            }
            if (RightPart > LeftPart && RightPart > MidPart) {
                RightList.add(name);
            }

        }
        ClassList.add(LeftList);
        ClassList.add(MidList);
        ClassList.add(RightList);
        return ClassList;
    }




    public static void main(String[] args) {
        new Classify();
    }

    class PanelPaint extends JPanel {
        private static final int LeftPoint = 50;
        private static final int LabelHeight = 650;
        private static final int StringHeight = 200;
        private static final int MidPoint = 650;
        private static final int RightPoint = 1250;
        private static final int R = 500;

        public void paint(Graphics g) {

            super.paint(g);
            Graphics2D g2d = (Graphics2D) g;
            Graphics2D g2d2 = (Graphics2D) g;
            Graphics2D g2d3 = (Graphics2D) g;

            //绘图
            g2d2.setFont(new Font("宋体", Font.BOLD, 27));
            g2d.setStroke(new BasicStroke(6.0F));
            g2d.setColor(new Color(73, 224, 33));
            g2d.drawArc(LeftPoint,LeftPoint,R,R,0,360);
            g2d.setStroke(new BasicStroke(2.0F));
            g2d2.drawString("小说第一阶段关系紧密",LeftPoint+100, LabelHeight);
            g2d.setColor(new Color(31, 51, 224));
            g2d.setStroke(new BasicStroke(2.0F));
            g2d.drawArc(MidPoint,LeftPoint,R,R,0,360);
            g2d2.drawString("小说第二阶段关系紧密",MidPoint+100, LabelHeight);
            g2d.setColor(new Color(224, 43, 94));
            g2d.setStroke(new BasicStroke(2.0F));
            g2d.drawArc(RightPoint,LeftPoint,R,R,0,360);
            g2d2.drawString("小说第三阶段关系紧密",RightPoint+100, LabelHeight);

            List<String> keyword = null;
            try {
                keyword = FileLoader.getTxt("Char.txt");
            }catch (Exception e)
            {
                e.printStackTrace();
            }
            List<List<String>> name = Compute(keyword);
            g2d3.setColor(new Color(115, 147, 223));

            //将分类结果绘制在图片中
            g2d3.setFont(new Font("宋体", Font.BOLD, 27));
            int x = LeftPoint + 100;
            for(int i = 0; i < name.size(); i++)
           {
               int y = StringHeight;
                for( int j = 0; j < name.get(i).size(); j++)
                {
                    g2d3.drawString(name.get(i).get(j),x,y);
                    y += 50;
                }
                x += 600;
           }

            }
        }

}
