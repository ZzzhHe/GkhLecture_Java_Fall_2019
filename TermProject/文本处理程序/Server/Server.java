package Server;

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
    private JTextArea taShow = new JTextArea();
    public Server() throws Exception{
        super("目前无客户端连接");
        this.add(btNovel,BorderLayout.SOUTH);
        this.add(taShow, BorderLayout.NORTH);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(300,100);
        this.setVisible(true);
        GUIUtil.toCenter(this);

        ss = new ServerSocket(9999);
        socket = ss.accept();
        String clientAddress = ss.getInetAddress().getHostAddress();
        taShow.append("客户"+clientAddress+"连接"+"\n");

        btNovel.addActionListener(this);

    }
    public void actionPerformed(ActionEvent e){
        try{
            FileReader fr = new FileReader("C:\\Users\\wohez\\IdeaProjects\\TermProject\\src\\Server\\1984.txt");
            BufferedReader br = new BufferedReader(fr);
            OutputStream os = socket.getOutputStream();
            BufferedWriter bw = new BufferedWriter( new OutputStreamWriter(os) );
            String str = null;
            while((str = br.readLine()) != null)
            {
                bw.write(str);
                System.out.println(str);
                bw.write(System.getProperty("line.separator"));
                bw.flush();
            }
            bw.close();
            br.close();
            bw.close();

        }catch (Exception ex)
        {
            ex.printStackTrace();
        }

        taShow.append("小说1984已经载入...");
    }
    public static void main(String[] args) throws Exception {
        new Server();
    }
}