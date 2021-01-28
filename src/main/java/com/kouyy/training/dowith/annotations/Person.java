package com.kouyy.training.dowith.annotations;

/**
 * @author kouyouyang
 * @date 2020-03-24 17:43
 */
public class Person {

    @NotNull
    public String name;

    @Range(max=20)
    public int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
