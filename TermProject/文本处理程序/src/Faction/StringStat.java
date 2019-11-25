package Faction;

import java.util.*;

//计算存在感类
public class StringStat {

    //计算出现次数函数
    public static LinkedHashMap<String, Integer> SearchKeyword(List<String> aWords, List<String> keyWords) {
    //传入文章和要搜索的人物

        //count接收 人物：出现次数
        LinkedHashMap<String, Integer> count = new LinkedHashMap<String, Integer>();

        //对每个人物进行循环判断
        for (String keyWord : keyWords) {
            int times = 0;

            //按String数组的每个元素为单位计算
            for (String aWord : aWords) {
                int index = 0;
                int next = 0;
                //next为每次查找的起始点，查询到一次就把next更新，每次查询的字符长度和人名长度相同

                while ((index = aWord.indexOf(keyWord, next)) != -1) {

                    next = index + keyWord.length();

                    times++;
                }
            }

            //得到的结果 put处理
            count.put(keyWord, times);
        }
        return count;
    }

    //排序出现次数函数
    public static LinkedHashMap<String,Integer> SortKeyword(LinkedHashMap aWords) throws Exception{

        //用Entry（键）的List来接收排序的结果
        List<Map.Entry<String,Integer>> list = new ArrayList<Map.Entry<String, Integer>>(aWords.entrySet());

        //Collections.sort中 compare函数的重写
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });

        //用新的Map存放排序后的结果并返回
        LinkedHashMap<String,Integer> lhm = new LinkedHashMap<String,Integer>();
        for( int i = 0; i < list.size(); i++)
        {
            lhm.put(list.get(i).getKey(),list.get(i).getValue());
        }
        return lhm;
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
