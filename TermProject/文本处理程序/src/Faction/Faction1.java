package Faction;

import UpDownload.Upload;
import util.GUIUtil;
import Client.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.net.Socket;
import java.util.LinkedHashMap;
import java.util.List;

public class Faction1 extends JFrame implements ActionListener {
    //传输客户端Socket
    private Socket socket;

    //控件
    private JButton btCount = new JButton("存在感");
    private JButton btUpload = new JButton("上传柱状图");
    private JButton btCancel = new JButton("取消");
    private JButton btSave = new JButton("保存图片");

    //构造函数
    public Faction1() {
        super("判断存在感");

        this.setLayout(new FlowLayout(FlowLayout.LEFT,20,20));

        //添加控件
        this.add(btCount);
        this.add(btCancel);
        this.add(btUpload);
        this.add(btSave);

        //设置界面
        this.setLayout(new FlowLayout());
        this.setSize(380, 160);
        GUIUtil.toCenter(this);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

        //添加监听事件
        btSave.addActionListener(this);
        btCancel.addActionListener(this);
        btCount.addActionListener(this);
        btUpload.addActionListener(this);

        //Faction1 Socket连接
        try{
            socket = new Socket("127.0.0.1",9999);
        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }
        //事件相应
        public void actionPerformed (ActionEvent ae ){

        //取消按钮
        if (ae.getSource() == btCancel)
            {
                this.dispose();
                new Client();
            }

        //计算存在感
        else if (ae.getSource() == btCount) {
                try {

                    //从文件中读取文章和主人翁
                    List<String> data = FileLoader.getTxt("Download.txt");
                    List<String> keyword = FileLoader.getTxt("Char.txt");

                    //查找人物出现的次数，并保存在LinkedHashMap中
                    LinkedHashMap<String,Integer> tm = StringStat.SortKeyword(StringStat.SearchKeyword(data,keyword));

                    //利用刚刚保存的存在感信息画出图形
                    new BarChart(tm);

                } catch (Exception ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null,"异常操作");
                }

        //上传图片按钮
        } else if (ae.getSource() == btUpload) {
                Upload.jpgUpload(socket);

        //截图
        } else  if(ae.getSource() == btSave){
                    try {
                        BufferedImage bi =
                                new Robot().createScreenCapture(new Rectangle(10, 10, 1300, 1000));
                        File file = new File("BarGraph.jpg");
                        ImageIO.write(bi,"JPEG",file);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }

}
