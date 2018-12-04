package com.qjx.concurrency.example.singleton;


import com.qjx.concurrency.annotations.NotRecommend;
import com.qjx.concurrency.annotations.ThreadSafe;

/**
 * 单例
 * 懒汉模式
 * 单例的实例在第一次运行的时候进行创建
 */
@ThreadSafe
@NotRecommend
public class SingletonExample3 {
    /**
     * 私有构造函数
     */
    private SingletonExample3(){

    }

    /**
     * 单例对象
     */
    public static SingletonExample3 instance= null;

    /**
     * 静态的工厂方法
     * @return
     */
    public static synchronized SingletonExample3 getInstance(){
        if(instance==null){
            instance = new SingletonExample3();
        }
        return instance;
    }
}
