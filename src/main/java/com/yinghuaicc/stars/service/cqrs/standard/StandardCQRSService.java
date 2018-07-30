package com.yinghuaicc.stars.service.cqrs.standard;

import com.yinghuaicc.stars.config.page.PageParam;
import com.yinghuaicc.stars.config.page.ResultPageList;
import com.yinghuaicc.stars.service.cqrs.standard.dto.response.FindIntervalListCQRSResponseDTO;

/**
 * @Author:Fly
 * @Date:Create in 2018/7/10 上午12:02
 * @Description: 标准设置
 * @Modified:
 */
public interface StandardCQRSService {

    /**
     *@Author:Fly Created in 2018/7/10 上午12:05
     *@Description: 标准设置列表
     */
    ResultPageList<FindIntervalListCQRSResponseDTO> findIntervalList(PageParam pageParam);
}
