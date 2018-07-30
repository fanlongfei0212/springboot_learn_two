package com.yinghuaicc.stars.service.base;

import com.yinghuaicc.stars.config.page.PageParam;
import com.yinghuaicc.stars.config.page.ResultPageList;
import com.yinghuaicc.stars.service.base.dto.request.EditBusinessFormRequestDTO;
import com.yinghuaicc.stars.service.base.dto.request.EditBusinessSpeciesRequestDTO;
import com.yinghuaicc.stars.service.base.dto.request.SaveBusinessSpeciesRequestDTO;
import com.yinghuaicc.stars.service.base.dto.response.*;

import java.util.List;

/**
 * @Author:Fly
 * @Date:Create in 2018/7/5 上午10:44
 * @Description: 基础数据
 * @Modified:
 */
public interface BaseService {

    /**
     *@Author:Fly Created in 2018/7/5 上午10:46
     *@Description: 全部城市
     */
    List<FindCityAllResponseDTO> findCityAll();

    /**
     *@Author:Fly Created in 2018/7/9 下午12:33
     *@Description: 添加业态
     */
    void saveBusinessForm(String name, String loginEmployeeId);

    /**
     *@Author:Fly Created in 2018/7/9 下午12:34
     *@Description: 编辑业态
     */
    void editBusinessForm(EditBusinessFormRequestDTO editBusinessFormRequestDTO, String loginEmployeeId);

    /**
     *@Author:Fly Created in 2018/7/9 下午11:45
     *@Description: 业态详情
     */
    FindBusinessFormByIdResponseDTO findBusinessFormById(String id);

    /**
     *@Author:Fly Created in 2018/7/9 下午12:35
     *@Description: 删除业态
     */
    void removeBusinessForm(String id);


    /**
     *@Author:Fly Created in 2018/7/9 下午12:37
     *@Description: 查询业态列表
     */
    ResultPageList<FindBusinessFormListResponseDTO> findBusinessFormList(PageParam pageParam);

    /**
     *@Author:Fly Created in 2018/7/9 下午12:40
     *@Description: 添加业种
     */
    void saveBusinessSpecies(SaveBusinessSpeciesRequestDTO saveBusinessSpeciesRequestDTO, String loginEmployeeId);

    /**
     *@Author:Fly Created in 2018/7/9 下午12:41
     *@Description: 修改业种
     */
    void editBusinessSpecies(EditBusinessSpeciesRequestDTO editBusinessSpeciesRequestDTO, String loginEmployeeId);

    /**
     *@Author:Fly Created in 2018/7/9 下午12:41
     *@Description: 删除业种
     */
    void removeBusinessSpecies(String id);

    /**
     *@Author:Fly Created in 2018/7/9 下午11:51
     *@Description: 业种详情
     */
    FindBusinessSpeciesByIdResponseDTO findBusinessSpeciesById(String id);

    /**
     *@Author:Fly Created in 2018/7/27 下午5:54
     *@Description: 业态下拉
     */
    List<FindBusinessFormSelectResponseDTO> findFindBusinessFormSelect();

    /**
     *@Author:Fly Created in 2018/7/27 下午5:54
     *@Description: 业种下拉
     */
    List<FindBusinessSpeciesSelectResponseDTO> findBusinessSpeciesSelect(String businessFormId);
}
