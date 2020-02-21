package com.kouyy.training.algorithm.mianshi;

import java.util.concurrent.Semaphore;

/**
 * Semaphore的作用主要是控住线程并发数量，常用场景是限流
 * @author kouyy
 */
public class UsualSemaphoreSample {
    public static void main(String[] args) {
        Semaphore semaphore=new Semaphore(5);
        for (int i = 0; i <10 ; i++) {
            Thread thread = new Thread(new MyThread1(semaphore));
            thread.start();
        }
    }
}


class MyThread1 implements Runnable{

    private Semaphore semaphore;

    public MyThread1(Semaphore semaphore) {
        this.semaphore = semaphore;
    }

    @Override
    public void run() {
        try {
            System.out.println(Thread.currentThread().getName()+"开始");
            semaphore.acquire();
            System.out.println(Thread.currentThread().getName()+"中间状态"+System.currentTimeMillis());
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            semaphore.release();
            System.out.println(Thread.currentThread().getName()+"状态结束");
        }
    }
}
