package com.qjx.concurrency.example.aqs;


import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 */
@Slf4j
public class CyclicBarrierExample3 {


    /**
     * 同步等待线程数
     */
    private static CyclicBarrier barrier = new CyclicBarrier(5,()->{
        log.info("callback is running");
    });

    public static void main(String[] args) throws Exception{

        ExecutorService executorService = Executors.newCachedThreadPool();

        for (int i = 0; i < 10; i++) {

            final int threadNum = i;

            Thread.sleep(1000);
            executorService.execute(()->{
                try {
                    race(threadNum);
                }catch (Exception e){
                    log.error("exception",e);
                }


            });
        }
        executorService.shutdown();



    }

    private static void race(int threadNum) throws Exception {
        Thread.sleep(1000);
        log.info("{} is ready",threadNum);
        barrier.await();
        log.info("{} continue",threadNum);
    }


}
