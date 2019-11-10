package Server;

import util.GUIUtil;

import javax.swing.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server extends JFrame {
    private ServerSocket ss;
    private Socket socket;
    public Server() {
        super("目前无客户端连接");
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
