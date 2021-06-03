package com.kouyy.training.algorithm;

import java.math.BigInteger;

/**
 * 递归算法练习
 */
public class Digui {
    public static void main(String[] args) {
        long time1 = System.currentTimeMillis();
//        BigInteger l = fun2(100);
//        int l = fbnqsl(1);
        print(100);
        long time2 = System.currentTimeMillis();
        System.out.println("所用时间为"+(time2-time1)+"s");
    }

    //递归的所有变量都储存在栈中，如果递归太深，容易发生堆栈溢出
    //迭代的效率比递归要高，并且在空间消耗上也比较小。
    /**
     * 线性递归
     * @param n
     * @return
     */
    public static BigInteger fun1(long n){
        if(n==1){
            return BigInteger.valueOf(1);
        }else{
            BigInteger b1=new BigInteger(n+"");
            BigInteger b2=new BigInteger(fun1(n-1)+"");
            return b1.multiply(b2);
        }
    }

    //迭代有这样几个条件：
    // 1、有一个有初始值的变量。
    // 2、一个说明变量值如何更新的规则。
    // 3、一个结束条件。（循环三要素：循环变量、循环体和循环终止条件）。和递归一样,时间要求随着输入的增长呈线性的可以叫做线性迭代。
    /**
     * 迭代,定义一个计数器，每进行一次乘法，计数器都自增一次，直到计数器的值等于N截至
     * @param n
     * @return
     */
    public static BigInteger fun2(long n){
        BigInteger p= BigInteger.valueOf(1);
        for (long i = 2; i <=n ; i++) {
            p=p.multiply(BigInteger.valueOf(i));
        }
        return p;
    }


    /**
     * 迭代实现斐波那契数列   fun(n)=fun(n-1)+fun(n-2)
     */
    public static int fbnqsl(int n){
        int fbnqsl=0;
        int a=1;
        for (int i = 0; i <n; i++) {
            int temp=fbnqsl;
            fbnqsl=fbnqsl+a;
            a=temp;
        }
        return fbnqsl;
    }

    /**
     * 一个简单的递归
     * @param n
     * @return
     */
    public static int print(int n){
        if(n==0)
            return 0;
        else{
            System.out.println(n);
            return print(n-1);
        }
    }


}
