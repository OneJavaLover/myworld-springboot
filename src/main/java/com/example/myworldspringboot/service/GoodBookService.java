package com.example.myworldspringboot.service;

import com.example.myworldspringboot.entity.GoodBook;
import com.example.myworldspringboot.mapper.GoodBookMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GoodBookService {
    @Autowired
    GoodBookMapper goodBookMapper;

    //获取书的信息并分组
    public List<GoodBook> findBookInfoAndGroup(){
        List<GoodBook> allInfoList = new ArrayList<GoodBook>();
        List<GoodBook> bookNameList = new ArrayList<GoodBook>();
        List<String> sentenceList = new ArrayList();
        bookNameList = goodBookMapper.findBookNameAndAuthNameAndDistinct();
        for (GoodBook book:bookNameList){
            GoodBook goodBook = new GoodBook();
            String bookName = book.getBookName();
            sentenceList = goodBookMapper.findSentenceByName(bookName);
            goodBook.setBookName(bookName);
            goodBook.setAuthName(book.getAuthName());
            goodBook.setSentenceList(sentenceList);
            allInfoList.add(goodBook);
        }
        return allInfoList;
    }
    //根据书名获取笔记
    public List<String> findSentenceByBookName(String bookName){
        return goodBookMapper.findSentenceByName(bookName);
    }
    //查找书名并去重
    public List<String> findBookNameAndDistinct(){
        return goodBookMapper.findBookNameAndDistinct();
    }
    //查找书名和作者名并去重
    public List<GoodBook> findBookNameAndAuthNameAndDistinct(){
        return goodBookMapper.findBookNameAndAuthNameAndDistinct();
    }
    //插入新句子
    public void insertNewSentence(String bookName, String authName, String sentence){
        goodBookMapper.insertNewSentence(bookName, authName, sentence);
    }
}
