package Frame;

import util.Conf;
import util.FileOpe;
import util.GUIUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ModifyFrame extends JFrame implements ActionListener {
    private JLabel lbAccount = new JLabel("您的账号"+"\n");
    private JLabel lbAccount2 = new JLabel(Conf.account);
    private JLabel lbPassword = new JLabel("请设置您的密码");
    private JPasswordField pfPassword = new JPasswordField(10);
    private JLabel lbPassword2 = new JLabel("请确认您的密码");
    private JPasswordField pfPassword2 = new JPasswordField(10);
    private JLabel lbName = new JLabel("请输入您的姓名");
    private JTextField tfName = new JTextField(10);
    private JLabel lbMaj = new JLabel("请设置您的专业");
    private JComboBox cbMaj = new JComboBox();
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
        this.add(lbName);
        this.add(tfName);
        this.add(lbMaj);
        this.add(cbMaj);
        cbMaj.addItem("计科");
        cbMaj.addItem("大数据");
        cbMaj.addItem("物联网");
        cbMaj.addItem("信安");
        this.add(btSub);
        this.add(btCanc);
        this.setSize(240, 180);
        GUIUtil.toCenter(this);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
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
            String name = tfName.getText();
            String Major = (String) cbMaj.getSelectedItem();
            FileOpe.updataCustomer(Conf.account,password,name,Major);
            JOptionPane.showMessageDialog(this,"成功修改");
            this.dispose();
        }
        else{
            this.dispose();
            System.exit(0);
        }
    }
}
