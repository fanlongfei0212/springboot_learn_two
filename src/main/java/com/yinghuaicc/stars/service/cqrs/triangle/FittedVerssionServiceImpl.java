package com.yinghuaicc.stars.service.cqrs.triangle;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.yinghuaicc.stars.common.utils.mapper.MapperFactoryUtil;
import com.yinghuaicc.stars.config.page.PageParam;
import com.yinghuaicc.stars.config.page.ResultPageList;
import com.yinghuaicc.stars.repository.mapper.triangle.FittedVerssionMapper;
import com.yinghuaicc.stars.repository.model.triangle.FittedVerssion;
import com.yinghuaicc.stars.service.cqrs.triangle.dto.request.FittedVerssionRequestDTO;
import com.yinghuaicc.stars.service.cqrs.triangle.dto.response.FittedVerssionResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 适配值版本
 */
@Service
public class FittedVerssionServiceImpl implements FittedVerssionService{

    @Autowired
    private FittedVerssionMapper fittedVerssionMapper;

    @Override
    public ResultPageList<FittedVerssionResponseDTO> findFittedVerssionByFittedVerssionCQRS(FittedVerssionRequestDTO fittedVerssionRequestDTO, PageParam pageParam) {

        Page page = PageHelper.startPage(pageParam.getP(), pageParam.getC());

        List<FittedVerssionResponseDTO> result = MapperFactoryUtil.mapperList(fittedVerssionMapper.findFittedVerssionByFittedVerssionCQRS(fittedVerssionRequestDTO), FittedVerssionResponseDTO.class);

        return new ResultPageList<FittedVerssionResponseDTO>()
                .setResultList(result)
                .setPage(pageParam.getP())
                .setSize(pageParam.getC())
                .setCountPage(page.getPages())
                .setCountSize(page.getTotal());
    }

    @Override
    public void saveFittedVerssion(FittedVerssion fittedVerssion) {
        fittedVerssionMapper.saveFittedVerssion(fittedVerssion);
    }
}
