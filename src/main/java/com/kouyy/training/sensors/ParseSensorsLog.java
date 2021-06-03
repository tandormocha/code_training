package com.kouyy.training.sensors;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.util.List;

public class ParseSensorsLog {
    public static void main(String[] args) throws Exception {
        List<String> logs = FileUtils.readLines(new File("/Users/kouyouyang/Desktop/orther_code/java_code/javatest/src/main/resources/nginxLog"), "ISO-8859-1");
//        List<String> logs = FileUtils.readLines(new File("/Users/kouyouyang/Downloads/access_log.2021022315"), "ISO-8859-1");

        for (String log : logs) {
            String jsonArray = SensorsLogUtil.getSensorsJsonArray(log);
            System.out.println(jsonArray);
//            String gzipLog = SensorsLogUtil.getSensorsGzipLog(log);
//            if (!"get_log".equals(gzipLog)) {
//                if (SlsUtil.producerLog(gzipLog)) {
//                    System.out.println("发送SLS成功");
//                }
//            }
//            System.out.println(gzipLog);
        }

        System.out.println(logs.size());
    }
}
