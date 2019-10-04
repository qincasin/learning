package com.qjx.dp.strategy.util;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * 封装获取applicationContext的对象类
 *
 *
 * @author: qincasin
 * @date: 2019/9/23/ 15:03
 */
@Component
public class BeanTool implements ApplicationContextAware {


    private static ApplicationContext applicationContext;


    @Override
public void setApplicationContext(ApplicationContext context) {
        if (applicationContext==null){
            applicationContext=context;
        }
    }

    /**通过bean的缩写的方式获取类型
     *
     * @param name
     * @return
     */
    public static Object getBean(String name){
        return applicationContext.getBean(name);
    }

    public static <T> T getBean(Class<T> clazz){
        return applicationContext.getBean(clazz);
    }
}
