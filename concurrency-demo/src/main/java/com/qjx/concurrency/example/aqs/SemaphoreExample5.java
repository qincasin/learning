package com.qjx.concurrency.example.aqs;


import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * 尝试获取时间内的许可次数
 */
@Slf4j
public class SemaphoreExample5 {
    /**
     * 请求数 20个线程
     */
    private final static int threadCount = 20;

    public static void main(String[] args) throws Exception{
        ExecutorService executorService = Executors.newCachedThreadPool();
        /**
         * 并发数目
         */
        final Semaphore semaphore = new Semaphore(3);

        for (int i = 0; i < threadCount; i++) {

            final int threadNum = i;

            executorService.execute(()->{
                try {
                    //尝试获取一个许可
                    if(semaphore.tryAcquire(2,5000, TimeUnit.MICROSECONDS)){
                        test(threadNum);
                        semaphore.release();
                    }

                }catch (Exception e){
                    log.error("exception",e);
                }

            });

        }
        log.info("finish");
        /**
         * 不会立刻关闭线程
         */
        executorService.shutdown();

    }

    private static void test(int threadNum) throws Exception {
        log.info("{}",threadNum);
        Thread.sleep(1000);

    }


}
