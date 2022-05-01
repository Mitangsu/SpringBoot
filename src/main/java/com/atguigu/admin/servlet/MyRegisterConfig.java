package com.atguigu.admin.servlet;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

/**
 * 1.MyServlet --> /my
 * 2.DispatcherServlet --> /
 * @author Su
 * @create 2022-04-30 6:22
 */
//(proxyBeanMethods = true) 保证依赖的组件是单实例的
//(proxyBeanMethods = false) 说明当前类每次调用里面的方法就重新创建对象
@Configuration(proxyBeanMethods = true)//more
public class MyRegisterConfig {

    @Bean
    public ServletRegistrationBean myServlet(){
        MyServlet myServlet = new MyServlet();

        return new ServletRegistrationBean(myServlet,"/my","/my02");
    }

    @Bean
    public FilterRegistrationBean myFilter(){

        MyFilter myFilter = new MyFilter();

//        return new FilterRegistrationBean(myFilter,myServlet());
        //创建对象
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean(myFilter);
        //设置拦截地址
        filterRegistrationBean.setUrlPatterns(Arrays.asList("/my","/css/*"));
        return filterRegistrationBean;
    }

    @Bean
    public ServletListenerRegistrationBean myListener(){
        MyServletContextListener listener = new MyServletContextListener();

        return new ServletListenerRegistrationBean(listener);
    }

}










