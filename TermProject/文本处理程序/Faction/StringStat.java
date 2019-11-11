package Faction;

import java.util.*;

public class StringStat {

    public static LinkedHashMap<String,Integer> SortKeyword(LinkedHashMap aWords) {
        List<Map.Entry<String,Integer>> list = new ArrayList<Map.Entry<String, Integer>>(aWords.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });
        LinkedHashMap<String,Integer> lhm = new LinkedHashMap<String,Integer>();
        for( int i = 0; i < list.size(); i++)
        {
            try {
                lhm.put(list.get(i).getKey(),list.get(i).getValue());
            }catch (Exception e)
            {
                e.printStackTrace();
            }
            System.out.println(list.get(i).getKey()+":"+list.get(i).getValue());
        }
        return lhm;
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






 /*
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
    */
