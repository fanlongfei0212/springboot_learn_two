package com.yinghuaicc.stars.service.cqrs.triangle;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.yinghuaicc.stars.common.utils.mapper.MapperFactoryUtil;
import com.yinghuaicc.stars.config.page.PageParam;
import com.yinghuaicc.stars.config.page.ResultPageList;
import com.yinghuaicc.stars.repository.mapper.triangle.FloorGuestMapper;
import com.yinghuaicc.stars.repository.model.triangle.FloorGuest;
import com.yinghuaicc.stars.service.cqrs.triangle.dto.request.FloorGuestRequestDTO;
import com.yinghuaicc.stars.service.cqrs.triangle.dto.response.FloorGuestResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 楼层客销度
 */
@Service
public class FloorGuestServiceImpl implements FloorGuestService {
    @Autowired
    private FloorGuestMapper floorGuestMapper;
    @Override
    public ResultPageList<FloorGuestResponseDTO> findFloorGuestByFloorGuestCQRS(FloorGuestRequestDTO floorGuestRequestDTO, PageParam pageParam) {
        Page page = PageHelper.startPage(pageParam.getP(), pageParam.getC());

        List<FloorGuestResponseDTO> result = MapperFactoryUtil.mapperList(floorGuestMapper.findFloorGuestByFloorGuestCQRS(floorGuestRequestDTO), FloorGuestResponseDTO.class);

        return new ResultPageList<FloorGuestResponseDTO>()
                .setResultList(result)
                .setPage(pageParam.getP())
                .setSize(pageParam.getC())
                .setCountPage(page.getPages())
                .setCountSize(page.getTotal());
    }

    @Override
    public void saveFloorGuest(FloorGuest floorGuest) {
        floorGuestMapper.saveFloorGuest(floorGuest);
    }
}
