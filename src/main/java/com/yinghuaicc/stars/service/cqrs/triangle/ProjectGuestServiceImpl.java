package com.yinghuaicc.stars.service.cqrs.triangle;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.yinghuaicc.stars.common.utils.mapper.MapperFactoryUtil;
import com.yinghuaicc.stars.config.page.PageParam;
import com.yinghuaicc.stars.config.page.ResultPageList;
import com.yinghuaicc.stars.repository.mapper.triangle.ProjectGuestMapper;
import com.yinghuaicc.stars.repository.model.triangle.ProjectGuest;
import com.yinghuaicc.stars.service.cqrs.triangle.dto.request.ProjectGuestRequestDTO;
import com.yinghuaicc.stars.service.cqrs.triangle.dto.response.ProjectGuestResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectGuestServiceImpl  implements ProjectGuestService{
    @Autowired
    private ProjectGuestMapper projectGuestMapper;

    @Override
    public ResultPageList<ProjectGuestResponseDTO> findProjectGuestByProjectGuestCQRS(ProjectGuestRequestDTO projectGuestRequestDTO, PageParam pageParam) {

        Page page = PageHelper.startPage(pageParam.getP(), pageParam.getC());

        List<ProjectGuestResponseDTO> result = MapperFactoryUtil.mapperList(projectGuestMapper.findProjectGuestByProjectGuestCQRS(projectGuestRequestDTO), ProjectGuestResponseDTO.class);

        return new ResultPageList<ProjectGuestResponseDTO>()
                .setResultList(result)
                .setPage(pageParam.getP())
                .setSize(pageParam.getC())
                .setCountPage(page.getPages())
                .setCountSize(page.getTotal());
    }

    @Override
    public void saveProjectGuest(ProjectGuest projectGuest) {
        projectGuestMapper.saveProjectGuest(projectGuest);
    }
}
