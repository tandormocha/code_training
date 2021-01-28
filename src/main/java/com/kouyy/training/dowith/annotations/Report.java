package com.kouyy.training.dowith.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author kouyouyang
 * @date 2020-03-24 17:07
 */
@Target({
        ElementType.METHOD,
        ElementType.TYPE
})
@Retention(RetentionPolicy.RUNTIME)//元注解表示注解的生命周期，默认为CLASS，通常自定义的注解都是RUNTIME
public @interface Report {

    /**
     * 元注解：jdk里面可以用来修饰其他注解的注解
     * 比如：@Target定义Annotation可以被应用于源码的哪些位置
     * 类或者接口：ElementType.TYPE
     * 字段：ElementType.FIELD
     * 方法：ElementType.METHOD
     * 构造方法：ElementType.CONSTRUCTOR
     * 方法参数：ElementType.PARAMETER
     */


    /**
     * 注解类型
     * SOURCE类型注解在编译期就被丢掉了
     * CLASS类型注解仅保存在class文件中
     * RUNTIME类型注解在运行期可以被读取（常用）
     */

    int type() default 0;

    String level() default "info";

    String value() default "";

}
