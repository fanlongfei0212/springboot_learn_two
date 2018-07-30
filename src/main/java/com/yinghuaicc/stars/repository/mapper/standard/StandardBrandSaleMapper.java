package com.yinghuaicc.stars.repository.mapper.standard;

import com.yinghuaicc.stars.repository.model.standard.StandardBrandSale;
import com.yinghuaicc.stars.service.cqrs.standard.dto.request.StandardBrandSaleRequestDTO;
import com.yinghuaicc.stars.service.cqrs.standard.dto.response.StandardBrandSaleResponseDTO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StandardBrandSaleMapper {

    @Select("<script>select * from yhcc_standard_condition_sale " +
            " <where> " +
            "<bind name='search.saleVessionName' value='search.saleVessionName' /> " +
            "<bind name='search.contractId' value='search.contractId' /> " +
            "<bind name='search.projectId' value='search.projectId' /> " +
            "<if test='search.saleVessionName != null'>AND sale_vession_name = #{search.saleVessionName}</if> " +
            "<if test='search.contractId != null'>AND contract_id = #{search.contractId}</if> " +
            "<if test='search.conditionName != null'>AND project_id = #{search.projectId}</if> " +
            "</where> " +
            "</script>")
    List<StandardBrandSaleResponseDTO> findStandardBrandSaleByStandardBrandSaleCQRS(@Param("search") StandardBrandSaleRequestDTO standardBrandSaleRequestDTO);

    /**
     *添加标准三角形品牌客销度
     * @param standardBrandSale
     */
    @Insert("insert into yhcc_standard_condition_sale " +
            "values(#{id}),#{saleVessionId},#{saleVessionName},#{contractId},#{projectId},#{projectName}," +
            "#{contractName},#{conditionId},#{conditionName},#{majoId},#{majoName},#{grossRate},#{perSale},#{signStatus},#{createTime},#{modifyTime},#{createUser},#{modifyUser}")
    void saveStandardBrandSale(StandardBrandSale standardBrandSale);




}
