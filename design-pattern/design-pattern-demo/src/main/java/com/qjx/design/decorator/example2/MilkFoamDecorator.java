package com.qjx.design.decorator.example2;

/**
 * 加奶泡
 */
public class MilkFoamDecorator extends Decorator {

    public MilkFoamDecorator(Coffee coffee) {
        super(coffee);
    }

    @Override
    public int getPrice() {
        return coffee.getPrice() + 15;
    }

    @Override
    public String getName() {
        return coffee.getName() + " addMilkFoam ";
    }
}
