package com.qjx.design.decorator.example1;

import lombok.extern.slf4j.Slf4j;

/**
 * 身份介绍类
 */
@Slf4j
public class CompetitorDecoratorC extends CompetitorDecorator {
    public CompetitorDecoratorC(Competitor competitor) {
        super(competitor);
    }

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
