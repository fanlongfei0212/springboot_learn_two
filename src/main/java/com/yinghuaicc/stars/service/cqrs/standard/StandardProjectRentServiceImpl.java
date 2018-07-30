package com.yinghuaicc.stars.service.cqrs.standard;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.yinghuaicc.stars.common.utils.mapper.MapperFactoryUtil;
import com.yinghuaicc.stars.config.page.PageParam;
import com.yinghuaicc.stars.config.page.ResultPageList;
import com.yinghuaicc.stars.repository.mapper.standard.StandardProjectRentMapper;
import com.yinghuaicc.stars.repository.model.standard.StandardProjectRent;
import com.yinghuaicc.stars.service.cqrs.standard.dto.request.StandardProjectRentRequestDTO;
import com.yinghuaicc.stars.service.cqrs.standard.dto.response.StandardProjectRentResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 标准三角形项目溢租率
 */
@Service
public class StandardProjectRentServiceImpl implements StandardProjectRentService {

    @Autowired
    private StandardProjectRentMapper standardProjectRentMapper;
    @Override
    public ResultPageList<StandardProjectRentResponseDTO> findStandardProjectRentByStandardProjectRentCQRS(StandardProjectRentRequestDTO floorGuestRequestDTO, PageParam pageParam) {
        Page page = PageHelper.startPage(pageParam.getP(), pageParam.getC());

        List<StandardProjectRentResponseDTO> result = MapperFactoryUtil.mapperList(standardProjectRentMapper.findStandardProjectRentByStandardProjectRentCQRS(floorGuestRequestDTO), StandardProjectRentResponseDTO.class);

        return new ResultPageList<StandardProjectRentResponseDTO>()
                .setResultList(result)
                .setPage(pageParam.getP())
                .setSize(pageParam.getC())
                .setCountPage(page.getPages())
                .setCountSize(page.getTotal());
    }

    @Override
    public void saveStandardProjectRent(StandardProjectRent standardProjectRent) {
        standardProjectRentMapper.saveStandardProjectRent(standardProjectRent);
    }


}
