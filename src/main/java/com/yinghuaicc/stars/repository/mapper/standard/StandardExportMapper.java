package com.yinghuaicc.stars.repository.mapper.standard;

import com.yinghuaicc.stars.service.cqrs.standard.dto.request.StandardExportDTO;
import com.yinghuaicc.stars.service.cqrs.standard.dto.response.FittedExportResponseDTO;
import com.yinghuaicc.stars.service.cqrs.standard.dto.response.StandardExportResponseDTO;
import com.yinghuaicc.stars.service.cqrs.standard.dto.response.StandardFittedExportResponseDTO;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by 你看见过我吗？你想一想在回答。 on 2018/7/29.
 */
@Repository
public interface StandardExportMapper {

    /**
     *  标准三角形客销度
     */

    @Select("<script> select a.id as contractId ," +
            "b.name as projectName," +
            "c.name as floorName," +
            "d.name as roomName," +
            "e.name as brandName," +
            "f.name as businessFormName," +
            "case when e.state = 1 then '已签约' else '未签约' end as state " +
            "from yhcc_contract a " +
            "LEFT JOIN yhcc_project b on b.id = a.project_id " +
            "LEFT JOIN yhcc_floor c on c.id = a.floor_id " +
            "LEFT JOIN yhcc_room d on d.id = a.room_id " +
            "LEFT JOIN yhcc_brand e on e.id = a.brand_id " +
            "LEFT JOIN yhcc_business_form f on f.id = e.business_form_id " +
            " <where> 1=1 " +
            "<if test='projectId != null'> AND a.project_id = #{projectId }</if> " +
            "<if test='floorId != null'> AND a.floor_id = #{floorId} </if> " +
            "</where> " +
            "</script>")
    List<StandardExportResponseDTO> getStandardExportList(StandardExportDTO standardExportDTO);


    /**
     * 标准三角形_适配值
     */

    //项目适配值
    @Select("<script> " +
            " select a.project_id as projectId,b.name as projectName " +
            " from yhcc_contract a " +
            " LEFT JOIN yhcc_project b on a.project_id = b.id " +
            " <where> 1=1 " +
            " <if test='projectId != null'> AND a.project_id = #{projectId} </if> " +
            " <if test='floorId != null'> AND a.floor_id = #{floorId} </if> " +
            " </where> " +
            " </script> ")
    List<StandardFittedExportResponseDTO> getStandardExportList1(StandardExportDTO standardExportDTO);


    //楼层适配值
    @Select("<script> " +
            " select a.id as id,b.name as projectName,c.name as floorName  " +
            " from yhcc_contract a " +
            " LEFT JOIN yhcc_project b on a.project_id = b.id " +
            " LEFT JOIN yhcc_floor c on c.id = a.floor_id " +
            " <where> 1=1 " +
            "<if test='projectId != null'> AND a.project_id = #{projectId} </if> " +
            "<if test='floorId != null'> AND a.floor_id = #{floorId} </if> " +
            "</where> " +
            "</script>")
    List<StandardFittedExportResponseDTO> getStandardExportList2(StandardExportDTO standardExportDTO);


    //业态适配值
    @Select("<script> " +
            " select a.id as id,b.name as projectName,d.name as businessName,e.name as speciesName  from yhcc_contract a " +
            " LEFT JOIN yhcc_project b on a.project_id = b.id " +
            " LEFT JOIN yhcc_brand c on c.id = a.brand_id " +
            " LEFT JOIN yhcc_business_form d on d.id = c.business_form_id " +
            " LEFT JOIN yhcc_business_species e on e.id = c.business_species_id " +
            " <where> 1=1 " +
            "<if test='projectId != null'> AND a.project_id = #{projectId} </if> " +
            "<if test='floorId != null'> AND a.floor_id = #{floorId} </if> " +
            "</where> " +
            "</script>")
    List<StandardFittedExportResponseDTO> getStandardExportList3(StandardExportDTO standardExportDTO);


    /**
     * 动态三角形_客销度
     */


    //项目客销度
    @Select("<script>" +
            " select a.id as id ,b.name as projectName from yhcc_contract a LEFT JOIN yhcc_project b on a.project_id = b.id " +
            " <where> 1=1 " +
            "<if test='projectId != null'> AND a.project_id = #{projectId} </if> " +
            "<if test='floorId != null'> AND a.floor_id = #{floorId} </if> " +
            "</where> " +
            "</script>")
    List<FittedExportResponseDTO> getFittedExportList(StandardExportDTO standardExportDTO);


    //楼层客销度
    @Select("<script>" +
            " select a.id as id ,b.name as projectName,c.name as floorName from yhcc_contract a LEFT JOIN yhcc_project b on a.project_id = b.id LEFT JOIN yhcc_floor c on c.id = a.floor_id " +
            " <where> 1=1 " +
            "<if test='projectId != null'> AND a.project_id = #{projectId} </if> " +
            "<if test='floorId != null'> AND a.floor_id = #{floorId} </if> " +
            "</where> " +
            "</script>")
    List<FittedExportResponseDTO> getFittedExportList1(StandardExportDTO standardExportDTO);

    //品牌客销度
    //动态三角形_适配值
    //动态三角形_溢租率
    @Select("<script>" +
            " select a.id as id ,b.name as projectName,c.name as floorName,d.name as roomName,e.name as brandName,f.name as businessName," +
            " case when a.status = 1 then '已签约' else '未签约' end as sate " +
            " from yhcc_contract a " +
            " LEFT JOIN yhcc_project b on a.project_id = b.id " +
            " LEFT JOIN yhcc_floor c on c.id = a.floor_id  " +
            " LEFT JOIN yhcc_room d on d.id = a.room_id " +
            " LEFT JOIN yhcc_brand e on e.id = a.brand_id " +
            " LEFT JOIN yhcc_business_form f on f.id = e.business_form_id " +
            " <where> 1=1 " +
            "<if test='projectId != null'> AND a.project_id = #{projectId} </if> " +
            "<if test='floorId != null'> AND a.floor_id = #{floorId} </if> " +
            "</where> " +
            "</script>")
    List<FittedExportResponseDTO> getFittedExportList2(StandardExportDTO standardExportDTO);
}
