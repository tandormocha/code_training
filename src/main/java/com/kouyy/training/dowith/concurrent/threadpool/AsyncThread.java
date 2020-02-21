package com.kouyy.training.dowith.concurrent.threadpool;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * 多线程执行，异步获取结果
 */
public class AsyncThread {
    public static void main(String[] args) {
        AsyncThread t = new AsyncThread();
        List<Future<String>> futureList = new ArrayList<Future<String>>();
        t.generate(3, futureList);
        t.doOtherThings();
        t.getResult(futureList);
    }

    /**
     *  * 生成指定数量的线程，都放入future数组
     */
    public void generate(int threadNum, List<Future<String>> fList) {
        ExecutorService service = Executors.newFixedThreadPool(threadNum);
        for (int i = 0; i < threadNum; i++) {
            //submit与execute的区别在于submit有返回值，一般对应于callable
            Future<String> f = service.submit(getJob(i));
            fList.add(f);
    }
        service.shutdown();
    }

    /**
     *  * other things
     *  
     */
    public void doOtherThings() {
        System.out.println("now is yes");
    }

    /**
     *  * 从future中获取线程结果，打印结果
     *  
     */
    public void getResult(List<Future<String>> fList) {
        ExecutorService service = Executors.newSingleThreadExecutor();
        service.execute(getCollectJob(fList));
        service.shutdown();
    }

    /**
     *  * 生成指定序号的线程对象
     *  
     */
    public Callable<String> getJob(final int i) {
        final int time = new Random().nextInt(10);
        return new Callable<String>() {
            @Override
            public String call() throws Exception {
                Thread.sleep(1000 * time);
                return "thread-" + i;
            }
        };
    }

    /**
     *  * 生成结果收集线程对象
     */
    public Runnable getCollectJob(final List<Future<String>> fList) {
        return new Runnable() {
            public void run() {
                for (Future<String> future : fList) {
                    try {
                        //如果不采用while(true)将会是阻塞式获取结果
                        while (true) {
                            if (future.isDone() && !future.isCancelled()) {
                                System.out.println("Future:" + future
                                        + ",Result:" + future.get());
                                break;
                            } else {
                                Thread.sleep(1000);
                            }
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        };
    }
}