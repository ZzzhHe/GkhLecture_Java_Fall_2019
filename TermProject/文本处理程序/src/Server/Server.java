package Server;

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


public class Server extends JFrame implements ActionListener{
    private ServerSocket ss;
    private Socket socket;
    private JButton btNovel = new JButton("小说");
    private JButton btDownload = new JButton("下载柱状图");
    private JTextArea taShow = new JTextArea();
    public Server() throws Exception{
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

        ServerSocket ss = new ServerSocket(9999);
        socket =ss.accept();
        String clientAddress = ss.getInetAddress().getHostAddress();
        taShow.append("客户"+clientAddress+"连接"+"\n");
    }

    public void actionPerformed(ActionEvent e){
        if (e.getSource() == btNovel) {

            Upload.txtUpload(socket);
            taShow.append("小说1984已经载 入...");
        } else if (e.getSource() == btDownload) {
            Download.jpgDownload(socket);
        }
    }


    public static void main(String[] args) throws Exception {
        new Server();
    }
}