package com.qjx.concurrency.example.syncContainer;

import com.google.common.collect.Lists;
import com.qjx.concurrency.annotations.ThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * Collections.synchronizedList
 */
@Slf4j
@ThreadSafe
public class CollectionsExample1 {


    /**
     * 请求总数
     */
    private static int clientTotal = 5000;
    /**
     * 同事并发执行的线程数
     */
    private static int threadTotal = 200;

    private static List<Integer> list = Collections.synchronizedList(Lists.newArrayList());

    public static void main(String[] args) throws Exception{

        ExecutorService executorService = Executors.newCachedThreadPool();
        final Semaphore semaphore = new Semaphore(threadTotal);

        final CountDownLatch countDownLatch = new CountDownLatch(clientTotal);

        for (int i = 0; i < clientTotal; i++) {
            final int count = i;
            executorService.execute(()->{

                try {
                    semaphore.acquire();
                    update(count);
                    semaphore.release();
                }catch (Exception e){
                    log.error(e.getMessage(),e);
                }
                countDownLatch.countDown();
            });
        }
        countDownLatch.await();
        executorService.shutdown();
        log.info("size {}",list.size());



    }

    private static void update(int i) {
        list.add(i);
    }


}
