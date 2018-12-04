package com.qjx.concurrency.example.publish;

import com.qjx.concurrency.annotations.NotRecommend;
import com.qjx.concurrency.annotations.NotThreadSafe;
import lombok.extern.slf4j.Slf4j;

/**
 * 对象溢出
 *
 */
@Slf4j
@NotThreadSafe
@NotRecommend
public class Escape {

    private int thisCanEscape = 0;

    public Escape(){
        new InnerClass();
    }

    /**
     * 在对象未完成之前不可以将下面的对象进行发布  应该采用线程来启动
     */
    private class InnerClass{

        public InnerClass(){
            log.info("{}",Escape.this.thisCanEscape);
        }

    }

    public static void main(String[] args) {
        new Escape();
    }

}
