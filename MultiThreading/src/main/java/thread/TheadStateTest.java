package thread;

public class TheadStateTest {

    public static void main(String[] args) {
        System.out.println("线程名："+Thread.currentThread().getName()+"线程状态："+Thread.currentThread().getState());
        TheadStateTest theadStateTest = new TheadStateTest();
        theadStateTest.testStateNew();
//        theadStateTest.testStartMethod();
    }

    /**
     * NEW
     * 处于NEW状态的线程此时尚未启动。这里的尚未启动指的是还没调用Thread实例的start()方法。
     */
    private void testStateNew() {
        Thread thread = new Thread(() -> {});
        System.out.println("线程名："+thread.getName()+"线程状态："+thread.getState());
    }

    /**
     * RUNNABLE
     *
     * 表示当前线程正在运行中。
     * 处于RUNNABLE状态的线程在Java虚拟机中运行，也有可能在等待其他系统资源（比如I/O）
     * Java线程的RUNNABLE状态其实是包括了传统操作系统线程的ready和running两个状态的。
     */



    /**
     * BLOCKED
     *
     * 阻塞状态。处于BLOCKED状态的线程正等待锁的释放以进入同步区。
     * 我们用BLOCKED状态举个生活中的例子：
     *      假如今天你下班后准备去食堂吃饭。
     *      你来到食堂仅有的一个窗口，发现前面已经有个人在窗口前了，此时你必须得等前面的人从窗口离开才行。
     *      假设你是线程t2，你前面的那个人是线程t1。此时t1占有了锁（食堂唯一的窗口），t2正在等待锁的释放，所以此时t2就处于BLOCKED状态。
     */




    /**
     * WAITING
     *
     * 等待状态。处于等待状态的线程变成RUNNABLE状态需要其他线程唤醒。
     *      Object.wait()：使当前线程处于等待状态直到另一个线程唤醒它；
     *      Thread.join()：等待线程执行完毕，底层调用的是Object实例的wait方法；
     *      LockSupport.park()：除非获得调用许可，否则禁用当前线程进行线程调度。
     * 我们延续上面的例子继续解释一下WAITING状态：
     *      你等了好几分钟现在终于轮到你了，突然你们有一个“不懂事”的经理突然来了。你看到他你就有一种不祥的预感，果然，他是来找你的。
     *      他把你拉到一旁叫你待会儿再吃饭，说他下午要去作报告，赶紧来找你了解一下项目的情况。你心里虽然有一万个不愿意但是你还是从食堂窗口走开了。
     *      此时，假设你还是线程t2，你的经理是线程t1。虽然你此时都占有锁（窗口）了，“不速之客”来了你还是得释放掉锁。此时你t2的状态就是WAITING。然后经理t1获得锁，进入RUNNABLE状态。
     *      要是经理t1不主动唤醒你t2（notify、notifyAll..），可以说你t2只能一直等待了。
     */




    /**
     * TIMED_WAITING
     *
     * 超时等待状态。线程等待一个具体的时间，时间到后会被自动唤醒。
     * 调用如下方法会使线程进入超时等待状态：
     *      Thread.sleep(long millis)：使当前线程睡眠指定时间；
     *      Object.wait(long timeout)：线程休眠指定时间，等待期间可以通过notify()/notifyAll()唤醒；
     *      Thread.join(long millis)：等待当前线程最多执行millis毫秒，如果millis为0，则会一直执行；
     *      LockSupport.parkNanos(long nanos)： 除非获得调用许可，否则禁用当前线程进行线程调度指定时间；
     *      LockSupport.parkUntil(long deadline)：同上，也是禁止线程进行调度指定时间；
     * 我们继续延续上面的例子来解释一下TIMED_WAITING状态：
     *      到了第二天中午，又到了饭点，你还是到了窗口前。
     *      突然间想起你的同事叫你等他一起，他说让你等他十分钟他改个bug。
     *      好吧，你说那你就等等吧，你就离开了窗口。很快十分钟过去了，你见他还没来，你想都等了这么久了还不来，那你还是先去吃饭好了。
     *      这时你还是线程t1，你改bug的同事是线程t2。t2让t1等待了指定时间，此时t1等待期间就属于TIMED_WATING状态。
     *      t1等待10分钟后，就自动唤醒，拥有了去争夺锁的资格。
     */


    /**
     * TERMINATED
     *
     * 终止状态。此时线程已执行完毕。
     */


    public void testStartMethod() {
        Thread thread = new Thread(() -> {});
        thread.start(); // 第一次调用
        thread.start(); // 第二次调用，會報IllegalThreadStateException，线程的生命周期是个不可循环的过程，一个线程对象结束了不能再次start
    }
}
