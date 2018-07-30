package com.yinghuaicc.stars.config.exception;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @Author:Fly
 * @Date:Create in 2018/5/31 下午8:09
 * @Description: 加载异常文件数据
 * @Modified:
 */
@Configuration
@PropertySource(value = "classpath:exception.properties", encoding = "UTF-8")
public class ExceptionSource {
}
