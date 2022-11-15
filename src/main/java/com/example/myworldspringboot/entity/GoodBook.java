package com.example.myworldspringboot.entity;

import lombok.Data;

import java.util.List;

@Data
public class GoodBook {
    private int id;
    private String bookName;
    private String authName;
    private String sentence;

    private List<String> sentenceList;

    public GoodBook() {
    }

    public GoodBook(int id, String bookName, String authName, String sentence) {
        this.id = id;
        this.bookName = bookName;
        this.authName = authName;
        this.sentence = sentence;
    }

    @Override
    public String toString() {
        return "GoodBook{" +
                "id=" + id +
                ", bookName='" + bookName + '\'' +
                ", authName='" + authName + '\'' +
                ", sentence='" + sentence + '\'' +
                ", sentenceList=" + sentenceList +
                '}';
    }
}
