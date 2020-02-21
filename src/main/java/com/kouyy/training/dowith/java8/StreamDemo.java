package com.kouyy.training.dowith.java8;

import com.kouyy.training.dowith.pojo.Consumer;
import com.kouyy.training.dowith.pojo.Provider;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamDemo {
    public static void main(String[] args) {

        //使用一个容器装载100个数字，通过Stream并行处理的方式将容器中为单数的数字转移到容器parallelList
        List<Integer> integerList= new ArrayList<Integer>();

        for (int i = 1; i <101; i++) {
            integerList.add(i);
        }

//        List<Integer> parallelList = new CopyOnWriteArrayList<>();
        List<Integer> parallelList = new Vector<>();
//        List<Integer> parallelList = new ArrayList<>();
        integerList.stream()
                .parallel()
                .filter(i -> i % 2 == 1)
                .forEach(i->parallelList.add(i));
//                .collect(Collectors.toList());

        parallelList.forEach(i-> System.out.println(i));
    }



    public static void fun2() {
        List<Integer> list = Stream.of(1, 2, 3, 4, 5).collect(Collectors.toList());
        list.stream().forEach(System.out::println);
    }

    public static void fun5() {
        List<Integer> list = new ArrayList<>();

        List<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(2);
        list1.add(3);

        List<Integer> list2 = new ArrayList<>();
        list2.add(3);
        list2.add(4);
        list2.add(5);
        list2.add(2);

        list.addAll(list1);
        list.addAll(list2);
        //求并集并去除重复元素
        list = list.stream().distinct().collect(Collectors.toList());

        System.out.println(list);

    }

    public void test1() {
        List<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(2);
        list1.add(3);

        List<Integer> list2 = new ArrayList<>();
        list2.add(3);
        list2.add(4);
        list2.add(5);

        System.out.println("====求交集===");

        List<Integer> list = list1.stream().filter(t -> list2.contains(t)).collect(Collectors.toList());
        list.stream().forEach(System.out::println);


        System.out.println("====求差集===");
        list = list1.stream().filter(t -> !list2.contains(t)).collect(Collectors.toList());
        list.stream().forEach(System.out::println);


        System.out.println("====求并集===");

        list.addAll(list1);
        list.addAll(list2);
        list = list.stream().distinct().collect(Collectors.toList());
        list.stream().forEach(System.out::println);
    }

    public static void fun6() {

        List<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(2);
        list1.add(3);

        List<Integer> list2 = new ArrayList<>();
        list2.add(2);
        list2.add(4);
        list2.add(6);
        list2.add(5);

        List<Integer> collect = list2.stream().filter(n -> list1.contains(n)).collect(Collectors.toList());

        if (collect != null && collect.size() > 0) {
            System.out.println(collect);
        }
    }

    public static void concurrentFun() {
        List<Integer> listOfIntegers =
                new ArrayList<>();

        for (int i = 0; i <100; i++) {
            listOfIntegers.add(i);
        }

//        List<Integer> parallelStorage = new ArrayList<>() ;
        List<Integer> parallelStorage = Collections.synchronizedList(new ArrayList<>());
       /* listOfIntegers
                .parallelStream()
                // Don't do this! It uses a stateful lambda expression.
                .map(e -> {
                    parallelStorage.add(e);
                    return e;
                })
                .forEachOrdered(e -> System.out.print(e + " "));*/

        listOfIntegers
                .parallelStream()
                .filter(i->i%2==0)
                // Don't do this! It uses a stateful lambda expression.
                .forEach(i->parallelStorage.add(i));


        System.out.println();

        parallelStorage
                .stream()
                .forEachOrdered(e -> System.out.print(e + " "));

        System.out.println();
        System.out.println("Sleep 5 sec");
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        parallelStorage
                .stream()
                .forEachOrdered(e -> System.out.print(e + " "));
    }


    public static void collectFun() {
        List<Integer> listOfIntegers =
                new ArrayList<>();

        for (int i = 0; i <100; i++) {
            listOfIntegers.add(i);
        }

        List<Integer> parallelStorage = listOfIntegers
                .parallelStream()
                .filter(i -> i % 2 == 0)
                .collect(Collectors.toList());


        System.out.println();

        parallelStorage
                .stream()
                .forEachOrdered(e -> System.out.print(e + " "));

        System.out.println();
        System.out.println("Sleep 5 sec");
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        parallelStorage
                .stream()
                .forEachOrdered(e -> System.out.print(e + " "));
    }

    public static void fun8(){
        List<Provider> list1 = Stream.of(new Provider("小米", "123456"), new Provider("苹果", "abc")).collect(Collectors.toList());
        List<Consumer> list2= Stream.of(new Consumer("小米", "123456","北京"), new Consumer("苹果", "abc","上海"),
                new Consumer("涉及到","收到","熬得到")).collect(Collectors.toList());
        List<Consumer> collect = list2.stream().filter(consumer -> !list1.contains(consumer)).collect(Collectors.toList());
        collect.forEach(c-> System.out.println(c.toString()));


    }


}
