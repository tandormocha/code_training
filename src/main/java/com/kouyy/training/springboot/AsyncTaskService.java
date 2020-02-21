package com.kouyy.training.springboot;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class AsyncTaskService {
    @Async
    public void executeAsyncTask(Integer n){
        System.out.println("异步任务执行："+n);
    }


    @Async
    public void executeAsyncTaskPlus(Integer n){
        System.out.println("异步任务执行+1："+(n+1));
    }
}
