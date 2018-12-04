package com.qjx.concurrency.example.singleton;


import com.qjx.concurrency.annotations.NotThreadSafe;

/**
 * 单例
 * 懒汉模式 -》 双重同步锁单例模式
 * 单例的实例在第一次运行的时候进行创建
 */
@NotThreadSafe
public class SingletonExample4 {
    /**
     * 私有构造函数
     */
    private SingletonExample4(){

    }

    //1.memory = allocate() 分配对象的内存空间
    //2.ctorInstance() 初始化对象
    //3.instance = memory 设置instance 指向刚分配的内存

    //jvm 和cpu优化，发生了指令重排

    //1.memory = allocate() 分配对象的内存空间
    //3.instance = memory 设置instance 指向刚分配的内存
    //2.ctorInstance() 初始化对象


    /**
     * 单例对象
     */
    public static SingletonExample4 instance= null;

    /**
     * 静态的工厂方法
     * @return
     */
    public static SingletonExample4 getInstance(){
        //双重检测机制
        if(instance==null){
            //同步锁
            synchronized (SingletonExample4.class){
                if(instance == null){
                    instance = new SingletonExample4();
                }
            }
        }
        return instance;
    }
}
