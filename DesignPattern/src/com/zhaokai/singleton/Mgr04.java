package com.zhaokai.singleton;

/**
 * lazy loading
 * 对于加锁后效率降低的问题————————减小锁的范围。。。。 扯淡一样
 */
public class Mgr04 {

    private static  volatile Mgr04 INSTANCE;

    private Mgr04() { }

    public static Mgr04 getInstance(){
        if(INSTANCE == null){
            //试图通过减小同步代码块的方式提高效率，但是就锁不住了。。。
            synchronized (Mgr04.class){
/*                try {
                    Thread.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }*/
                INSTANCE = new Mgr04();
            }
        }
        return INSTANCE;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(()->{
                System.out.println(Mgr04.getInstance().hashCode());
            }).start();
        }
    }
}
