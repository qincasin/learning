package com.qjx.dp.proxy.extend.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 动态代理类
 */
public class GamePlayIH implements InvocationHandler {

    //被代理者
    Class clzz = null;
    //被代理实例
    Object object = null;


    public GamePlayIH(Object object) {
        this.object = object;
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        Object result = method.invoke(this.object, args);

        if (method.getName().equalsIgnoreCase("login")) {
            System.out.println("有人在登录我的账号！");
        }
        return result;

    }
}
