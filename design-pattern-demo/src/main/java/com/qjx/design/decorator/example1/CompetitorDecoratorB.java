package com.qjx.design.decorator.example1;

import lombok.extern.slf4j.Slf4j;

/**
 * 伴奏修饰类：
 */
@Slf4j
public class CompetitorDecoratorB extends CompetitorDecorator{
    public CompetitorDecoratorB(Competitor competitor) {
        super(competitor);
    }

    @Override
    public void sing() {
        this.playMusic();
        super.sing();
    }

    /**
     * 背景音乐
     */
    private void playMusic() {
        log.info("背景音乐:播放背景音乐...");
    }
}
