package com.yinghuaicc.stars.service.cqrs.standard;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.yinghuaicc.stars.common.utils.mapper.MapperFactoryUtil;
import com.yinghuaicc.stars.config.page.PageParam;
import com.yinghuaicc.stars.config.page.ResultPageList;
import com.yinghuaicc.stars.repository.mapper.standard.StandardFloorRentMapper;
import com.yinghuaicc.stars.repository.mapper.standard.StandardProjectRentMapper;
import com.yinghuaicc.stars.repository.model.standard.StandardFloorRent;
import com.yinghuaicc.stars.service.cqrs.standard.dto.request.StandardFloorRentRequestDTO;
import com.yinghuaicc.stars.service.cqrs.standard.dto.request.StandardProjectRentRequestDTO;
import com.yinghuaicc.stars.service.cqrs.standard.dto.response.StandardFloorRentResponseDTO;
import com.yinghuaicc.stars.service.cqrs.standard.dto.response.StandardProjectRentResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 标准三角形楼层溢租率
 */
@Service
public class StandardFloorRentServiceImpl implements StandardFloorRentService {

    @Autowired
    private StandardFloorRentMapper standardFloorRentMapper;
    @Override
    public ResultPageList<StandardFloorRentResponseDTO> findStandardFloorRentByStandardFloorRentCQRS(StandardFloorRentRequestDTO standardFloorRentRequestDTO, PageParam pageParam) {
        Page page = PageHelper.startPage(pageParam.getP(), pageParam.getC());

        List<StandardFloorRentResponseDTO> result = MapperFactoryUtil.mapperList(standardFloorRentMapper.findStandardFloorRentByStandardFloorRentCQRS(standardFloorRentRequestDTO), StandardFloorRentResponseDTO.class);

        return new ResultPageList<StandardFloorRentResponseDTO>()
                .setResultList(result)
                .setPage(pageParam.getP())
                .setSize(pageParam.getC())
                .setCountPage(page.getPages())
                .setCountSize(page.getTotal());
    }

    @Override
    public void saveStandardFloorRent(StandardFloorRent standardFloorRent) {
        standardFloorRentMapper.saveStandardFloorRent(standardFloorRent);
    }


}
