package com.yinghuaicc.stars.service.base;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.yinghuaicc.stars.common.utils.exception.ExceptionUtil;
import com.yinghuaicc.stars.common.utils.mapper.MapperFactoryUtil;
import com.yinghuaicc.stars.common.utils.uuid.UuidUtil;
import com.yinghuaicc.stars.config.base.BusinessNum;
import com.yinghuaicc.stars.config.page.PageParam;
import com.yinghuaicc.stars.config.page.ResultPageList;
import com.yinghuaicc.stars.repository.mapper.base.BaseMapper;
import com.yinghuaicc.stars.repository.mapper.brand.BrandMapper;
import com.yinghuaicc.stars.repository.model.base.BusinessForm;
import com.yinghuaicc.stars.repository.model.base.BusinessSpecies;
import com.yinghuaicc.stars.service.base.dto.request.EditBusinessFormRequestDTO;
import com.yinghuaicc.stars.service.base.dto.request.EditBusinessSpeciesRequestDTO;
import com.yinghuaicc.stars.service.base.dto.request.SaveBusinessSpeciesRequestDTO;
import com.yinghuaicc.stars.service.base.dto.response.*;
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
 * @Date:Create in 2018/7/5 上午10:47
 * @Description:
 * @Modified:
 */
@Service
public class BaseServiceImpl implements BaseService{

    @Autowired
    private BaseMapper baseMapper;

    @Autowired
    private ExceptionUtil exceptionUtil;

    @Autowired
    private BrandMapper brandMapper;

    /**
     *@Author:Fly Created in 2018/7/5 上午10:47
     *@Description: 查询全部城市
     */
    @Override
    public List<FindCityAllResponseDTO> findCityAll() {

        return MapperFactoryUtil.mapperList(
                baseMapper.findCityAll(), FindCityAllResponseDTO.class);
    }

    /**
     *@Author:Fly Created in 2018/7/9 下午12:43
     *@Description: 添加业态
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void saveBusinessForm(String name, String loginEmployeeId) {

        if (baseMapper.countBusinessFormByName(name, null) > 0){

            throw exceptionUtil.throwCustomException("BASE_SAVE_BUSINESS_FORM_001");
        }

        baseMapper.saveBusinessForm(
                Stream.of(new BusinessForm()
                        .setId(UuidUtil.randomUUID())
                        .setNum(BusinessNum.BUSINESS_FORM+UuidUtil.randomUUID())
                        .setName(name)
                        .setCreateTime(LocalDateTime.now())
                        .setModifyTime(LocalDateTime.now())
                        .setCreateUser(loginEmployeeId)
                        .setModifyUser(loginEmployeeId)).collect(Collectors.toList()));
    }

    /**
     *@Author:Fly Created in 2018/7/9 下午12:54
     *@Description: 编辑业态
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void editBusinessForm(EditBusinessFormRequestDTO editBusinessFormRequestDTO, String loginEmployeeId) {

        BusinessForm businessForm = baseMapper.findBusinessFormById(editBusinessFormRequestDTO.getId());

        if (Objects.isNull(businessForm)){

            throw exceptionUtil.throwCustomException("BASE_EDIT_BUSINESS_FORM_003");
        }

        if (baseMapper.countBusinessFormByName(editBusinessFormRequestDTO.getName(), editBusinessFormRequestDTO.getId()) > 0){

            throw exceptionUtil.throwCustomException("BASE_EDIT_BUSINESS_FORM_004");
        }

        baseMapper.editBusinessForm(
                businessForm
                        .setName(editBusinessFormRequestDTO.getName())
                        .setModifyTime(LocalDateTime.now())
                        .setModifyUser(loginEmployeeId));
    }

    /**
     *@Author:Fly Created in 2018/7/9 下午11:45
     *@Description: 业态详情
     */
    @Override
    public FindBusinessFormByIdResponseDTO findBusinessFormById(String id) {

        BusinessForm businessForm = baseMapper.findBusinessFormById(id);

        if (Objects.isNull(businessForm)){

            throw exceptionUtil.throwCustomException("BASE_FIND_BY_ID_BUSINESS_FORM_001");
        }

        return MapperFactoryUtil.mapperObject(businessForm, FindBusinessFormByIdResponseDTO.class);
    }

    /**
     *@Author:Fly Created in 2018/7/9 下午12:59
     *@Description: 删除业态
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void removeBusinessForm(String id) {

        if (baseMapper.countBusinessSpeciesByBusinessFormId(id) > 0){

            throw exceptionUtil.throwCustomException("BASE_REMOVE_BUSINESS_FORM_001");
        }

        baseMapper.removeBusinessForm(id);
    }

    /**
     *@Author:Fly Created in 2018/7/9 下午1:01
     *@Description: 查询业态列表
     */
    @Override
    public ResultPageList<FindBusinessFormListResponseDTO> findBusinessFormList(PageParam pageParam) {

        Page page = PageHelper.startPage(pageParam.getP(), pageParam.getC());

        List<FindBusinessFormListResponseDTO> result =
                MapperFactoryUtil.mapperList(baseMapper.findBusinessFormList(), FindBusinessFormListResponseDTO.class);

        return new ResultPageList<FindBusinessFormListResponseDTO>()
                .setResultList(result)
                .setPage(pageParam.getP())
                .setSize(pageParam.getC())
                .setCountPage(page.getPages())
                .setCountSize(page.getTotal());
    }

    /**
     *@Author:Fly Created in 2018/7/9 下午1:04
     *@Description: 添加业种
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void saveBusinessSpecies(SaveBusinessSpeciesRequestDTO saveBusinessSpeciesRequestDTO, String loginEmployeeId) {

        if (Objects.isNull(baseMapper.findBusinessFormById(saveBusinessSpeciesRequestDTO.getBusinessFormId()))){

            throw exceptionUtil.throwCustomException("BASE_SAVE_BUSINESS_SPECIES_003");
        }

        if (baseMapper.countBusinessSpeciesByName(saveBusinessSpeciesRequestDTO.getName(), null) > 0){

            throw exceptionUtil.throwCustomException("BASE_SAVE_BUSINESS_SPECIES_004");
        }

        baseMapper.saveBusinessSpecies(
                Stream.of(new BusinessSpecies()
                        .setId(UuidUtil.randomUUID())
                        .setNum(BusinessNum.BUSINESS_SPECIES+UuidUtil.randomUUID())
                        .setBusinessFormId(saveBusinessSpeciesRequestDTO.getBusinessFormId())
                        .setName(saveBusinessSpeciesRequestDTO.getName())
                        .setCreateTime(LocalDateTime.now())
                        .setModifyTime(LocalDateTime.now())
                        .setCreateUser(loginEmployeeId)
                        .setModifyUser(loginEmployeeId))
                        .collect(Collectors.toList()));
    }

    /**
     *@Author:Fly Created in 2018/7/9 下午1:10
     *@Description: 修改业种
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void editBusinessSpecies(EditBusinessSpeciesRequestDTO editBusinessSpeciesRequestDTO, String loginEmployeeId) {

        if (Objects.isNull(baseMapper.findBusinessFormById(editBusinessSpeciesRequestDTO.getBusinessFormId()))){

            throw exceptionUtil.throwCustomException("BASE_EDIT_BUSINESS_SPECIES_004");
        }

        if (baseMapper.countBusinessSpeciesByName(editBusinessSpeciesRequestDTO.getName(), editBusinessSpeciesRequestDTO.getId()) > 0){

            throw exceptionUtil.throwCustomException("BASE_EDIT_BUSINESS_SPECIES_005");
        }

        BusinessSpecies businessSpecies = baseMapper.findBusinessSpeciesById(editBusinessSpeciesRequestDTO.getId());

        if (Objects.isNull(businessSpecies)){

            throw exceptionUtil.throwCustomException("BASE_EDIT_BUSINESS_SPECIES_006");
        }

        baseMapper.editBusinessSpecies(
                businessSpecies
                        .setBusinessFormId(editBusinessSpeciesRequestDTO.getBusinessFormId())
                        .setName(editBusinessSpeciesRequestDTO.getName())
                        .setModifyTime(LocalDateTime.now())
                        .setModifyUser(loginEmployeeId));

    }

    /**
     *@Author:Fly Created in 2018/7/9 下午1:18
     *@Description: 删除业种
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void removeBusinessSpecies(String id) {

        if (brandMapper.countBrandByBusinessSpeciesId(id)>0){

            throw exceptionUtil.throwCustomException("REMOVE_BUSINSSSPECIES_001");
        }

        baseMapper.removeBusinessSpecies(id);
    }

    /**
     *@Author:Fly Created in 2018/7/9 下午11:51
     *@Description: 业种详情
     */
    @Override
    public FindBusinessSpeciesByIdResponseDTO findBusinessSpeciesById(String id) {

        BusinessSpecies businessSpecies = baseMapper.findBusinessSpeciesById(id);

        if (Objects.isNull(businessSpecies)){

            throw exceptionUtil.throwCustomException("BASE_FIND_BY_ID_BUSINESS_SPECIES_001");
        }

        return MapperFactoryUtil.mapperObject(businessSpecies, FindBusinessSpeciesByIdResponseDTO.class);
    }

    /**
     *@Author:Fly Created in 2018/7/27 下午5:55
     *@Description: 业态列表
     */
    @Override
    public List<FindBusinessFormSelectResponseDTO> findFindBusinessFormSelect() {

        return MapperFactoryUtil.mapperList(baseMapper.findBusinessFormList(), FindBusinessFormSelectResponseDTO.class);
    }

    /**
     *@Author:Fly Created in 2018/7/27 下午5:55
     *@Description: 业种列表
     */
    @Override
    public List<FindBusinessSpeciesSelectResponseDTO> findBusinessSpeciesSelect(String businessFormId) {

        return MapperFactoryUtil.mapperList(baseMapper.findBusinessSpeciesByBusinessFormId(businessFormId), FindBusinessSpeciesSelectResponseDTO.class);
    }
}
