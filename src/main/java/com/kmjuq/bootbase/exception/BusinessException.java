package com.kmjuq.bootbase.exception;

import lombok.ToString;

/**
 * <p>
 *
 * </p>
 *
 * @author mengjian.ke@hand-china.com 2020/11/30 19:10
 */
public class BusinessException extends AppException {

    public BusinessException() {
        super();
    }

    public BusinessException(String code, String message) {
        super(code, message);
    }

    public BusinessException(AppExceptionEnum appExceptionEnum) {
        super(appExceptionEnum);
    }

}
