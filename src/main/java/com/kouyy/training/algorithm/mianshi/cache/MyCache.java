package com.kouyy.training.algorithm.mianshi.cache;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

public class MyCache implements Cache {

    private Long mixSize;
    private volatile AtomicLong currentSzie=new AtomicLong(0);
    private ConcurrentHashMap<String,HotMatrix> data=new ConcurrentHashMap<String,HotMatrix>(mixSize.intValue());

    public MyCache(Long mixSize) {
        this.mixSize = mixSize;
    }


    private synchronized void deleteLeastHotest(){
        Collection<HotMatrix> values = data.values();
        List list=(ArrayList)values;
        Collections.sort(list, new Comparator<HotMatrix>() {
            @Override
            public int compare(HotMatrix o1, HotMatrix o2) {
                return o2.getHot().intValue()-o1.getHot().intValue();
            }
        });
        list.remove(0);
    }

    @Override
    public Object get(String key) {
        HotMatrix hm = data.get(key);
        Object data = hm.getData();
        AtomicLong hot = hm.getHot();
        hot.incrementAndGet();
        return data;
    }

    @Override
    public boolean delete(String key) {
        data.remove(key);
        return true;
    }

    @Override
    public boolean put(String key, Object value) {
        HotMatrix hm=new HotMatrix();
        hm.setData(value);
        if(data.contains(key)){
            data.put(key,hm);
            return true;
        }
        if(data.size()>=mixSize.intValue()){
            deleteLeastHotest();
        }
        data.put(key,hm);
        currentSzie.incrementAndGet();
        return true;
    }

    @Override
    public boolean clear() {
        data.clear();
        return true;
    }
}
