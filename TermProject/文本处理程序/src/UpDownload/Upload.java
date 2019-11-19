package UpDownload;

import java.io.*;
import java.net.Socket;

public class Upload {
    public static void txtUpload(Socket socket) {
        try{
            FileReader fr = new FileReader("C:\\Users\\wohez\\IdeaProjects\\TermProject\\src\\Server\\1984.txt");
            BufferedReader br = new BufferedReader(fr);
            OutputStream os = socket.getOutputStream();
            BufferedWriter bw = new BufferedWriter( new OutputStreamWriter(os) );
            String str = null;
            while((str = br.readLine()) != null)
            {
                bw.write(str);
                bw.write(System.getProperty("line.separator"));
                bw.flush();
            }
            br.close();
            bw.close();

        }catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }

    public void jpgUpload(Socket socket) {
        try {
            socket = new Socket("127.0.0.1", 9999);
            FileInputStream fis = new FileInputStream(new File
                    ("C:\\Users\\wohez\\IdeaProjects\\TermProject\\BarGraph.jpg"));
            // TODO: 2019/11/15
            //  重新传回文件时，不能使用同一个socket？socket is close??
            //  在第一次读取小说的时候已经把socket.getOutputStream关闭了，如果不关闭则程序会卡死
            //  要运用多线程？？
            OutputStream os = socket.getOutputStream();
            int b;
            while ((b = fis.read()) != -1) {
                System.out.println(b);
                os.write(b);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
