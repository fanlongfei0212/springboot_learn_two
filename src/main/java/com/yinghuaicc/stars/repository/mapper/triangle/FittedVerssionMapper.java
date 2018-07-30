package com.yinghuaicc.stars.repository.mapper.triangle;

import com.yinghuaicc.stars.repository.model.triangle.FittedVerssion;
import com.yinghuaicc.stars.service.cqrs.triangle.dto.request.FittedVerssionRequestDTO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 适配值版本
 */
@Repository
public interface FittedVerssionMapper {


    @Select("<script>select * from yhcc_fitted_verssion " +
            " <where> " +
            "<bind name='search.fittedVerssionName' value=\"'%' + search.fittedVerssionName + '%'\" /> " +
            "<bind name='search.createTimeBegin' value='search.createTimeBegin ' /> " +
            "<bind name='search.createTimeEnd' value='search.createTimeEnd ' /> " +
            "<if test='search.fittedVerssionName != null and search.fittedVerssionName !=\"\" '>AND fitted_verssion_name like #{search.fittedVerssionName}</if> " +
            "<if test='search.createTimeBegin != null'>AND create_time &gt; #{search.createTimeBegin}</if> " +
            "<if test='search.createTimeEnd != null'>AND create_time &lt; #{search.createTimeEnd}</if> " +
            "</where> " +
            "</script>")
    List<FittedVerssion> findFittedVerssionByFittedVerssionCQRS(@Param("search") FittedVerssionRequestDTO fittedVerssionRequestDTO);


    @Insert("insert into yhcc_fitted_verssion " +
            "values(#{id},#{fittedVerssionName},,#{tempId},#{sumTarget},#{targetcount},#{untargetcount},#{createTime},#{modifyTime},#{createUser},#{modifyUser},#{status} )")
    void saveFittedVerssion(FittedVerssion fittedVerssion);
}
