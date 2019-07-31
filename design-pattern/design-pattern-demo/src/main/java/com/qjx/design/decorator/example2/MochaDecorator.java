package com.qjx.design.decorator.example2;

/**
 * 加摩卡
 */
public class MochaDecorator extends Decorator {
    public MochaDecorator(Coffee coffee) {
        super(coffee);
    }

    @Override
    public int getPrice() {
        return this.coffee.getPrice() + 20;
    }

    @Override
    public String getName() {
        return this.coffee.getName() + " addMocha ";
    }
}
