package Server;

import Faction2.Search;
import UpDownload.Download;
import UpDownload.Upload;
import org.jfree.chart.StandardChartTheme;
import util.GUIUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.lang.reflect.Field;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;


public class Server extends JFrame implements ActionListener,Runnable{
    //接收客户端Socket
    private Socket socket;

    //控件
    private JButton btNovel = new JButton("小说");
    private JButton btDownload = new JButton("下载柱状图");
    private JButton btDownload2 = new JButton("下载密度图");
    private JButton btDownload3 = new JButton("下载饼状图");
    private JButton btDownload4 = new JButton("下载关系图");
    private JTextArea taShow = new JTextArea();

    //构造函数
    public Server() {
        super("目前无客户端连接");

        //添加控件
        this.add(taShow);
        this.add(btNovel);
        this.add(btDownload);
        this.add(btDownload2);
        this.add(btDownload3);
        this.add(btDownload4);

        //设置界面
        this.setLayout(new FlowLayout(FlowLayout.LEFT,100,30));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(300, 600);
        this.setVisible(true);
        GUIUtil.toCenter(this);

        //添加监听
        btNovel.addActionListener(this);
        btDownload.addActionListener(this);
        btDownload2.addActionListener(this);
        btDownload3.addActionListener(this);
        btDownload4.addActionListener(this);

        //多线程运行
        new Thread(this).start();
    }

    //多线程函数
    public void run(){
        try{
            int i = 1;
            ServerSocket ss = new ServerSocket(9999);
            while(true) {

                //设置socket接收客户端的Socket
                socket = ss.accept();
                taShow.append("客户端" + i + "连接" + "\n");
                i++;
            }
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }


    //事件响应函数
    public void actionPerformed(ActionEvent e){
        //服务器段载入小说
        if (e.getSource() == btNovel) {
            Upload.txtUpload(socket);
            taShow.append("小说已经载入..."+"\n");
        }

        //下载柱状图
        else if (e.getSource() == btDownload) {
            Download.jpgDownload(socket);
            taShow.append("存在感图片已经下载..."+"\n");

        }

        //下载密度图
        else if(e.getSource() == btDownload2) {
            Download.jpgDownload2(socket);
            taShow.append("密度图已经下载..."+"\n");
        }
        else if(e.getSource() == btDownload3) {
            Download.jpgDownload3(socket);
            taShow.append("饼状图已经下载..."+"\n");
        }
        else if(e.getSource() == btDownload4) {
            Download.jpgDownload4(socket);
            taShow.append("关系图已经下载..."+"\n");
        }
    }


    public static void main(String[] args) throws Exception {
        //主函数
        new Server();
    }
}