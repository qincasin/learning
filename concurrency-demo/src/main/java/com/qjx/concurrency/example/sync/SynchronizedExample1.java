package com.qjx.concurrency.example.sync;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 多个线程同时访问的时候 交替打印输出
 */
@Slf4j
public class SynchronizedExample1 {
    /**
     * 修饰代码块
     * @param j
     */
    public void test1(int j){
        //同步代码块
        synchronized (this){
            for (int i = 0; i < 10; i++) {
                log.info("test1 {} - {}",j,i);
            }
        }
    }

    /**
     * 修饰方法
     */
    public synchronized void test2(int j){
        for (int i = 0; i < 10; i++) {
            log.info("test2 {} - {}",j,i);
        }
    }


    public static void main(String[] args) {
        SynchronizedExample1 example1 = new SynchronizedExample1();
        SynchronizedExample1 example2 = new SynchronizedExample1();
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(()->{
            example1.test2(1);
        });
        executorService.execute(()->{
            example2.test2(2);
        });
    }
}
