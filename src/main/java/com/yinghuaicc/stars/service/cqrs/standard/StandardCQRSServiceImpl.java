package com.yinghuaicc.stars.service.cqrs.standard;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.yinghuaicc.stars.config.page.PageParam;
import com.yinghuaicc.stars.config.page.ResultPageList;
import com.yinghuaicc.stars.repository.mapper.cqrs.standard.StandardCQRSMapper;
import com.yinghuaicc.stars.service.cqrs.standard.dto.response.FindIntervalListCQRSResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author:Fly
 * @Date:Create in 2018/7/9 下午9:56
 * @Description: 标准
 * @Modified:
 */
@Service
public class StandardCQRSServiceImpl implements StandardCQRSService{

    @Autowired
    private StandardCQRSMapper standardCQRSMapper;

    /**
     *@Author:Fly Created in 2018/7/10 上午12:05
     *@Description: 区间设置列表
     */
    @Override
    public ResultPageList<FindIntervalListCQRSResponseDTO> findIntervalList(PageParam pageParam) {

        Page page = PageHelper.startPage(pageParam.getP(), pageParam.getC());

        List<FindIntervalListCQRSResponseDTO> result = standardCQRSMapper.findIntervalListCQRS();

        return new ResultPageList<FindIntervalListCQRSResponseDTO>()
                .setResultList(result)
                .setPage(pageParam.getP())
                .setSize(pageParam.getC())
                .setCountPage(page.getPages())
                .setCountSize(page.getTotal());
    }
}
