package com.kmjuq.bootbase.http;

import com.kmjuq.bootbase.exception.AppException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.HandlerMethod;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 *
 * </p>
 *
 * @author mengjian.ke@hand-china.com 2020/11/20 14:55
 */
@Slf4j
@RestControllerAdvice
public class BaseControllerAdvice {

    // 全局异常拦截
    @ExceptionHandler(Exception.class)
    public ResponseEntity<AppExceptionResponse> exceptionHandler(Exception exception) {
        final AppExceptionResponse ber = new AppExceptionResponse();
        return Results.error(ber);
    }

    // 应用异常拦截
    @ExceptionHandler(AppException.class)
    public ResponseEntity<AppExceptionResponse> appExceptionHandler(AppException exception) {
        final AppExceptionResponse ber = new AppExceptionResponse();
        return Results.error(ber);
    }

    // 添加 hibernate validator
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<AppExceptionResponse> methodArgumentNotValidExceptionHandler(MethodArgumentNotValidException exception) {
        final AppExceptionResponse ber = new AppExceptionResponse();
        return Results.error(ber);
    }






}
