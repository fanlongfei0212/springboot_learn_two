package com.yinghuaicc.stars.service.cqrs.triangle;


import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.yinghuaicc.stars.common.utils.mapper.MapperFactoryUtil;
import com.yinghuaicc.stars.config.page.PageParam;
import com.yinghuaicc.stars.config.page.ResultPageList;
import com.yinghuaicc.stars.repository.mapper.triangle.DayRentMapper;
import com.yinghuaicc.stars.repository.model.triangle.DayRent;
import com.yinghuaicc.stars.service.cqrs.triangle.dto.request.DayRentRequestDTO;

import com.yinghuaicc.stars.service.cqrs.triangle.dto.response.DayRentResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class DayRentServiceImpl implements DayRentService{
    @Autowired
    private DayRentMapper dayRentMapper;

    @Override
    public ResultPageList<DayRentResponseDTO> findDayRentByDayRentCQRS(DayRentRequestDTO moonRentRequestDTO, PageParam pageParam) {
        Page page = PageHelper.startPage(pageParam.getP(), pageParam.getC());

        List<DayRentResponseDTO> result = MapperFactoryUtil.mapperList(dayRentMapper.findDayRentByDayRentCQRS(moonRentRequestDTO),DayRentResponseDTO.class);

        return new ResultPageList<DayRentResponseDTO>()
                .setResultList(result)
                .setPage(pageParam.getP())
                .setSize(pageParam.getC())
                .setCountPage(page.getPages())
                .setCountSize(page.getTotal());
    }

    @Override
    public DayRentResponseDTO findDayRentResponseDTOByContractId(String contractId, LocalDateTime time) {
        return dayRentMapper.findDayRentResponseDTOByContractId(contractId,time);
    }

    @Override
    public void saveDayRent(DayRent dayRent) {
        dayRentMapper.saveDayRent(dayRent);
    }


}
