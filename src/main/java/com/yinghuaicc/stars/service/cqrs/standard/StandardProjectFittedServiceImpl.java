package com.yinghuaicc.stars.service.cqrs.standard;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.yinghuaicc.stars.common.utils.mapper.MapperFactoryUtil;
import com.yinghuaicc.stars.config.page.PageParam;
import com.yinghuaicc.stars.config.page.ResultPageList;
import com.yinghuaicc.stars.repository.mapper.standard.StandardProjectFittedMapper;
import com.yinghuaicc.stars.repository.model.standard.StandardProjectFitted;
import com.yinghuaicc.stars.service.cqrs.standard.dto.request.StandardProjectFittedRequestDTO;
import com.yinghuaicc.stars.service.cqrs.standard.dto.response.StandardProjectFittedResponseDTO;
import com.yinghuaicc.stars.service.cqrs.standard.dto.response.StandardProjectRentResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 标准三角形项目溢租率
 */
@Service
public class StandardProjectFittedServiceImpl implements StandardProjectFittedService {

    @Autowired
    private StandardProjectFittedMapper standardProjectFittedMapper;
    @Override
    public ResultPageList<StandardProjectFittedResponseDTO> findStandardProjectFittedByStandardProjectFittedCQRS(StandardProjectFittedRequestDTO standardProjectFittedRequestDTO, PageParam pageParam) {
        Page page = PageHelper.startPage(pageParam.getP(), pageParam.getC());

        List<StandardProjectFittedResponseDTO> result = MapperFactoryUtil.mapperList(standardProjectFittedMapper.findStandardProjectFittedByStandardProjectFittedCQRS(standardProjectFittedRequestDTO), StandardProjectFittedResponseDTO.class);

        return new ResultPageList<StandardProjectFittedResponseDTO>()
                .setResultList(result)
                .setPage(pageParam.getP())
                .setSize(pageParam.getC())
                .setCountPage(page.getPages())
                .setCountSize(page.getTotal());
    }

    @Override
    public void saveStandardProjectFitted(StandardProjectFitted standardProjectFitted) {
        standardProjectFittedMapper.saveStandardProjectFitted(standardProjectFitted);
    }


}
