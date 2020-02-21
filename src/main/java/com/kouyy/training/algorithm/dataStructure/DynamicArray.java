package com.kouyy.training.algorithm.dataStructure;

/**
 * 动态数组，类似Arraylist的实现
 */
public class DynamicArray {

    private int[] data;
    private int size;

    private DynamicArray(Integer capacity){
//        data=new int[capacity];
//        size=0;
        size=capacity;
    }

    private DynamicArray(){
        this(10);
    }

    public int getCapacity(){
        return data.length;
    }

}
