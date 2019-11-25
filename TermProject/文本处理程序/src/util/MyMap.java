package util;

import java.util.ArrayList;
import java.util.List;

//创建一个数据结构
public class MyMap{
    private ArrayList<Integer> key = new ArrayList<Integer>();
    private ArrayList<Integer> value = new ArrayList<Integer>();
    public int size(){
        return key.size();
    }
    public ArrayList<Integer> ListKey() {
        return key;
    }
    public ArrayList<Integer> Listvalue(){
        return value;
    }
    public void put(int k,int v){
        key.add(k);
        value.add(v);
    }
    public void show(){
        for(int i = 0; i < key.size(); i++)
        {
            System.out.println("key: " + key.get(i) + "  value: " + value.get(i) );
        }
    }
    public Integer get(int k){
        return value.get(k);
    }
}
