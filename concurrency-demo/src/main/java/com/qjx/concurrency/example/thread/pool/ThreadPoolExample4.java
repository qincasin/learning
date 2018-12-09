package com.qjx.concurrency.example.thread.pool;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * newSingleThreadExecutor
 */
@Slf4j
public class ThreadPoolExample4 {

    public static void main(String[] args) {

        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(5);


        thread1(executorService);
//        thread2(executorService);
    }


    private static void thread1(ScheduledExecutorService executorService) {
        executorService.schedule(()->{
            log.warn("schedule run");
        },3, TimeUnit.SECONDS);
        executorService.shutdown();
    }


}
