package com.example.myworldspringboot.mapper;

import com.example.myworldspringboot.entity.ContentData;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface ContentMapper {
    //把知识点的数据存进数据库，参数：词条名，文章标题，文章内容
    @Update("INSERT INTO `content_data`( `bgimg`, `contentTitle`, `contentInfo`) VALUES (#{bgimg},#{contentTitle},#{contentInfo});")
    void save(@Param("bgimg") String entryName, @Param("contentTitle") String contentTitle, @Param("contentInfo") String contentInfo);

    //搜索数据库分页对应数据,搜索数据库模糊查询(这里参数要这么写：like concat('%',#{searchValue},'%'))
    @Select("select * from content_data where contentTitle like concat('%',#{searchValue},'%') and entryName=#{entryName} limit #{currentPage},#{pageSize}")
    List<ContentData> ContentAll(@Param("currentPage") int currentPage, @Param("pageSize") int pageSize,
                                 @Param("searchValue") String searchValue, @Param("entryName") String entryName);

    //搜索数据库数据总条数
    @Select("SELECT count(*) FROM content_data")
    int ContentIndex();

    //搜索数据库数据条件筛选后的总条数
    @Select("select count(*) from content_data where contentTitle like concat('%',#{searchValue},'%')")
    int ContentSearchIndex(@Param("searchValue") String searchValue);

    //根据id查询文章信息
    @Select("select * from contentdata where id=#{id}")
    ContentData searchById(Long id);

    //获取所有文章信息
    @Select("select * from contentdata")
    List<ContentData> getAllArticle();

    //根据文章标题获取文章内容
    @Select("select contentInfo from contentdata where contentTitle=#{contentTitle}")
    String getContentInfoByContentTitle(String contentTitle);
}


