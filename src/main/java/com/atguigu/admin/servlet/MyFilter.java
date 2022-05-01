package com.atguigu.admin.servlet;


import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * 过滤器
 * @author Su
 * @create 2022-04-30 2:43
 */
@Slf4j
//@WebFilter(urlPatterns = {"/css/*","/images/*"})//单*是Servlet写法,双*是Spring写法
public class MyFilter  implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
            log.info("MyFilter初始化完成");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        log.info("MyFilter工作");
        chain.doFilter(request,response);
    }

    @Override
    public void destroy() {
        log.info("MyFilter销毁");
    }
}
