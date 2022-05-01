package com.atguigu.admin.config;

import com.atguigu.admin.iterceptor.LoginInterceptor;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcRegistrations;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

/**
 * 1.编写一个拦截器实现HandlerInterceptor接口
 * 2.拦截器注册到容器中(实现WebMvcConfigurer方法)
 * 3.指定拦截规则{如果是拦截所有,静态资源也会被拦截}
 * @EnableWebMvc:全面接管MVC
 *          1.静态资源?视图解析器?欢迎页...全部失效
 * @author Su
 * @create 2022-04-29 11:15
 */
//@EnableWebMvc
@Configuration
public class AdminWebConfig implements WebMvcConfigurer {





    /**
     * 添加拦截器
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor())
                .addPathPatterns("/**") //拦截请求都被拦截包括静态资源
                .excludePathPatterns("/","/login","/css/**","/fonts/**","/images/**","/js/**");//放行"/","/login"页面
    }

//    @Bean
//    public WebMvcRegistrations webMvcRegistrations(){
//        return new WebMvcRegistrations() {
//            @Override
//            public RequestMappingHandlerMapping getRequestMappingHandlerMapping() {
//                return null;
//            }
//        };
//    }




}










