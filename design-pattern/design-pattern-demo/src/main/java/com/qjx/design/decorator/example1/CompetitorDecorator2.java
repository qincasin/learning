package com.qjx.design.decorator.example1;

import lombok.extern.slf4j.Slf4j;

/**
 * 加上舞蹈还不行，还要在唱歌的时候播放合拍的背景音乐：
 */
@Slf4j
public class CompetitorDecorator2  extends Competitor{
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
