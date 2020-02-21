package com.kouyy.training.dowith.pojo;

import java.util.Objects;

public class Provider {
    private String name;
    private String password;

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

    public Provider(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public Provider() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if ((o instanceof Consumer)){
            Consumer consumer = (Consumer) o;
            return Objects.equals(getName(), consumer.getName()) &&
                    Objects.equals(getPassword(), consumer.getPassword());
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getPassword());
    }

    @Override
    public String toString() {
        return "Provider{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

}
