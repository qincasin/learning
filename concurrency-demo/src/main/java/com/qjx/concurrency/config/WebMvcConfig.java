package com.qjx.concurrency.config;

import com.qjx.concurrency.filer.HttpFilter;
import com.qjx.concurrency.interceptor.HttpInterceptor;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@Configuration
public class WebMvcConfig extends WebMvcConfigurationSupport {

    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new HttpInterceptor()).addPathPatterns("/**");
    }

    @Bean
    public FilterRegistrationBean httpFilter(){
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        registrationBean.setFilter(filter());
        registrationBean.addUrlPatterns("/threadLocal/*");
        return registrationBean;
    }

    @Bean
    public HttpFilter filter(){
        return new HttpFilter();
    }

}
