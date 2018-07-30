package com.yinghuaicc.stars.service.cqrs.triangle;


import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.yinghuaicc.stars.common.utils.mapper.MapperFactoryUtil;
import com.yinghuaicc.stars.config.page.PageParam;
import com.yinghuaicc.stars.config.page.ResultPageList;
import com.yinghuaicc.stars.repository.mapper.triangle.RentVerssionMapper;
import com.yinghuaicc.stars.repository.model.triangle.RentVerssion;
import com.yinghuaicc.stars.service.cqrs.triangle.dto.request.RentVerssionRequestDTO;
import com.yinghuaicc.stars.service.cqrs.triangle.dto.response.RentVerssionResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 溢租率导入版本实现类
 */
@Service
public class RentVerssionServiceImpl implements RentVerssionService {

    @Autowired
    private RentVerssionMapper rentVerssionMapper;

    @Override
    public ResultPageList<RentVerssionResponseDTO> findRentVerssionByRantVersionCQRS(RentVerssionRequestDTO rentVerssionRequestDTO, PageParam pageParam) {

        Page page = PageHelper.startPage(pageParam.getP(), pageParam.getC());

        List<RentVerssionResponseDTO> result = MapperFactoryUtil.mapperList(rentVerssionMapper.findRentVerssionByRentVerssionCQRS(rentVerssionRequestDTO), RentVerssionResponseDTO.class);

        return new ResultPageList<RentVerssionResponseDTO>()
                .setResultList(result)
                .setPage(pageParam.getP())
                .setSize(pageParam.getC())
                .setCountPage(page.getPages())
                .setCountSize(page.getTotal());

    }

    @Override
    public void saveRentVerssion(RentVerssion rentVerssion) {
        rentVerssionMapper.saveRentVerssion(rentVerssion);
    }
}
