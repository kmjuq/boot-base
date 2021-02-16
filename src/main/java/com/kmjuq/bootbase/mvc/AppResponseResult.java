package com.kmjuq.bootbase.mvc;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.kmjuq.bootbase.exception.AppException;
import com.kmjuq.bootbase.exception.AppExceptionEnum;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * 封装返回结果
 */
@Setter
@Getter
@Accessors(chain = true)
public class AppResponseResult<T> {

    // 是否出现异常
    private Boolean success = Boolean.TRUE;
    // 异常代码
    private String code = "200";
    // 异常信息
    private String message = "请求成功";
    // 数据
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private T data = null;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String exception;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String trace;

    public AppResponseResult(T data) {
        this.data = data;
    }

    public AppResponseResult(){ }

    public static <T> AppResponseResult<T> exception(AppException ex) {
        final AppResponseResult<T> appResponseResult = new AppResponseResult<>();
        appResponseResult.setSuccess(Boolean.FALSE);
        appResponseResult.setCode(ex.getCode());
        appResponseResult.setMessage(ex.getMessage());
        return getAppExceptionResponse(ex, appResponseResult);
    }

    public static <T> AppResponseResult<T> exception(Exception ex) {
        final AppResponseResult<T> appResponseResult = new AppResponseResult<>();
        appResponseResult.setSuccess(Boolean.FALSE);
        appResponseResult.setCode(AppExceptionEnum.INTERNAL_SERVER_ERROR.getCode());
        appResponseResult.setMessage(AppExceptionEnum.INTERNAL_SERVER_ERROR.getMessage());
        return getAppExceptionResponse(ex, appResponseResult);
    }

    public static <T> AppResponseResult<T> exception(Exception ex, AppExceptionEnum appExceptionEnum) {
        return exception(ex,appExceptionEnum.getCode(),appExceptionEnum.getMessage());
    }

    public static <T> AppResponseResult<T> exception(Exception ex, String code,String message) {
        final AppResponseResult<T> appResponseResult = new AppResponseResult<>();
        appResponseResult.setSuccess(Boolean.FALSE);
        appResponseResult.setCode(code);
        appResponseResult.setMessage(message);
        return getAppExceptionResponse(ex, appResponseResult);
    }

    private static <T> AppResponseResult<T> getAppExceptionResponse(Exception ex, AppResponseResult<T> appResponseResult) {
        appResponseResult.setException(ex.getMessage());
        appResponseResult.setTrace(traceMsg(ex));
        return appResponseResult;
    }

    private static String traceMsg(Exception ex){
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        ex.printStackTrace(pw);
        return sw.toString();
    }

}
