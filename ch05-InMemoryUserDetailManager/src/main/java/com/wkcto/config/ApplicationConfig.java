package com.wkcto.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class ApplicationConfig {

    /**
    *   @author wsq
    *   @Date 2021/10/18 19:47
    *   @Description 内存用户管理类
    */
    @Bean
    public UserDetailsService userDetailsService(){
        PasswordEncoder encoder = passwordEncoder();
        InMemoryUserDetailsManager manager =  new InMemoryUserDetailsManager();
        manager.createUser(User.withUsername("wsq").password(encoder.encode("123456")).roles("admin").build());
        return manager;
    }
    /**
    *   @author wsq
    *   @Date 2021/10/18 19:47
    *   @Description 自定义密码加密方式
    */
    @Bean
    public PasswordEncoder passwordEncoder(){
     PasswordEncoder passwordEncoder =new BCryptPasswordEncoder();
     return passwordEncoder;
    }


}
