package com.qjx.concurrency.example.sync;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 多个线程同时访问的时候 第一个打印完之后再打印第二个
 */
@Slf4j
public class SynchronizedExample2 {
    /**
     * 修饰一个类
     * @param j
     */
    public static void test3(int j){
        //同步代码块
        synchronized (SynchronizedExample2.class){
            for (int i = 0; i < 10; i++) {
                log.info("test3 {} - {}",j,i);
            }
        }
    }

    /**
     * 修饰一个静态方法
     */
    public static synchronized void test4(int j){
        for (int i = 0; i < 10; i++) {
            log.info("test4 {} - {}",j,i);
        }
    }


    public static void main(String[] args) {
        SynchronizedExample2 example1 = new SynchronizedExample2();
        SynchronizedExample2 example2 = new SynchronizedExample2();
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(()->{
            example1.test4(1);
        });
        executorService.execute(()->{
            example2.test4(2);
        });
    }
}
