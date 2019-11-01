package NoiseRemover;/*
* 模式设计：适配器模型
* （特指在处理第三方降噪时使用的方法）
*
* 1.有一个图像处理类，可以显示图像
* 2.题1的软件已经交付，需要：在显示图像之前，将图像去噪
* 3.实现去噪模块的通用化设计
* 4.去噪模块由第三方开发
*
* */


//图像处理类，第一批交付，已经不能修改
class ImageOpe {
    public void show() {
        System.out.println("显示图像");
    }
}

interface INoiseRemover {
    void removeNoise();
}

/*
*   为完成题2任务，进行二次开发
*   难点：
*       在显示图像之前，实现去噪-->不能在主函数里再调用去噪对象的去噪函数，
*                               因为之后还有可能有各种各样的功能，
*                               不可能都在主函数里一个一写出来
* */
class NoiseRemover implements INoiseRemover {

    public void removeNoise() {
        System.out.println("去噪");
    }
}
/*
 *   题2的解决方案：
 *   再创建一个V1类，作为ImageOpe的新版本（基层ImageOpe类）
 *  在这个类中定义去噪对象调用去噪函数，并用super.显示图像函数
 *
 *  class NoiseRemover.ImageOpeV1 extends NoiseRemover.ImageOpe {
 *      public void show(){
 *          NoiseRemover.NoiseRemover nr = new NoiseRemover.NoiseRemover();
 *          nr.removeNoise();
 *          super.show();
 *      }
 * }
 * */
/*---------------------------------------------------------------------------------------------------*/
/*
* 背景：技术更新，导致去噪的算法也变得更加强，所以需要更换新的去噪算法
* 即，需要第三次开发（题目：3）
*
*   难点：
*       在二次开发时，创建了一个ImageOpeV1类，作为新版本，但是这个类是固定的，
*      只能调用第二次更新的去噪算法，但是如果之后去噪算法再有更新，就不能够调用新的，
*      必须重新建立新版本的ImageOpe
* */
class NewNoiseRemover implements INoiseRemover{

    public void removeNoise() {
        System.out.println("新方法去噪");
    }
}
/*
*   题3的解决方案：
*    创建一个接口(interface)NoiseRemover.INoiseRemover,规定所有的去噪算法都要按照这个接口指定的规则来写
*    同时在ImageOpeV1中也要设计函数，能够传入这个接口
*    提示：可以利用构造函数去传入这个接口（先在类中定义一个接口变量，之后传入构造函数传入类）
*                                    这个类是接口的继承类的一种，动态多态性的体现
* */
/*----------------------------------------------------------------------------------------------*/

/*
* 背景：新的去噪方法被开发出来，乃最先进技术，但是并不能获得源代码，只可以下载到类包
* 题4：第三方开发去噪的使用
*
*   难点：
*       从网上下载的类包不能够知道更不能改变代码的内容，
*       并且代码的命名等各种规则都不一定使用之前接口所制定的规则
*
* */

class QuZao {
    //这里面的代码都是不可知，也不能修改的
    public void quzao(){
        System.out.println("最先进方法去噪");
    }
}

/*
*   题4的解决方案：（适配器模型）
*       新建一个类，作为第三方类的子类，并且作为INoiseRemover的实力化（带帽子）
*       联想220V和110V的电源适配器
*       在新建类中，定义一个符合接口的函数（继承），并用super调用第三方算法
* */
class MyQuZao extends QuZao implements INoiseRemover {
    public void removeNoise() {
        super.quzao();
    }
}


class ImageOpeV1 extends ImageOpe {

    INoiseRemover in;

    public ImageOpeV1(INoiseRemover in) {
        this.in = in;
    }
//  以上步骤利用接口来操作，就可以实现对于任意符合该接口的类都可使用
    public void show() {
//        NoiseRemover.NoiseRemover nr = new NoiseRemover.NoiseRemover();//在三次开发过程中，此类就无法调用NewNR中的方法
//        nr.removeNoise();
        in.removeNoise();
        super.show();
    }
}

public class NoiseRemove {
    public static void main(String[] args) {
        ImageOpe io = new ImageOpeV1(new MyQuZao());
        io.show();
    }
}

