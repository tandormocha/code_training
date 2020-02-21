package com.kouyy.training.dowith.java8;

import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class LambdaDemo {
    public static void main(String[] args) {


    }


    public void fun1(){
        //java8函数式编程
        new Thread(()->{
            for (int i = 0; i <10 ; i++) {
                System.out.println("这是"+i);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        /**
         * lambda表达式常见形式
         */
        //无参数单语句
        Runnable rundemo=()-> System.out.println("无参数单语句");
        //单参数单语句,event就是ActionListener的实现类
        ActionListener al= event-> System.out.println("单参数单语句");
        //无参数多语句
        Runnable r=()->{
            System.out.println("第一个");
            System.out.println("无参数多语句");
        };
        //多参数单语句
        BinaryOperator<Integer> add=(x,y)->x+y;
        //或者
        BinaryOperator<Integer> add2=(Integer x,Integer y)->x+y;


        Predicate<String> p=a->{
            System.out.println("真知灼见");
            return true;
        };


        Consumer<String> consumer=a-> System.out.println(a);
    }

    void fun2(){
        Arrays.asList( "a", "b", "d" ).sort( (e1, e2 ) -> e1.compareTo( e2 ) );

        Arrays.asList( "a", "b", "d" ).sort( ( e1, e2 ) -> {
            int result = e1.compareTo( e2 );
            return result;
        } );
    }

}
