package Client;

import util.Conf;
import util.FileOpe;
import util.GUIUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ModifyFrame extends JFrame implements ActionListener {
    private JLabel lbAccount = new JLabel("   您的账号:                      ");
    private JLabel lbAccount2 = new JLabel(Conf.account);
    private JLabel lbPassword = new JLabel("请设置您的密码:  ");
    private JPasswordField pfPassword = new JPasswordField(10);
    private JLabel lbPassword2 = new JLabel("请确认您的密码:   ");
    private JPasswordField pfPassword2 = new JPasswordField(10);
    private JButton btSub = new JButton("提交修改");
    private JButton btCanc = new JButton("取消");
    public ModifyFrame() {
        this.setLayout(new FlowLayout());
        this.add(lbAccount);
        this.add(lbAccount2);
        this.add(lbPassword);
        this.add(pfPassword);
        this.add(lbPassword2);
        this.add(pfPassword2);
        this.add(btSub);
        this.add(btCanc);
        this.setSize(240, 180);
        GUIUtil.toCenter(this);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        btSub.addActionListener(this);
        btCanc.addActionListener(this);
    }
    public void actionPerformed( ActionEvent e ){
        if (e.getSource() == btSub) {
            if( ! new String(pfPassword.getPassword()).equals( new String(pfPassword2.getPassword() )))
            {
                JOptionPane.showMessageDialog(this,"密码不相同，请重新输入");
                return;
            }
            String password = new String(pfPassword.getPassword());
            FileOpe.updateCustomer(Conf.account,password);
            JOptionPane.showMessageDialog(this,"成功修改");
            this.dispose();
        }
        else{
            this.dispose();
            new Client();
        }
    }
}
