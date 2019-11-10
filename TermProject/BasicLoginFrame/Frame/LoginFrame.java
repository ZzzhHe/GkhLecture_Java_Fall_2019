package Frame;

import util.Conf;
import util.FileOpe;
import util.GUIUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginFrame extends JFrame implements ActionListener {
    private JLabel lbAccount = new JLabel("请输入您的账号");
    private JTextField tfAccount = new JTextField(10);
    private JLabel lbPassword = new JLabel("请输入您的密码");
    private JPasswordField pfPassword = new JPasswordField(10);
    JButton btLogin = new JButton("登陆");
    JButton btRegster = new JButton("注册");
    JButton btExit = new JButton("退出");
    public LoginFrame() {
        super("登陆");
        this.setLayout(new FlowLayout());
        this.add(lbAccount);
        this.add(tfAccount);
        this.add(lbPassword);
        this.add(pfPassword);
        this.add(btLogin);
        this.add(btRegster);
        this.add(btExit);
        this.setSize(240, 180);
        GUIUtil.toCenter(this);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setVisible(true);
        btLogin.addActionListener(this);
        btRegster.addActionListener(this);
        btExit.addActionListener(this);
    }
    public void actionPerformed(ActionEvent e) {
        if( e.getSource() == btLogin )
        {
            String account = tfAccount.getText();
            String password = new String( pfPassword.getPassword() );
            FileOpe.getInfoByAccount( account );
            if( Conf.account == null )
            {
                JOptionPane.showMessageDialog(this,"账号不存在");
                return;
            }else if(!Conf.password.equals(password))
            {
                JOptionPane.showMessageDialog(this,"密码不正确");
                return;
            }
            JOptionPane.showMessageDialog(this,"登陆成功");
            this.dispose();
            new OperationFrame();
        }
        else if( e.getSource() == btRegster )
        {
            this.dispose();
            new RegisterFrame();
        }
        else
        {
            JOptionPane.showMessageDialog(this,"即将退出");
            System.exit(0);
        }
    }
}
