package com.kouyy.training.algorithm.dataStructure;

import java.io.Serializable;
import java.util.*;

/**
 * 手动实现HashMap
 * 重点方法在put get remove containsKey
 *
 * @author kouyy
 */
public class MyHashMap<K, V> extends AbstractMap<K, V> implements Map<K, V>, Cloneable, Serializable {

    /**
     * HashMap中默认数组长度
     */
    static final int DEFAULT_INITIAL_CAPACITY = 1 << 4; // aka 16

    /**
     * HashMap中数组最大长度
     */
    static final int MAXIMUM_CAPACITY = 1 << 30;

    /**
     * 负载因子
     */
    static final float DEFAULT_LOAD_FACTOR = 0.75f;

    /**
     * 当每个Node节点上链表长度大于8可能结构会成为红黑树
     */
    static final int TREEIFY_THRESHOLD = 8;

    /**
     * 当每个Node节点上key个数小于6又从红黑树转变为链表
     */
    static final int UNTREEIFY_THRESHOLD = 6;

    /**
     * 只有数组长度大于64才会发生链表转红黑树
     */
    static final int MIN_TREEIFY_CAPACITY = 64;


    /**
     * Node是每个数组节点上的数据容器，装载着每个数组上一个k-v键值对的数据
     * 结构为一个链表结构
     * 每个Key一旦确定不能更改，hash值不能改，value可以更改
     *
     * @param <K>
     * @param <V>
     */
    static class Node<K, V> implements Map.Entry<K, V> {
        final int hash;
        final K key;
        V value;
        Node<K, V> next;

        public Node(int hash, K key, V value, Node<K, V> next) {
            this.hash = hash;
            this.key = key;
            this.value = value;
            this.next = next;
        }

        @Override
        public K getKey() {
            return key;
        }

        @Override
        public V getValue() {
            return value;
        }

        @Override
        public V setValue(V newValue) {
            V oldValue = value;
            value = newValue;
            return oldValue;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "hash=" + hash +
                    ", key=" + key +
                    ", value=" + value +
                    ", next=" + next +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o instanceof Node) {
                Node<?, ?> node = (Node<?, ?>) o;
                if (Objects.equals(key, node.getKey()) && Objects.equals(value, node.getValue()))
                    return true;
            }
            return false;
        }

        /**
         * 异或运算
         *
         * @return
         */
        @Override
        public int hashCode() {
            return Objects.hashCode(key) ^ Objects.hashCode(value);
        }
    }


    /**
     * HashMap的成员变量，一个Node[]
     *
     * @return
     */
    transient Node<K, V>[] table;

    transient Set<Map.Entry<K, V>> entrySet;

    /**
     * key-value对数
     */
    transient int size;

    /**
     * Map结构被修改的次数
     */
    transient int modeCount;

    /**
     * 下一次应该扩容时候的map容量
     */
    int threshold;

    /**
     * 负载因子
     */
    final float loadFactor;

    /**
     * 给定一个初始化key-value容量，得到的数组数量
     * 牛逼的位运算
     */
    static final int tableSizeFor(int cap) {
        int n = cap - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
    }

    /**
     * key的hash值运算,异或运算可以降低开销
     * 因为得到数组的key索引的时候计算方式是hash&(n-1)  ,n是2的整数幂
     *
     * @return
     */
    static final int hash(Object key) {
        int hash;
        return (key == null) ? 0 : (hash = key.hashCode()) ^ (hash >>> 16);
    }


    public MyHashMap(int initialCapacity, float loadFactor) {
        if (initialCapacity < 0)
            throw new IllegalArgumentException("Illegal initial capacity: " +
                    initialCapacity);
        if (initialCapacity > MAXIMUM_CAPACITY)
            initialCapacity = MAXIMUM_CAPACITY;
        if (loadFactor <= 0 || Float.isNaN(loadFactor))
            throw new IllegalArgumentException("Illegal load factor: " +
                    loadFactor);
        this.loadFactor = loadFactor;
        this.threshold = tableSizeFor(initialCapacity);
    }


    @Override
    public int size() {
        return size;
    }


    @Override
    public boolean isEmpty() {
        return size == 0;
    }


    @Override
    public Set<Entry<K, V>> entrySet() {
        return null;
    }


}
