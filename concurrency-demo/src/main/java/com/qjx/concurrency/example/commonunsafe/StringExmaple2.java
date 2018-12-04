package com.qjx.concurrency.example.commonunsafe;

import com.qjx.concurrency.annotations.NotThreadSafe;
import com.qjx.concurrency.annotations.ThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

@Slf4j
@ThreadSafe
public class StringExmaple2 {
    /**
     * 请求总数
     */
    private static int clientTotal = 5000;
    /**
     * 同事并发执行的线程数
     */
    private static int threadTotal = 200;

    public static StringBuffer stringBuffer = new StringBuffer();

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newCachedThreadPool();
        final Semaphore semaphore = new Semaphore(threadTotal);

        final CountDownLatch countDownLatch = new CountDownLatch(clientTotal);

        for (int i = 0; i < clientTotal; i++) {
            executorService.execute(()->{

                try {
                    semaphore.acquire();
                    update();
                    semaphore.release();
                }catch (Exception e){
                    log.error(e.getMessage(),e);
                }
            });
        }
        executorService.shutdown();
        log.info("size {}",stringBuffer.length());


    }

    private static void update() {
        stringBuffer.append("1");
    }


}
