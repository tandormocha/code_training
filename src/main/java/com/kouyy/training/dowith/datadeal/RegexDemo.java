package com.kouyy.training.dowith.datadeal;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * java正则表达式测试
 * @author kouyy
 */
public class RegexDemo {

    public static void main(String[] args) {
        String text="a/a";

        String [] tags=text.split("[\\,， \\\\]");//切割字符串，将,，和空字符串还有\隔开的字符分割

        boolean flag = text.matches(".*[\\,， ]+.*");//包含, ，和空字符串的正则表达式

        boolean matches = text.matches(".*[\\(\\) （\\） ]+.*");//包含()  （） 和空格的正则

        boolean matchesa = text.matches(".*[\\,，(\\) （\\） ]+.*");//包含,，()  （） 和空格的正则


        boolean f = text.matches("^[0-9]*$");//判断字符串是否是整数，不能包含小数点

        //过滤特殊字符
        String regEx=".*[\\~!#$%^&*()+=|{}':;',.<>/?~！#￥%……&*（）——+|{}【】\\[\\].‘；：”“’。，、？]+.*";

        String r2="[A-Z a-z 0-9_]";  //一个字母 一个数字  下划线  空格的正则

        String r3="[^A-Z a-z 0-9_]";   //匹配所有除了 大小写字母、数字和空格、下划线之外的所有字符"

        boolean matches1 = text.matches(regEx);

        System.out.println(matches1);
    }

    public void fun() throws IOException {
        File file=new File("E:\\tag.dic");
        List<String> strings = FileUtils.readLines(file, "utf-8");
        for (String string : strings) {
            //仅数字开头与结尾，数字与数字之间只能是逗号或者-号，并且，与-不能同时存在 正则
            if(string.matches("^(\\d[-])+\\d$")){
                System.out.println(string);
            }
        }
    }


}
