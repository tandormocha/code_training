package com.kouyy.training.algorithm;

import java.util.*;

/**
 * 提取出来两个数组相同的元素，两个数组都是a-z小写和大写的元素
 * @author kouyy
 */
public class ArrayTest {
    public static void main(String[] args) {
        char[] arrA=new char[]{'b','g','f','d','h','b','t','i','r','p','q','s','f'};
        char[] arrB=new char[]{'e','w','d','f','b','u','i','p','f','s','m','b','p'};
        SortAndSelect(arrA,arrB);
    }

    public static void SortAndSelect(char[] arrA,char[] arrB){
        //先排序
        Arrays.sort(arrA);
        Arrays.sort(arrB);

        Map<String,List<String>> map=new HashMap<>(16);
        //外层全循环
        for (int i = 0; i < arrA.length; i++) {
            int index=0;
            List list=new ArrayList<>();
            for (int j = index; j < arrB.length; j++) {
                if(arrA[i]<arrB[j]){
                    break;
                }

                String str=new String(new char[]{arrA[i]});

                if(arrA[i]==arrB[j]){
                    list.add(new String(new char[]{arrA[i]}));
                }
                if(list.size()>0){
                    map.put(str,list);
                }
            }
            index++;
        }

        Set<Map.Entry<String, List<String>>> entries = map.entrySet();
        for (Map.Entry<String, List<String>> entry : entries) {
            String key = entry.getKey();
            List<String> value = entry.getValue();
            System.out.println(key+"------------"+value);
        }

    }
}
