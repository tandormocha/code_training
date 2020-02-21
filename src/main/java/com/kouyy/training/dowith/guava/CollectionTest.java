package com.kouyy.training.dowith.guava;

import com.google.common.collect.*;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CollectionTest {
    public static void main(String[] args) {
        // 普通Collection的创建
        List<String> list = Lists.newArrayList();
        Set<String> set = Sets.newHashSet();
        Map<String, String> map = Maps.newHashMap();

        // 不变Collection的创建
        ImmutableList<String> iList = ImmutableList.of("a", "b", "c");
        ImmutableSet<String> iSet = ImmutableSet.of("e1", "e2");
        ImmutableMap<String, String> iMap = ImmutableMap.of("k1", "v1", "k2", "v2");

        /*先理解什么是immutable(不可变)对象
        1.在多线程操作下，是线程安全的。
        2.所有不可变集合会比可变集合更有效的利用资源。
        3.中途不可改变
        */

        Multimap<String,Integer> multimap = ArrayListMultimap.create();
        multimap.put("aa", 1);
        multimap.put("aa", 2);
        System.out.println(multimap.get("aa")); //[1, 2]


    }
}
