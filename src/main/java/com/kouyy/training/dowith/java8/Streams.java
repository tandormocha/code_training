package com.kouyy.training.dowith.java8;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Streams {
    private enum Status {
        OPEN, CLOSED
    };

    private static final class Task {
        private final Status status;
        private final Integer points;//分数

        Task( final Status status, final Integer points ) {
            this.status = status;
            this.points = points;
        }

        public Integer getPoints() {
            return points;
        }

        public Status getStatus() {
            return status;
        }

        @Override
        public String toString() {
            return String.format( "[%s, %d]", status, points );
        }
    }


    public static void main(String[] args) {
        fun2();
    }

    public static void fun1(){
        Collection< Task > tasks = Arrays.asList(
                new Task( Status.OPEN, 5 ),
                new Task( Status.OPEN, 13 ),
                new Task( Status.CLOSED, 8 )
        );
        //问题：所有状态为OPEN的任务一共有多少分数
        int sum = tasks.stream().filter(task -> task.getStatus().equals(Status.OPEN)).mapToInt(Task::getPoints).sum();

        //另一种方式并行计算所有分数和
        Optional<Integer> opt = tasks.stream().parallel().map(Task::getPoints).reduce(Integer::sum);

        Integer i = opt.orElse(0);

        //按照某种准则来对集合中的元素进行分组。Stream也可以处理这样的需求
        Map<Status, List<Task>> collect = tasks.parallelStream().collect(Collectors.groupingBy(Task::getStatus));

        //map新的遍历方式
        Set<Map.Entry<Status, List<Task>>> entries = collect.entrySet();
        entries.forEach(map-> System.out.println(map.getKey()+"====="+map.getValue()));

        //并行计算所有分数和
        Integer totalPoints = tasks.stream().parallel().map(Task::getPoints).reduce(0, Integer::sum);

        //整个集合中每个task分数（或权重）的平均值
        // Calculate the weight of each tasks (as percent of total points)
        final Collection< String > result = tasks
                .stream()                                        // Stream< String >
                .mapToInt( Task::getPoints )                     // IntStream
                .asLongStream()                                  // LongStream
                .mapToDouble( points -> points / totalPoints )   // DoubleStream
                .boxed()                                         // Stream< Double >
                .mapToLong( weigth -> ( long )( weigth * 100 ) ) // LongStream
                .mapToObj( percentage -> percentage + "%" )      // Stream< String>
                .collect( Collectors.toList() );                 // List< String >

        System.out.println(result);
    }


    public static void fun2(){
        //Stream API不仅仅处理Java集合框架。从文本文件中逐行读取数据这样典型的I/O操作也很适合用Stream API来处理。
        try {
            String filename="E:\\tag.dic";
            final Path path = new File( filename ).toPath();
            Stream< String > lines = Files.lines( path, StandardCharsets.UTF_8 );
            lines.onClose( () -> System.out.println("Done!") ).forEach( System.out::println );
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
