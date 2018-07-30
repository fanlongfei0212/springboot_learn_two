package com.yinghuaicc.stars.service.cqrs.triangle;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.yinghuaicc.stars.common.utils.mapper.MapperFactoryUtil;
import com.yinghuaicc.stars.config.page.PageParam;
import com.yinghuaicc.stars.config.page.ResultPageList;
import com.yinghuaicc.stars.repository.mapper.triangle.DayGuestMapper;
import com.yinghuaicc.stars.repository.model.triangle.DayGuest;
import com.yinghuaicc.stars.service.cqrs.triangle.dto.request.DayGuestRequestDTO;
import com.yinghuaicc.stars.service.cqrs.triangle.dto.response.DayGuestResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class DayGuestServiceImpl implements DayGuestService {

    @Autowired
    private DayGuestMapper dayGuestMapper;


    @Override
    public ResultPageList<DayGuestResponseDTO> findDayGuestByDayGuestCQRS(DayGuestRequestDTO dayGuestRequestDTO, PageParam pageParam) {
        Page page = PageHelper.startPage(pageParam.getP(), pageParam.getC());

        List<DayGuestResponseDTO> result = MapperFactoryUtil.mapperList(dayGuestMapper.findDayGuestByDayGuestCQRS(dayGuestRequestDTO),DayGuestResponseDTO.class);

        return new ResultPageList<DayGuestResponseDTO>()
                .setResultList(result)
                .setPage(pageParam.getP())
                .setSize(pageParam.getC())
                .setCountPage(page.getPages())
                .setCountSize(page.getTotal());
    }

    @Override
    public DayGuestResponseDTO findDayGuestByDayGuestByContractId(String contractId, LocalDateTime time) {
        return dayGuestMapper.findDayGuestByDayGuestByContractId(contractId,time);
    }


    @Override
    public void saveDayGuest(DayGuest dayGuest) {
        dayGuestMapper.saveDayGuest(dayGuest);
    }

    @Override
    public BigDecimal findPassengerFlowAll() {
        return dayGuestMapper.findPassengerFlowAll();
    }

    @Override
    public BigDecimal findSaleroomAll() {
        return dayGuestMapper.findSaleroomAll();
    }

}
