package com.jonluo.sso.client;

import com.jonluo.sso.client.Filter.JwtFilter;
import com.jonluo.sso.client.utils.EnvVariable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.embedded.FilterRegistrationBean;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

import java.util.Collections;

@SpringBootApplication
public class WebApplication extends SpringBootServletInitializer {

    @Autowired
    EnvVariable envVariable;

    @Bean
    public FilterRegistrationBean jwtFilter() {
        final FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        registrationBean.setFilter(new JwtFilter(envVariable.getJwtTokenCookieName(),envVariable.getSigningKey()));
        registrationBean.setInitParameters(Collections.singletonMap("services.auth", envVariable.getAuthService()));
        //拦截所有
        registrationBean.addUrlPatterns("/*");
        return registrationBean;
    }
    //war包启动，要继承SpringBootServletInitializer，然后覆盖configure方法
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(WebApplication.class);
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(WebApplication.class, args);
    }
}

