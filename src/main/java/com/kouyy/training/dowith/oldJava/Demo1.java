package com.kouyy.training.dowith.oldJava;

import org.apache.commons.io.FileUtils;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Demo1 {
    public static void main(String[] args) throws IOException {

        File file1=new File("E:\\sqlserver.txt");
        File file2=new File("E:\\mysql.txt");
        if(!file1.exists()){
            file1.createNewFile();
        }
        if(!file2.exists()){
            file2.createNewFile();
        }

        List<String> list1 = FileUtils.readLines(file1, "utf-8");
        List<String> list2 = FileUtils.readLines(file2, "utf-8");

        List<String> collect = list1.parallelStream().filter(str -> !list2.contains(str)).collect(Collectors.toList());
        for (String s : collect) {
            System.out.println(s);
        }
    }

    @Test
    public  void test(){
        List<String> list = Arrays.asList("1", "2", "3", "4", "5");
        ArrayList<String> objects = new ArrayList<>(list);
        objects.subList(3,objects.size()).clear();
        for (String s : objects) {
            System.out.println(s);
        }
    }

    @Test
    public  void test1(){
        Integer i = Integer.valueOf("14528525829852");
        System.out.println(i);
    }




}
