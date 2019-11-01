/*
 *       动态多态性的作用：
 *           1）函数的形参为父类类型，实参为子类对象
 *           (定义一个标准）
 *           便于软件开发的拓展性   二次开发！！
 *           2）函数返回类型是父类类型，函数中实际返回的是子类对象
 *
 *
 *
 *       需求:编写一个函数，支持字体对话框在界面中居中显示
 *              且要求支持二次开发！
 *
 *       分析：
 *           1）若按照原来的方法开发，属于静态多态性，每增加一种对话框，都需要重载一个新的函数（因为函数的参数--对话框发生了改变）
 *           2）创造一个父类，使所有父类作为一个标准接口（传递函数参数）
 * */

package The7th;

/*
class Dialog {
    public static void show() {
            System.out.println("");
        }     //不需要写函数体，只是作为一个接口
    }
    为了防止程序员没有在继承类中调用函数-->使用抽象类的概念abstract
    */

abstract class Dialog {
        public abstract void show();
}

class FontDialog extends Dialog {
    public void show() {
        System.out.println("字体对话框显示");
    }
}

class Main {
    public static void toCenter(Dialog d) {
        //要把函数定义为static 因为Main类并没有被实例化，不能够直接调用toCenter函数
        System.out.println("计算坐标");
        d.show();
    }

    public static void main(String[] args) {

        FontDialog fd = new FontDialog();
        toCenter(fd);
    //父类和子类对象之间的转换
//        Dialog d1 = new Dialog();
//        FontDialog d2 = new FontDialog();
//        Dialog d3 = new FontDialog();
//        d1 = d2;
//        d2 = d3;
//        d2 = (FontDialog)d3;必须是类型转换为其本身就代表的类
        //new Dialog() 错误
    }
}


/*
 *           总结：
 *               静态多态性：重载，增加功能，必须多写函数，虽然函数名没有增加
 *               动态多态性：只要多写一个父类，可以支持勿输功能的增加
 *
 * */

/*
*           抽象类和抽象函数几大特点：
*           1.抽象类必须用abstract修饰，抽象类不能被实例化，只能被继承
*           2.抽象类中必须有抽象函数（包括继承的），也可以包含普通函数
*           3.抽象函数必须在子类中被重写，否则报错，除非子类也是抽象函数
* */

/*
 *          final类：
 *              final类不能被继承
 *              final函数不能被重写
 *              final变量不能再被赋值
 */
