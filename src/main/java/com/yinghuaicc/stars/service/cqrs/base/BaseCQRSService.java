package com.yinghuaicc.stars.service.cqrs.base;

import com.yinghuaicc.stars.config.page.PageParam;
import com.yinghuaicc.stars.config.page.ResultPageList;
import com.yinghuaicc.stars.service.cqrs.base.dto.response.FindByBusinessSpeciesCQRSListResponseDTO;

/**
 * @Author:Fly
 * @Date:Create in 2018/7/9 下午12:16
 * @Description: 业种
 * @Modified:
 */
public interface BaseCQRSService {

    /**
     *@Author:Fly Created in 2018/7/9 下午12:27
     *@Description: 分页查询业种列表
     */
    ResultPageList<FindByBusinessSpeciesCQRSListResponseDTO> fundByBusinessSpeciesCQRSList(PageParam pageParam);


}
