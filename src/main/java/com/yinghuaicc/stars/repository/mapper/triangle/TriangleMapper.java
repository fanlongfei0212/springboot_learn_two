package com.yinghuaicc.stars.repository.mapper.triangle;

import com.yinghuaicc.stars.repository.model.triangle.Triangle;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TriangleMapper {

    @Select("select * from yhcc_triangle where id = #{triangleId}")
    List<Triangle> findTriangleByTriangleId(String triangleId);


}
