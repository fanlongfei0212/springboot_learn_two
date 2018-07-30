package com.yinghuaicc.stars.service.cqrs.standard;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.yinghuaicc.stars.common.utils.mapper.MapperFactoryUtil;
import com.yinghuaicc.stars.config.page.PageParam;
import com.yinghuaicc.stars.config.page.ResultPageList;
import com.yinghuaicc.stars.repository.mapper.standard.StandardFloorFittedMapper;
import com.yinghuaicc.stars.repository.model.standard.StandardFloorFitted;
import com.yinghuaicc.stars.service.cqrs.standard.dto.request.StandardFloorFittedRequestDTO;
import com.yinghuaicc.stars.service.cqrs.standard.dto.response.StandardFloorFittedResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 标准三角形楼层适配值
 */
@Service
public class StandardFloorFittedServiceImpl implements StandardFloorFittedService {

    @Autowired
    private StandardFloorFittedMapper standardFloorFittedMapper;
    @Override
    public ResultPageList<StandardFloorFittedResponseDTO> findStandardFloorFittedByStandardFloorFittedCQRS(StandardFloorFittedRequestDTO standardFloorFittedRequestDTO, PageParam pageParam) {
        Page page = PageHelper.startPage(pageParam.getP(), pageParam.getC());

        List<StandardFloorFittedResponseDTO> result = MapperFactoryUtil.mapperList(standardFloorFittedMapper.findStandardFloorFittedByStandardFloorFittedCQRS(standardFloorFittedRequestDTO), StandardFloorFittedResponseDTO.class);

        return new ResultPageList<StandardFloorFittedResponseDTO>()
                .setResultList(result)
                .setPage(pageParam.getP())
                .setSize(pageParam.getC())
                .setCountPage(page.getPages())
                .setCountSize(page.getTotal());
    }

    @Override
    public void saveStandardFloorFitted(StandardFloorFitted standardFloorFitted) {
        standardFloorFittedMapper.saveStandardFloorFitted(standardFloorFitted);
    }


}
