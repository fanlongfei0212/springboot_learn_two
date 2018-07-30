package com.yinghuaicc.stars.service.cqrs.brand;

import com.yinghuaicc.stars.config.page.PageParam;
import com.yinghuaicc.stars.config.page.ResultPageList;
import com.yinghuaicc.stars.service.cqrs.brand.dto.request.AppBrandCQRSListRequestDTO;
import com.yinghuaicc.stars.service.cqrs.brand.dto.request.BrandCQRSListRequestDTO;
import com.yinghuaicc.stars.service.cqrs.brand.dto.response.AppBrandCQRSListResponseDTO;
import com.yinghuaicc.stars.service.cqrs.brand.dto.response.BrandCQRSInfoResponseDTO;
import com.yinghuaicc.stars.service.cqrs.brand.dto.response.BrandCQRSListResponseDTO;

import java.util.List;


/**
 * @Author:Fly
 * @Date:Create in 2018/7/12 下午2:30
 * @Description: 品牌
 * @Modified:
 */
public interface BrandCQRSService {

    /**
     *@Author:Fly Created in 2018/7/12 下午3:29
     *@Description: 品牌列表
     */
    ResultPageList<BrandCQRSListResponseDTO> brandListCQRS(BrandCQRSListRequestDTO brandCQRSListRequestDTO, PageParam pageParam);

    /**
     *@Author:Fly Created in 2018/7/12 下午4:05
     *@Description: 品牌详情
     */
    BrandCQRSInfoResponseDTO brandInfoCQRS(String id);

    /**
     *  通过项目id、楼层id、业态id查询品牌
     * @return
     */
    List<AppBrandCQRSListResponseDTO> appBrandListCQRS(AppBrandCQRSListRequestDTO appBrandCQRSListRequestDTO);
}
