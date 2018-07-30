package com.yinghuaicc.stars.repository.mapper.base;

import com.yinghuaicc.stars.repository.model.base.BusinessForm;
import com.yinghuaicc.stars.repository.model.base.BusinessSpecies;
import com.yinghuaicc.stars.repository.model.base.City;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author:Fly
 * @Date:Create in 2018/7/5 上午10:39
 * @Description: 基础数据
 * @Modified:
 */
@Repository
public interface BaseMapper {

    /**
     *@Author:Fly Created in 2018/7/5 上午10:40
     *@Description: 查询所有城市
     */
    @Select("select * from yhcc_city ")
    List<City> findCityAll();

    /**
     *@Author:Fly Created in 2018/7/9 上午11:53
     *@Description: 添加业态
     */
    @Insert("<script> " +
            "insert into yhcc_business_form values " +
            "<foreach item = 'item' index = 'index' collection='list' separator=','> " +
            "(#{item.id}, #{item.num}, #{item.name}, #{item.createTime}, " +
            "#{item.modifyTime}, #{item.createUser}, #{item.modifyUser}) " +
            "</foreach> " +
            "</script> ")
    void saveBusinessForm(List<BusinessForm> businessForms);

    /**
     *@Author:Fly Created in 2018/7/9 下午12:00
     *@Description: 编辑业态信息
     */
    @Update("update yhcc_business_form set " +
            "name = #{name}, num = #{num}, create_time = #{createTime}, modify_time = #{modifyTime}, " +
            "create_user = #{createUser}, modify_user = #{modifyUser} where id = #{id}")
    void editBusinessForm(BusinessForm businessForm);

    /**
     *@Author:Fly Created in 2018/7/9 下午12:01
     *@Description: 根据业态id查询业态信息
     */
    @Select("select * from yhcc_business_form where id = #{id}")
    BusinessForm findBusinessFormById(String id);

    /**
     *@Author:Fly Created in 2018/7/9 下午12:02
     *@Description: 删除业态信息
     */
    @Delete("delete from yhcc_business_form where id = #{id}")
    void removeBusinessForm(String id);

    /**
     *@Author:Fly Created in 2018/7/9 下午12:03
     *@Description: 查询所有业态信息
     */
    @Select("select * from yhcc_business_form order by modify_time desc")
    List<BusinessForm> findBusinessFormList();

    /**
     *@Author:Fly Created in 2018/7/9 下午12:45
     *@Description: 根据业态名称查询是否存在同名业态(新增时业态id可以不传，修改时必须传业态id，否则自己不能修改自己)
     */
    @Select("<script> " +
            "select count(*) from yhcc_business_form where name = #{name} " +
            "<if test = ' id != null '>and id != #{id} </if>" +
            "</script> ")
    Integer countBusinessFormByName(@Param("name") String name, @Param("id") String id);

    /**
     *@Author:Fly Created in 2018/7/9 下午12:04
     *@Description: 添加业种信息
     */
    @Insert("<script> " +
            "insert into yhcc_business_species values " +
            "<foreach item = 'item' index = 'index' collection='list' separator=','> " +
            "(#{item.id}, #{item.num}, #{item.businessFormId}, #{item.name}, #{item.createTime}, " +
            "#{item.modifyTime}, #{item.createUser}, #{item.modifyUser}) " +
            "</foreach> " +
            "</script> ")
    void saveBusinessSpecies(List<BusinessSpecies> businessSpecies);

    /**
     *@Author:Fly Created in 2018/7/9 下午12:06
     *@Description: 编辑业种信息
     */
    @Update("update yhcc_business_species set " +
            "name = #{name}, num = #{num}, business_form_id = #{businessFormId}, create_time = #{createTime}, modify_time = #{modifyTime}, " +
            "create_user = #{createUser}, modify_user = #{modifyUser} where id = #{id}")
    void editBusinessSpecies(BusinessSpecies businessSpecies);

    /**
     *@Author:Fly Created in 2018/7/9 下午12:07
     *@Description: 根据业种id查询业种信息
     */
    @Select("select * from yhcc_business_species where id = #{id}")
    BusinessSpecies findBusinessSpeciesById(String id);

    /**
     *@Author:Fly Created in 2018/7/9 下午12:11
     *@Description: 删除业种信息
     */
    @Delete("delete from yhcc_business_species where id = #{id}")
    void removeBusinessSpecies(String id);

    /**
     *@Author:Fly Created in 2018/7/9 下午12:46
     *@Description: 根据业种名称查询是否存在同名业种(新增时业种id可以不传，修改时必须传业种id，否则自己不能修改自己)
     */
    @Select("<script> " +
            "select count(*) from yhcc_business_species where name = #{name} " +
            "<if test = ' id != null '>and id != #{id} </if>" +
            "</script> ")
    Integer countBusinessSpeciesByName(@Param("name") String name, @Param("id") String id);

    /**
     *@Author:Fly Created in 2018/7/9 下午12:47
     *@Description: 根据业态id查询此业态下是否存在业种
     */
    @Select("select count(*) from yhcc_business_species where business_form_id = #{businessFormId}")
    Integer countBusinessSpeciesByBusinessFormId(String businessFormId);

    /**
     *@Author:Fly Created in 2018/7/27 下午5:57
     *@Description: 根据业态id查询业种
     */
    @Select("select * from yhcc_business_species where business_form_id = #{businessFormId}")
    List<BusinessSpecies> findBusinessSpeciesByBusinessFormId(String businessFormId);
}
