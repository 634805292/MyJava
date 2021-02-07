package com.zhaokai.singleton;


/**
 * lazy loading     懒汉式
 * 虽然达到了按需初始化的目的，但却带来了多线程访问的安全问题
 */
public class Mgr02 {

    private static Mgr02 INSTANCE;

    public Mgr02() {}

    public static Mgr02 getInstance(){
        if ((INSTANCE == null)){
/*            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {      //模仿线程被打断
                e.printStackTrace();
            }*/
            INSTANCE = new Mgr02();
        }
        return INSTANCE;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(()->{
                System.out.println(Mgr02.getInstance().hashCode());
            }).start();
        }
    }
}
