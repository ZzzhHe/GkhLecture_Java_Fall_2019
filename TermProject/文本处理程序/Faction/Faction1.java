package Faction;

import util.GUIUtil;
import Client.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.TreeMap;

public class Faction1 extends JFrame implements ActionListener {
    private JButton btCount = new JButton("存在感");
    private JButton btCancel = new JButton("取消");

    public Faction1() {
        super("判断存在感");
        this.setLayout(new FlowLayout());
        this.add(btCount);
        this.add(btCancel);
        this.setSize(380, 160);
        GUIUtil.toCenter(this);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

        btCancel.addActionListener(this);
        btCount.addActionListener(this);
    }
        public void actionPerformed (ActionEvent ae ){
            if (ae.getSource() == btCancel)
            {
                this.dispose();
                new Client();
            } else if (ae.getSource() == btCount) {

                String srcFileName =
                        JOptionPane.showInputDialog("请您输入源文件路径");
                String t =
                        JOptionPane.showInputDialog("请您输入主人翁文件路径");
                try {
                    List<String> data = FileLoader.getTxt(srcFileName);
                    List<String> keyword = FileLoader.getTxt(t);
                    LinkedHashMap<String,Integer> tm = StringStat.SortKeyword(StringStat.SearchKeyword(data,keyword));
                    BarChart.Bar_Chart(tm);
                    FileSaver.save(tm, "new.txt");
//                    String fileName = BarChart.Bar_Chart(tm);
//                    System.out.println(fileName);
                } catch (Exception ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null,"异常操作");
                }
                JOptionPane.showMessageDialog(null,"输出完毕");
            }

        }

}
