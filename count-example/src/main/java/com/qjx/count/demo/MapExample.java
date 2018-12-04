package com.qjx.count.demo;

import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

@Slf4j
public class MapExample {

    private static Map<Integer,Integer> map = Maps.newHashMap();

    private static int threadNum = 200;
    private static int clientNum = 5000;

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();

        final Semaphore semaphore = new Semaphore(threadNum);

        for (int index = 0; index < clientNum; index++) {
            final int threadNum = index;
            executorService.execute(()->{
                try {
                    semaphore.acquire();
                    func(threadNum);
                    semaphore.release();

                }catch (Exception e){
                    log.error(e.getMessage(),e);
                }
            });
        }
        executorService.shutdown();
        log.info("size :{}",map.size());

        Runtime runtime = Runtime.getRuntime();
        int processors = runtime.availableProcessors();
        long totalMemory = runtime.totalMemory();
        log.info("processors:{}",processors);
        log.info("totalMemory:{}",totalMemory);
    }

    private static void func(int threadNum) {
        map.put(threadNum,threadNum);

    }

}
