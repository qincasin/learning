package com.qjx.dp.proxy.extend.force;


/**
 * 代理模式扩展之强制代理
 */
public class Client {
    public static void main(String[] args) {
         IGamePlayer player = new GamePlayer("张三");
//        GamePlayer proxy = new GamePlayer(player);  //不可以
        IGamePlayer proxy = player.getProxy();
        proxy.login("张三","123456");

        proxy.killBoss();

        proxy.upgrade();
    }
}
