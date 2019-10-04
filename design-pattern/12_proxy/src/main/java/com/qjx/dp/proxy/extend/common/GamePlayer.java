package com.qjx.dp.proxy.extend.common;

public class GamePlayer implements IGamePlayer {
    private String name = "";

    //普通代理
    public GamePlayer(IGamePlayer gamePlayer, String name) throws Exception {
        if (gamePlayer == null) {
            throw new Exception("不能创建角色");
        } else {
            this.name = name;
        }
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
