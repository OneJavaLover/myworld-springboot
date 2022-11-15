package com.example.myworldspringboot.result;

public class ResultFactory {
    //成功返回结果
    public static Result buildSuccessResult(Object data){
        return buildResult(ResultCode.SUCCESS,"成功",data);
    }

    //失败返回原因
    public static Result buildFailResult(String message){
        return buildResult(ResultCode.FAIL,message,null);
    }

    public static Result buildResult(ResultCode resultCode,String message,Object data){
        return buildResult(resultCode.code,message,data);
    }

    public static Result buildResult(int resultCode,String message,Object date){
        return new Result(resultCode,message,date);
    }
}
