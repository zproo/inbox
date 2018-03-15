package priv.zj.designpattern.创建型.singleton;
// http://www.runoob.com/design-pattern/design-pattern-tutorial.html

// 单例模式的几种实现
/*
 * ====================1. 懒汉式，线程不安全====================
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
 * ====================2、懒汉式，线程安全====================
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
 * ====================3、饿汉式====================
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

/*
 * ====================4、双检锁/双重校验锁（DCL，即 double-checked locking）====================
 * 是否 Lazy 初始化：是
 * 是否多线程安全：是
 * 实现难度：较复杂
 * 描述：这种方式采用双锁机制，安全且在多线程情况下能保持高性能。
 * getInstance() 的性能对应用程序很关键。
 * */
public class SingleObject {
    private volatile static SingleObject singleObject;
    private SingleObject() {}

    public static SingleObject getInstance() {
        if (singleObject == null) {
            synchronized (SingleObject.class) {
                if (singleObject == null) {
                    singleObject = new SingleObject();
                }
            }
        }
        return singleObject;
    }

    public void showMessage(){
        System.out.println("Hello World!");
    }
}
























