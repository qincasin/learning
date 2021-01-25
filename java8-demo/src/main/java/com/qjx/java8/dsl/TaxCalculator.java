package com.qjx.java8.dsl;

import java.util.function.DoubleUnaryOperator;

/**
 * Created by qincasin on 2021/1/23.
 * 税费计算 dsl方式实现
 */

public class TaxCalculator {
    public DoubleUnaryOperator taxFunction = d -> d;


    public TaxCalculator with(DoubleUnaryOperator f) {
        taxFunction = taxFunction.andThen(f);
        return this;
    }

    public double calculate(Order order) {
        return taxFunction.applyAsDouble(order.getValue());
    }

    public static void main(String[] args) {
        Order order = new Order();
        order.setValue(10);
        double calculate = new TaxCalculator()
                .with(Tax::general)
                .with(Tax::regional)
                .calculate(order);
        System.out.println(calculate);
    }


}
