package com.qjx.java8.dsl;

/**
 * Created by qincasin on 2021/1/23.
 */
public class Tax {
    public static double regional(double value) {
        return value * 2;
    }

    public static double general(double value) {
        return value * 3;
    }

    public static double surcharge(double value) {
        return value * 4;
    }

}
