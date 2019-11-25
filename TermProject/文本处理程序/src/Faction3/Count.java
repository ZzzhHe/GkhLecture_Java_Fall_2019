package Faction3;

import Faction.FileLoader;
import util.MyMap;

import java.util.*;

//计算亲密度
public class Count {
    List<String> Novel = null;
    public Count()
    {
        try {
            Novel = FileLoader.getTxt("Download.txt");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
//    寻找文章中出现主人公的位置
//    LinkedHashMap的Key值不能重复，所以需要用IdentityHashMap来替换
//    LinkedHashMap的Key值比较 .equal()，IdentityHashMap的Key值比较用 ==
    public MyMap IndexofMaster (){
        String Master = "思特里克兰德";
        MyMap count = new MyMap();
        for(int k = 0; k < Novel.size(); k++)
        {
            int index = 0;
            int next = 0;
            int temp = 0;
            while((index = Novel.get(k).indexOf(Master,next)) != -1){
                next = index + Master.length();
                count.put(k,index);
            }
        }
        count.show();
        return count;
    }

//    寻找主人公身旁的人-100~+100
    public LinkedHashMap<String,Integer> SearchSurround(MyMap myMap,List<String> name) {
        LinkedHashMap<String,Integer> countName = new LinkedHashMap<String, Integer>();
        ArrayList<Integer> keyArray = myMap.ListKey();
        for(String keyWord:name)
        {
            int count = 0;
            int i = 0;
            for (int k = 0; k < Novel.size(); k++) {
                while (k == keyArray.get(i) ) {
                    if (Novel.get(k).length() >= 100) {
                        Integer tmpIndex = myMap.get(i);
                        if (tmpIndex < 50) {
                            String subS = Novel.get(k).substring(0, tmpIndex + 50);
                            int index = 0;
                            int next = 0;
                            while ((index = subS.indexOf(keyWord, next)) != -1) {
                                next = index + keyWord.length();
                                count++;
                            }
                        } else if (tmpIndex > 50 && tmpIndex + 50 > Novel.get(k).length()) {
                            String subS = Novel.get(k).substring(tmpIndex - 50, Novel.get(k).length());
                            int index = 0;
                            int next = 0;
                            while ((index = subS.indexOf(keyWord, next)) != -1) {
                                next = index + keyWord.length();
                                count++;
                            }
                        } else {
                            String subS = Novel.get(k).substring(tmpIndex - 50, tmpIndex + 50);
                            int index = 0;
                            int next = 0;
                            while ((index = subS.indexOf(keyWord, next)) != -1) {
                                next = index + keyWord.length();
                                count++;
                            }
                        }
                    }
                    else if (Novel.get(k).length() < 100)
                    {
                        Integer tmpIndex = myMap.get(i);
                        int index = 0;
                        int next = 0;
                        while((index = Novel.get(k).indexOf(keyWord,next)) != -1){
                            next = index +keyWord.length();
                            count ++;
                        }
                    }
                    if(i < keyArray.size() - 1 )
                        i++;
                    else
                        break;
                }

            }
            countName.put(keyWord,count);
            System.out.println("keyWord" + keyWord + " count:" + count);
        }
        return countName;
    }



}
