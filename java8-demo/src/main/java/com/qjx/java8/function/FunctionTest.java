package com.qjx.java8.function;

import lombok.extern.slf4j.Slf4j;

import java.rmi.MarshalledObject;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

/**
 * Created by qincasin on 2020/11/7.
 */
@Slf4j
public class FunctionTest {


    /**
     * 接收泛型 T ，返回泛型 R
     * @param list
     * @param f
     * @param <T>
     * @param <R>
     * @return
     */
    public <T, R> List<R> map(List<T> list, Function<T, R> f) {
        List<R> result = new ArrayList<>();
        for (T t : list) {
            result.add(f.apply(t));
        }
        return result;
    }

    public static void main(String[] args) {
        FunctionTest test = new FunctionTest();
        List<Integer> result = test.map(Arrays.asList("happy", "a", "weekend"), String::length);
        log.info("result:{}",result);
    }
}


