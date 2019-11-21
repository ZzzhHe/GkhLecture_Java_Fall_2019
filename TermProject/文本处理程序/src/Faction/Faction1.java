package Faction;

import UpDownload.Upload;
import util.GUIUtil;
import Client.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.Socket;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.TreeMap;

public class Faction1 extends JFrame implements ActionListener {
    private JButton btCount = new JButton("存在感");
    private JButton btUpload = new JButton("上传柱状图");
    private JButton btCancel = new JButton("取消");
//+++++++++++++++++++++++++++++++++++++++++
    private Socket socket;
//-----------------------------------------
    public Faction1() {
        super("判断存在感");
        this.setLayout(new FlowLayout());
        this.add(btCount);
        this.add(btCancel);
        this.add(btUpload);
        this.setSize(380, 160);
        GUIUtil.toCenter(this);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

        btCancel.addActionListener(this);
        btCount.addActionListener(this);
        btUpload.addActionListener(this);
//+++++++++++++++++++++++++++++++++++++++++
        try{
            socket = new Socket("127.0.0.1",9999);
            JOptionPane.showMessageDialog(this,"连接成功");
        }catch(Exception e)
        {
            e.printStackTrace();
        }
//-----------------------------------------

    }
        public void actionPerformed (ActionEvent ae ){
            if (ae.getSource() == btCancel)
            {
                // TODO: 2019/11/15
                //  有一个问题
                //  当从一个子界面返回父界面时，使用new 新界面()
                //  似乎会出现问题

                this.dispose();
                new Client();
            } else if (ae.getSource() == btCount) {
                try {
                    List<String> data = FileLoader.getTxt("Download.txt");
                    List<String> keyword = FileLoader.getTxt("Char.txt");
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
            } else if (ae.getSource() == btUpload) {
//+++++++++++++++++++++++++++++++++++++++++
                Upload.jpgUpload(socket);
//-----------------------------------------
            }


        }

}
