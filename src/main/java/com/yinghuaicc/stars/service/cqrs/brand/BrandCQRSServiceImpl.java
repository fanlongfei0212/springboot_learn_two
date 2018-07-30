package com.yinghuaicc.stars.service.cqrs.brand;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.yinghuaicc.stars.config.page.PageParam;
import com.yinghuaicc.stars.config.page.ResultPageList;
import com.yinghuaicc.stars.repository.mapper.cqrs.brand.BrandCQRSMapper;
import com.yinghuaicc.stars.service.cqrs.brand.BrandCQRSService;
import com.yinghuaicc.stars.service.cqrs.brand.dto.request.AppBrandCQRSListRequestDTO;
import com.yinghuaicc.stars.service.cqrs.brand.dto.request.BrandCQRSListRequestDTO;
import com.yinghuaicc.stars.service.cqrs.brand.dto.response.AppBrandCQRSListResponseDTO;
import com.yinghuaicc.stars.service.cqrs.brand.dto.response.BrandCQRSInfoResponseDTO;
import com.yinghuaicc.stars.service.cqrs.brand.dto.response.BrandCQRSListResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author:Fly
 * @Date:Create in 2018/7/12 下午2:55
 * @Description: 品牌
 * @Modified:
 */
@Service
public class BrandCQRSServiceImpl implements BrandCQRSService{

    @Autowired
    private BrandCQRSMapper brandCQRSMapper;

    /**
     *@Author:Fly Created in 2018/7/12 下午3:29
     *@Description: 品牌列表
     */
    @Override
    public ResultPageList<BrandCQRSListResponseDTO> brandListCQRS(BrandCQRSListRequestDTO brandCQRSListRequestDTO, PageParam pageParam) {

        Page page = PageHelper.startPage(pageParam.getP(), pageParam.getC());

        List<BrandCQRSListResponseDTO> result = brandCQRSMapper.brandListCQRS(brandCQRSListRequestDTO);

        return new ResultPageList<BrandCQRSListResponseDTO>()
                .setResultList(result)
                .setPage(pageParam.getP())
                .setSize(pageParam.getC())
                .setCountPage(page.getPages())
                .setCountSize(page.getTotal());
    }

    /**
     *@Author:Fly Created in 2018/7/12 下午4:05
     *@Description: 品牌详情
     */
    @Override
    public BrandCQRSInfoResponseDTO brandInfoCQRS(String id) {

        return brandCQRSMapper.brandInfoCQRS(id);
    }

    @Override
    public List<AppBrandCQRSListResponseDTO> appBrandListCQRS(AppBrandCQRSListRequestDTO appBrandCQRSListRequestDTO) {
      return   brandCQRSMapper.appBrandListCQRS(appBrandCQRSListRequestDTO);
    }
}
