package com.yinghuaicc.stars.service.cqrs.tissue;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.yinghuaicc.stars.config.page.PageParam;
import com.yinghuaicc.stars.config.page.ResultPageList;
import com.yinghuaicc.stars.repository.mapper.cqrs.tissue.TissueCQRSMapper;
import com.yinghuaicc.stars.service.cqrs.tissue.dto.request.EmployeeListCQRSRequestDTO;
import com.yinghuaicc.stars.service.cqrs.tissue.dto.response.EmployeeListCQRSResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author:Fly
 * @Date:Create in 2018/7/18 下午3:06
 * @Description:
 * @Modified:
 */
@Service
public class TissueCQRSServiceImpl implements TissueCQRSService{

    @Autowired
    private TissueCQRSMapper tissueCQRSMapper;

    /**
     *@Author:Fly Created in 2018/7/18 下午3:06
     *@Description: 分页查询所有员工
     */
    @Override
    public ResultPageList<EmployeeListCQRSResponseDTO> findEmployeeListCQRS(EmployeeListCQRSRequestDTO employeeListCQRSRequestDTO, PageParam pageParam) {

        Page page = PageHelper.startPage(pageParam.getP(), pageParam.getC());

        List<EmployeeListCQRSResponseDTO> result = tissueCQRSMapper.employeeListCQRS(employeeListCQRSRequestDTO);

        return new ResultPageList<EmployeeListCQRSResponseDTO>()
                .setResultList(result)
                .setPage(pageParam.getP())
                .setSize(pageParam.getC())
                .setCountPage(page.getPages())
                .setCountSize(page.getTotal());
    }
}
