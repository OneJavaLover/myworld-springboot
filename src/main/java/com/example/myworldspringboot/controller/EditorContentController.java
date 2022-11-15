package com.example.myworldspringboot.controller;

import com.example.myworldspringboot.entity.EditorContent;
import com.example.myworldspringboot.result.Result;
import com.example.myworldspringboot.result.ResultFactory;
import com.example.myworldspringboot.service.EditorContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping("/Editor")
//@RequestMapping("/api/Editor")
public class EditorContentController {
    @Autowired
    EditorContentService editorContentService;

    @GetMapping("/saveContent")
    @CrossOrigin(allowCredentials = "true")
    //保存正在编辑的文章
    public Result saveContent(@RequestParam("editorTitle") String editorTitle, @RequestParam("editorInfo") String editorInfo,
                            @RequestParam("state") int state, @RequestParam("bgImg") String bgImg,
                            @RequestParam("coverImg") String coverImg) throws ParseException {
        editorContentService.saveContent(editorTitle,editorInfo,state,bgImg,coverImg);
        return ResultFactory.buildSuccessResult(0);
    }
    @PostMapping("/getAllContent")
    @CrossOrigin(allowCredentials = "true")
    //获取所有正在编辑的文章的信息
    public List<EditorContent> getAllContent(){
        return editorContentService.getAllContent();
    }
    @GetMapping("/updateEditorContent")
    @CrossOrigin(allowCredentials = "true")
    //更新正在编辑的文章的内容
    public Result updateEditorContent(@RequestParam("editorTitle") String editorTitle, @RequestParam("editorInfo") String editorInfo,
                                    @RequestParam("editorId") int editorId, @RequestParam("bgImg") String bgImg,
                                    @RequestParam("coverImg") String coverImg) throws ParseException {
        editorContentService.updateEditorContent(editorTitle,editorInfo,editorId,bgImg,coverImg);
        return ResultFactory.buildSuccessResult(0);
    }
    @GetMapping("/publishContent")
    @CrossOrigin(allowCredentials = "true")
    //发布文章
    public Result publishContent(@RequestParam("editorTitle")String editorTitle, @RequestParam("editorInfo") String editorInfo,
                                 @RequestParam("bgImg")String bgImg, @RequestParam("coverImg") String coverImg) throws ParseException {
        editorContentService.publishContent(editorTitle,editorInfo,bgImg,coverImg);
        return ResultFactory.buildSuccessResult("成功");
    }
}
