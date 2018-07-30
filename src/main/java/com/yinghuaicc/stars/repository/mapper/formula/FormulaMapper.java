package com.yinghuaicc.stars.repository.mapper.formula;

import com.yinghuaicc.stars.repository.model.formula.Formula;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author:Fly
 * @Date:Create in 2018/7/13 下午1:52
 * @Description: 公式
 * @Modified:
 */
@Repository
public interface FormulaMapper {

    /**
     *@Author:Fly Created in 2018/7/13 下午1:53
     *@Description: 添加公式
     */
    @Insert("<script> " +
            "insert into yhcc_formula values " +
            "<foreach item = 'item' index = 'index' collection='list' separator=','> " +
            "(#{item.id}, #{item.num}, #{item.targetId}, #{item.targetName}, #{item.operationFormula}, #{item.resultFormula}, #{item.state}, " +
            "#{item.createTime}, #{item.modifyTime}, #{item.createUser}, #{item.modifyUser} )"+
            "</foreach> " +
            "</script> ")
    void saveFormula(List<Formula> formula);

    /**
     *@Author:Fly Created in 2018/7/13 下午2:12
     *@Description: 编辑公式
     */
    @Update("update yhcc_formula set " +
            "num = #{num}, target_id = #{targetId}, target_name = #{targetName}, operation_formula = #{operationFormula}, result_formula = #{resultFormula}, " +
            "state = #{state}, create_time = #{createTime}, modify_time = #{modifyTime}, create_user = #{createUser}, modify_user = #{modifyUser}")
    void editFormula(Formula formula);

    /**
     *@Author:Fly Created in 2018/7/13 下午2:21
     *@Description: 查询指标详情
     */
    @Select("select * from yhcc_formula where id = #{id}")
    Formula findFormulaById(String id);

    /**
     *@Author:Fly Created in 2018/7/13 下午2:22
     *@Description: 删除指标
     */
    @Delete("delete from yhcc_formula where id = #{id}")
    void removeFormula(String id);




}
