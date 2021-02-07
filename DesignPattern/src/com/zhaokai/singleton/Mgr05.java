package com.zhaokai.singleton;

/**
 * lazy loading
 */
public class Mgr05 {

    private static volatile Mgr05 INSTANCE;      //volatile作用：线程间可见+禁止指令重排序

    private Mgr05() {}

    public static Mgr05 getInstance(){
        if(INSTANCE == null){
            //双重检查
            synchronized (Mgr05.class){
                if(INSTANCE == null){
                    try {
                        Thread.sleep(5);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    INSTANCE = new Mgr05();
                }
            }
        }
        return INSTANCE;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(()->{
                System.out.println(Mgr05.getInstance().hashCode());
            }).start();
        }
    }
}
