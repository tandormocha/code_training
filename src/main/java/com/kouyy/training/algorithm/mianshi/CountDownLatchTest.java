package com.kouyy.training.algorithm.mianshi;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class CountDownLatchTest {

    public static void main(String[] args) {
        CountDownLatch latch=new CountDownLatch(10);
        for (int i = 0; i <10 ; i++) {
            Thread thread = new Thread(new MyThread(latch,i));
            thread.start();
        }

        try {
            latch.await(10,TimeUnit.SECONDS);
        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            System.out.println("执行结束");
        }
    }



}


class MyThread implements Runnable{

    private CountDownLatch latch;
    private int i;

    public MyThread(CountDownLatch latch, int i) {
        this.latch = latch;
        this.i = i;
    }

    @Override
    public void run() {
        System.out.println("我是线程"+i);
        latch.countDown();
    }
}
