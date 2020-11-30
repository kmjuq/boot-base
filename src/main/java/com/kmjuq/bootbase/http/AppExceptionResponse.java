package com.kmjuq.bootbase.http;

import lombok.Getter;
import lombok.Setter;

/**
 * 封装返回结果
 *
 * @author bojiangzhou 2019/05/13
 */
@Setter
@Getter
public class AppExceptionResponse {

    private static final String HTTP_BUSINESS_SUCCESS = "app.success";
    private static final String HTTP_BUSINESS_FAILURE = "app.failure";

    // 请求是否获取到想要的数据
    private boolean success;
    // 异常代码
    private String code;
    // 异常信息
    private String message;


}
