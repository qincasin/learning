package com.qjx.design.decorator.example1;

import lombok.extern.slf4j.Slf4j;

/**
 * 但是这个是远远不够的，你有一个好嗓门，也是需要包装的，一个裸唱、没有伴奏、没有伴舞的参赛者去比赛哪有什么竞争力啊！于是，我们要对这个参赛者进行包装，在他唱歌的时候加上舞蹈:
 */
@Slf4j
public class CompetitorDecorator1 extends Competitor{
    @Override
    public void sing() {
        this.dance();
        super.sing();
    }

    /**
     * 跳舞
     */
    private void dance() {
        log.info("跳舞:翩翩起舞...");
    }
}
