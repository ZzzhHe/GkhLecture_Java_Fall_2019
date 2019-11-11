package Client;

import Faction.*;
import util.Conf;
import util.GUIUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class Client extends JFrame implements ActionListener {
    private JLabel lbWelcome = new JLabel(new ImageIcon("C:\\Users\\wohez\\IdeaProjects\\TermProject\\Client.jpg"));
    private JButton btDownload = new JButton("下载小说");
    private JButton btMod = new JButton("修改信息");
    private JButton btCount = new JButton("查找（试验）");
    private JButton btExit = new JButton("退出");
    private Socket socket;
    public Client() {
        super("用户界面");
        this.setLayout(new FlowLayout());
        this.add(lbWelcome);
        this.add(btMod);
        this.add(btExit);
        this.add(btCount);
        this.add(btDownload);
        this.setSize(280, 160);
        GUIUtil.toCenter(this);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        btExit.addActionListener(this);
        btMod.addActionListener(this);
        btCount.addActionListener(this);
        btDownload.addActionListener(this);
        try {
            socket = new Socket("127.0.0.1", 9999);
            JOptionPane.showMessageDialog(this, "连接成功");
            this.setTitle("客户端已成功连接服务器");
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }


    // TODO: 2019/11/11
//                把功能分割
//                连接功能与读取数据功能要分开
//                当服务器点击按钮时开始传输，客户端点击按钮时接受传输
    public void actionPerformed(ActionEvent ae) {
        if( ae.getSource() == btDownload){
            try {
                FileWriter fw = new FileWriter("C:\\Users\\wohez\\IdeaProjects\\TermProject\\out.txt");
                BufferedWriter bw = new BufferedWriter(fw);

                InputStream is = socket.getInputStream();
                BufferedReader br = new BufferedReader(new InputStreamReader(is));
                System.out.println("开始");
                String str = null;
                while( (str = br.readLine()) != null ){
                    bw.write(str);
                    System.out.println(str);
                    bw.write(System.getProperty("line.separator"));
                    bw.flush();
                }
                JOptionPane.showMessageDialog(this,"成功!");
                br.close();
            } catch (Exception e) { }
        }
        else if ( ae.getSource() == btMod) {
            this.dispose();
            new ModifyFrame();
        } else if (ae.getSource() == btCount ) {
            this.dispose();
            new Faction1();
        } else {
            JOptionPane.showMessageDialog(this, "即将退出");
            System.exit(0);
        }
    }
}
