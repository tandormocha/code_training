package com.kouyy.training.dowith.java8;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.util.List;


/**
 * @author kouyouyang
 * @date 2020-01-11 10:16
 */
public class HashCodeDemo {
    public static void main(String[] args) {
        String event="{\n" +
                "\t\"userId\": \"111302391401\",\n" +
                "\t\"remindId\": \"001rmd\",\n" +
                "\t\"activityId\": \"001act\",\n" +
                "\t\"reDup\": {\n" +
                "\t\t\"isOn\": true,\n" +
                "    \"reDupActIds\": [\"002act\", \"003act\"],\n" +
                "\t\t\"reDays\": 3\n" +
                "\t},\n" +
                "\t\"coupon\": {\n" +
                "\t\t\"isOn\": true,\n" +
                "\t\t\"couponPackageId\": \"001cpd\"\n" +
                "\t},\n" +
                "\t\"ab\": {\n" +
                "\t\t\"key\": \"batch_v1_marketing55 \",\n" +
                "\t\t\"testGroup \": \"b\",\n" +
                "\t\t\"isOn \": true\n" +
                "\t},\n" +
                "\t\"timestamp\": 1581927937367\n" +
                "}";

        JSONObject jsonObject = JSON.parseObject(event);

        String userId = jsonObject != null ? jsonObject.getString("userId") : "";
        String remindId = jsonObject != null ? jsonObject.getString("remindId") : "";
        String activityId = jsonObject != null ? jsonObject.getString("activityId") : "";

        JSONObject reDupJson = jsonObject != null ? jsonObject.getJSONObject("reDup") : null;
        JSONObject couponJson = jsonObject != null ? jsonObject.getJSONObject("coupon") : null;
        JSONObject abJson = jsonObject != null ? jsonObject.getJSONObject("ab") : null;
//
//
//        //去重
        boolean isDedup = reDupJson != null ? reDupJson.getBooleanValue("isOn") : true;
        List<String> reDupActIds = reDupJson != null ? reDupJson.getJSONArray("reDupActIds").toJavaList(String.class) : null;
        int reDays = reDupJson != null ? reDupJson.getIntValue("reDays") : 1;
//
//        //发券
        boolean isCoupon = couponJson != null ? couponJson.getBooleanValue("isOn") : false;
        String couponPackageId = couponJson != null ? couponJson.getString("couponPackageId") : "";
//
//        //AB
        boolean isAB = abJson != null ? abJson.getBooleanValue("isOn") : false;
        String key = abJson != null ? abJson.getString("key") : "";
        String testGroup = abJson != null ? abJson.getString("testGroup") : "";

        System.out.println(userId+"--"+remindId+"--"+activityId);




    }
}
