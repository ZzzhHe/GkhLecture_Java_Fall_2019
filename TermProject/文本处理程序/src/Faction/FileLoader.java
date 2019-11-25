package Faction;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

//加载本地文件
public class FileLoader {
    //加载本地文件函数
    public static List<String> getTxt(String srcFileName ) throws Exception{
        File file = new File(srcFileName);
        LineNumberReader fileReader = null;

        //用字符串List来保存文章
        List<String> words = new ArrayList<String>();

        //用LineNumberReader 来按行读取文件
        fileReader = new LineNumberReader(new InputStreamReader(new FileInputStream(file), StandardCharsets.UTF_8));
        String lineReader = null;

        //开始读取
        while ( (lineReader = fileReader.readLine()) != null)
            {
                words.add(lineReader);
            }

        fileReader.close();

        return words;
    }
}
