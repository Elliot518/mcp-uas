package com.mcp.micro.platform.center.permission.advice;

import com.mcp.infrastructure.common.domain.helper.ExceptionHunter;
import com.mcp.infrastructure.common.domain.response.BaseResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


/**
 * @author: KG
 * @description: 全局异常处理器
 * @date: Created in 5:56 下午 2020/8/5
 * @modified by: KG 2020/8/11
 */
@Slf4j
@RestControllerAdvice
public class ExceptionControllerAdvice {
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

