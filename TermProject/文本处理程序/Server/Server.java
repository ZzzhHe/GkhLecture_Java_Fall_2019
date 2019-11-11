package Server;

import util.GUIUtil;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

// TODO: 2019/11/10
// 1.挑选一本小说
// 2.从服务器读取文件到客户端中
// 3.对文本进行处理
//先后顺序不固定。可以尝试先进行3

public class Server extends JFrame {
    private ServerSocket ss;
    private Socket socket;
    private JButton btNovel = new JButton("小说");
    public Server() {
        super("目前无客户端连接");
        this.add(btNovel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(300,100);
        this.setVisible(true);
        GUIUtil.toCenter(this);
        try{
            ss = new ServerSocket(9999);
            socket = ss.accept();
            String clientAddress = ss.getInetAddress().getHostAddress();
            this.setTitle("客户"+clientAddress+"连接");
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
    public static void main(String[] args) {
        new Server();
    }
}
