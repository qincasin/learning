package com.qjx.design.decorator.example2;

/**
 * 加糖
 */
public class SugarDecorator extends Decorator {


    public SugarDecorator(Coffee coffee) {
        super(coffee);
    }

    @Override
    public int getPrice() {
        return this.coffee.getPrice() + 2;
    }

    @Override
    public String getName() {
        return this.coffee.getName() + " addSugar ";
    }
}
