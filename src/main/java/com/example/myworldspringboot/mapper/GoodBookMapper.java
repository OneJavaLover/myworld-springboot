package com.example.myworldspringboot.mapper;

import com.example.myworldspringboot.entity.GoodBook;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface GoodBookMapper {
    //按照书名查找句子
    List<String> findSentenceByName(@Param("bookName")String bookName);
    //查找书名和作者名并去重
    List<GoodBook> findBookNameAndAuthNameAndDistinct();
    //查找书名并去重
    List<String> findBookNameAndDistinct();
    //插入新句子
    void insertNewSentence(@Param("bookName")String bookName,
                           @Param("authName")String authName,
                           @Param("sentence")String sentence);
}
