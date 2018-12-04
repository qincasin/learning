package com.qjx.concurrency.example.singleton;


import com.qjx.concurrency.annotations.ThreadSafe;

/**
 * 单例
 * 饿汉模式
 * 单例的实例在类装载的时候进行创建
 * 饿汉模式可能会导致线程资源的浪费
 * 使用的时候注意的问题：
 * 1.私有构造函数在实现的时候没有太多的处理，不然会导致该类加载过慢，出现性能问题
 * 2.在使用过程中存在实际调用，不然会导致资源浪费
 */
@ThreadSafe
public class SingletonExample2 {
    /**
     * 私有构造函数
     */
    private SingletonExample2(){

    }

    /**
     * 单例对象
     */
    public static SingletonExample2 instance= new SingletonExample2();

    /**
     * 静态的工厂方法
     * @return
     */
    public static SingletonExample2 getInstance(){
        return instance;
    }
}
