package com.example.myworldspringboot;

import com.example.myworldspringboot.service.EditorContentService;
import com.example.myworldspringboot.service.GoodBookService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.ParseException;

@SpringBootTest
class MyworldSpringbootApplicationTests {
    @Autowired
    EditorContentService editorContentService;
    @Autowired
    GoodBookService goodBookService;
    @Test
    void contextLoads() {
    }

    @Test
    void test(){
        goodBookService.findBookInfoAndGroup();
    }
}
