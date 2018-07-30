package com.yinghuaicc.stars.service.cqrs.standard;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.yinghuaicc.stars.common.utils.mapper.MapperFactoryUtil;
import com.yinghuaicc.stars.config.page.PageParam;
import com.yinghuaicc.stars.config.page.ResultPageList;
import com.yinghuaicc.stars.repository.mapper.standard.StandardBrandSaleMapper;
import com.yinghuaicc.stars.repository.model.standard.StandardBrandSale;
import com.yinghuaicc.stars.service.cqrs.standard.dto.request.StandardBrandSaleRequestDTO;
import com.yinghuaicc.stars.service.cqrs.standard.dto.response.StandardBrandSaleResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StandardBrandSaleServiceImpl implements StandardBrandSaleService {

    @Autowired
    private StandardBrandSaleMapper standardBrandSaleMapper;
    @Override
    public ResultPageList<StandardBrandSaleResponseDTO> findStandardBrandSaleByStandardBrandSaleCQRS(StandardBrandSaleRequestDTO standardBrandSaleRequestDTO, PageParam pageParam) {
        Page page = PageHelper.startPage(pageParam.getP(), pageParam.getC());

        List<StandardBrandSaleResponseDTO> result = MapperFactoryUtil.mapperList(standardBrandSaleMapper.findStandardBrandSaleByStandardBrandSaleCQRS(standardBrandSaleRequestDTO), StandardBrandSaleResponseDTO.class);

        return new ResultPageList<StandardBrandSaleResponseDTO>()
                .setResultList(result)
                .setPage(pageParam.getP())
                .setSize(pageParam.getC())
                .setCountPage(page.getPages())
                .setCountSize(page.getTotal());
    }

    @Override
    public void saveStandardBrandSale(StandardBrandSale standardBrandSale) {
        standardBrandSaleMapper.saveStandardBrandSale(standardBrandSale);
    }


}
