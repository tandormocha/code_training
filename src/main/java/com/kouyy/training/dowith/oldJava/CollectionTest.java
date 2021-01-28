package com.kouyy.training.dowith.oldJava;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

/**
 * @author kouyouyang
 * @date 2020-03-24 12:36
 */
public class CollectionTest {
    public static void main(String[] args) {
        Collection<String> c=new ArrayList();
        c.add("小猪");
        c.add("玩吧");

        String[] strings = c.toArray(new String[]{});
        String s = Arrays.toString(strings);
        System.out.println(s);


    }
}
