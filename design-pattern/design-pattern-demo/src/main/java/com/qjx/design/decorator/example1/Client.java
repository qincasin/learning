package com.qjx.design.decorator.example1;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Client {
    public static void main(String[] args) {

        Competitor competitor = new Competitor();
        //加入了跳舞修饰，decorator 的sing() 方法中被动态添加了dance 修饰
        CompetitorDecorator decorator = new CompetitorDecoratorA(competitor);
        //在上面修饰的基础上，加入背景音乐修饰
        decorator = new CompetitorDecoratorB(decorator);

        //在上面修饰的基础上，加上悲惨的身世介绍
        decorator = new CompetitorDecoratorC(competitor);

        decorator.sing();

        log.info("满场尖叫，满分通过！！！！！");

    }

}
