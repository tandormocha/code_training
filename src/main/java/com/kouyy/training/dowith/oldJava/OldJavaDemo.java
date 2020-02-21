package com.kouyy.training.dowith.oldJava;

import java.util.ArrayList;
import java.util.List;

public class OldJavaDemo {
    public static void main(String[] args) {
        List<Integer> list=new ArrayList<>();
        for (int i = 0; i <100 ; i++) {
            list.add(i);
        }

        boolean flag=false;
        for (Integer integer : list) {
            if(integer.equals(10)){
                System.out.println("这个数值是"+integer);
                flag=true;
                break;
            }
        }

        if(flag){
            System.out.println("true");
        }

    }
}
