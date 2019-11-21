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



    public static void jpgUpload(Socket socket) {
        try {
            FileInputStream fis = new FileInputStream(new File
                    ("C:\\Users\\wohez\\IdeaProjects\\TermProject\\BarGraph.jpg"));
            OutputStream os = socket.getOutputStream();
//            int b;
//            while ((b = fis.read()) != -1) {
//                os.write(b);
//            }
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
        System.out.println("上传完毕");
    }
}
