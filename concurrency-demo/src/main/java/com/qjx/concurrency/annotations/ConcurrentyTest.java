package com.qjx.concurrency.annotations;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

@Slf4j
@NotThreadSafe
public class ConcurrentyTest {
    //请求总数
    public static int clientTotal = 5000;
    //同时并发执行的线程数
    public static int threadTotal = 200;
    //计数
    public static int count = 0;


    public static void main(String[] args) throws Exception{
        ExecutorService executorService = Executors.newCachedThreadPool();
        //放置信号量
        final Semaphore semaphore = new Semaphore(threadTotal);
        //请求总数
        final CountDownLatch countDownLatch = new CountDownLatch(clientTotal);
        for (int i = 0; i < clientTotal; i++) {
            executorService.execute(()->{
                try {
                    semaphore.acquire();
                    add();
                    semaphore.release();
                } catch (Exception e){
                    log.error("exception",e);
                }
                //闭锁 没执行行完一次 计数减一
                countDownLatch.countDown();

            });
        }
        //保证之前所有的方法都执行完毕
        countDownLatch.await();
        log.info("count:{}",count);
    }

    private static void add(){
        count++;
    }

}
