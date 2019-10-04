package com.qjx.dp.proxy.extend.dynamic;

/**
 * 代理是有个性的
 *
 */
public class Client {
    public static void main(String[] args) {
        IGamePlayer player = new GamePlayer("张三");

        IGamePlayer proxy = new GamePlayerProxy(player);

        proxy.login("zhangsan","123456");

        proxy.killBoss();

        proxy.upgrade();
    }
}
