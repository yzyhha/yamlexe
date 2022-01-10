package com.wsy.yamlexe.config;

import org.springframework.web.servlet.LocaleResolver;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

public class MyLocaleResolver implements LocaleResolver {
    @Override
    public Locale resolveLocale(HttpServletRequest request) {
//        获取请求中的语言参数
        String language = request.getParameter("l");
//如果没有就调用默认的·
        Locale locale = Locale.getDefault();
//判断请求是否为携带了国际化的参数
        if (!StringUtils.isEmpty(language)) {
//            定义字符串组用于接收：zh_CN
            String[] split = language.split("_");
//            获取字符串组中的国家，语言
           locale = new Locale(split[0],split[1]);
        }
        return locale;
    }

    @Override
    public void setLocale(HttpServletRequest request, HttpServletResponse response, Locale locale) {

    }
}
