package com.qjx.concurrency.example.lock;

import com.qjx.concurrency.annotations.ThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Condition
 */
@Slf4j
@ThreadSafe
public class LockExample6 {
    public static void main(String[] args) {
        ReentrantLock reentrantLock = new ReentrantLock();
        Condition condition = reentrantLock.newCondition();

        new Thread(()->{
            try {
                reentrantLock.lock();
                // 1
                log.info("wait signal ");
                condition.await();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            // 4
            log.info("get signal");
            reentrantLock.unlock();
        }).start();


        new Thread(()->{
            reentrantLock.lock();
            // 2
            log.info("get lock");
            try {
                Thread.sleep(3000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            condition.signalAll();
            //3
            log.info("send signal ~");
            reentrantLock.unlock();
        }).start();


    }
}
