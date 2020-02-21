package com.kouyy.training.algorithm;

/**
 * 实现一个功能，一个固定长度数组，生成一个新的长度相等的数组，新数组每位置数字为原数组除了该位置数之外其他数相乘。
 * @author kouyy
 */
public class Foo {
    public static void main(String[] args) {
        //源数组
        Integer[] srcArr=new Integer[5];

        for (int i = 0; i <5 ; i++) {
            srcArr[i]=i+1;
        }

        //目标数组
        Integer[] destArr=new Integer[srcArr.length];
        //算法复杂度为O（n^2）
        for (int i = 0; i < destArr.length; i++) {
            destArr[i]=1;
            for (int j = 0; j < srcArr.length; j++) {
                if(j!=i){
                    destArr[i]=destArr[i]*srcArr[j];
                }
            }
        }

        for (Integer integer : destArr) {
            System.out.println(integer);
        }
    }

}
