package com.yinghuaicc.stars.repository.mapper.external;

import com.yinghuaicc.stars.repository.model.external.ExternalEmployee;
import com.yinghuaicc.stars.repository.model.external.ExternalOrg;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author:Fly
 * @Date:Create in 2018/7/15 下午7:29
 * @Description: 外部系统同步本系统数据
 * @Modified:
 */
@Repository
public interface ExternalMapper {

    /**
     *@Author:Fly Created in 2018/7/17 下午1:46
     *@Description: 同步组织架构数据
     */
    @Insert("<script> " +
            "insert into yhcc_external_org values " +
            "<foreach item = 'item' index = 'index' collection='list' separator=','> " +
            "(#{item.id}, #{item.name}, #{item.parentId}, #{item.type}, " +
            "#{item.code}, #{item.status}, #{item.delflag}, #{item.createTime}, " +
            "#{item.modifyTime}, #{item.createUser}, #{item.modifyUser})" +
            "</foreach>" +
            "</script> ")
    void saveOrg(List<ExternalOrg> externalOrg);

    /**
     *@Author:Fly Created in 2018/7/17 下午1:49
     *@Description: 同步时删除旧数据
     */
    @Delete("<script> " +
            "delete from yhcc_external_org where id in" +
            "<foreach item='item' collection='list' open='(' close=')' separator=','> " +
            "#{item}" +
            "</foreach> " +
            "</script> ")
    void removeOrgByIds(List<String> ids);

    /**
     *@Author:Fly Created in 2018/7/17 下午2:53
     *@Description: 查询所有组织架构数据
     */
    @Select("select * from yhcc_external_org")
    List<ExternalOrg> findAll();

    /**
     *@Author:Fly Created in 2018/7/17 下午3:09
     *@Description: 同步人员数据
     */
    @Insert("<script> " +
            "insert into yhcc_external_employee values " +
            "<foreach item = 'item' index = 'index' collection='list' separator=','> " +
            "(#{item.id}, #{item.realName}, #{item.loginName}, #{item.email}, #{item.belongOrgId}, " +
            "#{item.mobile}, #{item.delflag}, #{item.status}, #{item.createTime}, " +
            "#{item.modifyTime}, #{item.createUser}, #{item.modifyUser})" +
            "</foreach>" +
            "</script> ")
    void saveEmployee(List<ExternalEmployee> externalEmployees);

    /**
     *@Author:Fly Created in 2018/7/17 下午3:15
     *@Description: 同步删除旧数据
     */
    @Delete("<script> " +
            "delete from yhcc_external_employee where id in" +
            "<foreach item='item' collection='list' open='(' close=')' separator=','> " +
            "#{item}" +
            "</foreach> " +
            "</script> ")
    void removeEmployeeByIds(List<String> ids);
}
