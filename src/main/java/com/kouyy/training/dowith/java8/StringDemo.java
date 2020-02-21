package com.kouyy.training.dowith.java8;

/**
 * @author kouyouyang
 * @date 2020-01-10 18:24
 */
public class StringDemo {
    public static void main(String[] args) {

        String str1 = "abc";
//        String str2 = new String("abc");
        String str2 = "abc";
        String str3 = str2.intern();

        assertSame(str1 == str2);
        assertSame(str2 == str3);
        assertSame(str1 == str3);

        String id="1";
        int i = id.hashCode();
        System.out.println(i);
    }

    public static void assertSame(boolean bl){
        System.out.println(bl);
    }
}
