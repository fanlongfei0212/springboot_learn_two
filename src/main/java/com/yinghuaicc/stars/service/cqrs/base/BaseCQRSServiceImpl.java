package com.yinghuaicc.stars.service.cqrs.base;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.yinghuaicc.stars.config.page.PageParam;
import com.yinghuaicc.stars.config.page.ResultPageList;
import com.yinghuaicc.stars.repository.mapper.cqrs.base.BaseCQRSMapper;
import com.yinghuaicc.stars.service.cqrs.base.dto.response.FindByBusinessSpeciesCQRSListResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author:Fly
 * @Date:Create in 2018/7/9 下午12:17
 * @Description: 业种
 * @Modified:
 */
@Service
public class BaseCQRSServiceImpl implements BaseCQRSService {

    @Autowired
    private BaseCQRSMapper baseCQRSMapper;

    /**
     *@Author:Fly Created in 2018/7/9 下午12:27
     *@Description: 分页查询业种列表
     */
    @Override
    public ResultPageList<FindByBusinessSpeciesCQRSListResponseDTO> fundByBusinessSpeciesCQRSList(PageParam pageParam) {

        Page page = PageHelper.startPage(pageParam.getP(), pageParam.getC());

        List<FindByBusinessSpeciesCQRSListResponseDTO> result= baseCQRSMapper.findByBusinessSpeciesCQRSList();

        return new ResultPageList<FindByBusinessSpeciesCQRSListResponseDTO>()
                .setResultList(result)
                .setPage(pageParam.getP())
                .setSize(pageParam.getC())
                .setCountPage(page.getPages())
                .setCountSize(page.getTotal());
    }
}
