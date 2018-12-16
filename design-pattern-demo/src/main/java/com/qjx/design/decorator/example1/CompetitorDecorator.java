package com.qjx.design.decorator.example1;

/**
 * 一个类要要动态绑定某个对象的行为，是持有相应的对象引用，然后在运行时根据这个引用绑定的具体对象，体现出不同的行为，这个就是动态绑定。
 * 依照上面定义的规则，我们可以通过下面来实现，定义一个Decorator类，持有一个Competitor对象，只有当运行的时候动态绑定到sing() 方法。然后在这个sing() 方法的基础上进行装饰，加入相应的辅助、增强功能。
 */
public class CompetitorDecorator extends Competitor{

    private Competitor competitor;

    public CompetitorDecorator(Competitor competitor){
        this.competitor = competitor;
    }

    @Override
    public void sing() {
        competitor.sing();
    }
}
