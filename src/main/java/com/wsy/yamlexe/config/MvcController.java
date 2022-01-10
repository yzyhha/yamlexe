package com.wsy.yamlexe.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcController implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/index.html").setViewName("index");
        registry.addViewController("/main.html").setViewName("dashboard");

    }
//    自定义的国际化组件
    @Bean
    public LocaleResolver localeResolver(){
        return new MyLocaleResolver();
    }

//    拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
//      addPathPatterns拦截的路径,excludePathPatterns不需要拦截的路径
        registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**").excludePathPatterns("/index.html","/","/user/login",
                "/css/**","/js/**","/img/**");
    }
}
