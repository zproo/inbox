package priv.zj.designpattern.创建型.singleton;

/*public class SingleObject {
    // 创建singleobject的一个对象
    // 无论一个类实例化多少对象，它的静态变量只有一份拷贝。静态变量也被成为类变量。局部变量不能被声明为static变量。
    private static SingleObject instance = new SingleObject();

    // 让构造函数为 private， 这样该类就不会被实例化
    private SingleObject() {}

    // 获取唯一可用的对象
    public static SingleObject getInstance() {
        return instance;
    }

    public void showMessage() {
        System.out.println("hello world");
    }
}*/


// 单例模式的几种实现
/*
 * 1. 懒汉式，线程不安全
 * 这种方式是最基本的实现方式，这种实现最大的问题就是不支持多线程。
 * 因为没有加锁 synchronized，所以严格意义上它并不算单例模式。
 * */
/*public class SingleObject {
    private static SingleObject instance;
    private SingleObject() {}

    public static SingleObject getInstance() {
        if (instance == null) {
            instance = new SingleObject();
        }
        return instance;
    }
}*/

/*
 * 2、懒汉式，线程安全
 *这种方式具备很好的 lazy loading，能够在多线程中很好的工作，
 * 但是，效率很低，99% 情况下不需要同步。
 * */
/*
public class SingleObject {
    private static SingleObject instance;
    private SingleObject(){}
    public static synchronized SingleObject getInstance() {
        if (instance == null) {
            instance = new SingleObject();
        }
        return instance;
    }
} */

/*
 * 3、饿汉式
 * 它基于 classloder 机制避免了多线程的同步问题，
 * 不过，instance 在类装载时就实例化,这时候初始化 instance
 * 显然没有达到 lazy loading 的效果。
 * */
/*
public class SingleObject {
    private static SingleObject instance = new SingleObject();
    private SingleObject(){}
    public static synchronized SingleObject getInstance() {
        return instance;
    }
}*/

public class SingleObject {
    private volatile static SingleObject singleObject;

    private SingleObject() {

    }

    public static SingleObject getSingleObject() {
        if (singleObject == null) {
            synchronized (SingleObject.class) {
                if (singleObject == null) {
                    singleObject = new SingleObject();
                }
            }
        }
        return singleObject;
    }

}
























