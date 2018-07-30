package com.yinghuaicc.stars.service.cqrs.standard;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.yinghuaicc.stars.common.utils.mapper.MapperFactoryUtil;
import com.yinghuaicc.stars.config.page.PageParam;
import com.yinghuaicc.stars.config.page.ResultPageList;
import com.yinghuaicc.stars.repository.mapper.standard.StandardConditionFittedMapper;
import com.yinghuaicc.stars.repository.mapper.standard.StandardConditionRentMapper;
import com.yinghuaicc.stars.repository.model.standard.StandardConditionFitted;
import com.yinghuaicc.stars.service.cqrs.standard.dto.request.StandardConditionFittedRequestDTO;
import com.yinghuaicc.stars.service.cqrs.standard.dto.request.StandardConditionRentRequestDTO;
import com.yinghuaicc.stars.service.cqrs.standard.dto.response.StandardConditionFittedResponseDTO;
import com.yinghuaicc.stars.service.cqrs.standard.dto.response.StandardConditionRentResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 标准三角形业态溢租率
 */
@Service
public class StandardConditionFittedServiceImpl implements StandardConditionFittedService {

    @Autowired
    private StandardConditionFittedMapper standardConditionFittedMapper;

    @Override
    public ResultPageList<StandardConditionFittedResponseDTO> findStandardConditionFittedByStandardConditionFittedCQRS(StandardConditionFittedRequestDTO standardConditionFittedRequestDTO, PageParam pageParam) {
        Page page = PageHelper.startPage(pageParam.getP(), pageParam.getC());

        List<StandardConditionFittedResponseDTO> result = MapperFactoryUtil.mapperList(standardConditionFittedMapper.findStandardConditionFittedByStandardConditionFittedCQRS(standardConditionFittedRequestDTO), StandardConditionFittedResponseDTO.class);

        return new ResultPageList<StandardConditionFittedResponseDTO>()
                .setResultList(result)
                .setPage(pageParam.getP())
                .setSize(pageParam.getC())
                .setCountPage(page.getPages())
                .setCountSize(page.getTotal());
    }

    @Override
    public void saveStandardConditionFitted(StandardConditionFitted standardConditionFitted) {
        standardConditionFittedMapper.saveStandardConditionFitted(standardConditionFitted);
    }


}
