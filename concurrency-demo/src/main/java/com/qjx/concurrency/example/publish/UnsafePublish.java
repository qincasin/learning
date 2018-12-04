package com.qjx.concurrency.example.publish;

import com.qjx.concurrency.annotations.NotThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * 对象发布
 */
@Slf4j
@NotThreadSafe
public class UnsafePublish {
    private String[] states = {"a","b","c"};

    /**
     * 类的非私有方法返回对象的引用
     * @return
     */
    public String[] getStates(){
        return states;
    }

    public static void main(String[] args) {
        UnsafePublish unsafePublish = new UnsafePublish();
        log.info("{}", Arrays.toString(unsafePublish.getStates()));
        unsafePublish.getStates()[0]="d";
        log.info("{}", Arrays.toString(unsafePublish.getStates()));

    }
}
