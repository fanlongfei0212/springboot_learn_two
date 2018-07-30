package com.yinghuaicc.stars.service.cqrs.standard.dto.request;

/**
 * 标准三角形品牌客销度请求参数
 */
public class StandardBrandSaleRequestDTO {
    //版本名称
    private String saleVessionName;
    //签约id
    private String contractId;
    //项目id
    private String projectId;

    public String getSaleVessionName() {
        return saleVessionName;
    }

    public void setSaleVessionName(String saleVessionName) {
        this.saleVessionName = saleVessionName;
    }

    public String getContractId() {
        return contractId;
    }

    public void setContractId(String contractId) {
        this.contractId = contractId;
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }
}
