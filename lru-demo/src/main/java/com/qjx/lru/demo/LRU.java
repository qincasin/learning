package com.qjx.lru.demo;


import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/**
 * 借助LinkedHashMap来实现
 * 固定缓存大小，需要给缓存分配一个固定的大小。
 * 每次读取缓存都会改变缓存的使用时间，将缓存的存在时间重新刷新。
 * 需要在缓存满了后，将最近最久未使用的缓存删除，再添加最新的缓存。
 */
public class LRU<K,V> {

    private final int MAX_CASHE_SIZE;
    private final float DEFAULT_LOAD_FACTORY = 0.75f;

    LinkedHashMap<K,V> map;

    public LRU(int cacheSize){
        MAX_CASHE_SIZE = cacheSize;
        int capacity = (int) Math.ceil(MAX_CASHE_SIZE/DEFAULT_LOAD_FACTORY)+1;
        /*
         * 第三个参数设置为true，代表linkedlist按访问顺序排序，可作为LRU缓存
         * 第三个参数设置为false，代表按插入顺序排序，可作为FIFO缓存
         */
        map = new LinkedHashMap<K, V>(capacity, DEFAULT_LOAD_FACTORY, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
                return size() > MAX_CASHE_SIZE;
            }
        };
    }

    public synchronized void put(K key,V value){
        map.put(key,value);
    }
    public synchronized V get (K key){
        return map.get(key);
    }

    public synchronized void remove(K key){
        map.remove(key);
    }

    public synchronized Set<Map.Entry<K,V>> getAll(){
        return map.entrySet();
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<K, V> entry : map.entrySet()) {
            sb.append(String.format("%s: %s  ",entry.getKey(),entry.getValue()));
        }
        return sb.toString();

    }

    public static void main(String[] args) {
        LRU<Integer,Integer> lru = new LRU<>(5);
        lru.put(1,1);
        lru.put(2,2);
        lru.put(3,3);
        System.out.println(lru);
        lru.get(1);
        System.out.println(lru);

        lru.put(4,4);
        lru.put(5,5);
        lru.put(6,6);
        System.out.println(lru);
        lru.put(7,7);
        System.out.println(lru);
    }









}
