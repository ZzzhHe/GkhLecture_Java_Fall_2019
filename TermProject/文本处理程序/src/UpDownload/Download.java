package UpDownload;

import Client.Client;

import javax.swing.*;
import java.io.*;
import java.net.Socket;

public class Download {
    public static void txtDownload(Socket socket) {

        try {
            FileWriter fw = new FileWriter("C:\\Users\\wohez\\IdeaProjects\\TermProject\\Download.txt");
            BufferedWriter bw = new BufferedWriter(fw);

            InputStream is = socket.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String str = null;
            while( (str = br.readLine()) != null ){
                bw.write(str);
                bw.write(System.getProperty("line.separator"));
                bw.flush();
            }
            JOptionPane.showMessageDialog(null,"成功!");
            br.close();
        } catch (Exception e) { }
    }

    public static void jpgDownload(Socket socket) {
        try {
            socket = new Socket("127.0.0.1", 9999);
            FileOutputStream fos = new FileOutputStream(new File
                    ("C:\\Users\\wohez\\IdeaProjects\\TermProject\\src\\Server\\BarGraph.jpg"));
            InputStream is = socket.getInputStream();
            int b;
            while ( ( b = is.read() ) != -1 ) {
                System.out.println(b);
                fos.write(b);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
