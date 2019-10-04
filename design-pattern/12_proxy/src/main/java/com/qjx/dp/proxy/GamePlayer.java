package com.qjx.dp.proxy;

public class GamePlayer implements IGamePlayer {
    private String name = "";


    public GamePlayer(String name) {
        this.name = name;
    }

    @Override
    public void login(String username, String password) {
        System.out.println("登录名：" + username + "密码：" + password);
    }

    @Override
    public void killBoss() {

        System.out.println(this.name + "在打怪");
    }

    @Override
    public void upgrade() {

        System.out.println(this.name + "又升一级！");
    }
}
