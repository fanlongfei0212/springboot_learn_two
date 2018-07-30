package com.yinghuaicc.stars.service.cqrs.standard;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.yinghuaicc.stars.common.utils.mapper.MapperFactoryUtil;
import com.yinghuaicc.stars.config.page.PageParam;
import com.yinghuaicc.stars.config.page.ResultPageList;
import com.yinghuaicc.stars.repository.mapper.standard.StandardConditionRentMapper;
import com.yinghuaicc.stars.repository.model.standard.StandardConditionRent;
import com.yinghuaicc.stars.service.cqrs.standard.dto.request.StandardConditionRentRequestDTO;
import com.yinghuaicc.stars.service.cqrs.standard.dto.response.StandardConditionRentResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 标准三角形业态溢租率
 */
@Service
public class StandardConditionRentServiceImpl implements StandardConditionRentService {

    @Autowired
    private StandardConditionRentMapper standardConditionRentMapper;
    @Override
    public ResultPageList<StandardConditionRentResponseDTO> findStandardConditionRentByStandardConditionRentCQRS(StandardConditionRentRequestDTO standardConditionRentRequestDTO, PageParam pageParam) {
        Page page = PageHelper.startPage(pageParam.getP(), pageParam.getC());

        List<StandardConditionRentResponseDTO> result = MapperFactoryUtil.mapperList(standardConditionRentMapper.findStandardConditionRentByStandardConditionRentCQRS(standardConditionRentRequestDTO), StandardConditionRentResponseDTO.class);

        return new ResultPageList<StandardConditionRentResponseDTO>()
                .setResultList(result)
                .setPage(pageParam.getP())
                .setSize(pageParam.getC())
                .setCountPage(page.getPages())
                .setCountSize(page.getTotal());
    }

    @Override
    public void saveStandardConditionRent(StandardConditionRent standardConditionRent) {
        standardConditionRentMapper.saveStandardConditionRent(standardConditionRent);
    }


}
