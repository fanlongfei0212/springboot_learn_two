package com.yinghuaicc.stars.service.cqrs.tissue;

import com.yinghuaicc.stars.config.page.PageParam;
import com.yinghuaicc.stars.config.page.ResultPageList;
import com.yinghuaicc.stars.service.cqrs.tissue.dto.request.EmployeeListCQRSRequestDTO;
import com.yinghuaicc.stars.service.cqrs.tissue.dto.response.EmployeeListCQRSResponseDTO;

/**
 * @Author:Fly
 * @Date:Create in 2018/7/18 下午2:41
 * @Description:
 * @Modified:
 */
public interface TissueCQRSService {

    /**
     *@Author:Fly Created in 2018/7/18 下午3:05
     *@Description: 分页查询所有员工
     */
    ResultPageList<EmployeeListCQRSResponseDTO> findEmployeeListCQRS(EmployeeListCQRSRequestDTO employeeListCQRSRequestDTO, PageParam pageParam);
}
