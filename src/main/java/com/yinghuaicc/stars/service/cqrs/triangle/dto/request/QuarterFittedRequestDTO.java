package com.yinghuaicc.stars.service.cqrs.triangle.dto.request;

public class QuarterFittedRequestDTO {

    //id
    private String id;

    //签约id
    private String contractId;

    //版本id
    private String fittedVerssionId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getContractId() {
        return contractId;
    }

    public void setContractId(String contractId) {
        this.contractId = contractId;
    }

    public String getFittedVerssionId() {
        return fittedVerssionId;
    }

    public void setFittedVerssionId(String fittedVerssionId) {
        this.fittedVerssionId = fittedVerssionId;
    }
}
