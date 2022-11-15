package com.example.myworldspringboot.service;

import com.example.myworldspringboot.entity.EditorContent;
import com.example.myworldspringboot.mapper.EditorContentMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class EditorContentService {
    @Autowired
    EditorContentMapper editorContentMapper;

    //保存正在编辑的文章
    public void saveContent(String editorTitle, String editorInfo,int state,String bgImg,String coverImg) throws ParseException {
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        String date1 = simpleDateFormat.format(date);
        Date startTime = simpleDateFormat.parse(date1);
        Date updateTime = simpleDateFormat.parse(date1);
        editorContentMapper.saveContent(editorTitle,editorInfo,startTime,updateTime,state,bgImg,coverImg);
    }

    //获取所有正在编辑的文章的信息
    public List<EditorContent> getAllContent(){
        return editorContentMapper.getAllContent();
    }

    //更新正在编辑的文章的内容
    public void updateEditorContent(String editorTitle,String editorInfo,int editorId,String bgImg,String coverImg) throws ParseException {
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        String date1 = simpleDateFormat.format(date);
        Date updateTime = simpleDateFormat.parse(date1);
        editorContentMapper.updateEditorContent(editorTitle,editorInfo,updateTime,editorId,bgImg,coverImg);
    }

    //发布文章
    public void publishContent(String editorTitle,String editorInfo,String bgImg,String coverImg) throws ParseException {
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        String date1 = simpleDateFormat.format(date);
        Date createTime = simpleDateFormat.parse(date1);
        editorContentMapper.publishContent(editorTitle,editorInfo,createTime,bgImg,coverImg);
    }
}
