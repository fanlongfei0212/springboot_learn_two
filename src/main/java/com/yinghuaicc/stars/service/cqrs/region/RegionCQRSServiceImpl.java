package com.yinghuaicc.stars.service.cqrs.region;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.yinghuaicc.stars.common.utils.exception.ExceptionUtil;
import com.yinghuaicc.stars.common.utils.mapper.MapperFactoryUtil;
import com.yinghuaicc.stars.config.page.PageParam;
import com.yinghuaicc.stars.config.page.ResultPageList;
import com.yinghuaicc.stars.controller.config.aop.pc.AopResourceEmployeeBean;
import com.yinghuaicc.stars.repository.mapper.cqrs.region.RegionCQRSMapper;
import com.yinghuaicc.stars.repository.mapper.region.RegionMapper;
import com.yinghuaicc.stars.repository.mapper.tissue.TissueMapper;
import com.yinghuaicc.stars.service.cqrs.region.dto.request.FloorCQRSListRequestDTO;
import com.yinghuaicc.stars.service.cqrs.region.dto.request.ProjectCQRSListRequestDTO;
import com.yinghuaicc.stars.service.cqrs.region.dto.request.RoomCQRSListRequestDTO;
import com.yinghuaicc.stars.service.cqrs.region.dto.response.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @Author:Fly
 * @Date:Create in 2018/7/3 下午7:57
 * @Description: 项目管理服务
 * @Modified:
 */
@Service
public class RegionCQRSServiceImpl implements RegionCQRSService {

    @Autowired
    private TissueMapper tissueMapper;

    @Autowired
    private RegionCQRSMapper regionCQRSMapper;

    @Autowired
    private RegionMapper regionMapper;

    @Autowired
    private ExceptionUtil exceptionUtil;

    /**
     *@Author:Fly Created in 2018/7/3 下午7:57
     *@Description: 项目管理列表
     */
    @Override
    public ResultPageList<ProjectCQRSListResponseDTO> projectList(ProjectCQRSListRequestDTO projectCQRSListRequestDTO, AopResourceEmployeeBean aopResourceEmployeeBean, PageParam pageParam) {

        Page page = null;

        List<ProjectCQRSListResponseDTO> result = new ArrayList<ProjectCQRSListResponseDTO>();


        if (Objects.nonNull(aopResourceEmployeeBean.getProjectIds())&&aopResourceEmployeeBean.getProjectIds().size()>0){

            page = PageHelper.startPage(pageParam.getP(), pageParam.getC());

            result = regionCQRSMapper.findProjectCQRS(
                    aopResourceEmployeeBean.getProjectIds(), projectCQRSListRequestDTO);
        }

        return new ResultPageList<ProjectCQRSListResponseDTO>()
                .setResultList(result)
                .setPage(pageParam.getP())
                .setSize(pageParam.getC())
                .setCountPage(Objects.isNull(page)?0:page.getPages())
                .setCountSize(Objects.isNull(page)?0:page.getTotal());

    }

    /**
     *@Author:Fly Created in 2018/7/5 上午9:52
     *@Description: 项目详情
     */
    @Override
    public ProjectCQRSInfoByIdResponseDTO projectInfo(String projectId) {

        ProjectCQRSInfoByIdResponseDTO result = regionCQRSMapper.findProjectByIdCQRS(projectId);

        if (Objects.isNull(result)){

            throw exceptionUtil.throwCustomException("CQRS_PROJECT_PROJECT_INFO_001");
        }

//        result.setProjectRelationTeamName(
//                MapperFactoryUtil.mapperList(
//                        tissueMapper.findEmployeeListById(
//                                regionMapper.findEmployeeProjectRelationTeamByProjectId(projectId)
//                                        .stream().map(employeeProjectRelationTeam -> employeeProjectRelationTeam.getEmployeeId()).collect(Collectors.toList())), ProjectCQRSInfoEmployeeResponseDTO.class))
//                .setProjectImages(regionMapper.findProjectImageByProjectId(projectId).stream().map(projectImage -> projectImage.getUrl()).collect(Collectors.toList()));

        return result;
    }

    /**
     *@Author:Fly Created in 2018/7/11 下午3:27
     *@Description: 层详情
     */
    @Override
    public FloorCQRSInfoByIdResponseDTO floorInfo(String floorId) {

        return regionCQRSMapper.findFloorByIdCQRS(floorId);
    }

    /**
     *@Author:Fly Created in 2018/7/11 下午4:51
     *@Description: 层列表
     */
    @Override
    public ResultPageList<FloorCQRSListResponseDTO> floorList(FloorCQRSListRequestDTO floorCQRSListRequestDTO, PageParam pageParam) {

        Page page = PageHelper.startPage(pageParam.getP(), pageParam.getC());

        List<FloorCQRSListResponseDTO> result = regionCQRSMapper.findFloorListCQRS(floorCQRSListRequestDTO);
        return new ResultPageList<FloorCQRSListResponseDTO>()
                .setResultList(result)
                .setPage(pageParam.getP())
                .setSize(pageParam.getC())
                .setCountPage(page.getPages())
                .setCountSize(page.getTotal());
    }

    /**
     *@Author:Fly Created in 2018/7/11 下午11:53
     *@Description: 铺位详情
     */
    @Override
    public RoomCQRSInfoByIdResponseDTO roomInfo(String roomId) {

        return regionCQRSMapper.findRoomByIdCQRS(roomId);
    }

    /**
     *@Author:Fly Created in 2018/7/12 上午12:52
     *@Description: 铺位列表
     */
    @Override
    public ResultPageList<RoomCQRSListResponseDTO> roomList(RoomCQRSListRequestDTO roomCQRSListRequestDTO, PageParam pageParam) {

        Page page = PageHelper.startPage(pageParam.getP(), pageParam.getC());

        List<RoomCQRSListResponseDTO> result = regionCQRSMapper.findRoomListCQRS(roomCQRSListRequestDTO);

        return new ResultPageList<RoomCQRSListResponseDTO>()
                .setResultList(result)
                .setPage(pageParam.getP())
                .setSize(pageParam.getC())
                .setCountPage(page.getPages())
                .setCountSize(page.getTotal());
    }

    /**
     *@Author:Fly Created in 2018/7/17 上午10:52
     *@Description: 查询未签约的铺位
     */
    @Override
    public List<FindRoomByProjectCQRSResponseDTO> roomByProject(String projectId, String roomName) {

        return regionCQRSMapper.findRoomByProjectCQRS(projectId, roomName);
    }

}
