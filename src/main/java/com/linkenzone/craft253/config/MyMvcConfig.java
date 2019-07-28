package com.linkenzone.craft253.config;

import com.linkenzone.craft253.component.LoginHandlerInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyMvcConfig implements WebMvcConfigurer {
    //所有 WebMvcConfigurationSupport 组件都会一起起作用
    @Bean
    public WebMvcConfigurer WebMvcConfigurer() {
        WebMvcConfigurer support = new WebMvcConfigurer() {

            /**
             * 添加视图解析器
             * @param registry
             */
            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
//                super.addViewControllers(registry);
                registry.addViewController("/").setViewName("index");
                registry.addViewController("/index.html").setViewName("index");
                registry.addViewController("/introduce.html").setViewName("introduce");
//                registry.addViewController("/index.html").setViewName("login");
//                registry.addViewController("/main.html").setViewName("dashboard");
            }

            /**
             * 创建拦截器
             * @param registry
             */
            @Override
            public void addInterceptors(InterceptorRegistry registry) {
             registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/admin/**");
//                        .excludePathPatterns("/index.html","/","/user/login","/webjars/**","/asserts/**");
            }
        };
        return support;
    }
}
