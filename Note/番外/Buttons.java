/*
 *   印度工程师
 *   界面类：按钮类
 *   点击按钮，窗口背景变红
 *
 *   注意：按钮的功能是在窗口中实现的，因为按钮不只实现一个功能，
 *           如果功能在按钮中实现，那么就需要在按钮中写许许多多的函数去调用
 *           而功能如果写在窗口中实现，就可以实现一个按钮多个功能，在不同的窗口中实现多个功能
 *           且新写功能就可以只在Window中写，而不改变Button
 * */
//事件监听模型     高内聚，低耦合-->通用性
/*
 * 任务1：点击按钮，窗口背景变红
 * 任务2：添加功能，实现点击按钮，修改窗口大小
 * 任务3：添加功能，实现点击按钮，另一个窗口颜色变红
 * 任务4：添加功能，实现点击按钮，窗口颜色变红，之后再点击窗口，修改另一个窗口的大小
 *
 */

package Button;

class Button {
    IButton ib;
    public void buding(IButton ib) {
        this.ib = ib;
    }
    public void click() {
        this.ib.action();
    }
}

interface IButton {
    void action();
}
//第一个窗口功能
class Window implements IButton{
    public void action() {
        this.changeColor();
    }
    public void changeColor() {
        System.out.println("显示红色");
    }
}
//第二个窗口功能
class WindowV1 implements IButton {
    public void action() {
        this.changeSize();
    }
    public void changeSize() {
        System.out.println("尺寸缩小");
    }
}

public class Buttons {
    public static void main(String[] args) {
        Window w = new Window();
        WindowV1 w1 = new WindowV1();
        Button b = new Button();
        b.buding(w);
        b.click();
        b.buding(w1);
        b.click();
    }
}
/*
 *   任务1：实现窗口变红的功能需要在窗口功能实现。
 *           因为之后的功能有很多，如果都在Button类中实现，那么Button类中的函数会有很多个。
 *           而如果把Button函数功能放在Window中
 *           就可以实现分门别类的区分，不同的窗口实现自己不同的功能
 * */
/*
 *   任务2：想要用按钮实现多个功能
 *           在Window窗口中利用一个action函数（名字是抽象的），用Button中的click调用，
 *           这样Button就不需要知道具体的功能是什么（可以是修改颜色，也可以是修改窗口大小)
 *           而具体的实现都在窗口中进行
 *
 *           从而实现，Button与具体的功能不绑定，通过改变Window中的功能来改变实现的功能
 * */
/*、
 *   任务3：想要用按钮控制多个窗口
 *           如果在之后再添加几个窗口，用这一个按钮控制多个窗口去显示红色，
 *           那么就需要利用接口(interface)IButton去实现具体
 *           创建一个接口，具有统一规则action()
 *           把IButton传入Button中，在Button中调用action()
 *           (利用构造函数传输接口)
 *
 *           从而实现，在只要是符合IButton接口的Window都可以传入Button中，让其调用它的功能
 * */
/*
 *   任务4：想要一个按钮先后调用不同窗口的不同功能
 *           想要先后调用不同的窗口的功能，就不能再用构造函数的方法（因为构造函数只能调用一次)
 *           那就再创建一个函数，用它来接收接口，并且调用action
 *
 *           从而实现，当想要更换Button实现的功能时，只需修改穿入函数的参数即可
 * */