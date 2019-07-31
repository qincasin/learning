package com.qjx.design.decorator.example1;

import lombok.extern.slf4j.Slf4j;

/**
 * 舞蹈修饰类
 */
@Slf4j
public class CompetitorDecoratorA extends CompetitorDecorator {
    public CompetitorDecoratorA(Competitor competitor) {
        super(competitor);
    }

    @Override
    public void sing() {
        this.dance();
        super.sing();
    }

    private void dance() {
        log.info("跳舞:翩翩起舞...");
    }
}
