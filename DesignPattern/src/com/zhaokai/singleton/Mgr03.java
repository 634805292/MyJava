package com.zhaokai.singleton;


/**
 * lazy loading 懒汉式
 * 虽然达到了按需初始化的目的，但却带来多线程访问的安全问题————————可以通过synchronized来解决，但也带来效率下降的问题
 */
public class Mgr03 {

    private static  Mgr03 INSTANCE;

    private Mgr03() {}

    public static synchronized Mgr03 getInstance(){
        if(INSTANCE == null){
/*                        try {
                Thread.sleep(5);
            } catch (InterruptedException e) {     // 模仿线程被打断
                e.printStackTrace();
            }*/
            INSTANCE = new Mgr03();
        }

        return  INSTANCE;
    }


    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(()->{
                System.out.println(Mgr03.getInstance().hashCode());
            }).start();
        }
    }
}
