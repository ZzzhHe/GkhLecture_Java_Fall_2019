package Client;

import Faction.*;
import util.Conf;
import util.GUIUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.Socket;

public class Client extends JFrame implements ActionListener {
    private JLabel lbWelcome = new JLabel(new ImageIcon("C:\\Users\\wohez\\IdeaProjects\\TermProject\\Client.jpg"));
    private JButton btConn = new JButton("连接服务器");
    private JButton btMod = new JButton("修改信息");
    private JButton btCount = new JButton("查找（试验）");
    private JButton btExit = new JButton("退出");
    private Socket socket;
    public Client() {
        super("用户界面");
        this.setLayout(new FlowLayout());
        this.add(lbWelcome);
        this.add(btConn);
        this.add(btMod);
        this.add(btExit);
        this.add(btCount);
        this.setSize(280, 160);
        GUIUtil.toCenter(this);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        btConn.addActionListener(this);
        btExit.addActionListener(this);
        btMod.addActionListener(this);
        btCount.addActionListener(this);
    }

    public void actionPerformed(ActionEvent ae) {
        if( ae.getSource() == btConn ) {
            try{
                socket = new Socket("127.0.0.1",9999);
                JOptionPane.showMessageDialog(this,"正在连接服务器...");
                Thread.sleep(2000);
                JOptionPane.showMessageDialog(this,"连接成功");
                this.setTitle("客户端已成功连接服务器");
            }catch(Exception e){
                e.printStackTrace();
            }
        }else if ( ae.getSource() == btMod) {
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
