package com.yinghuaicc.stars.service.cqrs.triangle;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.yinghuaicc.stars.common.utils.mapper.MapperFactoryUtil;
import com.yinghuaicc.stars.config.page.PageParam;
import com.yinghuaicc.stars.config.page.ResultPageList;
import com.yinghuaicc.stars.repository.mapper.triangle.QuarterFittedMapper;
import com.yinghuaicc.stars.repository.model.triangle.QuarterFitted;
import com.yinghuaicc.stars.service.cqrs.triangle.dto.request.QuarterFittedRequestDTO;
import com.yinghuaicc.stars.service.cqrs.triangle.dto.response.QuarterFittedResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class QuarterFittedServiceImpl implements  QuarterFittedService{

    @Autowired
    private QuarterFittedMapper quarterFittedMapper;

    @Override
    public ResultPageList<QuarterFittedResponseDTO> findQuarterFittedCQRS(QuarterFittedRequestDTO quarterFittedRequestDTO, PageParam pageParam) {

        Page page = PageHelper.startPage(pageParam.getP(), pageParam.getC());

        List<QuarterFittedResponseDTO> result = MapperFactoryUtil.mapperList(quarterFittedMapper.findQuarterFittedCQRS(quarterFittedRequestDTO), QuarterFittedResponseDTO.class);

        return new ResultPageList<QuarterFittedResponseDTO>()
                .setResultList(result)
                .setPage(pageParam.getP())
                .setSize(pageParam.getC())
                .setCountPage(page.getPages())
                .setCountSize(page.getTotal());
    }

    @Override
    public QuarterFittedResponseDTO findQuarterFittedResponseDTOByContractId(String contractId, LocalDateTime time) {
        return quarterFittedMapper.findQuarterFittedResponseDTOByContractId(contractId,time);
    }

    @Override
    public void saveQuarterFitted(QuarterFitted quarterFitted) {
        quarterFittedMapper.saveQuarterFitted(quarterFitted);
    }

    @Override
    public void editQuarterFitted(QuarterFitted quarterFitted) {
        quarterFittedMapper.editQuarterFitted(quarterFitted);
    }
}
