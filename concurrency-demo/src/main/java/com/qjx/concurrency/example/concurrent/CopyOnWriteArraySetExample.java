package com.qjx.concurrency.example.concurrent;

import com.qjx.concurrency.annotations.ThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.Set;
import java.util.concurrent.*;

/**
 * CopyOnWriteArraySet
 */
@Slf4j
@ThreadSafe
public class CopyOnWriteArraySetExample {


    /**
     * 请求总数
     */
    private static int clientTotal = 5000;
    /**
     * 同事并发执行的线程数
     */
    private static int threadTotal = 200;

    private static Set<Integer> list = new CopyOnWriteArraySet();

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
