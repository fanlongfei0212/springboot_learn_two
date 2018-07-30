package com.yinghuaicc.stars.repository.mapper.cqrs.standard;

import com.yinghuaicc.stars.service.cqrs.standard.dto.response.FindIntervalListCQRSResponseDTO;
import com.yinghuaicc.stars.service.cqrs.standard.dto.response.FindTriangleListCQRSResponseDTO;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author:Fly
 * @Date:Create in 2018/7/9 下午9:55
 * @Description: 区间查询
 * @Modified:
 */
@Repository
public interface StandardCQRSMapper {

    /**
     *@Author:Fly Created in 2018/7/9 下午10:26
     *@Description: 查询区间
     */
    @Select("select " +
            "i.id as id, " +
            "i.num as num, " +
            "i.dimension as dimension, " +
            "i.type as type, " +
            "bu.name as businessFormName, " +
            "bs.name as businessSpeciesName, " +
            "i.yx as yx, " +
            "i.lh as lh, " +
            "i.ts as ts, " +
            "i.hl as hl, " +
            "i.ks as ks, " +
            "i.create_time as createTime, " +
            "i.modify_time as modifyTime " +
            "from " +
            "yhcc_interval_conf as i " +
            "inner join yhcc_business_form as bu in i.business_form_id = bu.id " +
            "inner join yhcc_business_species as bs in i.business_species_id = bs.id " +
            "order by i.modify_time desc")
    List<FindIntervalListCQRSResponseDTO> findIntervalListCQRS();

    /**
     *@Author:Fly Created in 2018/7/10 下午3:30
     *@Description: 标准三角形查询
     */
    @Select("select " +
            "t.id as id, " +
            "t.num as num, " +
            "t.dimension as dimension, " +
            "bu.name as businessFormName, " +
            "bs.name as businessSpeciesName, " +
            "t.probably_profits as probablyProfits, " +
            "t.price as price, " +
            "t.rent_ratio as rentRatio, " +
            "t.gp_degree as gpDegree, " +
            "t.adapter as adapter, " +
            "t.create_time as createTime, " +
            "t.modify_time as modifyTime " +
            "from " +
            "yhcc_triangle as t " +
            "inner join yhcc_business_form as bu in t.business_form_id = bu.id " +
            "inner join yhcc_business_species as bs in t.business_species_id = bs.id " +
            "order by t.modify_time desc")
    List<FindTriangleListCQRSResponseDTO> findTriangleListCQRS();
}
