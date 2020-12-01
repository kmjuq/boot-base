package com.kmjuq.bootbase.http;

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
    public static <T> ResponseEntity<T> success(T data) {
        return ResponseEntity.ok(data);
    }

    /**
     * 请求成功,但是抛出异常
     *
     * @param data 返回值
     * @return HttpStatus 200
     */
    public static <T> ResponseEntity<T> error(T data) {
        return ResponseEntity.ok(data);
    }

    /**
     * 自定义Http返回
     */
    public static <T> ResponseEntity<T> newResult(HttpStatus httpStatus) {
        return newResult(null, null, httpStatus);
    }

    public static <T> ResponseEntity<T> newResult(T data) {
        return newResult(data, null, HttpStatus.OK);
    }

    public static <T> ResponseEntity<T> newResult(HttpHeaders httpHeaders, HttpStatus httpStatus) {
        return newResult(null, httpHeaders, httpStatus);
    }

    public static <T> ResponseEntity<T> newResult(T data, HttpStatus httpStatus) {
        return newResult(data, null, httpStatus);
    }

    public static <T> ResponseEntity<T> newResult(T data, HttpHeaders httpHeaders, HttpStatus httpStatus) {
        return new ResponseEntity<>(data, httpHeaders, httpStatus);
    }

}
