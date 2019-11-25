package Faction3;

import Client.Client;
import Faction.FileLoader;
import UpDownload.Upload;
import org.jfree.chart.plot.PieLabelLinkStyle;
import util.GUIUtil;
import util.MyMap;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.Socket;
import java.util.LinkedHashMap;
import java.util.List;

/*
*   求出主人公的出现位置，求出前后100个字节内出现的人物，对出现的人物count++,最后通过饼状图展示
*   循环1：求出主人公位置，循环2：遍历前50个字符到后50个字符
*
* */


public class Faction3 extends JFrame implements ActionListener {

    //Socket
    private Socket socket;

    //控件
    private JButton btIntimacy = new JButton("判断亲密度");
    private JButton btCancel = new JButton("取消");
    private JButton btClassify = new JButton("分类");
    private JButton btUpload = new JButton("上传饼状图");
    private JButton btUpload2 = new JButton("上传关系图");

    public Faction3()
    {

        super("判断亲密度");


        //添加控件
        this.add(btIntimacy);
        this.add(btClassify);
        this.add(btUpload);
        this.add(btUpload2);
        this.add(btCancel);

        //设置界面
        this.setLayout(new FlowLayout(FlowLayout.LEFT,20,20));
        this.setSize(380, 160);
        GUIUtil.toCenter(this);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

        //添加监听事件
        btIntimacy.addActionListener(this);
        btCancel.addActionListener(this);
        btClassify.addActionListener(this);
        btUpload.addActionListener(this);
        btUpload2.addActionListener(this);

        //Faction3 Socket连接
        try{
            socket = new Socket("127.0.0.1",9999);
        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    public void actionPerformed(ActionEvent ac){
        if(ac .getSource() == btCancel)
        {
            this.dispose();
            new Client();
        }

        //计算亲密度
        else if(ac.getSource() == btIntimacy)
        {
            //调用计算亲密度函数
            List<String> keyword = null;
            try {
                keyword = FileLoader.getTxt("Char.txt");
            }catch (Exception e)
            {
                e.printStackTrace();
            }

            //用Count.IndexOfMaster得到主角出现的具体位置
            //用MyMap(数据结构）保存主角出现的具体位置
            Count c = new Count();
            MyMap t = c.IndexofMaster();

            //计算亲密度，保存在lhm中
            LinkedHashMap<String,Integer> Intimacy = new LinkedHashMap<String, Integer>() ;
            Intimacy = c.SearchSurround(t,keyword);

            //画图
            new PieChart(Intimacy);
        }

        //分类
        else if (ac.getSource() == btClassify)
        {
            new Classify();
        }

        //上传饼状图
        else if (ac.getSource() == btUpload){
            Upload.jpgUpload3(socket);
        }

        //上传关系图
        else if (ac.getSource() == btUpload2){
            try{
                socket = new Socket("127.0.0.1",9999);
            }catch(Exception e)
            {
                e.printStackTrace();
            }
            Upload.jpgUpload4(socket);
        }

    }


}
