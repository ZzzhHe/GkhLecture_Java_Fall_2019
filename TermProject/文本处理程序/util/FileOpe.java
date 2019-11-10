package util;
/*
*   文件打开类：
*       功能：1.从文件中读取数据存放在客户端中
*            2.把更新的信息重新写入文件中
* */
import javax.swing.*;
import java.io.FileReader;
import java.io.PrintStream;
import java.util.Properties;

public class FileOpe {
    private static String fileName = "cus.inc";
    private static Properties pps;
    //把存放数据的“cus.inc”文件，用按行访问的Properties打开
    static{
        pps = new Properties();
        FileReader reader = null;
        try{
            reader = new FileReader(fileName);
            pps.load(reader);
        }catch (Exception e){
            JOptionPane.showMessageDialog(null,"文件操作异常");
            System.exit(0);
        }finally {
            try {
                reader.close();
            }catch(Exception ex){ }
        }
    }
    //把Properties中的信息输出到文件中
    private static void listInfo(){
        PrintStream ps =null;
        try {
            ps = new PrintStream(fileName);
            pps.list(ps);
        }catch (Exception ex){
            JOptionPane.showMessageDialog(null,"文件操作异常");
            System.exit(0);
        }finally {
            try {
                ps.close();
            } catch (Exception ex) {}
        }
    }
    //把存在文件中的信息读取到Conf中
    public static void getInfoByAccount(String account){
        String cusInfo = pps.getProperty(account);
        if( cusInfo != null ){
            String[] info = cusInfo.split("#");
            Conf.account = account;
            Conf.password = info[0];
        }
    }
    //把更新的数据重新写入到文件中
    public static void updateCustomer(String account, String password){
        pps.setProperty(account,password);
        listInfo();
    }
}
