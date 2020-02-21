package com.kouyy.training.algorithm.mianshi;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 线程池测试类
 */
public class ThreadPoolTest {
    public static void main(String[] args) {
        //创建一个可重用固定数量的线程池
        ThreadPoolExecutor pool = new ThreadPoolExecutor(3, 6,
                0L, TimeUnit.MILLISECONDS,
                new ArrayBlockingQueue<Runnable>(10));
        pool.execute(new NewThread());
        pool.execute(new NewThread());
        pool.execute(new NewThread());
        pool.execute(new NewThread());
        pool.execute(new NewThread());
        pool.execute(new NewThread());
        pool.execute(new NewThread());
        pool.execute(new NewThread());
        pool.execute(new NewThread());
        pool.execute(new NewThread());
        pool.execute(new NewThread());
        pool.execute(new NewThread());
        pool.execute(new NewThread());
        pool.execute(new NewThread());
        pool.execute(new NewThread());
        pool.execute(new NewThread());
        pool.execute(new NewThread());
        pool.execute(new NewThread());
        pool.execute(new NewThread());
        pool.execute(new NewThread());

    }
}
class NewThread extends Thread {
    @Override
    public void run(){
        System.out.println("线程"+Thread.currentThread().getName()+"正在运行");
    }
}
