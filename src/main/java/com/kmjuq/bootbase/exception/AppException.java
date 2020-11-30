package com.kmjuq.bootbase.exception;

import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 *
 * </p>
 *
 * @author mengjian.ke@hand-china.com 2020/11/20 15:17
 */
@Setter
@Getter
public abstract class AppException extends RuntimeException {

    private String code;

    private String message;

}
