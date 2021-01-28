package com.kouyy.training.dowith.oldJava;

/**
 * 注解训练
 */
@MyAnnotation("this is ")
public class AnnotationTest {

    public static void main(String[] args) {
        MyAnnotation annotation = AnnotationTest.class.getAnnotation(MyAnnotation.class);
        String value = annotation.value();
        String color = annotation.color();
        System.out.println(value+color);
    }


}
