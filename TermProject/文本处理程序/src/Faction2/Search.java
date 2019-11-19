package Faction2;

import Faction.FileLoader;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Search {

    public static LinkedHashMap<Integer,Integer> DensitySearch(String name) {
        List<String> word = null;
        try {
            word = FileLoader.getTxt("1984.txt");
        } catch (Exception e) {
            e.printStackTrace();
        }
        LinkedHashMap<Integer,Integer> count = new LinkedHashMap<Integer, Integer>();
        int[] times = new int[20];
        int i = 0;
        for ( int k = 0; k < word.size(); k++) {
            int index = 0;
            int next = 0;
            while ((index = word.get(k).indexOf(name, next)) != -1) {
                next = index + name.length();
                times[i]++;
            }
            if (k > (word.size() / 20) * (i+1)) {
                i++;
            }
        }

            for (int j = 0; j < 20; j++) {
                count.put(j, times[j]);
                int m = j +1;
                System.out.println("文中第"+m+"部分"+"出现"+name+":"+times[j]);
            }
        return count;
    }

}
