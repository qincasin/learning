package com.qjx.concurrency.example.lock;

import lombok.extern.slf4j.Slf4j;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * ReentrantReadWriteLock
 * 悲观读取 (在写入锁执行的时候不能有读锁在执行)，读多写少的情况下，写锁会产生饥饿
 */
@Slf4j
public class LockExample3 {

    private final Map<String,Data> map = new TreeMap<>();

    private final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    /**
     * 读锁
     */
    private final Lock readLock = lock.readLock();
    /**
     * 写锁
     */
    private final Lock writeLock = lock.writeLock();


    public Data get(String key){
        readLock.lock();
        try {
            return map.get(key);
        }finally {
            readLock.unlock();
        }
    }
    public Set<String> getAllKeys(){
        readLock.lock();
        try {
            return map.keySet();
        }finally {
            readLock.unlock();
        }
    }

    public Data put(String key,Data value){
        writeLock.lock();
        try {
            return map.put(key,value);
        } finally {
            writeLock.unlock();
        }
    }

    public void clear(){
        writeLock.lock();
        try {
            map.clear();
        }finally {
            writeLock.unlock();
        }
    }


    class Data{

    }



}
