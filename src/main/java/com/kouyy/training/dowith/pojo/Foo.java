package com.kouyy.training.dowith.pojo;

public class Foo {
    //private static修饰的变量只能在本类中使用，而且可以被静态方法调用
    private static String name="小米";
    private static String address="上地";

    public static void main(String[] args) {
        System.out.println(name+"---"+address);
    }
}

class Main_{
    private String name_;

    public void test(){
        Foo.main(new String[]{"ss"});
    }

    public static void main(String[] args) {
        new Main_().test();
    }

}
