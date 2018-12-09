package com.qjx.concurrency.example.aqs;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.FutureTask;

@Slf4j
public class FutureTaskExample2 {

    public static void main(String[] args)  throws Exception{
        FutureTask<String> futureTask;
        futureTask = new FutureTask<String>(()-> {
            log.info("do something in Runable ");
            try {
                Thread.sleep(5000);
            }catch (Exception e){
                e.printStackTrace();
            }
        },"i");
//        FutureTask<String> futureTask = new FutureTask<>(new Callable<String>(){
//            @Override
//            public String call() throws Exception{
//            log.info("do something in callable ");
//            Thread.sleep(5000);
//            return "Done";
//            }
//        });

        new Thread(futureTask).start();
        log.info("do something in main");
        Thread.sleep(1000);
        String result = futureTask.get();
        log.info("result:{}",result);
    }


}
