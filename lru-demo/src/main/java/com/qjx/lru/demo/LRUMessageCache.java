package com.qjx.lru.demo;

import lombok.extern.slf4j.Slf4j;

import java.util.LinkedHashMap;
import java.util.Map;

@Slf4j
public class LRUMessageCache extends LinkedHashMap<String, Integer> {

    private static final long serialVersionUID = 1L;

    private int cacheSize;

    LRUMessageCache(int cacheSize) {
        super((int) ((float) cacheSize * 1.3333334F), 0.75F, true);
        if (cacheSize < 1) {
            throw new IllegalArgumentException("cache size cannot be small than 1");
        } else {
            this.cacheSize = cacheSize;
        }
    }
    protected int getMessageCountAndThenIncrement(String msg) {

        if (msg == null) {
            return 0;
        } else {
            Integer i;
            synchronized (this) {
                i = (Integer) super.get(msg);
                if (i == null) {
                    i = 0;
                } else {
                    i = i + 1;
                }
                super.put(msg,i);
            }
            return i;
        }

    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<String, Integer> eldest) {
        return this.size()>this.cacheSize;
    }
    @Override
    public synchronized void clear() {
        super.clear();
    }

    public static void main(String[] args) {
        LRUMessageCache cache = new LRUMessageCache(4);
        cache.put("1",1);
//        cache.put("2",2);
        cache.put("3",3);
        cache.put("4",4);
        log.info("cache:{}",cache);
        cache.put("5",5);
        log.info("cache:{}",cache);
        cache.put("4",4);
        log.info("cache:{}",cache);
        cache.put("1",1);
        log.info("cache:{}",cache);
        cache.getMessageCountAndThenIncrement("1");
        log.info("cache:{}",cache);




    }



}
