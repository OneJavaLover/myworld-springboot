package com.example.myworldspringboot.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContentData {
    private int id;
    private String bgImg;
    private String contentTitle;
    private String contentInfo;
    //日期时间返回的格式规定
    @JsonFormat(pattern="yyyy-MM-dd HH:mm",timezone="GMT+8")
    private Date createTime;
    private String coverImg;
    private int readVolume;
}
