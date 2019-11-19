package Client;

import util.Conf;
import util.FileOpe;
import util.GUIUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginFrame extends JFrame implements ActionListener {
    private JLabel lbAccount = new JLabel("用户名：");
    private JTextField tfAccount = new JTextField(10);
    private JLabel lbPassword = new JLabel("密  码：");
    private JPasswordField pfPassword = new JPasswordField(10);
    private JLabel lbWelcome = new JLabel(new ImageIcon("C:\\Users\\wohez\\IdeaProjects\\TermProject\\welcome.jpg"));
    JButton btLogin = new JButton("登陆");
    JButton btExit = new JButton("退出");
    public LoginFrame() {
        super("登陆");
        this.setLayout(new FlowLayout());
        this.add(lbWelcome);
        this.add(lbAccount);
        this.add(tfAccount);
        this.add(lbPassword);
        this.add(pfPassword);
        this.add(btLogin);
        this.add(btExit);
        this.setSize(380, 160);
        GUIUtil.toCenter(this);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        btLogin.addActionListener(this);
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
            new Client();
        }
        else
        {
            JOptionPane.showMessageDialog(this,"即将退出");
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        new LoginFrame();
    }
}
