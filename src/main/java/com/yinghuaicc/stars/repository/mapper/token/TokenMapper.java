package com.yinghuaicc.stars.repository.mapper.token;

import com.yinghuaicc.stars.repository.model.token.AppToken;
import com.yinghuaicc.stars.repository.model.token.Token;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author:Fly
 * @Date:Create in 2018/7/2 下午7:09
 * @Description: Token
 * @Modified:
 */
@Repository
public interface TokenMapper {

    /**
     *@Author:Fly Created in 2018/7/2 下午7:16
     *@Description: 根据员工id查询Token
     */
    @Select("select * from yhcc_token where employee_id = #{employeeId}")
    List<Token> findTokenByEmployeeId(String employeeId);

    /**
     *@Author:Fly Created in 2018/7/2 下午7:25
     *@Description: 删除员工Token
     */
    @Delete("delete from yhcc_token where employee_id = #{employeeId}")
    void removeTokenByEmployeeId(String employeeId);

    /**
     *@Author:Fly Created in 2018/7/2 下午8:20
     *@Description: 添加Token信息
     */
    @Insert("insert into yhcc_token " +
            "values(#{id}, #{accessToken}, #{refreshToken}, #{employeeId}, #{createTime}, #{modifyTime}, #{createUser}, #{modifyUser})")
    void saveToken(Token token);

    /**
     *@Author:Fly Created in 2018/7/3 上午9:44
     *@Description: 根据RefreshToken查询Token信息
     */
    @Select("select * from yhcc_token where refresh_token = #{refreshToken}")
    Token findByRefreshToken(String refreshToken);

    /**
     *@Author:Fly Created in 2018/7/3 上午1:36
     *@Description: 根据RefreshToken修改Token信息
     */
    @Update("update yhcc_token " +
            "set " +
            "access_token = #{accessToken}, " +
            "refresh_token = #{refreshToken}, " +
            "employee_id = #{employeeId}, " +
            "modify_time = #{modifyTime}, " +
            "create_time = #{createTime}, " +
            "create_user = #{createUser}, " +
            "modify_user = #{modifyUser} " +
            "where refresh_token = #{refreshToken}")
    void editTokenByRefreshToken(Token token);

    /**
     *@Author:Fly Created in 2018/7/3 上午11:08
     *@Description: 根据AccessToken获取Token信息
     */
    @Select("select * from yhcc_token where access_token = #{accessToken}")
    Token findByAccessToken(String accessToken);

    /**
     *@Author:Fly Created in 2018/7/25 下午4:23
     *@Description: 按照员工id删除AppToken信息
     */
    @Delete("delete from yhcc_app_token where employee_id = #{employeeId}")
    void removeAppTokenByEmployeeId(String employeeId);

    /**
     *@Author:Fly Created in 2018/7/25 下午4:25
     *@Description: 添加AppToken
     */
    @Insert("insert into yhcc_app_token " +
            "values(#{id}, #{accessToken}, #{refreshToken}, #{employeeId}, #{createTime}, #{modifyTime}, #{createUser}, #{modifyUser})")
    void saveAppToken(AppToken appToken);

    /**
     *@Author:Fly Created in 2018/7/25 下午4:25
     *@Description: 按照App的RefreshToken查询AccessToken
     */
    @Select("select * from yhcc_app_token where refresh_token = #{refreshToken}")
    AppToken findByRefreshAppToken(String refreshToken);

    /**
     *@Author:Fly Created in 2018/7/25 下午4:27
     *@Description: 根据RefreshToken修改AppToken信息
     */
    @Update("update yhcc_app_token " +
            "set " +
            "access_token = #{accessToken}, " +
            "refresh_token = #{refreshToken}, " +
            "employee_id = #{employeeId}, " +
            "modify_time = #{modifyTime}, " +
            "create_time = #{createTime}, " +
            "create_user = #{createUser}, " +
            "modify_user = #{modifyUser} " +
            "where refresh_token = #{refreshToken}")
    void editTokenByRefreshAppToken(AppToken token);

    /**
     *@Author:Fly Created in 2018/7/25 下午4:27
     *@Description: 根据AccessToken获取AppToken信息
     */
    @Select("select * from yhcc_app_token where access_token = #{accessToken}")
    AppToken findByAppAccessToken(String accessToken);

}
