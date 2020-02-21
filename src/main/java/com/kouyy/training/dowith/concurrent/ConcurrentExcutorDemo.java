package com.kouyy.training.dowith.concurrent;

import java.util.ArrayList;
import java.util.List;

public class ConcurrentExcutorDemo {

    public static void main(String[] args){
        List<Integer> list=new ArrayList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(8);
        list.add(9);
        list.add(11);
        list.add(12);
        list.add(13);
        list.add(14);
        list.add(15);
        list.add(16);
        list.add(17);
        list.add(18);
        list.add(19);
        list.add(20);
        list.add(21);
        list.add(22);
        list.add(23);
        list.add(24);
        list.add(26);
        list.add(14);
        list.add(58);
        list.add(58);
        list.add(58);
        list.add(58);
        list.add(58);
        list.add(58);
        list.add(58);
        list.add(58);
        list.add(58);
        list.add(58);
        list.add(58);
        list.add(58);
        list.add(58);
        list.add(58);
        list.add(58);
        list.add(58);
        list.add(58);
        list.add(58);
        list.add(58);
        list.add(58);
        list.add(58);
        list.add(58);
        list.add(58);
        list.add(58);
        list.add(58);
        list.add(58);
        list.add(58);
        list.add(58);
        list.add(58);
        list.add(58);
        list.add(58);
        list.add(58);
        list.add(58);
        list.add(58);
        list.add(58);
        list.add(58);
        list.add(58);
        list.add(58);
        list.add(58);
        list.add(58);
        list.add(58);
        list.add(58);
        list.add(58);
        list.add(58);
        list.add(58);
        list.add(58);
        list.add(58);
        list.add(58);
        list.add(58);
        list.add(58);
        list.add(58);
        list.add(58);
        list.add(58);
        list.add(58);
        list.add(58);
        list.add(58);
        list.add(58);
        list.add(58);
        list.add(58);
        list.add(58);
        list.add(58);
        list.add(58);
        list.add(58);
        list.add(58);
        list.add(58);
        list.add(58);
        list.add(58);
        list.add(58);
        list.add(58);
        list.add(58);
        list.add(58);
        long time1 = System.currentTimeMillis();

        Task[] tasks = new Task[list.size()];
        for(int i=0; i<list.size(); i++)
        {
            tasks[i] = new Task(list.get(i));
        }
        ConcurrentExcutor concurrentExcutor = new ConcurrentExcutor<>(tasks, 10);
        concurrentExcutor.excute();
        long time2 = System.currentTimeMillis();
        System.out.println("总耗时"+(time2-time1)/1000+"s");
    }
}
