package com.yinghuaicc.stars.service.cqrs.brand.dto.response;

/**
 * App查询品牌列表
 */
public class AppBrandCQRSListResponseDTO {
    //品牌id
    private  String brandId;
    private String brandName;

    public String getBrandId() {
        return brandId;
    }

    public void setBrandId(String brandId) {
        this.brandId = brandId;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }
}
