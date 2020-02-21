package com.kouyy.training.algorithm.mianshi.cache;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author kouyy
 * 单例模式，一个简单的缓存管理器
 */
public class MyCacheManager implements CacheManager {

    private static volatile MyCacheManager instance;
    private Cache cache;
    private static Lock lock=new ReentrantLock();

    private MyCacheManager(){};

    private MyCacheManager(Cache cache){this.cache=cache;};

    public static MyCacheManager getInstance(){
        if(instance==null){
            lock.lock();
            try{
                if(instance==null){
                    instance = new MyCacheManager();
                }
            }finally {
                lock.unlock();
            }

        }
        return instance;
    }

    @Override
    public void setCache(Cache cache) {
        this.cache=cache;
    }

    @Override
    public Object get(String key) {
        return this.cache.get(key);
    }

    @Override
    public boolean delete(String key) {
        this.cache.delete(key);
        return true;
    }

    @Override
    public boolean put(String key, Object value) {
        this.cache.put(key,value);
        return true;
    }

    @Override
    public boolean clear() {
        this.cache.clear();
        return true;
    }
}
