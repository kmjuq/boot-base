package com.kmjuq.bootbase.mvc;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/**
 * 封装返回 ResponseEntity
 */
public class Results {

    private Results() {
    }

    /**
     * 请求成功
     *
     * @param data 返回值
     * @return HttpStatus 200
     */
    public static <T> ResponseEntity<AppResponseResult<T>> success(T data) {
        return Results.newResult(data,HttpStatus.OK);
    }

    /**
     * 请求失败
     */
    public static <T> ResponseEntity<AppResponseResult<T>> error(T data) {
        return Results.newResult(data,HttpStatus.INTERNAL_SERVER_ERROR);
    }

    /**
     * 请求成功，抛出异常
     */
    public static ResponseEntity<AppResponseResult<?>> exception(AppResponseResult<?> appResponseResult) {
        return Results.newResult(appResponseResult,HttpStatus.INTERNAL_SERVER_ERROR);
    }

    public static ResponseEntity<AppResponseResult<?>> newResult(AppResponseResult<?> appResponseResult,
                                                                 HttpHeaders httpHeaders,
                                                                 HttpStatus httpStatus){
        return new ResponseEntity<>(appResponseResult,httpHeaders,httpStatus);
    }

    public static ResponseEntity<AppResponseResult<?>> newResult(AppResponseResult<?> appResponseResult, HttpStatus httpStatus) {
        return new ResponseEntity<>(appResponseResult, httpStatus);
    }

    public static <T> ResponseEntity<AppResponseResult<T>> newResult(HttpStatus httpStatus) {
        return new ResponseEntity<>(httpStatus);
    }

    public static <T> ResponseEntity<AppResponseResult<T>> newResult(HttpHeaders httpHeaders, HttpStatus httpStatus) {
        return new ResponseEntity<>(httpHeaders, httpStatus);
    }

    public static <T> ResponseEntity<AppResponseResult<T>> newResult(T data, HttpStatus httpStatus) {
        return new ResponseEntity<>(new AppResponseResult<>(data), httpStatus);
    }

    public static <T> ResponseEntity<AppResponseResult<T>> newResult(T data, HttpHeaders httpHeaders, HttpStatus httpStatus) {
        return new ResponseEntity<>(new AppResponseResult<>(data), httpHeaders, httpStatus);
    }

}
