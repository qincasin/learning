package com.qjx.design.decorator.example2;

import lombok.extern.slf4j.Slf4j;

/**
 * 咖啡店里咖啡中可以加不同的配料–摩卡、牛奶、糖、奶泡；不同的饮品加上不同的配料有不同的价钱，怎样实现呢？
 */
@Slf4j

public class Client {

    public static void main(String[] args) {

        Coffee coffee = new SimpleCoffee();
        log.info("普通咖啡:{},价格:{}",coffee.getName(),coffee.getPrice());
        //添加了牛奶
        Decorator milk = new MilkDecorator(coffee);

        log.info("添加了:{},价格:{}",milk.getName(),milk.getPrice());
        //添加了糖和牛奶
        milk = new SugarDecorator(milk);
        log.info("添加了:{},价格:{}",milk.getName(),milk.getPrice());






    }


}
