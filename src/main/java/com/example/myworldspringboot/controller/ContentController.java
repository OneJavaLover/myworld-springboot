package com.example.myworldspringboot.controller;

import com.example.myworldspringboot.entity.ContentData;
import com.example.myworldspringboot.mapper.ContentMapper;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import java.util.List;

@RestController
//@RequestMapping("/api/Content")
@RequestMapping("/Content")
public class ContentController {
    @Resource
    ContentMapper contentMapper;
    //保存词条，文章标题，文章内容
    @CrossOrigin(origins ="*",maxAge = 3600)
    @GetMapping("/setContent")
    public void findContent(@RequestParam("entryName") String entryName, @RequestParam("contentTitle") String contentTitle,
                            @RequestParam("contentInfo") String contentInfo){
        contentMapper.save(entryName,contentTitle,contentInfo);
    }
//    //搜索用于展示的表格，分页查询文章的标题等展示
//    @CrossOrigin(origins = "*", maxAge = 3600)
//    @GetMapping("/SelectContentList")
//    public EntryList findContent(@RequestParam("currentPage") int currentPage, @RequestParam("pageSize") int pageSize, @RequestParam("searchValue") String searchValue,@RequestParam("entryName") String entryName) {
//        if (searchValue == "") {
//            //判断：如果searchValue内为空，代表输入框没有输入值，那就正常查询所有表格数据返回
//            //当前页
//            int cuIndex = (currentPage - 1) * pageSize;
//            //调用数据库的方法返回的表格数据用数组保存
//            List list = contentMapper.ContentAll(cuIndex, pageSize, searchValue,entryName);
//            //存下当前页
//            int currentPageIndex = currentPage;
//            //存下每页数
//            int pageSizeIndex = pageSize;
//            //调用数据库表格总数方法返回的值存下来
//            int totalIndex = contentMapper.ContentIndex();
//            //new出要返回给前端的对象，不new出对象无法往里面赋值
//            EntryList entryList = new EntryList();
//            //往对象内list添加表格数据
//            entryList.setList(list);
//            //把当前页赋值进去
//            entryList.setCurrentPage(currentPageIndex);
//            //把每页数赋值进去
//            entryList.setPageSize(pageSizeIndex);
//            //把总数赋值进去
//            entryList.setTotal(totalIndex);
//            //对象的数据上面赋值都拿到了，返回整个对象给前端
//            return entryList;
//        } else {
//            //在搜索框输入了值就走这边。
//
//            //当前页
//            int cuIndex = (currentPage - 1) * pageSize;
//            //调用数据库的方法返回的表格数据用数组保存
//            List list = contentMapper.ContentAll(cuIndex, pageSize, searchValue,entryName);
//            //存下当前页
//            int currentPageIndex = currentPage;
//            //存下每页数
//            int pageSizeIndex = pageSize;
//            //调用数据库表格总数方法返回的值存下来，这里专门调用的查询对应条件的总数方法
//            int totalIndex = contentMapper.ContentSearchIndex(searchValue);
//            //new出要返回给前端的对象，不new出对象无法往里面赋值
//            EntryList entryList = new EntryList();
//            //往对象内list添加表格数据
//            entryList.setList(list);
//            //把当前页赋值进去
//            entryList.setCurrentPage(currentPageIndex);
//            //把每页数赋值进去
//            entryList.setPageSize(pageSizeIndex);
//            //把总数赋值进去
//            entryList.setTotal(totalIndex);
//            //对象的数据上面赋值都拿到了，返回整个对象给前端
//            return entryList;
//        }
//    }
    //根据id查询对应文章
    @CrossOrigin(allowCredentials = "true", maxAge = 3600)
    @GetMapping("/searchContentId")
    public ContentData searchContent(@RequestParam("id") Long id){
        return contentMapper.searchById(id);
    }

    //获取所有文章信息
    @CrossOrigin(allowCredentials = "true")
    @GetMapping("/getAllArticle")
    public List<ContentData> getAllArticle(){
        System.out.println("被访问了");
        return contentMapper.getAllArticle();
    }

    //根据标题获取文章内容
    @CrossOrigin(allowCredentials = "true")
    @GetMapping("/getContentInfoByContentTitle")
    public String getContentInfoByContentTitle(@RequestParam("contentTitle") String contentTitle){
        return contentMapper.getContentInfoByContentTitle(contentTitle);
    }
}


