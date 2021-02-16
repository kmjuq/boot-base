package com.kmjuq.bootbase.exception;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * <p>
 *
 * </p>
 *
 * @author mengjian.ke@hand-china.com 2020/11/20 15:17
 */
@Setter
@Getter
@ToString
public abstract class AppException extends RuntimeException {

    // 异常代码
    private String code;
    // 异常信息
    private String message;

    public AppException(){ }

    public AppException(String code,String message){
        this.code = code;
        this.message = message;
    }

    public AppException(AppExceptionEnum appExceptionEnum) {
        this.code = appExceptionEnum.getCode();
        this.message = appExceptionEnum.getMessage();
    }

}
