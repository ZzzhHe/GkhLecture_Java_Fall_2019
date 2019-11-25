package UpDownload;

import Client.Client;

import javax.swing.*;
import java.io.*;
import java.net.Socket;

//下载文件类
public class Download {

    //服务器-->客户端本地 小说
    public static void txtDownload(Socket socket) {

        try {
            //BufferedReader 读取小说 从InputStream
            //BufferedWriter 写入小说 到本地
            FileWriter fw = new FileWriter("C:\\Users\\wohez\\IdeaProjects\\TermProject\\Download.txt");
            BufferedWriter bw = new BufferedWriter(fw);
            InputStream is = socket.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String str = null;
            while( (str = br.readLine()) != null ){
                bw.write(str);
                //换行符
                bw.write(System.getProperty("line.separator"));
                //冲洗流
                bw.flush();
            }
            JOptionPane.showMessageDialog(null,"成功!");
            br.close();
            bw.close();
        } catch (Exception e) { }
    }

    //客户端-->服务器文件夹
    public static void jpgDownload(Socket socket) {
        try {
            //InputStream 读取文件 从InputStream中
            //FileOutputStream 读取文件 到服务器客户端
            FileOutputStream fos = new FileOutputStream(new File
                    ("C:\\Users\\wohez\\IdeaProjects\\TermProject\\src\\Server\\BarGraph.jpg"));
            InputStream is = socket.getInputStream();
//            int b;
//            while ( ( b = is.read() ) != -1 ) {
//                fos.write(b);
//            }
            //byte读取法
            int n = 0;
            byte[] b = new byte[1024];
            while((n = is.read(b)) != -1)
            {
                fos.write(b,0,n);
            }
            is.close();
            fos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void jpgDownload2(Socket socket){
        try {
            FileOutputStream fos = new FileOutputStream(new File
                    ("C:\\Users\\wohez\\IdeaProjects\\TermProject\\src\\Server\\Graph.jpg"));
            InputStream is = socket.getInputStream();
            int n = 0;
            byte[] b = new byte[1024];
            while((n = is.read(b)) != -1)
            {
                fos.write(b,0,n);
            }
            is.close();
            fos.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void jpgDownload3(Socket socket){
        try {
            FileOutputStream fos = new FileOutputStream(new File
                    ("C:\\Users\\wohez\\IdeaProjects\\TermProject\\src\\Server\\PieGraph.jpg"));
            InputStream is = socket.getInputStream();
            int n = 0;
            byte[] b = new byte[1024];
            while((n = is.read(b)) != -1)
            {
                fos.write(b,0,n);
            }
            is.close();
            fos.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void jpgDownload4(Socket socket){
        try {
            FileOutputStream fos = new FileOutputStream(new File
                    ("C:\\Users\\wohez\\IdeaProjects\\TermProject\\src\\Server\\Classify.jpg"));
            InputStream is = socket.getInputStream();
            int n = 0;
            byte[] b = new byte[1024];
            while((n = is.read(b)) != -1)
            {
                fos.write(b,0,n);
            }
            is.close();
            fos.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
