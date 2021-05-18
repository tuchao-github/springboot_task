package com.lagou.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.LocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName MyLocaleResovle.java
 * @Description TODO
 * @createTime 2021年05月18日 21:51:00
 */
@Configuration
public class MyLocaleResovle implements LocaleResolver {

    // 自定义 区域解析方式
    @Override
    public Locale resolveLocale(HttpServletRequest httpServletRequest) {
        //获取页面手动传送的语言参数l ：zh_CN en_US ''
        String l = httpServletRequest.getParameter("l");
        Locale locale= null;
        if (!StringUtils.isEmpty(l)){
            // 如果参数不为空，就根据参数值进行手动语言切换
            String[] s = l.split("_");
            locale = new Locale(s[0],s[1]);
        }else{
            // Accept-Language: zh-CN,zh;q=0.9
            String header = httpServletRequest.getHeader("Accept-Language");
            String[] s = header.split(",")[0].split("-");
            locale = new Locale(s[0],s[1]);
        }
        return locale;
    }

    @Override
    public void setLocale(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Locale locale) {

    }

    /**将自定义的MyLocaleResovle重新注册为一个LocaleResolver的bean组件*/
    @Bean
    public LocaleResolver localeResolver(){
        return new MyLocaleResovle();
    }
}
