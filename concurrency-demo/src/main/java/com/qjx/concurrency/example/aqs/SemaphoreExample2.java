package com.qjx.concurrency.example.aqs;


import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * 获取多个许可
 */
@Slf4j
public class SemaphoreExample2 {
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
                    //获取多个许可
                    semaphore.acquire(3);

                    test(threadNum);

                    //释放多个许可
                    semaphore.release(3);

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
