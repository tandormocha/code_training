package com.kouyy.training.dowith.java8;

import com.google.common.collect.Lists;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class OptionalDemo {

    public static void main(String[] args) {
        /*Provider user=new Provider("易车");
        Optional<Provider> opt=Optional.of(user);
        String s = opt.map(u -> u.getOrders()).map(u -> u.toUpperCase()).orElse(null);*/
        final String[] atr = {""};
        List<String> list= Stream.of("你好","你说","我们").collect(Collectors.toList());
//        list=null;
        Optional<List<String>> opt = Optional.ofNullable(list);
        opt.ifPresent(l->{
            atr[0] =l.get(0);
            System.out.println(atr[0]);
                }
        );
        Lists.newCopyOnWriteArrayList();



    }

}



class User{

    private String orders;

    public User() {
    }

    public User(String orders) {
        this.orders = orders;
    }

    public String getOrders() {
        return orders;
    }

    public void setOrders(String orders) {
        this.orders = orders;
    }
}
