package com.qjx.singleton.demo;

public class Singleton7 {
    private volatile static Singleton7 singleton7;
    private Singleton7(){}
    public static Singleton7 getInstance(){
        if(singleton7==null){
            synchronized (Singleton7.class){
                if(singleton7==null){
                    singleton7=new Singleton7();
                }
            }
        }
        return singleton7;
    }

}
