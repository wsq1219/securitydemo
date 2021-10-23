package com.wkcto.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/hello")
@RestController
public class HelloSecurityController {

    @RequestMapping("/world")
    public String sayHello(){
        return "Hello SpringSecurity 安全管理框架";
    }

}
