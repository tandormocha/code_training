package com.kouyy.training.sensors;

import com.aliyun.openservices.log.Client;
import com.aliyun.openservices.log.common.LogItem;
import com.aliyun.openservices.log.common.LogStore;
import com.aliyun.openservices.log.exception.LogException;
import com.aliyun.openservices.log.response.CreateLogStoreResponse;

import java.util.ArrayList;
import java.util.List;

/**
 * 阿里云Log Java SDK
 */
public class SlsProducer {
    public static void main(String[] args) throws LogException {
        //构建client
        String accessId = "";
        String accessKey = "";
        String host = "cn-hongkong.log.aliyuncs.com";
        Client client = new Client(host, accessId, accessKey);

        //创建Logstore
        String project = "bigdata-log-prod";
        String logstore = "xingchen-client-log-test";
        int ttl_in_day = 3;
        int shard_count = 10;
        LogStore store = new LogStore(logstore, ttl_in_day, shard_count);
        CreateLogStoreResponse res = client.CreateLogStore(project, store);

        /**
         * 向log service发送一个日志包，每个日志包中，有2行日志
         */
        List<LogItem> logGroup = new ArrayList<LogItem>();
        LogItem logItem = new LogItem();
        logItem.PushBack("data", "{\"recv_time\":1615970706389,\"lib\":{\"$lib\":\"Java\",\"$lib_method\":\"code\",\"$lib_version\":\"3.1.1\",\"$lib_detail\":\"com.wb.common.SensorService##profileIncrement##SensorService.java##235\"},\"map_id\":\"8BBDF822-F900-4942-A31D-10200CFAB570\",\"distinct_id\":\"93362603\",\"project\":\"glbsgtest\",\"time\":1615970702626,\"type\":\"profile_increment\",\"properties\":{\"totalPay\":\"29.99\",\"$ip\":\"10.22.0.33\",\"$is_login_id\":true}}");
        logItem.PushBack("data_md5", "cc3e1f7c8149281311ec16f939572bce");
        logGroup.add(logItem);

        try {
            client.PutLogs(project, logstore, "", logGroup, "");
        } catch (LogException e) {
            System.out.println("error code :" + e.GetErrorCode());
            System.out.println("error message :" + e.GetErrorMessage());
            System.out.println("error requestId :" + e.GetRequestId());
            throw e;
        }


    }
}
