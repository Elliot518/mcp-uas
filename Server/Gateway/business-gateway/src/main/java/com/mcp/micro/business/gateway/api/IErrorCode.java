package com.mcp.micro.business.gateway.api;

/**
 * @author: KG
 * @description: 错误码
 * @date: Created in 10:23 下午 2020/8/7
 * @modified by:
 */

public interface IErrorCode {
    long getCode();

    String getMessage();
}
