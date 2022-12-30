package com.mcp.micro.platform.center.auth.exception;

import com.mcp.infrastructure.common.domain.api.CommonResult;
import com.mcp.infrastructure.common.domain.helper.ExceptionHunter;
import com.mcp.infrastructure.common.domain.response.BaseResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.oauth2.common.exceptions.OAuth2Exception;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author: KG
 * @description: Oauth2 Global Exception Handler
 * @date: Created in 5:10 下午 2020/9/1
 * @modified by:
 */
@Slf4j
@RestControllerAdvice
public class Oauth2ExceptionHandler {
    @ResponseBody
    @ExceptionHandler(value = OAuth2Exception.class)
    public CommonResult handleOauth2(OAuth2Exception e) {
        return CommonResult.failed(e.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public BaseResponse<String> methodArgumentNotValidExceptionHandler(MethodArgumentNotValidException e) {
        ObjectError objectError = e.getBindingResult().getAllErrors().get(0);

        return ExceptionHunter.captureParamError(objectError.getDefaultMessage());
    }

    @ExceptionHandler(Exception.class)
    public BaseResponse<String> apiExceptionHandler(Exception e) {
        return ExceptionHunter.captureApiException(e);
    }
}









