package com.zhaokai.singleton;


/**
 * 饿汉式
 * 类加载到内存后，就实例化一个单例，JVM保证线程安全
 * 简单使用，推荐使用
 * 唯一缺点：不管用到与否，类装载时就会完成实例化
 *
 */
public class Mgr01 {

    private static final Mgr01 INSTANCE = new Mgr01();

    private Mgr01() { }     //构造方法私有，别人new不了，想用只能通过 getInstance方法

    public static Mgr01 getInstance(){
        return INSTANCE;
    }

    public static void main(String[] args) {
        Mgr01 m1 = Mgr01.getInstance();
        Mgr01 m2 = Mgr01.getInstance();
        System.out.println(m1 == m2);   //true
    }
}

