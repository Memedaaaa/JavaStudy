import com.lg.pattern.observer.Observer;
import com.lg.pattern.observer.Subject;
import com.lg.pattern.observer.impl.ObserverWX;
import com.lg.pattern.observer.impl.SubjectImpl;
import com.lg.pattern.observer.jdkObserverImpl.ObserverJdkImpl;
import com.lg.pattern.observer.jdkObserverImpl.SubjectJdkImpl1;
import com.lg.pattern.observer.jdkObserverImpl.SubjectJdkImpl2;
import org.junit.Test;

import java.util.Observable;

/**
 * Description:
 * 使用场景
 *      关联行为场景，需要注意的是，关联行为是可拆分的，而不是“组合”关系。
 *      事件多级触发场景。
 *      跨系统的消息交换场景，如消息队列、事件总线的处理机制。
 * 优点
 *      解除耦合，让耦合的双方都依赖于抽象，从而使得各自的变换都不会影响另一边的变换。
 * 缺点
 *      在应用观察者模式时需要考虑一下开发效率和运行效率的问题
 *      开发效率：程序中包括一个被观察者、多个观察者，开发、调试等内容会比较复杂，
 *      运行效率: 而且在Java中消息的通知一般是顺序执行，那么一个观察者卡顿，会影响整体的执行效率，在这种情况下，一般会采用异步实现。
 *
 * @auther: 李果
 * @date: 14:25 2020/4/20
 */

public class ObserverTest {

    /**
     * 测试
     */
    @Test
    public void Client(){
        //新增一个被订阅者
        Subject subject = new SubjectImpl("Mark");
        //新增三个订阅者
        Observer observer1 = new ObserverWX("张三");
        Observer observer2 = new ObserverWX("李四");
        Observer observer3 = new ObserverWX("王五");
        //三个订阅者订阅被订阅者
        subject.attach(observer1);
        subject.attach(observer2);
        subject.attach(observer3);
        //被订阅者通知订阅者更新消息
        subject.notify("Mark发送消息！");
    }

    @Test
    public void JdkClient(){
        //新增一个被订阅者1
        SubjectJdkImpl1 subjectJdkImpl1 = new SubjectJdkImpl1();
        //新增一个被订阅者2
        SubjectJdkImpl2 subjectJdkImpl2 = new SubjectJdkImpl2();

        //新增一个订阅者1
        java.util.Observer observer = new ObserverJdkImpl();

        //订阅者1订阅两个被订阅者
        subjectJdkImpl1.addObserver(observer);
        subjectJdkImpl2.addObserver(observer);

        //两个被订阅者发送消息给订阅者
        subjectJdkImpl1.setMsg("subjectJdkImpl1发生消息！！！");
        subjectJdkImpl2.setMsg("subjectJdkImpl2发生消息！！！");
    }

}
