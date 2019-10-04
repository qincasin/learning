package com.qjx.dp.proxy.extend.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class ClientDynamic {
    public static void main(String[] args) {
        IGamePlayer player = new GamePlayer("张三");
        InvocationHandler handler = new GamePlayIH(player);


        //获得class loader
        ClassLoader classLoader = player.getClass().getClassLoader();

        //动态产生一个代理
        IGamePlayer proxy = (IGamePlayer) Proxy.newProxyInstance(classLoader,new Class[]{IGamePlayer.class},handler);
        proxy.login("zhangsan","123456");
        proxy.killBoss();
        proxy.upgrade();
    }
}
