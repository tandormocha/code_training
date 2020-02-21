package com.kouyy.training.dowith;

import org.junit.Test;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class Main {
    public static void main(String[] args) throws Exception {
       //泛型用于编译期，运行期间泛型擦除
        ArrayList list=new ArrayList();
        list.add("tom");
        list.add("tony");
        list.add("jack");
        Class<? extends ArrayList> aClass = list.getClass();
        Method method = aClass.getMethod("add",Object.class);
        method.invoke(list, 100);
        for (Object o : list) {
            System.out.println(o);
        }
    }

    @Test
    //hash算法探究
    public void hashTest(){
        HashMap map=new HashMap(16);
        map.put("id","123");

    }

    @Test
    public void privateStaticTest(){
        Random random = new Random(100);
        int i = random.nextInt();
        System.out.println(i);
    }




}
