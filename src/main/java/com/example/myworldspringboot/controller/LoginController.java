package com.example.myworldspringboot.controller;

import com.example.myworldspringboot.entity.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
//@RequestMapping("/api")
public class LoginController {
    @PostMapping("/myController/myLogin")
    public int login(@RequestParam("userName") String userName, @RequestParam("userPassword") String userPassword){
        Subject subject = SecurityUtils.getSubject();
        AuthenticationToken token = new UsernamePasswordToken(userName,userPassword);
        try {
            subject.login(token);
            System.out.println("登录成功");
            return 1;
        }catch (AuthenticationException e){
            e.printStackTrace();
            System.out.println("登录失败");
            return 0;
        }
    }

    @GetMapping("/authentication")
    public String authentication(){
        return "认证成功";
    }
}
