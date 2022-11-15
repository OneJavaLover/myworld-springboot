package com.example.myworldspringboot.mapper;

import com.example.myworldspringboot.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface LoginMapper {

    @Select("select user,password from myworld.userinfo where user = #{user}")
    User getPasswordByName(@Param("user") String user);
}
