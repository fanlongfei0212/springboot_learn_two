package com.yinghuaicc.stars.repository.mapper.target;

import com.yinghuaicc.stars.repository.model.target.Target;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author:Fly
 * @Date:Create in 2018/7/7 下午2:11
 * @Description: 指标
 * @Modified:
 */
@Repository
public interface TargetMapper {

    /**
     *@Author:Fly Created in 2018/7/7 下午2:18
     *@Description: 添加指标
     */
    @Insert("insert into yhcc_target " +
            "values (#{id}, #{num}, #{name}, #{showName}, #{state}, " +
            "#{targetType}, #{createTime}, #{modifyTime}, #{createUser}, #{modifyUser})")
    void saveTarget(Target target);

    /**
     *@Author:Fly Created in 2018/7/7 下午2:20
     *@Description: 修改指标
     */
    @Update("update yhcc_target set " +
            "num = #{num}, name = #{name}, show_name = #{showName}, state = #{state}, " +
            "target_type = #{targetType}, create_time = #{createTime}, modify_time = #{modifyTime}, create_user = #{createUser}, modify_user = #{modifyUser} " +
            "where id = #{id}")
    void editTarget(Target target);

    /**
     *@Author:Fly Created in 2018/7/7 下午2:21
     *@Description: 删除指标
     */
    @Delete("delete from yhcc_target where id = #{id}")
    void removeTarget(String id);

    /**
     *@Author:Fly Created in 2018/7/7 下午2:31
     *@Description: 根据指标id查询指标信息
     */
    @Select("select * from yhcc_target where id = #{id}")
    Target findTargetById(String id);

    /**
     *@Author:Fly Created in 2018/7/7 下午2:33
     *@Description: 查询所有指标
     */
    @Select("<script> " +
            "select * from yhcc_target " +
            "<where> " +
            "<bind name='num' value=\"'%' + num + '%'\" /> " +
            "<bind name='name' value=\"'%' + name + '%'\" /> " +
            "<bind name='showName' value=\"'%' + showName + '%'\" /> " +
            "<if test='num != null and num != \"\" '>AND num like #{num}</if> " +
            "<if test='name != null and name != \"\" '>AND name like #{name}</if> " +
            "<if test='showName != null and showName != \"\" '>AND show_name like #{showName}</if> " +
            "<if test='targetType != null'>AND target_type = #{targetType}</if> " +
            "<if test='state != null'>AND state = #{state}</if> " +
            "</where> " +
            "order by modify_time desc " +
            "</script> ")
    List<Target> findTargetList(Target target);

    /**
     *@Author:Fly Created in 2018/7/7 下午2:55
     *@Description: 查询数据中是否存在的名称或显示名称，根据指标名称查询是否存在同名业种(新增时指标id可以不传，修改时必须传指标id，否则自己不能修改自己)
     */
    @Select("<script> " +
            "select count(*) from yhcc_target where name = #{name} or show_name = #{name} " +
            "<if test = ' id != null '>and id != #{id} </if> " +
            "</script> ")
    Integer countTargetByNameOrShowName(String name, String id);

}
