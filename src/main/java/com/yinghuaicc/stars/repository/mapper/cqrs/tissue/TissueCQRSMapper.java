package com.yinghuaicc.stars.repository.mapper.cqrs.tissue;

import com.yinghuaicc.stars.service.cqrs.tissue.dto.request.EmployeeListCQRSRequestDTO;
import com.yinghuaicc.stars.service.cqrs.tissue.dto.response.EmployeeListCQRSResponseDTO;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author:Fly
 * @Date:Create in 2018/7/18 下午2:38
 * @Description: 员工查询
 * @Modified:
 */
@Repository
public interface TissueCQRSMapper {

    /**
     *@Author:Fly Created in 2018/7/18 下午2:45
     *@Description: 分页查询所有员工
     */
    @Select("<script> " +
            "select " +
            "em.id as id, " +
            "em.name as name, " +
            "em.user_name as userName, " +
            "em.phone as phone, " +
            "concat(IFNULL(de.name,''),IFNULL(co.name,'')) as deptName, " +
            "em.email as email, " +
            "em.state as state " +
            "from yhcc_employee as em " +
            "left join yhcc_department as de on em.org_id = de.id " +
            "left join yhcc_company as co on em.org_id = co.id " +
            "<where> " +
            "<bind name='search.name' value=\"'%' + search.name + '%'\" /> " +
            "<bind name='search.userName' value=\"'%' + search.userName + '%'\" /> " +
            "<if test='search.name != null and search.name !=\"\" '>AND em.name like #{search.name}</if> " +
            "<if test='search.userName != null and search.userName !=\"\" '>AND em.user_name like #{search.userName}</if> " +
            "</where> " +
            "order by em.modify_time desc " +
            "</script> ")
    List<EmployeeListCQRSResponseDTO> employeeListCQRS(@Param("search") EmployeeListCQRSRequestDTO employeeListCQRSRequestDTO);
}
