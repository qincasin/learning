package com.qjx.java8.dsl;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by qincasin on 2021/1/22.
 */
public class DSLTest {

    public static void main(String[] args) throws Exception {
        String fileName = "/Users/qinjiaxing/code/casin/learning/java8-demo/src/main/resources/file.txt";
        List<String> list = Files.lines(Paths.get(fileName))
                .filter(line -> line.startsWith("123"))
                .limit(3)
                .collect(Collectors.toList());
        System.out.println(list);
    }
}
