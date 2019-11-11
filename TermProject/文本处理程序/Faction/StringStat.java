package Faction;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.TreeMap;

public class StringStat {
    public static List<String> Clearup(List<String> words) {
        String[] arrWords = new String[words.size()];
        words.toArray(arrWords);
        List<String> aWord = new ArrayList<String>();
        for (int i = 0; i < arrWords.length; i++) {
            String[] t = arrWords[i].split(" ");
            for (int j = 0; j < t.length; j++) {
                int length = t[j].length();
                int begin = 0;
                int end = length;
                for (int k = 0; k < length; k++) {
                    if (t[j].charAt(k) == ',' || t[j].charAt(k) == '.' || t[j].charAt(k) == '"'
                            || t[j].charAt(k) == ')' || t[j].charAt(k) == '?' || t[j].charAt(k) == '!'
                            || t[j].charAt(k) == '(' || t[j].charAt(k) == '\'') {
                        if (k * 2 < length)
                            begin++;
                        else
                            end--;
                    }
                }
                t[j] = t[j].substring(begin, end);
                aWord.add(t[j]);
            }
        }
        return aWord;
    }

    public static LinkedHashMap<String, Integer> SearchKeyword(List<String> aWords, List<String> keyWords) {

        LinkedHashMap<String, Integer> count = new LinkedHashMap<String, Integer>();
        for (String keyWord : keyWords) {
            int times = 0;
            for (String aWord : aWords) {
                int index = 0;
                int next = 0;
                while ((index = aWord.indexOf(keyWord, next)) != -1) {
                    next = index + keyWord.length();
                    times++;
                }
            }
            count.put(keyWord, times);
            System.out.println("文中出现关键词"+keyWord+"达"+times+" 次");
        }
        return count;
    }
}
