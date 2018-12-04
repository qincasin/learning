package com.qjx.concurrency.example.singleton;


import com.qjx.concurrency.annotations.NotThreadSafe;

/**
 * 单例
 * 懒汉模式
 * 单例的实例在第一次运行的时候进行创建
 * 单线程下安全 ，多线程下不安全
 */
@NotThreadSafe
public class SingletonExample1 {
    /**
     * 私有构造函数
     */
    private SingletonExample1(){

    }

    /**
     * 单例对象
     */
    public static SingletonExample1 instance= null;

    /**
     * 静态的工厂方法
     * @return
     */
    public static SingletonExample1 getInstance(){
        if(instance==null){
            instance = new SingletonExample1();
        }
        return instance;
    }
}
