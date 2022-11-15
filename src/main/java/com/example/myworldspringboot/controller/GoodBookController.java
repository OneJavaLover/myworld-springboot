package com.example.myworldspringboot.controller;

import com.example.myworldspringboot.entity.GoodBook;
import com.example.myworldspringboot.result.Result;
import com.example.myworldspringboot.result.ResultFactory;
import com.example.myworldspringboot.service.GoodBookService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@RequestMapping("/api/goodBook")
@RequestMapping("/goodBook")
public class GoodBookController {
    @Autowired
    GoodBookService goodBookService;
    //获取书的信息并分组
    @GetMapping("/findBookInfoAndGroup")
    public Result findBookInfoAndGroup(){
        List<GoodBook> list = goodBookService.findBookInfoAndGroup();
        return ResultFactory.buildSuccessResult(list);
    }
    //根据书名获取笔记
    @GetMapping("/findSentenceByBookName")
    public Result findSentenceByBookName(@RequestParam("bookName")String bookName){
        List<String> sentences = goodBookService.findSentenceByBookName(bookName);
        return ResultFactory.buildSuccessResult(sentences);
    }
    //查找书名并去重
    @GetMapping("/findBookNameAndDistinct")
    public Result findBookNameAndDistinct(){
        List<String> bookNames = goodBookService.findBookNameAndDistinct();
        return ResultFactory.buildSuccessResult(bookNames);
    }
    //查找书名和作者名并去重
    @GetMapping("/findBookNameAndAuthNameAndDistinct")
    public Result findBookNameAndAuthNameAndDistinct(){
        List<GoodBook> bookAndAuthNames = goodBookService.findBookNameAndAuthNameAndDistinct();
        return ResultFactory.buildSuccessResult(bookAndAuthNames);
    }
    //插入新句子
    @GetMapping("/insertNewSentence")
    public Result insertNewSentence(@RequestParam("bookName")String bookName, @RequestParam("authName")String authName,
                                    @RequestParam("sentence")String sentence){
        goodBookService.insertNewSentence(bookName, authName, sentence);
        return ResultFactory.buildSuccessResult("成功");
    }
}
