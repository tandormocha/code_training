package com.kouyy.training.dowith.design_mode;

/**
 * 单例模式，双重校验锁
 * @author kouyy
 */
public class Singleton {

    /**
     * 私有的构造方法，不让外部直接创造对象
     */
    private Singleton() {
    }

    private static volatile Singleton instance=null;

    public static Singleton getInstance(){
        if(instance==null){
            synchronized (Singleton.class){
                if(instance==null){
                    instance=new Singleton();
                }
            }
        }
        return instance;
    }


    public static void main(String[] args) {
        for (int i = 0; i <10 ; i++) {
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    Singleton instance = Singleton.getInstance();
                    System.out.println(instance);
                }
            };
            Thread thread=new Thread(runnable);
            thread.start();
        }
    }


}
