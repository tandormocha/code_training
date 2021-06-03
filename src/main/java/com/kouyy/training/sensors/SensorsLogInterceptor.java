package com.kouyy.training.sensors;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.codec.Charsets;
import org.apache.flume.Event;
import org.apache.flume.interceptor.Interceptor;

import java.util.ArrayList;
import java.util.List;

public class SensorsLogInterceptor implements Interceptor {
    @Override
    public void initialize() {
    }

    @Override
    public void close() {

    }

    @Override
    public Event intercept(Event event) {
        String inputeBody = null;
        byte[] outputBoday = null;

        try {
            ArrayList<String> temp = new ArrayList<>();

            inputeBody = new String(event.getBody(), Charsets.UTF_8);
            String sensorsJsonArray = SensorsLogUtil.getSensorsJsonArray(inputeBody);

            //将json数组转为\n分割的字符串，同时进行ID-MAPPING
            JSONArray objects = JSONArray.parseArray(sensorsJsonArray);

            for (Object item : objects) {
                String map_id = "";
                JSONObject itemObj = JSON.parseObject(item.toString());

                String distinct_id = itemObj.getString("distinct_id");
                String type = itemObj.getString("type");
                String et = itemObj.getString("event");

                //ID-MAPPING
                if ("track".equals(type)) {

                } else if ("track_signup".equals(type)){

                }else if("profile_set".equals(type)){

                }else if("profile_increment".equals(type)){

                }


            }


            //1)公共字段
//            String host = bodyObj.getString("host");
//            String user_id = bodyObj.getString("user_id");
//            JSONArray data = bodyObj.getJSONArray("items");

            //2)Json数组=>every json obj
//            for (Object item : data) {
//                JSONObject itemObj = JSON.parseObject(item.toString());
//                HashMap<String, Object> fields = new HashMap<>();
//                fields.put("host",host);
//                fields.put("user_id",user_id);
//                fields.put("item_type",itemObj.getString("item_type"));
//                fields.put("active_time",itemObj.getLongValue("active_time"));
//                temp.add(new JSONObject(fields).toJSONString());
//            }
            //3)Json obj 拼接
            outputBoday = String.join("\n", temp).getBytes();
        } catch (Exception e) {
            System.out.println("输入数据:" + inputeBody);
            e.printStackTrace();
        }
        event.setBody(outputBoday);
        return event;
    }

    @Override
    public List<Event> intercept(List<Event> list) {
        return null;
    }


}
