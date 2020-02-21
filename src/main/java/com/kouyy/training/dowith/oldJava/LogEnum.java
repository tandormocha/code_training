package com.kouyy.training.dowith.oldJava;

public enum LogEnum {

    one("一"),
    usa("美国"),
    china("中国");

    private String remark;

    LogEnum(String remark) {
        this.remark = remark;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public static void main(String[] args) {

        LogEnum[] values = LogEnum.values();
        for (LogEnum value : values) {
            //枚举类所有实例的名字
            String name = value.name();
            System.out.println(name);
        }


    }
}
