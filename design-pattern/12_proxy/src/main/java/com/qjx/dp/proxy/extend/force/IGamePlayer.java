package com.qjx.dp.proxy.extend.force;

public interface IGamePlayer {
    void login(String username, String password);


    void killBoss();


    void upgrade();

    IGamePlayer getProxy();

}
