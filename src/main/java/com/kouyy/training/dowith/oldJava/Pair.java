package com.kouyy.training.dowith.oldJava;

/**
 * @author kouyouyang
 * @date 2020-03-24 15:11
 */
public class Pair<T> {
    T s;

//    public Pair(T s, T t) {
//        this.s = s;
//        this.t = t;
//    }


    public Pair(Class<T> clazz) throws IllegalAccessException, InstantiationException {
        this.s=clazz.newInstance();
    }

    public T getName(){
        return s;
    }


}
