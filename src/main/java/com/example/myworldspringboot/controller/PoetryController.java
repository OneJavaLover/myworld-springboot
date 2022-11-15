package com.example.myworldspringboot.controller;

import com.example.myworldspringboot.entity.Poetry;
import com.example.myworldspringboot.result.Result;
import com.example.myworldspringboot.result.ResultFactory;
import com.example.myworldspringboot.service.PoetryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
//@RequestMapping("/api/poetry")
@RequestMapping("/poetry")
public class PoetryController {
    @Autowired
    PoetryService poetryService;

    @GetMapping("/findAllPoetry")
    //获取所有诗
    public Result findAllPoetry(){
        List<Poetry> list = poetryService.findAllPoetry();
        return ResultFactory.buildSuccessResult(list);
    }
}
