package com.wtcto.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class MyWebSecurityConfig extends WebSecurityConfigurerAdapter {

    //在方法中配置用户和密码信息作为用户登陆的数据
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        PasswordEncoder pe = passwordEncoder();
        auth.inMemoryAuthentication()
                .withUser("wsq")
                .password(pe.encode("123456")).roles();
        auth.inMemoryAuthentication()
                .withUser("wff")
                .password(pe.encode("123456")).roles();
    }
    @Bean
    public PasswordEncoder passwordEncoder(){
           return new BCryptPasswordEncoder();
    }
}
