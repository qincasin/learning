package com.qjx.java8.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.Optional;

/**
 * Created by qincasin on 2021/1/26.
 */
@Accessors(chain = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Car {
    private Integer  id;
    private String name;
    private Optional<Insurance> insurance;
}
