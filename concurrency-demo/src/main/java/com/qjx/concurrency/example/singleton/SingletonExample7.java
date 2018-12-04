package com.qjx.concurrency.example.singleton;


import com.qjx.concurrency.annotations.Recommend;
import com.qjx.concurrency.annotations.ThreadSafe;

/**
 * 单例
 * 枚举模式
 * 最安全
 */
@ThreadSafe
@Recommend
public class SingletonExample7 {
    /**
     * 私有构造方法
     */
    private SingletonExample7 (){

    }

    public static SingletonExample7 getInstance(){
        return Singleton.SINGLETON.getInstance();
    }

    /**
     * 枚举类定义单利实现
     */
    private enum Singleton{
        /**
         * 枚举单例
         */
        SINGLETON;
        private SingletonExample7 singleton;

        /**
         * JVM保证这个方法绝对只被调用一次
         */
        Singleton(){
            singleton = new SingletonExample7();
        }

        public SingletonExample7 getInstance(){
            return singleton;
        }
    }


}
