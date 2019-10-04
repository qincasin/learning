package com.qjx.dp.proxy.extend.dynamic.common;

public class RealSubject implements Subject {
    @Override
    public void doSomething(String str) {
        //业务操作
        System.out.println("do something!---->" + str);
    }


}
