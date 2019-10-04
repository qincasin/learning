package com.qjx.dp.strategy.config;

import com.google.common.collect.Maps;
import com.qjx.dp.strategy.annotation.HandlerType;
import com.qjx.dp.strategy.util.ClassScaner;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 *
 *
 *
 * @author: qincasin
 * @date: 2019/9/23/ 13:56
 */
@Component
public class HandlerProcessor implements BeanFactoryPostProcessor {

    private static final String HANDLER_PACKAGE = "com.qjx.dp.strategy.service.impl";

    /**
     * 扫描handler type 初始化handlerContext ，将其注入到spring bean容器中
     * @param configurableListableBeanFactory
     * @throws BeansException
     */
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {
        Map<String,Class>  handlerMap = Maps.newHashMapWithExpectedSize(3);

        ClassScaner.scan(HANDLER_PACKAGE, HandlerType.class).forEach(clazz->{
            String type = clazz.getAnnotation(HandlerType.class).value();
            handlerMap.put(type,clazz);
        });
        HandlerContext context = new HandlerContext(handlerMap);
        configurableListableBeanFactory.registerSingleton(HandlerContext.class.getName(),context);



    }
}
