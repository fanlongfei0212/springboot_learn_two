package com.yinghuaicc.stars.service.brand;

import com.yinghuaicc.stars.common.utils.exception.ExceptionUtil;
import com.yinghuaicc.stars.common.utils.mapper.MapperFactoryUtil;
import com.yinghuaicc.stars.common.utils.uuid.UuidUtil;
import com.yinghuaicc.stars.config.base.BusinessNum;
import com.yinghuaicc.stars.repository.mapper.base.BaseMapper;
import com.yinghuaicc.stars.repository.mapper.brand.BrandMapper;
import com.yinghuaicc.stars.repository.model.brand.Brand;
import com.yinghuaicc.stars.service.brand.dto.request.EditBrandRequestDTO;
import com.yinghuaicc.stars.service.brand.dto.request.SaveBrandRequestDTO;
import com.yinghuaicc.stars.service.brand.dto.response.BrandAllResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Author:Fly
 * @Date:Create in 2018/7/12 下午2:56
 * @Description: 品牌服务
 * @Modified:
 */
@Service
public class BrandServiceImpl implements BrandService{

    @Autowired
    private ExceptionUtil exceptionUtil;

    @Autowired
    private BrandMapper brandMapper;

    @Autowired
    private BaseMapper baseMapper;


    /**
     *@Author:Fly Created in 2018/7/12 下午3:06
     *@Description: 添加品牌
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void saveBrand(SaveBrandRequestDTO saveBrandRequestDTO, String loginEmployeeId) {

        if (Objects.isNull(baseMapper.findBusinessFormById(saveBrandRequestDTO.getBusinessFormId()))){

            throw exceptionUtil.throwCustomException("BRAND_SAVE_BRAND_005");
        }

        if (Objects.isNull(baseMapper.findBusinessSpeciesById(saveBrandRequestDTO.getBusinessSpeciesId()))){

            throw exceptionUtil.throwCustomException("BRAND_SAVE_BRAND_006");
        }

        brandMapper.saveBrand(
                Stream.of(
                        MapperFactoryUtil.mapperObject(saveBrandRequestDTO, Brand.class)
                                .setId(UuidUtil.randomUUID())
                                .setNum(BusinessNum.BRAND+UuidUtil.randomUUID())
                                .setState(2)
                                .setModifyUser(loginEmployeeId)
                                .setCreateUser(loginEmployeeId)
                                .setModifyTime(LocalDateTime.now())
                                .setCreateTime(LocalDateTime.now()))
                        .collect(Collectors.toList()));
    }

    /**
     *@Author:Fly Created in 2018/7/12 下午3:06
     *@Description: 编辑品牌
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void editBrand(EditBrandRequestDTO editBrandRequestDTO, String loginEmployeeId) {

        Brand brand = brandMapper.findBrandById(editBrandRequestDTO.getId());

        if (Objects.isNull(brand)){

            throw exceptionUtil.throwCustomException("BRAND_EDIT_BRAND_008");
        }

        brandMapper.editBrand(
                brand
                        .setName(editBrandRequestDTO.getName())
                        .setBusinessFormId(editBrandRequestDTO.getBusinessFormId())
                        .setBusinessSpeciesId(editBrandRequestDTO.getBusinessSpeciesId())
                        .setBrandType(editBrandRequestDTO.getBrandType())
                        .setModifyTime(LocalDateTime.now())
                        .setModifyUser(loginEmployeeId));
    }

    /**
     *@Author:Fly Created in 2018/7/12 下午3:06
     *@Description: 删除品牌
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void removeBrand(String id) {

        brandMapper.removeBrandById(id);
    }

    /**
     *@Author:Fly Created in 2018/7/16 下午12:45
     *@Description: 所有品牌
     */
    @Override
    public List<BrandAllResponseDTO> brandAll() {

        return MapperFactoryUtil.mapperList(brandMapper.findBrandAll(), BrandAllResponseDTO.class);
    }

    /**
     *@Author:Fly Created in 2018/7/30 下午12:56
     *@Description: 根据业种查询品牌
     */
    @Override
    public List<Brand> findBrandByBusinessSpeciesId(String businessSpeciesId) {

        return brandMapper.findBrandByBusinessSpeciesId(businessSpeciesId);
    }
}
