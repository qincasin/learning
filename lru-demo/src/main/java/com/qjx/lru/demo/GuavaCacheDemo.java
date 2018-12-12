package com.qjx.lru.demo;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import lombok.extern.slf4j.Slf4j;

import java.beans.EventHandler;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

@Slf4j
public class GuavaCacheDemo {


    public static CacheLoader<String,String> createCacheLoader(){
        return new CacheLoader<String, String>() {
            @Override
            public String load(String key) throws Exception {
                return key;
            }
        };
    }



    public static void main(String[] args) throws ExecutionException ,InterruptedException{

        LoadingCache<String,String> cache = CacheBuilder.newBuilder()
                .maximumSize(100)
                //写之后30ms过期
                .expireAfterWrite(30L, TimeUnit.MILLISECONDS)
                //访问之后30ms过期
                .expireAfterAccess(30L,TimeUnit.MILLISECONDS)
                //20ms之后刷新
                .refreshAfterWrite(20L,TimeUnit.MILLISECONDS)
                //开启weakKey key 当启动垃圾回收时，该缓存也被回收
                .weakKeys()
                .build(createCacheLoader());
        log.info("hello:{}",cache.get("hello"));
        cache.put("hello1","我是hello1");
        log.info("hello1:{}",cache.get("hello1"));
        cache.put("hello2","我是hello2");
        log.info("hello2:{}",cache.get("hello2"));
        Thread.sleep(5000);
        log.info("cache size:{}",cache.size());

        log.info("------------------------------------");
        Cache<String,String> cache1 = CacheBuilder.newBuilder()
                .maximumSize(100)
                .expireAfterWrite(5, TimeUnit.MILLISECONDS)
                .concurrencyLevel(1)
                .build();

        cache1.put("hello1", "我是hello1");
        cache1.put("hello2", "我是hello2");
        cache1.put("hello3", "我是hello3");
        cache1.put("hello4", "我是hello4");
        Thread.sleep(5);
        log.info("cache1 size:{}",cache1.size());
        cache1.put("hello5","hello5");
        log.info("cache1 size:{}",cache1.size());
        









    }




}
