package com.qjx.dp.strategy.config;

import com.qjx.dp.strategy.service.AbstractHandle;
import com.qjx.dp.strategy.util.BeanTool;

import java.util.Map;

/**
 *
 *
 *
 * @author: qincasin
 * @date: 2019/9/23/ 14:21
 */
public class HandlerContext {
    private Map<String,Class> handlerMap;

    public HandlerContext(Map<String, Class> handlerMap) {
        this.handlerMap = handlerMap;
    }

    public AbstractHandle getInstance(String type){
        Class clazz = handlerMap.get(type);
        if (clazz == null) {
            throw new IllegalArgumentException("输入的参数类型有问题："+type);
        }
        return (AbstractHandle)BeanTool.getBean(clazz);
    }
}
