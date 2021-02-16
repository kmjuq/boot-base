package com.kmjuq.bootbase.mvc;

import com.kmjuq.bootbase.exception.AppException;
import com.kmjuq.bootbase.exception.AppExceptionEnum;
import lombok.extern.slf4j.Slf4j;
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
public class AppControllerAdvice {

    // 全局异常拦截
    @ExceptionHandler(Exception.class)
    public ResponseEntity<AppResponseResult<?>> exceptionHandler(Exception exception) {
        return Results.exception(AppResponseResult.exception(exception,AppExceptionEnum.INTERNAL_SERVER_ERROR));
    }

    // 应用异常拦截
    @ExceptionHandler(AppException.class)
    public ResponseEntity<AppResponseResult<?>> appExceptionHandler(AppException exception) {
        return Results.exception(AppResponseResult.exception(exception));
    }

    // 添加 hibernate validator
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<AppResponseResult<?>> methodArgumentNotValidExceptionHandler(MethodArgumentNotValidException exception) {
        StringBuilder errorMsg = new StringBuilder();
        exception.getBindingResult().getAllErrors().forEach(error -> {
            errorMsg.append(error.getDefaultMessage()).append(";");
        });
        return Results.exception(AppResponseResult.exception(exception,AppExceptionEnum.METHOD_ARGUMENT_NOT_VALID_EXCEPTION.getCode(),errorMsg.toString()));
    }

}
