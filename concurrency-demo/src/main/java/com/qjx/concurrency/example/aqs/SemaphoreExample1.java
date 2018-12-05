package com.qjx.concurrency.example.aqs;


import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;

/**
 * 每一秒最多执行三个请求  也就是说 每一秒最多三个并发
 */
@Slf4j
public class SemaphoreExample1 {
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
                    //获取一个许可
                    semaphore.acquire();

                    test(threadNum);

                    //释放一个许可
                    semaphore.release();

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
