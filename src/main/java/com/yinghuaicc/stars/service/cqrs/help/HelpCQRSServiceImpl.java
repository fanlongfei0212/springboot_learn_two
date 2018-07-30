package com.yinghuaicc.stars.service.cqrs.help;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.yinghuaicc.stars.config.page.PageParam;
import com.yinghuaicc.stars.config.page.ResultPageList;
import com.yinghuaicc.stars.repository.mapper.cqrs.help.HelpCQRSMapper;
import com.yinghuaicc.stars.repository.mapper.help.HelpMapper;
import com.yinghuaicc.stars.service.cqrs.help.dto.request.FindHelpPlanFloorListCQRSRequestDTO;
import com.yinghuaicc.stars.service.cqrs.help.dto.request.FindHelpPlanProjectListCQRSRequestDTO;
import com.yinghuaicc.stars.service.cqrs.help.dto.response.FindHelpPlanBusinessSpeciesListCQRSResponseDTO;
import com.yinghuaicc.stars.service.cqrs.help.dto.response.FindHelpPlanFloorListCQRSResponseDTO;
import com.yinghuaicc.stars.service.cqrs.help.dto.response.FindHelpPlanProjectListCQRSResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author:Fly
 * @Date:Create in 2018/7/20 上午10:45
 * @Description: 帮扶计划
 * @Modified:
 */
@Service
public class HelpCQRSServiceImpl implements HelpCQRSService {

    @Autowired
    private HelpMapper helpMapper;

    @Autowired
    private HelpCQRSMapper helpCQRSMapper;

    /**
     *@Author:Fly Created in 2018/7/20 上午11:17
     *@Description: 项目帮扶计划列表
     */
    @Override
    public ResultPageList<FindHelpPlanProjectListCQRSResponseDTO> findHelpPlanProjectListCQRS(FindHelpPlanProjectListCQRSRequestDTO findHelpPlanProjectListCQRSRequestDTO, PageParam pageParam) {

        Page page = PageHelper.startPage(pageParam.getP(), pageParam.getC());

        List<FindHelpPlanProjectListCQRSResponseDTO> result =
                helpCQRSMapper.findHelpPlanCQRSList(findHelpPlanProjectListCQRSRequestDTO);

        return new ResultPageList<FindHelpPlanProjectListCQRSResponseDTO>()
                .setResultList(result)
                .setPage(pageParam.getP())
                .setSize(pageParam.getC())
                .setCountPage(page.getPages())
                .setCountSize(page.getTotal());
    }

    /**
     *@Author:Fly Created in 2018/7/20 下午8:13
     *@Description: 层帮扶计划列表
     */
    @Override
    public ResultPageList<FindHelpPlanFloorListCQRSResponseDTO> findHelpPlanFloorListCQRS(FindHelpPlanFloorListCQRSRequestDTO findHelpPlanFloorListCQRSRequestDTO, PageParam pageParam) {

        Page page = PageHelper.startPage(pageParam.getP(), pageParam.getC());

        List<FindHelpPlanFloorListCQRSResponseDTO> result =
                helpCQRSMapper.findHelpPlanFloorCQRSList(findHelpPlanFloorListCQRSRequestDTO);

        return new ResultPageList<FindHelpPlanFloorListCQRSResponseDTO>()
                .setResultList(result)
                .setPage(pageParam.getP())
                .setSize(pageParam.getC())
                .setCountPage(page.getPages())
                .setCountSize(page.getTotal());
    }

    /**
     *@Author:Fly Created in 2018/7/21 下午1:54
     *@Description: 业态帮扶计划列表
     */
    @Override
    public ResultPageList<FindHelpPlanBusinessSpeciesListCQRSResponseDTO> findHelpPlanBusinessSpeciesListCQRS(String projectId, PageParam pageParam) {

        Page page = PageHelper.startPage(pageParam.getP(), pageParam.getC());

        List<FindHelpPlanBusinessSpeciesListCQRSResponseDTO> result =
                helpCQRSMapper.findHelpPlanBusinessSpeciesCQRSList(projectId);

        return new ResultPageList<FindHelpPlanBusinessSpeciesListCQRSResponseDTO>()
                .setResultList(result)
                .setPage(pageParam.getP())
                .setSize(pageParam.getC())
                .setCountPage(page.getPages())
                .setCountSize(page.getTotal());
    }
}
