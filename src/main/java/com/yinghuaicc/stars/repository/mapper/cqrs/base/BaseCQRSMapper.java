package com.yinghuaicc.stars.repository.mapper.cqrs.base;

import com.yinghuaicc.stars.service.cqrs.base.dto.response.FindByBusinessSpeciesCQRSListResponseDTO;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author:Fly
 * @Date:Create in 2018/7/9 下午12:14
 * @Description: 业种
 * @Modified:
 */
@Repository
public interface BaseCQRSMapper {

    /**
     *@Author:Fly Created in 2018/7/9 下午12:22
     *@Description: 分页查询业种列表
     */
    @Select("select " +
            "bs.id as id, " +
            "bs.num as num, " +
            "bs.name as name, " +
            "bf.name as businessFormName, " +
            "bs.create_time as createTime, " +
            "bs.modify_time as modifyTime " +
            "from " +
            "yhcc_business_species as bs " +
            "inner join yhcc_business_form as bf on bs.business_form_id = bf.id " +
            "order by bs.modify_time desc ")
    List<FindByBusinessSpeciesCQRSListResponseDTO> findByBusinessSpeciesCQRSList();

}
