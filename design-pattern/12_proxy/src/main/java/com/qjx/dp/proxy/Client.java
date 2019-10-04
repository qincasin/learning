package com.qjx.dp.proxy;


public class Client {
    public static void main(String[] args) {
        IGamePlayer player = new GamePlayer("张三");
        IGamePlayer proxy = new GamePlayerProxy(player);
        proxy.login("张三","123456");
        proxy.killBoss();
        proxy.upgrade();

    }
}
