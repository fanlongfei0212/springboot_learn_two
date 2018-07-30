package com.yinghuaicc.stars.repository.mapper.triangle;


import com.yinghuaicc.stars.repository.model.triangle.RentVerssion;
import com.yinghuaicc.stars.service.cqrs.triangle.dto.request.RentVerssionRequestDTO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 溢租率版本表
 */
@Repository
public interface RentVerssionMapper {

    /**
     * 通过id查询溢租率版本信息
     * @param rentVerssionRequestDTO
     * @return
     */
    @Select("<script>select * from yhcc_rent_verssion " +
            " <where> " +
            "<bind name='search.rentVerssionName' value=\"'%' + search.rentVerssionName + '%'\" /> " +
            "<bind name='search.createTimeBegin' value='search.createTimeBegin ' /> " +
            "<bind name='search.createTimeEnd' value='search.createTimeEnd ' /> " +
            "<if test='search.rentVerssionName != null and search.rentVerssionName !=\"\" '>AND rent_verssion_name like #{search.rentVerssionName}</if> " +
            "<if test='search.createTimeBegin != null'>AND create_time &gt; #{search.createTimeBegin}</if> " +
            "<if test='search.createTimeEnd != null'>AND create_time &lt; #{search.createTimeEnd}</if> " +
            "</where> " +
            "</script>")
    List<RentVerssion> findRentVerssionByRentVerssionCQRS(@Param("search") RentVerssionRequestDTO rentVerssionRequestDTO);


    /**
     * 保存溢租率版本信息
     * @param rentVerssion
     */
    @Insert("Insert into yhcc_rent_verssion " +
            "values(#{id},#{rentVerssionName},#{sumTarget},#{targetcount},#{untargetcount},#{createTime},#{modifyTime},#{createUser},#{modifyUser} )")
    void saveRentVerssion(RentVerssion rentVerssion);

}
