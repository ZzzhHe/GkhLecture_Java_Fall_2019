package Faction;

import java.io.PrintStream;
import java.util.LinkedHashMap;
import java.util.Set;


//文件保存类
public class FileSaver {
    //文件保存函数
    public static void save(LinkedHashMap<String, Integer> tm, String destFileName)
            throws Exception {
        //用PrintStream来进行文件的保存
        PrintStream ps = new PrintStream(destFileName);

        //keySet接收key
        Set<String> keySet = tm.keySet();

        for (String s : keySet) {
            ps.println(s + "\t" + "\t" + tm.get(s));
        }

        ps.close();

    }
}

