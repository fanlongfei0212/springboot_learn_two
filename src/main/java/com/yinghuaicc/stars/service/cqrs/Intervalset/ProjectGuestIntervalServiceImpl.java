package com.yinghuaicc.stars.service.cqrs.Intervalset;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.yinghuaicc.stars.common.utils.mapper.MapperFactoryUtil;
import com.yinghuaicc.stars.common.utils.uuid.UuidUtil;
import com.yinghuaicc.stars.config.page.PageParam;
import com.yinghuaicc.stars.config.page.ResultPageList;
import com.yinghuaicc.stars.repository.mapper.Intervalset.ProjectGuestIntervalMapper;
import com.yinghuaicc.stars.repository.mapper.cqrs.contract.ContractCQRSMapper;
import com.yinghuaicc.stars.repository.model.Intervalset.ProjectGuestInterval;
import com.yinghuaicc.stars.service.cqrs.Intervalset.dto.request.ProjectGuestIntervalRequestDTO;
import com.yinghuaicc.stars.service.cqrs.Intervalset.dto.response.ProjectGuestIntervalResponseDTO;
import com.yinghuaicc.stars.service.cqrs.triangle.TriangleCQRSService;
import com.yinghuaicc.stars.service.cqrs.triangle.dto.request.BrandTriangleRequestDTO;
import com.yinghuaicc.stars.service.cqrs.triangle.dto.response.BrandTriangleResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

/**
 * 区间设置-项目客销度
 */
@Service
public class ProjectGuestIntervalServiceImpl  implements ProjectGuestIntervalService{


    @Autowired
    private ProjectGuestIntervalMapper projectGuestIntervalMapper;

    @Autowired
    private ContractCQRSMapper contractCQRSMapper;

    @Autowired
    private TriangleCQRSService triangleCQRSService;

    @Override
    public ResultPageList<ProjectGuestIntervalResponseDTO> findProjectGuestIntervalByProjectGuestIntervalCQRS(ProjectGuestIntervalRequestDTO projectGuestIntervalRequestDTO, PageParam pageParam) {

        Page page = PageHelper.startPage(pageParam.getP(), pageParam.getC());

        List<ProjectGuestIntervalResponseDTO> result = MapperFactoryUtil.mapperList(projectGuestIntervalMapper.findProjectGuestIntervalByProjectGuestIntervalCQRS(projectGuestIntervalRequestDTO), ProjectGuestIntervalResponseDTO.class);

        return new ResultPageList<ProjectGuestIntervalResponseDTO>()
                .setResultList(result)
                .setPage(pageParam.getP())
                .setSize(pageParam.getC())
                .setCountPage(page.getPages())
                .setCountSize(page.getTotal());
    }

    @Override
    public void saveProject(ProjectGuestInterval projectGuestInterval) {

        //优秀
        Integer yx = 0;
        //良好
        Integer lh = 0;
        //提升
        Integer ts = 0;
        //合格
        Integer hl = 0;

        //-- 通过项目id查询标准三角形该项目下所有品牌客销度之和
        BrandTriangleRequestDTO brandTriangleRequestDTO = new BrandTriangleRequestDTO();
        brandTriangleRequestDTO.setProjectId(projectGuestInterval.getProjectId());
        BrandTriangleResponseDTO brandTriangleResponseDTO  =  triangleCQRSService.findBrandTriangleByBrandId(brandTriangleRequestDTO);
        BigDecimal standardGuest = brandTriangleResponseDTO.getStandardGuest();
        //区间最大值
        BigDecimal maxvalue = projectGuestInterval.getMaxvalue();;
        //区间增长百分比
        BigDecimal intervalRate = projectGuestInterval.getIntervalRate();
       // 标准三角形客销度为X，那么合理区间为（Z-X）*Y%,客销度只需要导入Z、Y；Z为区间最大值、Y为每个区间的百分比数值,每次增长10%
        ts = maxvalue.subtract(standardGuest).multiply(intervalRate.add(new BigDecimal(0.1))).add(standardGuest).intValue();
        lh = maxvalue.subtract(standardGuest).multiply(intervalRate.add(new BigDecimal(0.2))).add(standardGuest).intValue();
        yx = maxvalue.subtract(standardGuest).multiply(intervalRate.add(new BigDecimal(0.3))).add(standardGuest).intValue();
        projectGuestInterval.setId(UuidUtil.randomUUID());//id
        projectGuestInterval.setYx(yx);
        projectGuestInterval.setLh(lh);
        projectGuestInterval.setTs(ts);
        projectGuestInterval.setHl(hl);
        //---------------------------------------------------------------
        projectGuestIntervalMapper.saveProject(projectGuestInterval);
    }

    @Override
    public ProjectGuestInterval findProjectByProjectId(String projectId) {
        return projectGuestIntervalMapper.findProjectByProjectId(projectId);
    }

    @Override
    public void editProject(ProjectGuestInterval projectGuestInterval) {
        projectGuestIntervalMapper.editProject(projectGuestInterval);
    }
}
