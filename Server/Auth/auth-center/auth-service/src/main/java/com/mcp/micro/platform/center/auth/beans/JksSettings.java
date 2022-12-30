package com.mcp.micro.platform.center.auth.beans;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author: KG
 * @description:
 * @date: Created in 5:44 下午 2020/8/18
 * @modified by:
 */

@Data
@Component
public class JksSettings {
    @Value("${jks.password}")
    private String password;

    @Value("${jks.key}")
    private String key;

    @Value("${jks.filename}")
    private String filename;
}
