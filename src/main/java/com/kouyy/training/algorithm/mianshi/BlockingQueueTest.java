package com.kouyy.training.algorithm.mianshi;

import java.util.LinkedList;
import java.util.Random;
import java.util.concurrent.*;

/**
 * 實現一個功能。有两个线程A,B,  A线程每200ms就生成一个[0,100]之间的随机数，
 B线程每2S中打印出A线程所产生的增量随机数。
 * @author kouyy
 */
public class BlockingQueueTest {

    private static BlockingQueue<Integer> queue=new LinkedBlockingDeque<>(10);

    public static void main(String[] args) {
        ScheduledExecutorService executor=Executors.newScheduledThreadPool(1);
        Random r=new Random();
        executor.scheduleAtFixedRate(()->{
            int i = r.nextInt(101);
            try{
                queue.offer(i);
            }catch (Exception ex){
                ex.printStackTrace();
            }
        },0,200, TimeUnit.MILLISECONDS);

        new Thread(new Runnable() {
            @Override
            public void run() {
                while(true){
                    try {
                        Thread.sleep(2000);
                        System.out.println("开始取值");
                        LinkedList<Integer> list=new LinkedList<>();
                        queue.drainTo(list);
                        list.forEach(System.out::println);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();;

    }


}
