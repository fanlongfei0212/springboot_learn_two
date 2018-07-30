package com.yinghuaicc.stars.repository.mapper.cqrs.contract;

import com.yinghuaicc.stars.service.cqrs.contract.dto.request.ContractCQRSListRequestDTO;
import com.yinghuaicc.stars.service.cqrs.contract.dto.request.ContractTriangleCQRSListRequestDTO;
import com.yinghuaicc.stars.service.cqrs.contract.dto.response.ContractCQRSListResponseDTO;
import com.yinghuaicc.stars.service.cqrs.contract.dto.response.ContractTriangleCQRSListResponseDTO;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author:Fly
 * @Date:Create in 2018/7/16 下午7:34
 * @Description: 签约
 * @Modified:
 */
@Repository
public interface ContractCQRSMapper {

    /**
     *@Author:Fly Created in 2018/7/16 下午7:40
     *@Description: 签约列表
     */
    @Select("<script> " +
            "select " +
            "co.id as id, " +
            "ar.name as areaName, " +
            "pr.name as projectName, " +
            "br.name as brandName, " +
            "br.id as brandId, " +
            "fl.name as floorName, " +
            "ro.name as roomName, " +
            "bf.name as businessFormName, " +
            "bs.name as businessSpeciesName, " +
            "ro.acreage as acreage, " +
            "co.status as state " +
            "from yhcc_contract as co " +
            "inner join yhcc_room as ro on co.room_id = ro.id " +
            "inner join yhcc_project as pr on co.project_id = pr.id " +
            "inner join yhcc_building as bui on bui.project_id = pr.id " +
            "inner join yhcc_floor as fl on co.floor_id = fl.id " +
            "inner join yhcc_brand as br on co.brand_id = br.id " +
            "inner join yhcc_business_form as bf on br.business_form_id = bf.id " +
            "inner join yhcc_business_species as bs on br.business_species_id = bs.id " +
            "inner join yhcc_area as ar on pr.area_id = ar.id " +
            "<where> " +
            "<bind name='search.areaId' value='search.areaId' /> " +
            "<bind name='search.projectId' value='search.projectId' /> " +
            "<bind name='search.buildingId' value='search.buildingId' /> " +
            "<bind name='search.floorId' value='search.floorId' /> " +
            "<bind name='search.businessFormId' value='search.businessFormId' /> " +
            "<bind name='search.businessSpeciesId' value='search.businessSpeciesId' /> " +
            "<bind name='search.brandId' value='search.brandId' /> " +
            "<bind name='search.name' value=\"'%' + search.name + '%'\" /> " +
            "<if test='search.areaId != null and search.areaId !=\"\" '>AND ar.id = #{search.areaId}</if> " +
            "<if test='search.projectId != null and search.projectId !=\"\" '>AND pr.id = #{search.projectId}</if> " +
            "<if test='search.buildingId != null and search.buildingId !=\"\" '>AND bui.id = #{search.buildingId}</if> " +
            "<if test='search.floorId != null and search.floorId !=\"\" '>AND fl.id = #{search.floorId}</if> " +
            "<if test='search.businessFormId != null and search.businessFormId !=\"\" '>AND bf.id = #{search.businessFormId}</if> " +
            "<if test='search.businessSpeciesId != null and search.businessSpeciesId !=\"\" '>AND bs.id = #{search.businessSpeciesId}</if> " +
            "<if test='search.brandId != null and search.brandId !=\"\" '>AND br.id = #{search.brandId}</if> " +
            "<if test='search.name != null and search.name !=\"\" '>AND ro.name like #{search.name}</if> " +
            "</where> " +
            "order by co.modify_time desc" +
            "</script>")
    List<ContractCQRSListResponseDTO> contractList(@Param("search") ContractCQRSListRequestDTO contractCQRSListRequestDTO);


    /**
     * 通过条件查询签约信息表
     * @param contractTriangleCQRSListRequestDTO
     * @return
     */
    @Select("<script> " +
            "select " +
            "co.id as id, " +
            "ar.name as areaName, " +
            "pr.id as projectId, " +
            "pr.name as projectName, " +
            "br.name as brandName, " +
            "br.id as brandId, " +
            "fl.id as floorId, " +
            "fl.name as floorName, " +
            "ro.id as roomId, " +
            "ro.name as roomName, " +
            "bf.id as businessFormId, " +
            "bf.name as businessFormName, " +
            "bs.id as businessSpeciesId, " +
            "bs.name as businessSpeciesName, " +
            "ro.acreage as acreage, " +
            "co.status as status " +
            "from yhcc_contract as co " +
            "inner join yhcc_room as ro on co.room_id = ro.id " +
            "inner join yhcc_project as pr on co.project_id = pr.id " +
            "inner join yhcc_floor as fl on co.floor_id = fl.id " +
            "inner join yhcc_brand as br on co.brand_id = br.id " +
            "inner join yhcc_business_form as bf on br.business_form_id = bf.id " +
            "inner join yhcc_business_species as bs on br.business_species_id = bs.id " +
            "inner join yhcc_area as ar on pr.area_id = ar.id " +
            "<where> " +
            "<bind name='search.areaId' value='search.areaId' /> " +
            "<bind name='search.projectId' value='search.projectId' /> " +
            "<bind name='search.floorId' value='search.floorId' /> " +
            "<bind name='search.businessFormId' value='search.businessFormId' /> " +
            "<bind name='search.brandId' value='search.brandId' /> " +
            "<bind name='search.name' value=\"'%' + search.name + '%'\" /> " +
            "<if test='search.areaId != null and search.areaId !=\"\" '>AND ar.id = #{search.areaId}</if> " +
            "<if test='search.projectId != null and search.projectId !=\"\" '>AND pr.id = #{search.projectId}</if> " +
            "<if test='search.floorId != null and search.floorId !=\"\" '>AND fl.id = #{search.floorId}</if> " +
            "<if test='search.businessFormId != null and search.businessFormId !=\"\" '>AND bf.id = #{search.businessFormId}</if> " +
            "<if test='search.brandId != null and search.brandId !=\"\" '>AND br.id = #{search.brandId}</if> " +
            "<if test='search.name != null and search.name !=\"\" '>AND ro.name like #{search.name}</if> " +
            "order by co.modify_time desc" +
            "</where> " +
            "</script>")
    List<ContractTriangleCQRSListResponseDTO> findContractTriangleCQRSListResponseDTO(@Param("search") ContractTriangleCQRSListRequestDTO contractTriangleCQRSListRequestDTO);
}
