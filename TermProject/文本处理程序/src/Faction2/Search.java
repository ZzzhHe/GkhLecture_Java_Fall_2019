package Faction2;

import Faction.FileLoader;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

//检索密度类
public class Search {

    //求出每个姓名在不同章节出现的次数
    public static LinkedHashMap<Integer,Integer> DensitySearch(String name) {

        //用Novel读取整个文章
        List<String> Novel = null;
        try {
            Novel = FileLoader.getTxt("Download.txt");

        } catch (Exception e) {
            e.printStackTrace();
        }

        //正片文章按照章节进行分段，分段标记保存在Index中
        int[] index = new int[59];
        int x = 1;
            for (int k = 0; k < Novel.size(); k++) {
                int t = 0;
                while ((t = Novel.get(k).indexOf("#" + x)) !=-1){
                    index[x] = k ;
                    x++;
                }
            }

        //用words储存分段之后的结果
        //并且把一共58个章节分成了10个部分
        List<List<String>> words = new ArrayList<List<String>>();
        for(int i = 0; i < 10; i++)
        {
//            0~5 6~11 12~17 18~23 24~29 30~35 36~41 42~47 48~53 54~59
            try{

                if( i * 6 + 5 < 58)
                    words.add(Novel.subList(index[i*6],index[i*6+5]));
                else
                    words.add(Novel.subList(index[i*6],index[i*6+4]));
            }catch (Exception e)
            {
                e.printStackTrace();
            }
        }

        //对每一段再进行出现次数查找操作
        LinkedHashMap<Integer,Integer> count = new LinkedHashMap<Integer, Integer>();
        int[] times = new int[10];

        for( int j = 0; j < 10; j++)
        {
            //wordList存放 10段内容
            List<String> wordList = words.get(j);
            for ( int k = 0; k < wordList.size(); k++) {
                int indexs = 0;
                int next = 0;
                //这里查找的范围是每一段
                while ((indexs = wordList.get(k).indexOf(name, next)) != -1) {
                    next = indexs + name.length();
                    times[j]++;
                }
            }
        }
            for (int j = 0; j < 10; j++) {
                count.put(j, times[j]);
            }
        return count;
    }

}
