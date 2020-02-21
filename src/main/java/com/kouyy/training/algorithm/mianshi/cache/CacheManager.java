package com.kouyy.training.algorithm.mianshi.cache;

public interface CacheManager {
    void setCache(Cache cache);
    Object get(String key);
    boolean delete(String key);
    boolean put(String key,Object value);
    boolean clear();
}
