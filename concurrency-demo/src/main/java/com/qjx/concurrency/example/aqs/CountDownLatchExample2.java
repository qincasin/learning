package com.qjx.concurrency.example.aqs;


import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class CountDownLatchExample2 {
    /**
     * 同时执行的线程数
     */
    private final static int threadCount = 200;

    public static void main(String[] args) throws Exception{
        ExecutorService executorService = Executors.newCachedThreadPool();
        final CountDownLatch countDownLatch = new CountDownLatch(threadCount);


        for (int i = 0; i < threadCount; i++) {

            int threadNum = i;

            executorService.execute(()->{
                try {
                    test(threadNum);
                }catch (Exception e){
                    log.error("exception",e);
                }finally {
                    countDownLatch.countDown();
                }

            });

        }
        /**
         * 支持给定时间的等待
         * 当前线程只关注10ms 之内执行的内容，超过10ms之后的不在关注，但是存在的线程还是执行
         */
        countDownLatch.await(10, TimeUnit.MILLISECONDS);
        log.info("finish");
        /**
         * 不会立刻关闭线程
         */
        executorService.shutdown();

    }

    private static void test(int threadNum) throws Exception {
        Thread.sleep(100);
        log.info("{}",threadNum);

    }


}
