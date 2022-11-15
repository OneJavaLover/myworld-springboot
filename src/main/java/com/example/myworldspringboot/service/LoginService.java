package com.example.myworldspringboot.service;

import com.example.myworldspringboot.entity.User;
import com.example.myworldspringboot.mapper.LoginMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
    @Autowired
    LoginMapper loginMapper;

    public User getPasswordByName(String user){
        return loginMapper.getPasswordByName(user);
    }
}
