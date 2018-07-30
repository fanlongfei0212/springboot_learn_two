package com.yinghuaicc.stars.controller.config.system;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @Author:Fly
 * @Date:Create in 2018/7/6 下午1:42
 * @Description: 系统配置
 * @Modified:
 */
@Configuration
@PropertySource(value = "classpath:system.properties", encoding = "UTF-8")
public class SystemResource {

    @Value("${pc.aop.token.able.minutes}")
    private String tokenAbleMinutes;

    @Value("${file.upload.image.path.url}")
    private String fileUploadImagePathUrl;

    @Value("${file.upload.excel.path.url}")
    private String fileUploadExcelPathUrl;

    @Value("${file.upload.other.path.url}")
    private String fileUploadOtherPathUrl;

    @Value("${file.image.url}")
    private String fileImageUrl;

    @Value("${file.excel.url}")
    private String fileExcelUrl;

    @Value("${file.other.url}")
    private String fileOtherUrl;

    @Value("${external.url}")
    private String externalUrl;

    @Value("${sso.privateKey}")
    private String ssoPrivateKey;

    public String getTokenAbleMinutes() {
        return tokenAbleMinutes;
    }

    public SystemResource setTokenAbleMinutes(String tokenAbleMinutes) {
        this.tokenAbleMinutes = tokenAbleMinutes;
        return this;
    }

    public String getFileUploadImagePathUrl() {
        return fileUploadImagePathUrl;
    }

    public SystemResource setFileUploadImagePathUrl(String fileUploadImagePathUrl) {
        this.fileUploadImagePathUrl = fileUploadImagePathUrl;
        return this;
    }

    public String getFileUploadExcelPathUrl() {
        return fileUploadExcelPathUrl;
    }

    public SystemResource setFileUploadExcelPathUrl(String fileUploadExcelPathUrl) {
        this.fileUploadExcelPathUrl = fileUploadExcelPathUrl;
        return this;
    }

    public String getFileUploadOtherPathUrl() {
        return fileUploadOtherPathUrl;
    }

    public SystemResource setFileUploadOtherPathUrl(String fileUploadOtherPathUrl) {
        this.fileUploadOtherPathUrl = fileUploadOtherPathUrl;
        return this;
    }

    public String getFileImageUrl() {
        return fileImageUrl;
    }

    public SystemResource setFileImageUrl(String fileImageUrl) {
        this.fileImageUrl = fileImageUrl;
        return this;
    }

    public String getFileExcelUrl() {
        return fileExcelUrl;
    }

    public SystemResource setFileExcelUrl(String fileExcelUrl) {
        this.fileExcelUrl = fileExcelUrl;
        return this;
    }

    public String getFileOtherUrl() {
        return fileOtherUrl;
    }

    public SystemResource setFileOtherUrl(String fileOtherUrl) {
        this.fileOtherUrl = fileOtherUrl;
        return this;
    }

    public String getExternalUrl() {
        return externalUrl;
    }

    public SystemResource setExternalUrl(String externalUrl) {
        this.externalUrl = externalUrl;
        return this;
    }

    public String getSsoPrivateKey() {
        return ssoPrivateKey;
    }

    public SystemResource setSsoPrivateKey(String ssoPrivateKey) {
        this.ssoPrivateKey = ssoPrivateKey;
        return this;
    }
}
