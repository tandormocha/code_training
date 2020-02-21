package com.kouyy.training.algorithm;

import java.util.*;

/**
 * map根据value排序
 * @author kouyy
 */
public class RankMapValue {
    public static void main(String[] args) {
        Map map=new HashMap();
        map.put("动漫",2);
        map.put("A",4);
        map.put("C",5);
        map.put("F",6);
        map.put("Y",1);
        map.put("K",7);
        map.put("L",0);
        map.put("M",1);
        map.put("V",10);

        ArrayList<Map.Entry<String,Integer>> entries= sortMap(map);
        for( int i=0;i<map.keySet().size();i++){
            System. out.println(entries.get(i).getKey()+":" +entries.get(i).getValue());
        }

    }

    public static ArrayList<Map.Entry<String,Integer>> sortMap(Map map){

        List<Map.Entry<String, Integer>> entries = new ArrayList<Map.Entry<String, Integer>>(map.entrySet());

        Collections.sort(entries, new Comparator<Map.Entry<String, Integer>>() {

            @Override
            public int compare(Map.Entry<String, Integer> obj1 , Map.Entry<String, Integer> obj2) {

                return obj2.getValue() - obj1.getValue();

            }

        });

        return (ArrayList<Map.Entry<String, Integer>>) entries;

    }
    }
