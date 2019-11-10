package Frame;

import util.Conf;
import util.GUIUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OperationFrame extends JFrame implements ActionListener {
    private JButton btQuery = new JButton("显示");
    private JButton btModi  = new JButton("修改");
    private JButton btExit  = new JButton("退出");

    public OperationFrame() {
        super("已登陆账号"+ Conf.account);
        this.setLayout( new FlowLayout() );
        this.add( btQuery );
        this.add( btModi );
        this.add( btExit );
        this.setSize(240, 180);
        GUIUtil.toCenter(this);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setVisible(true);
        btQuery.addActionListener(this);
        btModi.addActionListener(this);
        btExit.addActionListener(this);

    }

    public void actionPerformed( ActionEvent e ) {
        if(e.getSource() == btQuery)
        {
            String message = "账号: " + Conf.account + "\n";
            message += "姓名: " + Conf.name + "\n";
            message += "专业: " + Conf.dept + "\n";
            JOptionPane.showMessageDialog( this, message );
        } else if (e.getSource() == btModi) {
            this.dispose();
            new ModifyFrame();
        } else {
            this.dispose();
            JOptionPane.showMessageDialog(this,"即将关闭");
            System.exit(0);
        }
    }
}
