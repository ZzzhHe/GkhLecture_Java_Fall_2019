/*
*       ✳IO操作
*       划分输入输出：从内存角度
*       输入输出，最典型的是文件的输入输出
*       文件输入，文件输出
*
*       java.io包
*       1：怎样用Java操作文件
*           java.io.File类
*       例：将D盘下面Java文件夹下面所有文件删除
*       2.读写文件
*           读文件：读入->显示在显示屏上
*               ①java.io.FileInputStream:字节流，支持类型多，但是对双字节字符支持不佳（可支持图片和视频等等）
*               ②java.io.FileReader:字符流，一般支持字符，对双字节字符支持较好
*               ③还有一种读的功能，按照行读，readLine，在网络编程中应用较多   BufferedReader
*           写文件：
*               ①java.io.FileOutputStream:可以支持中文
*               ②java.io.FileWriter:没有自己的成员函数，全部来自继承
*               ③更加丰富的格式写：
*               System.out == PrintStream 功能上 System.out实现的功能是在屏幕上输出，而PrintStream实现的功能实在文件中输出
* `     3.随机文件的读写：
*           在文件某个随机位置定义一个起始点，从起始点进行读写
*               java.io.RandomAccessFile
*               可以读+写，区别在于可以随意选取起始点进行读写
* */


package The10th;

import java.io.*;

public class JavaIo {
    //    例：将D盘下面Java文件夹下面所有文件删除
    public static void main(String[] args) throws Exception{
 /*
        File f = new File("d:/Java");

        File[] files = f.listFiles();
        for (File ft : files) {
            System.out.println(ft.getAbsolutePath());
            ft.delete();
        }
        FileInputStream fis = new FileInputStream("d:/test");
        System.out.println(fis.read());
        /*
        while (true) {
            int ch = fis.read();
            if( ch == -1 )
                break;
            System.out.print( (char) ch );
        }
        byte[] data = new byte[100];
        fis.read( data );
        String str = new String( data );
        System.out.println( str );
        */

    FileInputStream fis = new FileInputStream( "a.jpg" );
    FileOutputStream fos = new FileOutputStream("d:/b.jpg");
    while( true ){
        int i = fis.read();
        if( i == -1 )
            break;
        fos.write( i );
    }
    fis.close();
    fos.close();
    }
}

class ReadLine {
    public static void main(String[] args) throws Exception{
        BufferedReader = new BufferedReader(new FileReader("d:/test"));

    }
}
