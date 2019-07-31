package com.qjx.design.decorator.example2;

/**
 * 装饰器类
 */
public abstract class Decorator extends Coffee{

    protected Coffee coffee;

    public Decorator(Coffee coffee) {
        this.coffee = coffee;
    }
}
