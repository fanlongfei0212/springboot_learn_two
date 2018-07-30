package com.yinghuaicc.stars.service.target;

import com.yinghuaicc.stars.config.page.PageParam;
import com.yinghuaicc.stars.config.page.ResultPageList;
import com.yinghuaicc.stars.service.target.dto.request.EditTargetRequestDTO;
import com.yinghuaicc.stars.service.target.dto.request.FindTargetAllListRequestDTO;
import com.yinghuaicc.stars.service.target.dto.request.IsAbleTargetRequestDTO;
import com.yinghuaicc.stars.service.target.dto.request.SaveTargetRequestDTO;
import com.yinghuaicc.stars.service.target.dto.response.FindTargetAllListResponseDTO;


/**
 * @Author:Fly
 * @Date:Create in 2018/7/7 下午2:21
 * @Description: 指标服务
 * @Modified:
 */
public interface TargetService {

    /**
     *@Author:Fly Created in 2018/7/7 下午2:25
     *@Description: 添加指标服务
     */
    void saveTarget(SaveTargetRequestDTO saveTargetRequestDTO, String loginEmployeeId);

    /**
     *@Author:Fly Created in 2018/7/7 下午2:26
     *@Description: 修改指标服务
     */
    void editTarget(EditTargetRequestDTO editTargetRequestDTO, String loginEmployeeId);

    /**
     *@Author:Fly Created in 2018/7/7 下午2:27
     *@Description: 删除指标
     */
    void removeTarget(String id);

    /**
     *@Author:Fly Created in 2018/7/7 下午2:29
     *@Description: 禁用/启用指标
     */
    void isAbleTarget(IsAbleTargetRequestDTO isAbleTargetRequestDTO, String loginEmployeeId);

    /**
     *@Author:Fly Created in 2018/7/7 下午2:42
     *@Description: 分页查询所有指标
     */
    ResultPageList<FindTargetAllListResponseDTO> findTargetList(FindTargetAllListRequestDTO findTargetAllListRequestDTO, PageParam pageParam);
}
