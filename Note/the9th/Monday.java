/*
*       Java.unit 包：Java工具包
*
*   1.Java集合框架类 Java.set/collection(collection>set)
*       Java中的集合有三类：
*           ①一维变长数组（有下标，元素可重复）
*           List：ArrayList,LinkedList,Vector
*               ArrayList:底层用数组存储
*               LinkedList：底层用链表存储
*               Vector：底层用数组存储，线程同步更安全
*           他们的功能基本相同：添，删，查，改
*           ArrayList:
*           理论上，可以在变长数组中添加任何内容，但是消耗性能。为了提高性能，便于编程，
*           Java发明了泛型。在定义的时候确定好变长数组中存储元素的类型：<类型名称>
*           若要频繁的增加删除，适合用LinkedList，因为链表方便增加删除。
*
*           ②一维变长数组（无下标，元素不可重复）
*           Set：HashSet，LinkedHashSet,TreeSet
*               HashSet:普通的set，保存元素，不带下标，不可重复，顺序打乱
*               LinkedHashSet：set,顺序按照输入的顺序存储
*               TreeSet：支持排序
*           Set的性能要比List的性能要高很多
*
*           ③二位变长数组
*           Map（映射）:
*               key不可重复，每个key对应一个value
*           key         value
*           HashMap,LinkedHashMap,TreeMap
*               HashMap:普通Map，key乱序
*               LinkedHashMap：按照key添加的顺序
*               TreeMap：可以按照key排序
*           LinkedHashMap较为常用
*           Map着重复习
*           主要作用：当一些数据需要封装，但是又不复杂，不需要用类来创建，为了简便就可以用Map
*
* */
package The9th;
import javax.swing.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Set;

public class Monday {
    public static void main(String[] args) {
      /*  ArrayList<String> cities = new ArrayList();
        for (String c : cities) {//for循环打印的简化写法
            System.out.println(c);
*/
      //有一个字符串，要求去掉里面的重复字符，再次显示。每个字符显示一次。(字符串长度为n，计算复杂度为 O(n²)
 /*       String s = "aasdefascbrtgwedas";
        LinkedHashSet<Character> set = new LinkedHashSet<Character>();
        for (int i = 0; i < s.length(); i++) {
            set.add(s.charAt(i));
        }
        for (Character c : set) {
            System.out.println(c);
        }
       */

//    练习：有一个很长的字符串，请列出该字符串中，每个字符出现的次数。（计算复杂度 O(n)
        LinkedHashMap<Character,Object> conf= new LinkedHashMap<Character, Object>();
        /*
        *   key     value
        *   字符      次数
        *   a         0
        *   b         0
        *   c         0
        * */
        String str = "asasddasfasdassgfgklxcajwdasd";
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);//chatAt(i)返回i位置的数组(String)元素
            if (!conf.containsKey(ch)) {    //如果这个字符还没有在map中建立映射
                conf.put(ch, 0);        //就把这个字符作为一个key，安放在map中
            }
         conf.put(ch, (int)conf.get(ch) + 1);//如果已经建立映射，那么直接++

        }
        Set<Character> keys = conf.keySet();    //keySet()返回一个集合，集合包含所有的key
        for (Character key : keys) {
            System.out.print(key+"  ");
            System.out.println(conf.get(key));

        }

        }
    }


