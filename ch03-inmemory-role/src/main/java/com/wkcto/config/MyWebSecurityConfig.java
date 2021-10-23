package com.wkcto.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
/**
*   @author wsq
*   @Date 2021/10/18 14:27
*   @Description   @EnableGlobalMethodSecurity启动方法级别认证
 *    prePostEnabled属性默认是false
 *    true表示可以使用@PreAuthorize @PostAuthorize
*/
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class MyWebSecurityConfig extends WebSecurityConfigurerAdapter {

    //在方法中配置用户和密码信息作为用户登陆的数据
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        PasswordEncoder pe = passwordEncoder();
        //定义两个角色 normal admin
        auth.inMemoryAuthentication()
                .withUser("wsq")
                .password(pe.encode("123456")).roles("normal");
        auth.inMemoryAuthentication()
                .withUser("wff")
                .password(pe.encode("123456")).roles("normal");
        auth.inMemoryAuthentication()
                .withUser("cd")
                .password(pe.encode("123456")).roles("normal","admin");
    }
    @Bean
    public PasswordEncoder passwordEncoder(){
           return new BCryptPasswordEncoder();

    }
}
