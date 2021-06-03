package com.kouyy.training.sensors;

import com.aliyun.openservices.log.Client;
import com.aliyun.openservices.log.common.LogItem;
import com.aliyun.openservices.log.exception.LogException;

import java.util.ArrayList;
import java.util.List;

public class SlsUtil {

    //SLS账户信息
    static final String accessId = "";
    static final String accessKey = "";
    static final String host = "cn-hongkong.log.aliyuncs.com";
    static Client client = new Client(host, accessId, accessKey);

    //创建Logstore
    static final String project = "bigdata-log-prod";
    static final String logstore = "xingchen-original-log";

    public static boolean producerLog(String log) throws LogException {

        /**
         * 向log service发送一个日志包，每个日志包中，有2行日志
         */
        List<LogItem> logGroup = new ArrayList<LogItem>();
        LogItem logItem = new LogItem();
        logItem.PushBack("data_list", log);
        logGroup.add(logItem);

        try {
            client.PutLogs(project, logstore, "xingchen_original_log", logGroup, "test");
        } catch (LogException e) {
            System.out.println("error code :" + e.GetErrorCode());
            System.out.println("error message :" + e.GetErrorMessage());
            System.out.println("error requestId :" + e.GetRequestId());
            throw e;
        }

        return false;
    }
}
