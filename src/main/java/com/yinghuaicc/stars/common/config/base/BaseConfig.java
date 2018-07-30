package com.yinghuaicc.stars.common.config.base;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @Author:Fly
 * @Date:Create in 2018/6/23 下午2:59
 * @Description: 项目基础配置
 * @Modified:
 */
@Configuration
public class BaseConfig {

    /**
     *@Author:Fly Created in 2018/6/23 下午3:05
     *@Description: 解决Spring默认处理返回Json无法解析Object问题，
     * 并且手动配置Jackson序列化LocalDateTime的时间格式，如果不手动
     * 配置的话，@JsonFormat会因为设置SerializationFeature.FAIL_ON_EMPTY_BEANS
     * 而失效，配置后无需再DTO中添加@JsonFormat(pattern = "yyyy-MM-dd HH:ss:mm", timezone = "GMT+8")注解
     */
    @Bean
    public ObjectMapper objectMapper(){

        JavaTimeModule javaTimeModule = new JavaTimeModule();

        javaTimeModule.addSerializer(
                LocalDateTime.class, new LocalDateTimeSerializer(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));

        return new ObjectMapper()
                .disable(SerializationFeature.FAIL_ON_EMPTY_BEANS)
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
                .registerModule(javaTimeModule);
    }

    /**
     *@Author:Fly Created in 2018/6/23 下午4:23
     *@Description: 配置RestTemplate
     */
    @Bean
    public RestTemplate restTemplate(){

        return new RestTemplateBuilder().build();
    }

}
