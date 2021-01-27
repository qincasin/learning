package com.qjx.java8.optional;

import cn.hutool.json.JSON;
import cn.hutool.json.JSONUtil;
import com.qjx.java8.domain.Car;
import com.qjx.java8.domain.Insurance;
import com.qjx.java8.domain.Person;
import org.junit.jupiter.api.Test;

import java.util.Optional;
import java.util.OptionalInt;
import java.util.Properties;

/**
 * Created by qincasin on 2021/1/26.
 */
public class OptionalTest {
    @Test
    public void testFlatMap() {
        Person person = new Person().setAge(20)
                .setCar(Optional.of(new Car().setId(1).setName("benchi").setInsurance(
                        Optional.of(new Insurance().setId(1).setName("保险单子一号")
                        ))));

//        Person person2 = new Person().setAge(10)
//                .setCar(Optional.of(new Car().setId(2).setName("benchi2").setInsurance(
//                        new Insurance().setId(2).setName("保险单子二号")
//                )));

        String s = JSONUtil.toJsonStr(person);
        System.out.println(s);

        Optional<Person> optional = Optional.of(person);
        Optional<Car> car = optional.filter(p -> p.getAge() > 10)
                .flatMap(Person::getCar);
        System.out.println(JSONUtil.toJsonStr(person));
        Optional<String> s1 = car.flatMap(Car::getInsurance)
                .map(Insurance::getName);
        System.out.println(s1);


    }

    /**
     * 整合
     */
    @Test
    public void test() {
        Properties properties = new Properties();
        properties.setProperty("a", "5");
        properties.setProperty("b", "1");
        int a = readDuration(properties, "a");
        System.out.println(a);

    }

    public int readDuration(Properties properties, String name) {
        return Optional.of(properties.get(name))
                .flatMap(OptionalUtility::stringToInt)
                .filter(i -> i > 0)
                .orElse(0);

    }

}
