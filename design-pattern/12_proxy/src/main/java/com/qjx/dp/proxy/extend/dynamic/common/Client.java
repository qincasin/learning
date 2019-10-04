package com.qjx.dp.proxy.extend.dynamic.common;

public class Client {
    public static void main(String[] args) {
        Subject subject = new RealSubject();
//        InvocationHandler handler = new MyInvocationHandler(subject);
//
//        //定义主题的代理
//
//        Subject proxy = DynamicProxy.newProxyInstance(subject.getClass().getClassLoader(), subject.getClass().getInterfaces(), handler);
//        //执行代理行为
//        proxy.doSomething("Finish");
        Subject proxy = SubjectDynamicProxy.newProxyInstance(subject);

        proxy.doSomething("Finish!");
    }
}
