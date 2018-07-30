package com.yinghuaicc.stars.service.contract.dto.request;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @Author:Fly
 * @Date:Create in 2018/7/16 下午4:27
 * @Description: 添加签约信息
 * @Modified:
 */
public class SaveContractRequestDTO {

    //项目id
    @NotEmpty(message = "CONTRACT_SAVE_CONTRACT_001")
    private String projectId;

    //层id
    @NotEmpty(message = "CONTRACT_SAVE_CONTRACT_002")
    private String floorId;

    //铺位id
    @NotNull(message = "CONTRACT_SAVE_CONTRACT_003")
    private List<String> roomId;

    //品牌id
    @NotEmpty(message = "CONTRACT_SAVE_CONTRACT_004")
    private String brandId;

    public String getProjectId() {
        return projectId;
    }

    public SaveContractRequestDTO setProjectId(String projectId) {
        this.projectId = projectId;
        return this;
    }

    public String getFloorId() {
        return floorId;
    }

    public SaveContractRequestDTO setFloorId(String floorId) {
        this.floorId = floorId;
        return this;
    }

    public List<String> getRoomId() {
        return roomId;
    }

    public SaveContractRequestDTO setRoomId(List<String> roomId) {
        this.roomId = roomId;
        return this;
    }

    public String getBrandId() {
        return brandId;
    }

    public SaveContractRequestDTO setBrandId(String brandId) {
        this.brandId = brandId;
        return this;
    }
}
