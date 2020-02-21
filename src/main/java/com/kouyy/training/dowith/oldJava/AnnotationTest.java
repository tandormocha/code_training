package com.kouyy.training.dowith.oldJava;

@MyAnnotation("this is ")
public class AnnotationTest {

    public static void main(String[] args) {
        MyAnnotation annotation = AnnotationTest.class.getAnnotation(MyAnnotation.class);
        String value = annotation.value();
        String color = annotation.color();
        System.out.println(value+color);
    }


}
