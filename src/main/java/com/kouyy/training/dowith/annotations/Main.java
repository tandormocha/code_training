package com.kouyy.training.dowith.annotations;

import java.lang.reflect.Field;

/**
 * 注解是java语言用于工具处理的标注，若参数名称为value则可以省略参数名称
 *
 * @author kouyouyang
 * @date 2020-03-24 17:03
 */
public class Main {

    public static void main(String[] args) throws Exception {
        Person p1 = new Person("jack", 25);
        Person p2 = new Person(null, 15);
        checkPerson(p1);
        checkPerson(p2);
    }

    static void checkPerson(Person p) throws Exception {
        System.out.println("check " + p + " ...");
        //反射获取p的class对象
        Class c = Person.class;
        //获取都有哪些字段
        for (Field field : c.getFields()) {
            //对每个字段都进行检查
            checkField(field, p);
        }

    }

    static void checkField(Field field, Person p) throws Exception {
        if (field.isAnnotationPresent(NotNull.class)) {
            Object o = field.get(p);
            if(o==null){
                System.out.println("Error:field "+field.getName()+" is NULL");
            }
        }

        if(field.isAnnotationPresent(Range.class)){
            Range range = field.getAnnotation(Range.class);
            Integer i = (Integer)field.get(p);
            if(i<range.min()||i>range.max()){
                System.out.println("Error: Field "+field.getName()+" is out of range");
            }
        }

    }

}
