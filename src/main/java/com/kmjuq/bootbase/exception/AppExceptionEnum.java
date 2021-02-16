package com.kmjuq.bootbase.exception;

/**
 * <p>
 *
 * </p>
 *
 * @author mengjian.ke@hand-china.com 2021/2/3 上午9:56
 */
public enum AppExceptionEnum {

    METHOD_ARGUMENT_NOT_VALID_EXCEPTION("5001","参数校验失败"),
    INTERNAL_SERVER_ERROR("500","系统内部错误，请联系管理员");

    private final String code;
    private final String message;

    AppExceptionEnum(String code,String message){
        this.code = code;
        this.message = message;
    }

    public String getCode(){
        return code;
    }

    public String getMessage(){
        return message;
    }

}
