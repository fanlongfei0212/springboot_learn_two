package com.yinghuaicc.stars.service.help;

import com.yinghuaicc.stars.config.page.PageParam;
import com.yinghuaicc.stars.config.page.ResultPageList;
import com.yinghuaicc.stars.service.help.dto.request.*;
import com.yinghuaicc.stars.service.help.dto.response.FindHelpContextListResponseDTO;

import java.util.List;


/**
 * @Author:Fly
 * @Date:Create in 2018/7/19 下午3:51
 * @Description:
 * @Modified:
 */
public interface HelpService {

    /**
     *@Author:Fly Created in 2018/7/19 下午4:20
     *@Description: 添加帮扶计划
     */
    void saveHelpContext(SaveHelpContextRequestDTO saveHelpContextRequestDTO, String loginEmployeeId);

    /**
     *@Author:Fly Created in 2018/7/19 下午4:22
     *@Description: 编辑帮扶内容
     */
    void editHelpContext(EditHelpContextRequestDTO editHelpContextRequestDTO, String loginEmployeeId);

    /**
     *@Author:Fly Created in 2018/7/19 下午4:23
     *@Description: 删除帮扶内容
     */
    void removeHelpContext(String id);

    /**
     *@Author:Fly Created in 2018/7/19 下午4:24
     *@Description: 帮扶内容列表
     */
    ResultPageList<FindHelpContextListResponseDTO> findHelpContextList(PageParam pageParam, Integer type);

    /**
     *@Author:Fly Created in 2018/7/29 下午5:10
     *@Description: 查询全部列表
     */
    List<FindHelpContextListResponseDTO> findHelpContextAll(Integer type);

    /**
     *@Author:Fly Created in 2018/7/20 下午3:19
     *@Description: 添加项目帮扶计划
     */
    void saveHelpPlanProject(SaveHelpPlanProjectRequestDTO saveHelpPlanProjectRequestDTO, String loginEmployeeId);

    /**
     *@Author:Fly Created in 2018/7/20 下午8:20
     *@Description: 添加层帮扶计划
     */
    void saveHelpPlanFloor(SaveHelpPlanFloorRequestDTO saveHelpPlanFloorRequestDTO, String loginEmployeeId);

    /**
     *@Author:Fly Created in 2018/7/21 下午1:36
     *@Description: 添加业种帮扶计划
     */
    void saveHelpPlanHelpPlanBusinessSpecies(SaveHelpPlanBusinessSpeciesRequestDTO saveHelpPlanBusinessSpeciesRequestDTO, String loginEmployeeId);
}
