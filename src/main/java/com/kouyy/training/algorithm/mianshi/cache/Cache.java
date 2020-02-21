package com.kouyy.training.algorithm.mianshi.cache;

/**
 * 缓存接口
 */
public interface Cache{
    Object get(String key);
    boolean delete(String key);
    boolean put(String key,Object value);
    boolean clear();
}