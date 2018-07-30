package com.yinghuaicc.stars.service.brand;

import com.yinghuaicc.stars.repository.model.brand.Brand;
import com.yinghuaicc.stars.service.brand.dto.request.EditBrandRequestDTO;
import com.yinghuaicc.stars.service.brand.dto.request.SaveBrandRequestDTO;
import com.yinghuaicc.stars.service.brand.dto.response.BrandAllResponseDTO;

import java.util.List;

/**
 * @Author:Fly
 * @Date:Create in 2018/7/12 下午2:57
 * @Description: 品牌
 * @Modified:
 */
public interface BrandService {

    /**
     *@Author:Fly Created in 2018/7/12 下午3:04
     *@Description: 添加品牌
     */
    void saveBrand(SaveBrandRequestDTO saveBrandRequestDTO, String loginEmployeeId);

    /**
     *@Author:Fly Created in 2018/7/12 下午3:05
     *@Description: 编辑品牌
     */
    void editBrand(EditBrandRequestDTO editBrandRequestDTO, String loginEmployeeId);

    /**
     *@Author:Fly Created in 2018/7/12 下午3:05
     *@Description: 删除品牌
     */
    void removeBrand(String id);

    /**
     *@Author:Fly Created in 2018/7/16 下午12:45
     *@Description: 所有品牌
     */
    List<BrandAllResponseDTO> brandAll();

    /**
     *@Author:Fly Created in 2018/7/30 下午12:55
     *@Description: 根据业种查询品牌
     */
    List<Brand> findBrandByBusinessSpeciesId(String businessSpeciesId);
}
