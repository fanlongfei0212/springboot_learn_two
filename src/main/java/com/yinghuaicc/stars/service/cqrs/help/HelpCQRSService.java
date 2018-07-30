package com.yinghuaicc.stars.service.cqrs.help;

import com.yinghuaicc.stars.config.page.PageParam;
import com.yinghuaicc.stars.config.page.ResultPageList;
import com.yinghuaicc.stars.service.cqrs.help.dto.request.FindHelpPlanFloorListCQRSRequestDTO;
import com.yinghuaicc.stars.service.cqrs.help.dto.request.FindHelpPlanProjectListCQRSRequestDTO;
import com.yinghuaicc.stars.service.cqrs.help.dto.response.FindHelpPlanBusinessSpeciesListCQRSResponseDTO;
import com.yinghuaicc.stars.service.cqrs.help.dto.response.FindHelpPlanFloorListCQRSResponseDTO;
import com.yinghuaicc.stars.service.cqrs.help.dto.response.FindHelpPlanProjectListCQRSResponseDTO;

/**
 * @Author:Fly
 * @Date:Create in 2018/7/20 上午10:42
 * @Description: 帮扶计划CQRS
 * @Modified:
 */
public interface HelpCQRSService {

    /**
     *@Author:Fly Created in 2018/7/20 上午11:15
     *@Description: 项目帮扶计划列表
     */
    ResultPageList<FindHelpPlanProjectListCQRSResponseDTO> findHelpPlanProjectListCQRS(FindHelpPlanProjectListCQRSRequestDTO findHelpPlanProjectListCQRSRequestDTO, PageParam pageParam);

    /**
     *@Author:Fly Created in 2018/7/20 下午8:13
     *@Description: 层帮扶计划
     */
    ResultPageList<FindHelpPlanFloorListCQRSResponseDTO> findHelpPlanFloorListCQRS(FindHelpPlanFloorListCQRSRequestDTO findHelpPlanFloorListCQRSRequestDTO, PageParam pageParam);

    /**
     *@Author:Fly Created in 2018/7/21 下午1:53
     *@Description: 业态帮扶计划
     */
    ResultPageList<FindHelpPlanBusinessSpeciesListCQRSResponseDTO> findHelpPlanBusinessSpeciesListCQRS(String projectId, PageParam pageParam);
}
