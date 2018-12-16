package com.qjx.design.decorator.example2;

/**
 * 添加奶茶
 */
public class MilkDecorator extends Decorator {

    public MilkDecorator(Coffee coffee) {
        super(coffee);
    }

    @Override
    public int getPrice() {
        return coffee.getPrice() + 10;
    }

    @Override
    public String getName() {
        return coffee.getName() + " addMilk ";
    }


}
