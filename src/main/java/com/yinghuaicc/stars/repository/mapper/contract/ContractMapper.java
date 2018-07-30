package com.yinghuaicc.stars.repository.mapper.contract;

import com.yinghuaicc.stars.repository.model.contract.Contract;
import com.yinghuaicc.stars.service.cqrs.contract.dto.response.ContractCQRSListResponseDTO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author:Fly
 * @Date:Create in 2018/7/15 上午11:34
 * @Description: 签约
 * @Modified:
 */
@Repository
public interface ContractMapper {

    /**
     *@Author:Fly Created in 2018/7/16 下午1:52
     *@Description: 添加签约信息
     */
    @Insert("<script> " +
            "insert into yhcc_contract values " +
            "<foreach item = 'item' index = 'index' collection='list' separator=','> " +
            "(#{item.id}, #{item.projectId}, #{item.floorId}, #{item.roomId}, " +
            "#{item.brandId}, #{item.status}, #{item.createTime}, #{item.modifyTime}, " +
            "#{item.createUser}, #{item.modifyUser})" +
            "</foreach> " +
            "</script>")
    void saveContract(List<Contract> contracts);

    /**
     *@Author:Fly Created in 2018/7/16 下午1:58
     *@Description: 查询铺位是否已经签约
     */
    @Select("select count(*) from yhcc_contract where room_id = #{roomId}")
    Integer countContractByRoomId(String roomId);

    /**
     *@Author:Fly Created in 2018/7/16 下午4:24
     *@Description: 编辑签约信息
     */
    @Update("update yhcc_contract set " +
            "project_id = #{projectId}, floor_id = #{floorId}, room_id = #{roomId}, " +
            "brand_id = #{brandId}, status = #{status}, create_time = #{createTime}, " +
            "modify_time = #{modifyTime}, create_user = #{createUser}, modify_user = #{modifyUser} " +
            "where id = #{id} ")
    void editContractById(Contract contract);

    /**
     *@Author:Fly Created in 2018/7/16 下午4:24
     *@Description: 签约详情
     */
    @Select("select * from yhcc_contract where id = #{id}")
    Contract findContractById(String id);


}
