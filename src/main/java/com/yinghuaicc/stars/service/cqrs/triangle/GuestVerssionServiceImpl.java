package com.yinghuaicc.stars.service.cqrs.triangle;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.yinghuaicc.stars.common.utils.mapper.MapperFactoryUtil;
import com.yinghuaicc.stars.config.page.PageParam;
import com.yinghuaicc.stars.config.page.ResultPageList;
import com.yinghuaicc.stars.repository.mapper.triangle.GuestVerssionMapper;
import com.yinghuaicc.stars.repository.model.triangle.GuestVerssion;
import com.yinghuaicc.stars.service.cqrs.triangle.dto.request.GuestVerssionRequestDTO;
import com.yinghuaicc.stars.service.cqrs.triangle.dto.response.GuestVerssionResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GuestVerssionServiceImpl implements GuestVerssionService{

    @Autowired
    private GuestVerssionMapper guestVerssionMapper;

    @Override
    public ResultPageList<GuestVerssionResponseDTO> findGuestVerssionByGuestVerssionCQRS(GuestVerssionRequestDTO guestVerssionRequestDTO, PageParam pageParam) {
        Page page = PageHelper.startPage(pageParam.getP(), pageParam.getC());

        List<GuestVerssionResponseDTO> result = MapperFactoryUtil.mapperList(guestVerssionMapper.findGuestVerssionByGuestVerssionCQRS(guestVerssionRequestDTO), GuestVerssionResponseDTO.class);

        return new ResultPageList<GuestVerssionResponseDTO>()
                .setResultList(result)
                .setPage(pageParam.getP())
                .setSize(pageParam.getC())
                .setCountPage(page.getPages())
                .setCountSize(page.getTotal());
    }

    @Override
    public void saveGuestVerssion(GuestVerssion guestVerssion) {
        guestVerssionMapper.saveGuestVerssion(guestVerssion);
    }
}
