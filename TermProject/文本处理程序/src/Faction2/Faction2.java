package Faction2;

import Client.Client;
import Faction.FileLoader;
import util.GUIUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.Socket;
import java.util.LinkedHashMap;
import java.util.List;

public class Faction2 extends JFrame implements ActionListener {
    //Socket
    private Socket socket;

    //控件
    private JButton btSearch = new JButton("查找密度");
    private JComboBox<String> cbName = new JComboBox<String>();
    private JButton btCancel = new JButton("取消");
    private JButton btUpload = new JButton("上传密度图");
    public static String name = "思特里克兰德";

    //lhm用于多个函数之间的调用
    public static LinkedHashMap<Integer,Integer> lhm = new LinkedHashMap<Integer, Integer>();

    //构造函数
    public Faction2() {
        super("密度");

        this.setLayout(new FlowLayout(FlowLayout.LEFT,20,20));
        //添加控件
        this.add(btCancel);
        this.add(btSearch);
        this.add(cbName);
        this.add(btUpload);

        //用keyWord 保存几个主人公的名字
        List<String> keyWord = null;
        try {
            keyWord = FileLoader.getTxt("Char.txt");

        } catch (Exception e) {
            e.printStackTrace();
        }

        //把名字添加在下拉菜单中
        for (int i = 0; i < keyWord.size(); i++) {
            cbName.addItem(keyWord.get(i));
        }

        //设置界面
        this.setSize(380, 160);
        GUIUtil.toCenter(this);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

        //增加监听事件
        btCancel.addActionListener(this);
        btSearch.addActionListener(this);
        cbName.addActionListener(this);
        btUpload.addActionListener(this);

        //创建客户端与服务器之间的连接
        try{
            socket = new Socket("127.0.0.1",9999);
        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }


    public void actionPerformed(ActionEvent e) {

        //检索密度功能
        if (e.getSource() == btSearch) {
            name = cbName.getSelectedItem().toString();
            lhm = Search.DensitySearch(name);
            new Graph(lhm);
        }

        //取消按钮
        else if (e.getSource() == btCancel) {
            this.dispose();
            new Client();
        }

        //上传密度图
        else if (e.getSource() == btUpload ){
            UpDownload.Upload.jpgUpload2(socket);
        }
    }

}
