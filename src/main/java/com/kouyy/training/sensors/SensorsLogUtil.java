package com.kouyy.training.sensors;

import java.net.URLDecoder;

public class SensorsLogUtil {

    public static final String ENCODE_UTF_8 = "UTF-8";
    public static final String ENCODE_ISO_8859_1 = "ISO-8859-1";

    public static String getSensorsGzipLog(String log) throws Exception {
        String[] splits = log.split(" \\++_ ");
        String content = "";
        String gzipLog = "";

        if (log.contains("GET")) {
            content = "get_log";
        } else if (log.contains("POST")) {
            content = splits[6].replaceAll("\"", "");
        }

        if (content.contains("gzip=1")) {
            for (String str : content.split("&")) {
                if (str.contains("data_list=")) {
                    gzipLog = str.split("=")[1];
                }
            }
        } else {
            if (content.contains("data_list=")) {
                gzipLog = content.split("=")[1];
            } else {
                gzipLog = content;
            }
        }

        return gzipLog;
    }


    public static String getSensorsJsonArray(String log) throws Exception {
        String[] splits = log.split(" \\++_ ");
        String content = "";
        String jsonArray = "";

        if (log.contains("GET")) {
            content = splits[4].replaceAll("\"", "");
        } else if (log.contains("POST")) {
            content = splits[6].replaceAll("\"", "");
        }

        if (content.contains("gzip=1")) {
            for (String str : content.split("&")) {
                if (str.contains("data_list=")) {
                    jsonArray = parseGzipLog(str.split("=")[1]);
                }
            }
        } else {
            if (content.contains("data_list=")) {
                jsonArray = parseBase64Log(content.split("=")[1]);
            } else {
                jsonArray = parseBase64Log(content);
            }
        }

        if (!jsonArray.startsWith("[")) {
            jsonArray = "[" + jsonArray + "]";
        }
        return jsonArray;
    }


    public static String parseGzipLog(String log) throws Exception {
        byte[] bytes = log.getBytes(ENCODE_ISO_8859_1);

        String s1 = new String(bytes, ENCODE_UTF_8);

        String urldecode = URLDecoder.decode(s1, ENCODE_UTF_8);

        byte[] decode = Base64Coder.decode(urldecode);

        return GZIPUtils.uncompressToString(decode);
    }


    public static String parseBase64Log(String log) throws Exception {
        byte[] bytes = log.getBytes(ENCODE_ISO_8859_1);

        String s1 = new String(bytes, ENCODE_UTF_8);

        String urldecode = URLDecoder.decode(s1, ENCODE_UTF_8);

        byte[] decode = Base64Coder.decode(urldecode);

        return new String(decode, ENCODE_UTF_8);
    }


}
