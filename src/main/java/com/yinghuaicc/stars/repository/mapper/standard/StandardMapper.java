package com.yinghuaicc.stars.repository.mapper.standard;

import com.yinghuaicc.stars.repository.model.standard.IntervalConf;
import com.yinghuaicc.stars.repository.model.standard.Triangle;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author:Fly
 * @Date:Create in 2018/7/9 下午8:12
 * @Description: 区间设置
 * @Modified:
 */
@Repository
public interface StandardMapper {


    /**
     *@Author:Fly Created in 2018/7/9 下午8:13
     *@Description: 添加区间设置
     */
    @Insert("<script> " +
            "insert into yhcc_interval_conf values " +
            "<foreach item='item' collection='list' open='(' close=')' separator=','> " +
            "(#{item.id}, #{item.dimension}, #{item.type}, #{item.businessFormId}, #{item.businessSpeciesId}, #{item.yx}, #{item.lh}, " +
            "#{item.ts}, #{item.hl}, #{item.ks}, #{item.createTime}, #{item.modifyTime}, #{item.createUser}, #{item.modifyUser} ) " +
            "</foreach> " +
            "</script> ")
    void saveIntervalConf(List<IntervalConf> intervalConf);

    /**
     *@Author:Fly Created in 2018/7/9 下午8:41
     *@Description: 修改区间设置
     */
    @Update("update yhcc_interval_conf set " +
            "dimension = #{dimension}, type = #{type}, business_form_id = #{businessFormId}, business_species_id = #{businessSpeciesId}, " +
            "yx = #{yx}, lh = #{lh}, ts = #{ts}, ks = #{ks}, create_time = #{createTime}, modify_time = #{modifyTime}, " +
            "create_user = #{createUser}, modify_user = #{modifyUser} where id = #{id}")
    void editIntervalConf(IntervalConf intervalConf);

    /**
     *@Author:Fly Created in 2018/7/9 下午8:45
     *@Description: 按照区间设置id查询区间设置
     */
    @Select("select * from yhcc_interval_conf where id = #{id}")
    IntervalConf findIntervalConfById(String id);

    /**
     *@Author:Fly Created in 2018/7/9 下午8:47
     *@Description: 删除区间设置
     */
    @Delete("delete from yhcc_interval_conf where id = #{id}")
    void removeIntervalById(String id);

    /**
     *@Author:Fly Created in 2018/7/9 下午9:37
     *@Description: 查询同一维度、分类、业态id、业种id是否已经存在区间设置(新增时区间设置id可以不传，修改时必须传区间设置id，否则自己不能修改自己)
     */
    @Select("<script> " +
            "select count(*) from yhcc_interval_conf " +
            "where dimension = #{dimension} and type = #{type} and business_form_id = #{businessFormId} and business_species_id = #{businessSpeciesId} " +
            "<if test = ' id != null '>and id != #{id} </if> " +
            "</script>")
    Integer countIntervalConfByDimensionAndTypeAndBusinessFormIdAndBusinessSpeciesId(IntervalConf intervalConf);

    /**
     *@Author:Fly Created in 2018/7/10 下午2:59
     *@Description: 新增标准三角形
     */
    @Insert("<script> " +
            "insert into yhcc_triangle values " +
            "<foreach item='item' collection='list' open='(' close=')' separator=','> " +
            "(#{item.id}, #{item.num}, #{item.dimension}, #{item.businessFormId}, #{item.businessSpeciesId}, #{item.probablyProfits}, #{item.price}, " +
            "#{item.rentRatio}, #{item.gpDegree}, #{item.adapter}, #{item.createTime}, #{item.modifyTime}, #{item.createUser}, #{item.modifyUser} ) " +
            "</foreach> " +
            "</script> ")
    void saveTriangle(List<Triangle> triangles);

    /**
     *@Author:Fly Created in 2018/7/10 下午3:08
     *@Description: 编辑标准三角形
     */
    @Update("update yhcc_triangle set " +
            "num = #{num}, dimension = #{dimension}, business_form_id = #{businessFormId}, business_species_id = #{businessSpeciesId}, probably_profits = #{probablyProfits}, price = #{price}, rent_ratio = #{rentRatio}, " +
            "gp_degree = #{gpDegree}, adapter = #{adapter}, create_time = #{createTime}, modify_time = #{modifyTime}, create_user = #{createUser}, modify_user = #{modifyUser} " +
            "where id = #{id}")
    void editTriangle(Triangle triangle);

    /**
     *@Author:Fly Created in 2018/7/10 下午3:13
     *@Description: 根据id查询标准三角形
     */
    @Select("select * from yhcc_triangle where id = #{id}")
    Triangle findTriangleById(String id);

    /**
     *@Author:Fly Created in 2018/7/10 下午3:17
     *@Description: 查询同一纬度、业态、业种下数据条数(新增标准三角形id可以不传，修改时必须传标准三角形id，否则自己不能修改自己)
     */
    @Select("<script> " +
            "select count(*) from yhcc_triangle " +
            "where dimension = #{dimension} and business_form_id = #{businessFormId} and business_species_id = #{businessSpeciesId} " +
            "<if test = ' id != null '>and id != #{id} </if> " +
            "</script>")
    Integer countTriangleByDimensionAndBusinessFormIdAndBusinessSpeciesId(Triangle triangle);

    /**
     *@Author:Fly Created in 2018/7/10 下午3:21
     *@Description: 删除标准三角形
     */
    @Delete("delete from yhcc_triangle where id = #{id} ")
    void removeTriangle(String id);
}
