package com.qjx.design.decorator.example1;

import lombok.extern.slf4j.Slf4j;

/**
 * 竞争者
 * 举个例子，最近流行歌曲比赛，什么《中国好声音》，《中国好歌曲》什么的，对于一个参赛者而言，就是唱歌，定义类如下：
 */
@Slf4j
public class Competitor {

    public void sing(){
        log.info("我要唱歌...");
    }

}
