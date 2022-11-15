package com.example.myworldspringboot.service;

import com.example.myworldspringboot.entity.Poetry;
import com.example.myworldspringboot.mapper.PoetryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PoetryService {
    @Autowired
    PoetryMapper poetryMapper;

    //查找所有诗
    public List<Poetry> findAllPoetry(){
        return poetryMapper.findAllPoetry();
    }
}
