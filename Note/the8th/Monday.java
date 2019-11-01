/*
*   Java的异常处理(Exception) 例外
*       常见异常：
*           1.编译不通过：语法有错
*           2.运行时不正常：异常
*
*   一个程序出现异常，往往是预想不到的
*
*   程序异常的危害：
*       1.异常退出，错误提示
*       2.程序在出现异常之后，后边的代码将不会执行
*
*   如何解决？
*       1.遇见所有可能的异常，在编程时进行约束（但是很难做到）
*       2.一网打尽-->try-catch
*                   try块来管理可能出现异常的代码
*                   catch块来处理某种异常
*       类比  抛绣球
*       try{
*       //把可能存在异常的代码放置在try中
*       }catch(Exception e){//e是对象名，Exception为类名（e可以拆开）
*       //若出现异常，则执行catch中的内容
*       }
*       利用try-catch来实现“一网打尽”
*
*       一个try后可以跟多个catch，分别处理多个异常
*
*       try-catch后面可以接一个finally块，包含了不管是否出现异常，都需要执行的代码，保证程序安全
*       （虽然写在最后也可以，但是推荐使用finally，便于维护)
*       finally块中的内容，即使是跳出，或者程序关闭，只要是进入了try就一定会执行finally中内容
*
*       try-catch-finally --> 异常捕获和处理
* -------------------------------------------------------------------------------------------------------
*
*       throw,throws --> 异常的产生和抛出
*       throw：在函数中抛出一个异常对象(动作）
*       throws:标注该函数可能会抛出某种异常（一般现在时）
*       一般调用throw的函数，调用时一定要用try-catch来处理
*       OR 再次抛出(在定义函数时，在后边标记throws+ 异常名
*           ①在（调用有异常throw函数）的函数定义的时候在后边throws 异常名
*       OR  ②在调用有异常throw函数的时候，用
*                               try{
*                                   function();
*                                  }catch(异常类 对象名){
*                                       throw 对象名;(再次抛出）
*                                                    }
*
*       连续调用循环为什么在后边才处理，而不是一开始就处理？
*       1.重复代码
*           可能第一个部分有错误代码段A,B,C，第二个有B,C,D，第三个有C,D,E，则每一次都有重复的，
* 且每一次都有新的错误代码，所以可能会很多重复的代码，不如在最后一次（或倒数第二次）
*       2.不具备条件
*           数据库，一般是在真正调用数据库之前进行排错
*
*
* */


package The8th;
import javax.swing.JOptionPane;
public class Monday {
    static int setAge(int age) throws Exception {//throws Exception代表该函数可能会抛出Exception(通用异常)_
        if (age < 0 || age > 100) {
            Exception e = new Exception("年龄错误");
            throw e;
        }
        return age;
    }
    public static void main(String[] args) throws Exception {//①在调用函数中也要设置可能会抛出Exception
//        try {
//            setAge(500);
//        }catch (Exception ex){
//            ex.getMessage();
//            throw ex;
//            抛给调用main函数的函数（此处为系统底层）
//            Exception in thread "main" java.lang.Exception: 年龄错误
//        }

/*
*         //异常处理有时候可能完成和异常不想管的功能
// 输入一个数，显示这个数的平方，要求当输错时，输入框重新显示，直到输入正确为止
        int n;
        while(true) {
            try {
                String str = JOptionPane.showInputDialog("请输入一个数字");
                n = Integer.parseInt(str);//把String转换为Int

            } catch (Exception e) { }
        }
            int t = n * n;
            System.out.println("平方是:" + t);
*/
/*
        //      打开数据库连接->访问数据库->调用数据库内容进行计算->关闭数据库连接
        for (int a = 1; a < 10; a++) {
            try {
                System.out.println("数据库连接打开");
                break;
            } catch (Exception e) {
                System.out.println("异常");
            } finally {
                System.out.println("关闭数据库连接");
            }
        }
*/
/*
        //   例子：编写程序，输入一个数字，显示该数字的平方
        try {
            String str = JOptionPane.showInputDialog("请输入一个数字");
            int n = Integer.parseInt(str);//把String转换为Int
            int t = n * n;
            System.out.println("平方是:" + t);
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());//For input string: "asd"
            System.out.println("数字格式异常");
        } catch (NullPointerException e) {
            System.out.println("未分配内存异常");
        } catch (ArithmeticException e) {
            System.out.println("数字计算异常");
        } catch (Exception e ) {
            System.out.println("父类Exception");
        }

//        若输入非数字：Exception in thread "main" java.lang.NumberFormatException: For input string: "a"
*/
/*
        int a = 5;
        int b = 0;
        int c = a/b;//java.lang.ArithmeticException: / by zero
 */
    }
}

/*
*   Java中异常有很多
*   但不需要记忆，只需了解
*
* */