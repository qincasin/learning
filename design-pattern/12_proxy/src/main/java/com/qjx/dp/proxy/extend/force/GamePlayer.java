package com.qjx.dp.proxy.extend.force;

public class GamePlayer  implements IGamePlayer{

    private String name ="";

    private  IGamePlayer proxy = null;

    public GamePlayer(String name) {
        this.name = name;
    }



    @Override
    public void login(String username, String password) {
        if(isProxy()){
            System.out.println("登录名：" + username + "密码：" + password);
        }else {
            System.out.println("请使用制定的代理访问");
        }
    }

    @Override
    public void killBoss() {
        if (isProxy()) {
            System.out.println(this.name +"在打怪！");
        }else {
            System.out.println("请使用制定的代理访问");
        }
    }

    @Override
    public void upgrade() {

        if (isProxy()) {
            System.out.println(this.name + "又升一级！");
        }else {
            System.out.println("请使用制定的代理访问");
        }
    }

    @Override
    public IGamePlayer getProxy() {
        proxy = new GamePlayerProxy(this);
        return this.proxy;
    }

    private boolean isProxy(){
        if (this.proxy == null) {
            return false;
        }else {
            return true;
        }
    }
}
