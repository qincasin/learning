package com.qjx.design.decorator.example1;

import lombok.extern.slf4j.Slf4j;

/**
 * 现在的选手都打感情牌，唱完歌后，介绍自己有多不幸，什么没爹啦，没娘啦，早年多不幸啊，自己多努力啊……诸如此类，把评委和观众搞得稀里哗啦的，然后评分就蹭蹭地上去了:
 */
@Slf4j
public class CompetitorDecorator3 extends Competitor {

    @Override
    public void sing() {
        this.introduceBackground();
        super.sing();
    }

    /**
     * 介绍自己的背景
     */
    private void introduceBackground() {
        log.info("悲惨背景介绍，博取同情，赢感情牌....");
    }
}
