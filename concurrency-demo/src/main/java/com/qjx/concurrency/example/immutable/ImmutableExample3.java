package com.qjx.concurrency.example.immutable;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.qjx.concurrency.annotations.ThreadSafe;
import lombok.extern.slf4j.Slf4j;

/**
 * ImmutableXXX
 */
@Slf4j
@ThreadSafe
public class ImmutableExample3 {

    private final static ImmutableList list = ImmutableList.of(1,2,3);

    private final static ImmutableSet set = ImmutableSet.copyOf(list);

    private final static ImmutableMap map = ImmutableMap.of(1,2,3,4);

    private final static ImmutableMap map2 = ImmutableMap.builder()
            .put(1, 2)
            .put(3, 4)
            .build();


    public static void main(String[] args) {

//        list.add(4);
//
//        log.info("{}",list);

//        map.put(1,4);

        log.info("{}",map2.get(1));


    }



}
