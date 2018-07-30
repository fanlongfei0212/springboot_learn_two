package com.yinghuaicc.stars.service.cqrs.region;

import com.yinghuaicc.stars.config.page.PageParam;
import com.yinghuaicc.stars.config.page.ResultPageList;
import com.yinghuaicc.stars.controller.config.aop.pc.AopResourceEmployeeBean;
import com.yinghuaicc.stars.service.cqrs.region.dto.request.FloorCQRSListRequestDTO;
import com.yinghuaicc.stars.service.cqrs.region.dto.request.ProjectCQRSListRequestDTO;
import com.yinghuaicc.stars.service.cqrs.region.dto.request.RoomCQRSListRequestDTO;
import com.yinghuaicc.stars.service.cqrs.region.dto.response.*;

import java.util.List;

/**
 * @Author:Fly
 * @Date:Create in 2018/7/3 下午5:18
 * @Description: 项目管理服务
 * @Modified:
 */
public interface RegionCQRSService {

    /**
     *@Author:Fly Created in 2018/7/3 下午5:27
     *@Description: 项目列表
     */
    ResultPageList<ProjectCQRSListResponseDTO> projectList(ProjectCQRSListRequestDTO projectCQRSListRequestDTO, AopResourceEmployeeBean aopResourceEmployeeBean, PageParam pageParam);

    /**
     *@Author:Fly Created in 2018/7/5 上午9:52
     *@Description: 项目详情
     */
    ProjectCQRSInfoByIdResponseDTO projectInfo(String projectId);

    /**
     *@Author:Fly Created in 2018/7/11 下午3:26
     *@Description: 层详情
     */
    FloorCQRSInfoByIdResponseDTO floorInfo(String floorId);

    /**
     *@Author:Fly Created in 2018/7/11 下午4:50
     *@Description: 层列表
     */
    ResultPageList<FloorCQRSListResponseDTO> floorList(FloorCQRSListRequestDTO floorCQRSListRequestDTO, PageParam pageParam);

    /**
     *@Author:Fly Created in 2018/7/11 下午11:53
     *@Description: 铺位详情
     */
    RoomCQRSInfoByIdResponseDTO roomInfo(String roomId);

    /**
     *@Author:Fly Created in 2018/7/12 上午12:52
     *@Description: 铺位列表
     */
    ResultPageList<RoomCQRSListResponseDTO> roomList(RoomCQRSListRequestDTO roomCQRSListRequestDTO, PageParam pageParam);

    /**
     *@Author:Fly Created in 2018/7/17 上午10:51
     *@Description: 查询未签约的铺位
     */
    List<FindRoomByProjectCQRSResponseDTO> roomByProject(String projectId, String roomName);
}
