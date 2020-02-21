package com.kouyy.training.dowith.pojo;

import java.util.Objects;

public class Consumer implements Comparable{
    private String name;
    private String password;
    private String address;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Consumer(String name, String password, String address) {
        this.name = name;
        this.password = password;
        this.address = address;
    }

    public Consumer() {
    }

    public void buy(String obj){
        System.out.println("消费者消费");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if ((o instanceof Provider)){
            Provider provider=(Provider) o;
            return Objects.equals(getName(), provider.getName()) &&
                    Objects.equals(getPassword(), provider.getPassword());
        }
        Consumer consumer = (Consumer) o;
        return Objects.equals(getName(), consumer.getName()) &&
                Objects.equals(getPassword(), consumer.getPassword());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getPassword());
    }

    @Override
    public String toString() {
        return "Consumer{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", address='" + address + '\'' +
                '}';
    }


    @Override
    public int compareTo(Object o) {
        if(this ==o){
            return 0;
        }
        else if (o!=null && o instanceof Consumer) {
            Consumer u = (Consumer) o;
            if(password.length()<=u.password.length()){
                return -1;
            }else{
                return 1;
            }
        }else{
            return -1;
        }
    }
}
