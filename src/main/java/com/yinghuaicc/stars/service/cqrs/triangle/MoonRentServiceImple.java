package com.yinghuaicc.stars.service.cqrs.triangle;


import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.yinghuaicc.stars.common.utils.mapper.MapperFactoryUtil;
import com.yinghuaicc.stars.config.page.PageParam;
import com.yinghuaicc.stars.config.page.ResultPageList;
import com.yinghuaicc.stars.repository.mapper.triangle.MoonRentMapper;
import com.yinghuaicc.stars.repository.model.triangle.MoonRent;
import com.yinghuaicc.stars.service.cqrs.triangle.dto.request.MoonRentRequestDTO;
import com.yinghuaicc.stars.service.cqrs.triangle.dto.response.MoonRentResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 月溢租率
 */
@Service
public class MoonRentServiceImple implements MoonRentService {

    @Autowired
    private MoonRentMapper moonRentMapper;

    @Override
    public ResultPageList<MoonRentResponseDTO> findRentVerssionByRantVersionCQRS(MoonRentRequestDTO moonRentRequestDTO, PageParam pageParam) {

        Page page = PageHelper.startPage(pageParam.getP(), pageParam.getC());

        List<MoonRentResponseDTO> result = moonRentMapper.findMoonRentByMoonRentCQRS(moonRentRequestDTO);

        return new ResultPageList<MoonRentResponseDTO>()
                .setResultList(result)
                .setPage(pageParam.getP())
                .setSize(pageParam.getC())
                .setCountPage(page.getPages())
                .setCountSize(page.getTotal());

    }

    @Override
    public MoonRentResponseDTO findRentVerssionByContractId(MoonRentRequestDTO moonRentRequestDTO) {
        return null;
    }

    @Override
    public void saveMoonRent(MoonRent moonRent) {
        moonRentMapper.saveMoonRent(moonRent);
    }

    @Override
    public void editMoonRent(MoonRent moonRent) {
        moonRentMapper.editMoonRent(moonRent);
    }
}
