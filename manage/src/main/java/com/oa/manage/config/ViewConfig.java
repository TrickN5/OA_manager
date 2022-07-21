package com.oa.manage.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;
import org.springframework.web.servlet.view.freemarker.FreeMarkerView;
import org.springframework.web.servlet.view.freemarker.FreeMarkerViewResolver;

/**
 * @description: 使用一个普通类作为配置类代替以前的xml配置文件
 */
@Configuration
public class ViewConfig {
    /**
     * jsp视图解析器
     *
     * @Bean的注解的意思等同于<bean class="org.springframework.web.servlet.view.InternalResourceViewResolver">
     * 当前类ViewConfig随着启动类ManageApp会同时被初始化,
     * @Bean注解的方法被自动被调用底层会执行 InternalResourceViewResolver internalResourceViewResolver = new InternalResourceViewResolver()
     * 然后把internalResourceViewResolver对象交给spring管理
     * @Bean 看做是<bean></bean>
     */
    @Bean
    public InternalResourceViewResolver getInternalResourceViewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/jsp/");
        viewResolver.setSuffix(".jsp");
        viewResolver.setOrder(1); //优先级
        return viewResolver;
    }

    /**
     * html视图解析器
     *
     * @return
     */
    @Bean
    public FreeMarkerConfigurer getFreeMarkerConfigurer() {
        FreeMarkerConfigurer configurer = new FreeMarkerConfigurer();
        configurer.setTemplateLoaderPath("/WEB-INF/html/");
        configurer.setDefaultEncoding("utf-8");
        return configurer;
    }

    @Bean
    public FreeMarkerViewResolver getFreeMarkerViewResolver() {
        FreeMarkerViewResolver resolver = new FreeMarkerViewResolver();
        resolver.setViewClass(FreeMarkerView.class);
        resolver.setSuffix(".html");
        resolver.setContentType("text/html;charset=utf-8");
        resolver.setOrder(0);
        return resolver;
    }
}
