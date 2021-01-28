package com.kouyy.training.sensors;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.util.List;

public class ParseSensorsLog {
    public static void main(String[] args) throws Exception {
        List<String> logs = FileUtils.readLines(new File("/Users/kouyouyang/Desktop/orther_code/java_code/javatest/src/main/resources/nginxLog"), "ISO-8859-1");
        for (String log : logs) {
            String requestContent = SensorsLogUtil.getSensorsJsonArray(log);
            System.out.println(requestContent);
        }
    }
}
