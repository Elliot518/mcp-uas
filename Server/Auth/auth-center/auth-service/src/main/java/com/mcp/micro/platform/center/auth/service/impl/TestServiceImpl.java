package com.mcp.micro.platform.center.auth.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

/**
 * @author: KG
 * @description:
 * @date: Created in 11:22 下午 2020/8/18
 * @modified by:
 */
@Slf4j
@Service
public class TestServiceImpl {
    @PostConstruct
    public void init() {
      log.info("Init test service...");
    }
}
