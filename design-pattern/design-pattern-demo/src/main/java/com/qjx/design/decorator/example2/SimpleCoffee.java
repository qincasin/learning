package com.qjx.design.decorator.example2;

/**
 * coffee基础类
 */
public class SimpleCoffee extends Coffee{

    /**
     * 起步价十元
     * @return
     */
    @Override
    public int getPrice() {
        return 10;
    }

    /**
     * 默认名字咖啡
     * @return
     */
    @Override
    public String getName() {
        return "coffee";
    }
}
