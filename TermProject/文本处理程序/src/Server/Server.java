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
//    private ServerSocket ss;
//    private Socket socket;
//    private Socket[] socket = new Socket[10];
    private Socket socket;
    private JButton btNovel = new JButton("小说");
    private JButton btDownload = new JButton("下载柱状图");
    private JTextArea taShow = new JTextArea();
    public Server() {
        super("目前无客户端连接");
        this.add(btDownload,BorderLayout.EAST);
        this.add(btNovel,BorderLayout.SOUTH);
        this.add(taShow, BorderLayout.NORTH);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(300,100);
        this.setVisible(true);
        GUIUtil.toCenter(this);

        btDownload.addActionListener(this);
        btNovel.addActionListener(this);

        /*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
        new Thread(this).start();
        /*----------------------------------------------------------------------------------*/

//        ServerSocket ss = new ServerSocket(9999);
//        Socket s  =ss.accept();
    }
    /*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
    public void run(){
        try{
            int i = 1;
            ServerSocket ss = new ServerSocket(9999);
            while(true) {
                socket = ss.accept();
                taShow.append("客户端" + i + "连接" + "\n");
                i++;
            }
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    /*-------------------------------------------------------------------------------*/


    public void actionPerformed(ActionEvent e){
        if (e.getSource() == btNovel) {

            Upload.txtUpload(socket);
            taShow.append("小说1984已经载入..."+"\n");
            System.out.println("小说1984已经载入....");

        } else if (e.getSource() == btDownload) {
            System.out.println("进入下载功能外部");
            Download.jpgDownload(socket);
        }
    }


    public static void main(String[] args) throws Exception {
        new Server();
    }
}