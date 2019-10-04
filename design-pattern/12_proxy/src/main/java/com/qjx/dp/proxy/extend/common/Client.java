package com.qjx.dp.proxy.extend.common;

/**
 * 代理类扩展之普通代理类
 */
public class Client {
    public static void main(String[] args) {

        //普通代理类
        IGamePlayer proxy = new GamePlayerProxy("张三");

        proxy.login("张三","123456");

        proxy.killBoss();

        proxy.killBoss();

    }
}
