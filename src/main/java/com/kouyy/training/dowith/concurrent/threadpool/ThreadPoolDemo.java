package com.kouyy.training.dowith.concurrent.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolDemo {
    public static void main(String[] args) {
        ExecutorService exe = Executors.newFixedThreadPool(3);
        for (int i=0; i<3; i++){
            int finalI = i;
            exe.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread()+""+ finalI);
                }
            });
        }
    }
}
