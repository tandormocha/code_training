package com.kouyy.training.algorithm.dataStructure;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ComparertorDemo implements Comparable {

    private int height;
    private int lang;

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getLang() {
        return lang;
    }

    public void setLang(int lang) {
        this.lang = lang;
    }

    public ComparertorDemo(int height) {
        this.height = height;
    }

    /**
     * 按照高度升序
     * @param o  O表示被比较对象，this表示新元素
     * @return  返回值为负，按倒序排
     */
    @Override
    public int compareTo(Object o) {
        if(o instanceof ComparertorDemo){
            ComparertorDemo temp=(ComparertorDemo)o;
            return this.getHeight()-temp.getHeight();
        }
        throw new ClassCastException("不能转换为ComparertorDemo类型的对象...");
    }

    @Override
    public String toString() {
        return "ComparertorDemo{" +
                "height=" + height +
                '}';
    }

    public static void main(String[] args) {
        ComparertorDemo c1=new ComparertorDemo(6);
        ComparertorDemo c2=new ComparertorDemo(7);
        ComparertorDemo c3=new ComparertorDemo(8);
        ComparertorDemo c4=new ComparertorDemo(4);
        List<ComparertorDemo> list = Arrays.asList(c1, c2, c3, c4);
        Collections.sort(list);
        for (ComparertorDemo c : list) {
            System.out.println(c.toString());
        }
    }
}
