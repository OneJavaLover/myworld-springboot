package com.example.myworldspringboot.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

//编辑中的文章
@Data
public class EditorContent {
    private int editorId;
    private String editorTitle;
    private String editorInfo;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm",timezone = "GMT+8")
    private Date startTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm",timezone = "GMT+8")
    private Date updateTime;
    private int state;
    private String bgImg;
    private String coverImg;

    public EditorContent() {
    }

    public EditorContent(int editorId, String editorTitle, String editorInfo, Date startTime, Date updateTime, int state, String bgImg, String coverImg) {
        this.editorId = editorId;
        this.editorTitle = editorTitle;
        this.editorInfo = editorInfo;
        this.startTime = startTime;
        this.updateTime = updateTime;
        this.state = state;
        this.bgImg = bgImg;
        this.coverImg = coverImg;
    }
}
