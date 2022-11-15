package com.example.myworldspringboot.mapper;

import com.example.myworldspringboot.entity.EditorContent;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

@Mapper
public interface EditorContentMapper {
    //保存正在编辑的文章(新增)
    void saveContent(@Param("editorTitle") String editorTitle,
                     @Param("editorInfo") String editorInfo,
                     @Param("startTime") Date startTime,
                     @Param("updateTime") Date updateTime,
                     @Param("state") int state,
                     @Param("bgImg") String bgImg,
                     @Param("coverImg") String coverImg);

    //获取所有正在编辑的文章的信息
    List<EditorContent> getAllContent();

    //获取所有正在更新的文章的信息
    List<EditorContent> getUpdateContent();

    //获取所有已经发布的文章的信息
    List<EditorContent> getPublishContent();

    //更新正在编辑的文章的内容
    void updateEditorContent(@Param("editorTitle") String editorTitle,
                             @Param("editorInfo") String editorInfo,
                             @Param("updateTime") Date updateTime,
                             @Param("editorId") int editorId,
                             @Param("bgImg") String bgImg,
                             @Param("coverImg") String coverImg);

    //发布文章
    void publishContent(@Param("editorTitle") String editorTitle,
                        @Param("editorInfo") String editorInfo,
                        @Param("publishTime") Date publishTime,
                        @Param("bgImg") String bgImg,
                        @Param("coverImg") String coverImg);
}
