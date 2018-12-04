package com.qjx.concurrency.example.atomic;

import com.qjx.concurrency.annotations.ThreadSafe;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/**
 *
 */
@Slf4j
@ThreadSafe
public class AtomicExample5 {
    /**
     * 原子性的更新某一个类的实例
     */
    private static AtomicIntegerFieldUpdater<AtomicExample5> updater = AtomicIntegerFieldUpdater.
            newUpdater(AtomicExample5.class,"count");
    @Getter
    private  volatile int count =100;

    private static AtomicExample5 example5 = new AtomicExample5();



    public static void main(String[] args) {

        if(updater.compareAndSet(example5,100,120)){
            log.info("update success 1,{}",example5.getCount());
        }
        if(updater.compareAndSet(example5,100,120)){
            log.info("update success 2{}",example5.getCount());
        }else {
            log.info("update failed {}",example5.getCount());
        }

    }

}
