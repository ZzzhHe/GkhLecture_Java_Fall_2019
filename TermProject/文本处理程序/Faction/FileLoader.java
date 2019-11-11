package Faction;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class FileLoader {
    public static List<String> getTxt(String srcFileName ) {
        File file = new File(srcFileName);
        LineNumberReader fileReader = null;
        List<String> words = new ArrayList<String>();
        try {
            fileReader = new LineNumberReader(new InputStreamReader(new FileInputStream(file), StandardCharsets.UTF_8));
            String lineReader = null;
            while ( (lineReader = fileReader.readLine()) != null)
            {
                words.add(lineReader);
            }
            fileReader.close();
        }catch(Exception e) {
            e.printStackTrace();
        }
        return words;
    }
}
