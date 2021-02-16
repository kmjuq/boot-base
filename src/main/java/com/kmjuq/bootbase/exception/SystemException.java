package com.kmjuq.bootbase.exception;

import lombok.ToString;

/**
 * <p>
 *
 * </p>
 *
 * @author mengjian.ke@hand-china.com 2020/11/30 19:10
 */
public class SystemException extends AppException {

    public SystemException() {
        super();
    }

    public SystemException(String code, String message) {
        super(code, message);
    }

    public SystemException(AppExceptionEnum appExceptionEnum) {
        super(appExceptionEnum);
    }
}
