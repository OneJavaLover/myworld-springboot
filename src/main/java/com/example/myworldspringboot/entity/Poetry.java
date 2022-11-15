package com.example.myworldspringboot.entity;

import lombok.Data;

@Data
public class Poetry {
    private int id;
    private String sentence;
    private String comeFrom;

    public Poetry() {
    }

    public Poetry(int id, String sentence, String comeFrom) {
        this.id = id;
        this.sentence = sentence;
        this.comeFrom = comeFrom;
    }
}
