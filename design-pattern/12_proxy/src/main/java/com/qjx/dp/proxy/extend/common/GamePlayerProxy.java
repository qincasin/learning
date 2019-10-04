package com.qjx.dp.proxy.extend.common;

public class GamePlayerProxy implements IGamePlayer {
    private IGamePlayer gamePlayer = null;

    //普通代理类
    public GamePlayerProxy(String name){
        try {
            gamePlayer = new GamePlayer(this,name);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    @Override
    public void login(String username, String password) {
        this.gamePlayer.login(username,password);
    }

    @Override
    public void killBoss() {
        this.gamePlayer.killBoss();
    }

    @Override
    public void upgrade() {
        this.gamePlayer.upgrade();

    }
}
