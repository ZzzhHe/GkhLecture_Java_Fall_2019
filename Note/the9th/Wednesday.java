/*
*       Java多线程开发
*
*       进程（process）与线程（thread）
*       进程：操作系统层面，计算机能够“同时”运行的各个应用程序；管理上，每个进程占用独自的内存资源；（作弊软件是深入操作系统中进行操作）
*            “同时”：分时间片  CPU运行速度过快，平时感觉不到分时的效果。
*       线程：应用程序层面，程序能够同时运行的各个任务；管理上，各个线程共用的内存资源
*
*
*       开发线程：
*       关键是将需要用线程管理的代码（不依赖主
*
*       开发方法1：
*           ①编写线程类，继承Thread
*           ②将线程代码放在线程内的run()中
*           ③实例化线程类，启动线程（调用start()函数）
*       开发方法2：
*           ①编写线程类，实现Runnable接口
*           ②将线程代码放在线程的实现类的run()函数中
*           ③实例化线程对象，实例化线程实现类，传入线程对象（通过构造函数）,启动线程（调用start()函数）
*
*       方法2比方法1更加灵活：因为一个类只能继承一个类，但是可以同时继承一个类并且实例化一个接口
*
*       线程的控制：开始-暂停-继续-停止(不要用文档中的题目）
*           暂停：suspend()
*           恢复：resume()
*           但是不安全，deprecated 存在死锁的危险，线程暂停时，并不释放线程所拥有的资源
*       如何解决？
*           建议让线程暂停，等价于让线程结束运行。因为结束运行会释放资源；
*           线程运行结束的标志：run()函数运行完毕
*           线程继续相当于新开一个程序，在原有基础上运行
*           所以线程暂停时，要注意保护现场
*
* -------------------------------------------------------------------------------------------------------------
* 线程同步安全：
* 线程同步安全，线程死锁
*
* */
package The9th;

//方法一：
class DownloadThread extends Thread {
    public boolean canRun = true;
    int i = 0;//保护现场
    public int result = 0;
    public void run() {//下载文件
        for (i = 1; i <= 10 && canRun; i++) {//可以通过外部控制canRUN来控制
            try {
                Thread.sleep(500);
            } catch (Exception ex) { }
            System.out.println(("下载进度：" + 10 * i + "%"));
        }
        result = 10*i;
    }
}

class PlayThread extends Thread {
    public void run() {//播放音乐
        for (int i = 1; i <= 10; i++) {
            try {
                Thread.sleep(1000);
            } catch (Exception ex) {
            }
            System.out.println(("音乐播放：" + 10 * i + "%"));
        }
    }
}

//方法二：
class Download implements Runnable {
    public void run() {//下载文件
        for (int i = 1; i <= 10; i++) {
            try {
                Thread.sleep(500);
            } catch (Exception ex) { }
            System.out.println(("下载进度：" + 10 * i + "%"));
        }
    }
}

class Play implements Runnable {
    public void run() {//播放音乐
        for (int i = 1; i <= 10; i++) {
            try {
                Thread.sleep(1000);
            } catch (Exception ex) { }
            System.out.println(("音乐播放：" + 10 * i + "%"));
        }
    }
}
public class Wednesday {
    public static void main(String[] args) {
        //例：一个程序，可以下载文件同时  ▶🎵🎵
        //方法1
        DownloadThread dt = new DownloadThread();
        PlayThread pt = new PlayThread();
        //启动线程
        dt.start();
        pt.start();
        //方法2
        Download d = new Download();
        Play p = new Play();
        Thread ddt = new Thread(d);
        Thread ppt = new Thread(p);
        //启动线程
        ddt.start();
        ppt.start();
    }
}

