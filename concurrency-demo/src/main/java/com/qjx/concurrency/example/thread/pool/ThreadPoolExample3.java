package com.qjx.concurrency.example.thread.pool;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * newSingleThreadExecutor
 */
@Slf4j
public class ThreadPoolExample3 {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();


        thread1(executorService);
//        thread2(executorService);
    }

    private static void thread2(ExecutorService executorService) {
        for (int i = 0; i < 10; i++) {
            final int index = i;
            executorService.execute(new Runnable() {

                @Override
                public void run() {
                    log.info("task:{}",index);
                }
            });
        }
        executorService.shutdown();


    }

    private static void thread1(ExecutorService executorService) {
        for (int i = 0; i < 10; i++) {
            final int index = i;
            executorService.execute(() -> {
                log.info("task:{}", index);
            });
        }
        executorService.shutdown();
    }

}
