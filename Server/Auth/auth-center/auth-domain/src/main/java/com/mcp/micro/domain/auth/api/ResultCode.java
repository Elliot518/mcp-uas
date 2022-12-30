package com.mcp.micro.domain.auth.api;

import com.mcp.infrastructure.common.domain.api.IErrorCode;

/**
 * MERCHANTS操作码
 * Created by KG on 2020/9/7
 */

public enum ResultCode implements IErrorCode {
    /**
     * Admin Related
     */
    ADMIN_NO_USER("2001", "公司用户名不存在"),
    ADMIN_NO_CURRENT_USER("2002","当前用户不存在");

    private String code;
    private String message;

    private ResultCode(String code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
