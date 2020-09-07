package com.qjx.java.enums;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Created by qincasin on 2020/6/24.
 */

public enum Enums {
    //888
    day(1, "day"),
    month(2, "month"),
    year(3, "year"),
    error(0, "error");
    @Setter
    @Getter
    private Integer code;

    @Setter
    @Getter
    private String msg;


    Enums(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    String getMsgByCode(Integer code){
        return Optional.ofNullable(valueByCode(code))
                .map(Enums::getMsg)
                .orElse(Enums.error.msg);
    }

    Enums valueByCode(Integer code) {
        List<Enums> enums = Arrays.stream(Enums.values())
                .filter(a -> a.getCode().equals(code))
                .collect(Collectors.toList());
        if (enums.isEmpty()) {
            return null;
        } else if (enums.size() == 1) {
            return enums.get(0);
        } else {
            throw new RuntimeException("unknown code: " + code);
        }
    }

}
