package com.kouyy.training.dowith.oldJava;

public enum LogType {
    NEWS,
    VEDIO,
    SMALL_VEDIO;


    public static void main(String[] args){
        LogType news = Main2.fromTypeName("NEWS");
        String name = news.name();
        System.out.println(name);
    }
}

class Main2{
    public static LogType fromTypeName(String typeName) {
        for (LogType type : LogType.values()) {
            if (type.name().equals(typeName)) {
                return type;
            }
        }
        return null;
    }
}


