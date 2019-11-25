package Client;

import Faction.*;
import Faction2.Faction2;
import Faction3.Faction3;
import UpDownload.Download;
import UpDownload.Upload;
import util.GUIUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.Socket;

public class Client extends JFrame implements ActionListener {

    //添加控件
    private JLabel lbWelcome = new JLabel(new ImageIcon("C:\\Users\\wohez\\IdeaProjects\\TermProject\\Client.jpg"));
    private JButton btDownload = new JButton("下载小说");
    private JButton btMod = new JButton("修改信息");
    private JButton btCount = new JButton("计算存在感");
    private JButton btExit = new JButton("退出");
    private JButton btSearch = new JButton("计算密度");
    private JButton btIntimacy = new JButton("计算亲密度");

    //客户端Socket
    private Socket socket;

    public Client() {
        //设置界面
        super("用户界面");
        this.setLayout(new FlowLayout(FlowLayout.LEFT,30,40));
        this.add(lbWelcome);
        this.add(btMod);
        this.add(btDownload);
        this.add(btCount);
        this.add(btSearch);
        this.add(btIntimacy);
        this.add(btExit);
        this.setSize(380, 300);
        GUIUtil.toCenter(this);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

        //添加监听
        btExit.addActionListener(this);
        btMod.addActionListener(this);
        btCount.addActionListener(this);
        btDownload.addActionListener(this);
        btSearch.addActionListener(this);
        btIntimacy.addActionListener(this);

        //客户端连接服务器
        try {
            socket = new Socket("127.0.0.1", 9999);
            this.setTitle("客户端已成功连接服务器");
        }catch (Exception e)
        {
            e.printStackTrace();
        }

    }

        //监听事件
    public void actionPerformed(ActionEvent ae) {
        //下载小说
        if( ae.getSource() == btDownload){
            Download.txtDownload(socket);
        }
        //修改信息
        else if ( ae.getSource() == btMod) {
            this.dispose();
            new ModifyFrame();
        }
        //计算存在感
        else if (ae.getSource() == btCount ) {
            this.dispose();
            new Faction1();
        }
        //计算密度
        else if (ae.getSource() == btSearch) {
            this.dispose();
            new Faction2();
        }
        //计算亲密度
        else if (ae.getSource() == btIntimacy){
            this.dispose();
            new Faction3();
        }
        //退出界面
        else if (ae.getSource() == btExit){
            JOptionPane.showMessageDialog(this, "即将退出");
            System.exit(0);
        }
    }
}
