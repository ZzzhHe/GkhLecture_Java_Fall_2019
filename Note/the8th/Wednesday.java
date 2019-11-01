/*
*       Java中常用API
*       API：应用编程接口
*       Java常用API：Java内置的一些类及其功能
*   使用Java文档Specification（帮助文件）：
*   java.lang: Java语言核心包，包含了Java编程最基本的支持类 language
*   java.lang 默认被任何程序import，使用里边的类不需要导入。其他包必须导入才能使用
*
* */

/*
*   Java.lang.math类：负责数学计算
* */

//例：在一个100个元素的1维数组（默认值为0），随机将50个位置赋值为1
/*
*   业内方法：先放置后交换-->
*       在前50个位置放置1，在后50个位置放置0。在前50个位置中选取1个位置，在后50个位置中选取1个位置，两个交换数值。
*       进行这个随机选取+交换10000次，就达到了随机的放置的功能
* */

/*
*   Java.lang.String类，负责字符串处理
*   字符串：Java中，采用池机制进行管理
* */

/*
*   Java.lang.StringButter类，负责可变字符串的处理
*   可变字符串与不可变字符串：
*       String是不可变的字符串，如果改变，必须再定义一个String变量去接受改变后的结果
*       StringBuffer是可变字符串，
* */

/*
*   基本数据类型的包装类
*   Java是面向对象的语言，但是基本的数据类型，如int,short,float,double等并没有遵循面向对象。
*   Java中为他们各自设计了一个包装类
*   int-->Integer
*   double-->Double
*
*   作用：
*   1.将各种数据用对象包装，便于管理
*   2.便于和字符串之间互相转换
*       字符串转各种类型：Double.parseDouble()/Integer.parseInt()...
*       各种类型转字符串：String.valueOf()
* */

/*
*   System类
*
*
* */
package The8th;

import java.lang.StringBuffer;
public class Wednesday {

    public static void main(String[] args) {
        String s1 = "I Love Java";
        String s2 = "I Love Java";
        String s3 = "I Love" + " Java";
        String s4 = new String("I Love Java");//"new String()" is redundant
        char[] c5 = {'J', 'a', 'v', 'a'};
        String s5 = "I love " + c5;//??字符串存放按照池模式，那为什么s5和s3得到的结果不一样？
        System.out.println(s1 == s2);
        System.out.println(s1 == s3);
        System.out.println(s1 == s4);
        System.out.println(s1 == s5);
        //在比较字符串时，要用以下方法，不能用==
        //s.equals()
        System.out.println(s1.equals(s4));
        System.out.println(s1.equals(s5));

        s1.replace("Java", "Cpp");
        System.out.println(s1);

        System.out.println(s1.codePointAt(1));//index是光标位 返回的是ASCII值

        StringBuffer sb = new StringBuffer("I Love Java");
        sb.replace(7,11,"Python");//start,end代表的是光标所在的位置
        System.out.println(sb);

        System.out.println(s1.concat("java"));
    }
}

/*
*
*
* */