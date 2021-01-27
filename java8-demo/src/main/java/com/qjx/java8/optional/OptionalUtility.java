package com.qjx.java8.optional;

import java.util.Optional;

/**
 * Created by qincasin on 2021/1/26.
 */
public class OptionalUtility {
    public static Optional<Integer> stringToInt(Object value) {
        try {

            return Optional.of(Integer.parseInt((String) value));
        } catch (NumberFormatException e) {
            return Optional.empty();
        }
    }
}
