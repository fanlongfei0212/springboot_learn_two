package com.yinghuaicc.stars.repository.mapper.cqrs.formula;

import com.yinghuaicc.stars.service.cqrs.formula.dto.request.FindFormulaCQRSListRequestDTO;
import com.yinghuaicc.stars.service.cqrs.formula.dto.response.FindFormulaListCQRSListResponseDTO;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author:Fly
 * @Date:Create in 2018/7/13 下午2:30
 * @Description: 公式
 * @Modified:
 */
@Repository
public interface FormulaCQRSMapper {

    /**
     *@Author:Fly Created in 2018/7/13 下午2:39
     *@Description: 公式列表
     */
    @Select("<script> " +
            "select " +
            "fo.id as id, " +
            "fo.num as num, " +
            "fo.target_id as targetId, " +
            "fo.target_name as targetName, " +
            "fo.operation_formula as operationFormula, " +
            "fo.result_formula as resultFormula, " +
            "fo.state as state, " +
            "fo.create_time as createTime, " +
            "fo.modify_time as modifyTime, " +
            "fo.create_user as createUser, " +
            "fo.modify_user as modifyUser, " +
            "em.name as createUserName, " +
            "em.name as modifyUserName " +
            "from yhcc_formula as fo " +
            "inner join yhcc_target as ta on fo.target_id = ta.id " +
            "inner join yhcc_employee as em on fo.create_user = em.id " +
            "inner join yhcc_employee as emp on fo.modify_user = emp.id " +
            "<where> " +
            "<bind name='search.targetName' value=\"'%' + search.targetName + '%'\" /> " +
            "<bind name='search.targetType' value='search.targetType' /> " +
            "<bind name='search.state' value='search.state' /> " +
            "<if test='search.targetName != null and search.targetName !=\"\" '>AND fo.target_name like #{search.targetName}</if> " +
            "<if test='search.targetType != null '>AND ta.target_type = #{search.targetType}</if> " +
            "<if test='search.state != null '>AND fo.state = #{search.state}</if> " +
            "</where> " +
            "order by fo.modify_time desc" +
            "</script> ")
    List<FindFormulaListCQRSListResponseDTO> formulaListCQRS(@Param("search") FindFormulaCQRSListRequestDTO findFormulaCQRSListRequestDTO);
}
