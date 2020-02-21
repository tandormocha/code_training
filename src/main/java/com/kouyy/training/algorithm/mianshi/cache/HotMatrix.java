package com.kouyy.training.algorithm.mianshi.cache;

import java.util.concurrent.atomic.AtomicLong;

/**
 * 带热度的值
 */
public class HotMatrix  {
    private AtomicLong hot=new AtomicLong(0);
    private Object data;

    public AtomicLong getHot() {
        return hot;
    }

    public void setHot(AtomicLong hot) {
        this.hot = hot;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }


}
