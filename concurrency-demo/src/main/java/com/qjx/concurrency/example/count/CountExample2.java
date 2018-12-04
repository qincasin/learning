package com.qjx.concurrency.example.count;

import com.qjx.concurrency.annotations.ThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

@Slf4j
@ThreadSafe
public class CountExample2 {
    private static int threadTotal = 200;
    private static int clientTotal = 5000;


    private static long count = 0;

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();

        final Semaphore semaphore = new Semaphore(threadTotal);

        for (int index = 0; index < clientTotal; index++) {
            executorService.execute(()->{
                try {
                    semaphore.acquire();
                    add();
                    semaphore.release();
                } catch (Exception e){
                    log.error(e.getMessage(),e);
                }
            });
        }
        executorService.shutdown();
        log.info("count:{}",count);
    }
    private static synchronized void add(){
        count++;
    }

}
