package com.yinghuaicc.stars.repository.mapper.brand;

import com.yinghuaicc.stars.repository.model.brand.Brand;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author:Fly
 * @Date:Create in 2018/7/12 下午1:54
 * @Description: 品牌
 * @Modified:
 */
@Repository
public interface BrandMapper {

    /**
     *@Author:Fly Created in 2018/7/12 下午1:55
     *@Description: 添加品牌
     */
    @Insert("<script> " +
            "insert into yhcc_brand values " +
            "<foreach item = 'item' index = 'index' collection='list' separator=','> " +
            "(#{item.id}, #{item.num}, #{item.name}, #{item.businessFormId}, #{item.businessSpeciesId}, #{item.brandType}, " +
            "#{item.state}, #{item.createTime}, #{item.modifyTime}, #{item.createUser}, #{item.modifyUser}) " +
            "</foreach> " +
            "</script> ")
    void saveBrand(List<Brand> brand);

    /**
     *@Author:Fly Created in 2018/7/12 下午2:03
     *@Description: 编辑品牌
     */
    @Update("update yhcc_brand set " +
            "num = #{num}, name = #{name}, business_form_id = #{businessFormId}, business_species_id = #{businessSpeciesId}, " +
            "brand_type = #{brandType}, state = #{state}, create_time = #{createTime}, modify_time = #{modifyTime}, create_user = #{createUser}, modify_user = #{modifyUser} " +
            "where id = #{id}")
    void editBrand(Brand brand);

    /**
     *@Author:Fly Created in 2018/7/12 下午2:07
     *@Description: 根据id查询品牌
     */
    @Select("select * from yhcc_brand where id = #{id}")
    Brand findBrandById(String id);

    /**
     *@Author:Fly Created in 2018/7/12 下午2:10
     *@Description: 删除品牌
     */
    @Delete("delete from yhcc_brand where id = #{id}")
    void removeBrandById(String id);

    /**
     *@Author:Fly Created in 2018/7/16 下午1:10
     *@Description: 查询所有品牌
     */
    @Select("select * from yhcc_brand")
    List<Brand> findBrandAll();

    /**
     *@Author:Fly Created in 2018/7/30 下午12:54
     *@Description: 根据业种查询品牌
     */
    @Select("select * from yhcc_brand where business_species_id = #{businessSpeciesId}")
    List<Brand> findBrandByBusinessSpeciesId(String businessSpeciesId);

    /**
     *@Author:Fly Created in 2018/7/30 下午12:57
     *@Description: 根据业种查询品牌数量
     */
    @Select("select count(*) from yhcc_brand where business_species_id = #{businessSpeciesId}")
    Integer countBrandByBusinessSpeciesId(String BusinessSpeciesId);
}
