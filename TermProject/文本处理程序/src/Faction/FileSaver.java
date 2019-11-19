package Faction;

import java.io.PrintStream;
import java.util.LinkedHashMap;
import java.util.Set;
import java.util.TreeMap;

public class FileSaver {
    public static void save(LinkedHashMap<String, Integer> tm, String destFileName)
            throws Exception {
        PrintStream ps = new PrintStream(destFileName);
        Set<String> keySet = tm.keySet();
        for (String s : keySet) {
            ps.println(s + "\t" + "\t" + tm.get(s));
        }
        ps.close();
    }
}

