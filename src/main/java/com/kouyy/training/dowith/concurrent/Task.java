package com.kouyy.training.dowith.concurrent;

import java.util.concurrent.Callable;

public  class Task implements Callable{

   private int i;

    public Task() {
    }

    public Task(int i) {
        this.i = i;
    }

    @Override
    public Object call() throws Exception {
        System.out.println("这是"+i);
        return null;
    }
}
