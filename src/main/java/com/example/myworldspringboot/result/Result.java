package com.example.myworldspringboot.result;

import lombok.Data;

@Data
public class Result {
    private int code;
    private String message;
    private Object result;

    public Result(int code, String message, Object result) {
        this.code = code;
        this.message = message;
        this.result = result;
    }
}
