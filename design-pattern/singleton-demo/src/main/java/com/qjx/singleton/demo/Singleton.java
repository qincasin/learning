package com.qjx.singleton.demo;


public class Singleton {
    private final static Singleton SINGLETON = new Singleton();

    private Singleton(){}

    public static Singleton getInstance(){
        return SINGLETON;
    }


}
