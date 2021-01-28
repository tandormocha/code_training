package com.kouyy.training.dowith.oldJava;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @author kouyouyang
 * @date 2020-03-24 15:11
 */
public class GenericDemo {
    public static void main(String[] args) throws InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {

        Class<String> clazz=String.class;
        Constructor<String> constructor = clazz.getConstructor(String.class);
        String s = constructor.newInstance("1876298237");


        System.out.println(s);


    }
}
