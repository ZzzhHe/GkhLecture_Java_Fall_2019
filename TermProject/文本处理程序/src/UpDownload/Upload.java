package UpDownload;

import java.io.*;
import java.net.Socket;

//上传文件类
public class Upload {
    //服务器文件夹-->服务器 小说
    public static void txtUpload(Socket socket) {
        try{
            //BufferedReader读取（从服务器文件夹）
            //BufferedWriter写入-->OutputStream
            FileReader fr = new FileReader("C:\\Users\\wohez\\IdeaProjects\\TermProject\\src\\Server\\The Moon and Sixpence.txt");
            BufferedReader br = new BufferedReader(fr);
            OutputStream os = socket.getOutputStream();
            BufferedWriter bw = new BufferedWriter( new OutputStreamWriter(os) );
            String str = null;
            while((str = br.readLine()) != null)
            {
                bw.write(str);
                //换行符
                bw.write(System.getProperty("line.separator"));
                //冲刷流
                bw.flush();
            }
            br.close();
            bw.close();

        }catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }


    //客户端本地文件夹-->客户端 图片
    public static void jpgUpload(Socket socket) {
        try {
            //FileInputStream 从本地读文件
            //OutputStream 把文件写入InputStream
            FileInputStream fis = new FileInputStream(new File
                    ("C:\\Users\\wohez\\IdeaProjects\\TermProject\\BarGraph.jpg"));
            OutputStream os = socket.getOutputStream();
            int n = 0;
            byte[] b = new byte[2048];
            //byte法读取
            while(( n = fis.read(b)) != -1)
            {
                os.write(b,0,n);
            }
            fis.close();
            os.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void jpgUpload2(Socket socket) {
        try {
            FileInputStream fis = new FileInputStream(new File
                    ("C:\\Users\\wohez\\IdeaProjects\\TermProject\\Graph.jpg"));
            OutputStream os = socket.getOutputStream();
            int n = 0;
            byte[] b = new byte[2048];
            while(( n = fis.read(b)) != -1)
            {
                os.write(b,0,n);
            }
            fis.close();
            os.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void jpgUpload3(Socket socket) {
        try {
            FileInputStream fis = new FileInputStream(new File
                    ("C:\\Users\\wohez\\IdeaProjects\\TermProject\\PieGraph.jpg"));
            OutputStream os = socket.getOutputStream();
            int n = 0;
            byte[] b = new byte[2048];
            while(( n = fis.read(b)) != -1)
            {
                os.write(b,0,n);
            }
            fis.close();
            os.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void jpgUpload4(Socket socket) {
        try {
            FileInputStream fis = new FileInputStream(new File
                    ("C:\\Users\\wohez\\IdeaProjects\\TermProject\\Classify.jpg"));
            OutputStream os = socket.getOutputStream();
            int n = 0;
            byte[] b = new byte[2048];
            while(( n = fis.read(b)) != -1)
            {
                os.write(b,0,n);
            }
            fis.close();
            os.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
