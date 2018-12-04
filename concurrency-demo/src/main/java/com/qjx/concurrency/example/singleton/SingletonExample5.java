package com.qjx.concurrency.example.singleton;


import com.qjx.concurrency.annotations.ThreadSafe;

/**
 * 单例
 * 懒汉模式 -》 双重同步锁单例模式
 * 单例的实例在第一次运行的时候进行创建
 */
@ThreadSafe
public class SingletonExample5 {
    /**
     * 私有构造函数
     */
    private SingletonExample5(){

    }

    //1.memory = allocate() 分配对象的内存空间
    //2.ctorInstance() 初始化对象
    //3.instance = memory 设置instance 指向刚分配的内存


    /**
     * 单例对象 volatile + 双重检测机制 -> 禁止指令重拍
     */
    public volatile static SingletonExample5 instance= null;

    /**
     * 静态的工厂方法
     * @return
     */
    public static SingletonExample5 getInstance(){
        //双重检测机制
        if(instance==null){
            //同步锁
            synchronized (SingletonExample5.class){
                if(instance == null){
                    instance = new SingletonExample5();
                }
            }
        }
        return instance;
    }
}
