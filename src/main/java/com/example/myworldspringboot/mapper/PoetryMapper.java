package com.example.myworldspringboot.mapper;

import com.example.myworldspringboot.entity.Poetry;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PoetryMapper {
    //查询所有诗
    List<Poetry> findAllPoetry();
}
