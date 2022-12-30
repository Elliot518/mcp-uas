package com.mcp.micro.domain.auth.api;

import com.mcp.infrastructure.common.domain.exception.ApiException;

/**
 * @author: KG
 * @description:
 * @date: Created in 5:42 下午 2020/9/7
 * @modified by:
 */

public class AuthApiException extends ApiException {
    public AuthApiException(ResultCode resultCode) {
        this.code = resultCode.getCode();
        this.msg = resultCode.getMessage();
    }
}
