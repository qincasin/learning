package com.qjx.concurrency.example.aqs;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

@Slf4j
public class FutureExample {

    static class MyCallable implements Callable<String>{
        @Override
        public String call() throws Exception {
            log.info("do something in callable ");
            Thread.sleep(5000);
            return "Done";
        }
    }


    public static void main(String[] args) throws Exception{
        ExecutorService executorService = Executors.newCachedThreadPool();
        //使用future接收另外一个线程执行的结果
        Future<String> future = executorService.submit(new MyCallable());
        log.info("do something in main");

        Thread.sleep(1000);
        //一直在阻塞中
        String result = future.get();

        log.info("result: {} ",result);


    }

}
