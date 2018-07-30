package com.yinghuaicc.stars.service.cqrs.Intervalset;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.yinghuaicc.stars.common.utils.mapper.MapperFactoryUtil;
import com.yinghuaicc.stars.common.utils.uuid.UuidUtil;
import com.yinghuaicc.stars.config.page.PageParam;
import com.yinghuaicc.stars.config.page.ResultPageList;
import com.yinghuaicc.stars.repository.mapper.Intervalset.ConditionGuestIntervalMapper;
import com.yinghuaicc.stars.repository.model.Intervalset.ConditionGuestInterval;
import com.yinghuaicc.stars.repository.model.Intervalset.FloorGuestInterval;
import com.yinghuaicc.stars.service.cqrs.Intervalset.dto.request.ConditionGuestIntervalRequestDTO;
import com.yinghuaicc.stars.service.cqrs.Intervalset.dto.response.ConditionGuestIntervalResponseDTO;
import com.yinghuaicc.stars.service.cqrs.Intervalset.dto.response.FloorGuestIntervalResponseDTO;
import com.yinghuaicc.stars.service.cqrs.triangle.TriangleCQRSService;
import com.yinghuaicc.stars.service.cqrs.triangle.dto.request.BrandTriangleRequestDTO;
import com.yinghuaicc.stars.service.cqrs.triangle.dto.response.BrandTriangleResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

/**
 * 区间设置-业态客销度
 */
@Service
public class ConditionGuestIntervalServiceImpl implements ConditionGuestIntervalService{

    @Autowired
    private ConditionGuestIntervalMapper conditionGuestIntervalMapper;

    @Autowired
    private TriangleCQRSService triangleCQRSService;

    @Override
    public ResultPageList<ConditionGuestIntervalResponseDTO> findConditionGuestIntervalByConditionGuestIntervalCQRS(ConditionGuestIntervalRequestDTO conditionGuestIntervalRequestDTO, PageParam pageParam) {

        Page page = PageHelper.startPage(pageParam.getP(), pageParam.getC());

        List<ConditionGuestIntervalResponseDTO> result = MapperFactoryUtil.mapperList(conditionGuestIntervalMapper.findConditionGuestIntervalByConditionGuestIntervalCQRS(conditionGuestIntervalRequestDTO), ConditionGuestIntervalResponseDTO.class);

        return new ResultPageList<ConditionGuestIntervalResponseDTO>()
                .setResultList(result)
                .setPage(pageParam.getP())
                .setSize(pageParam.getC())
                .setCountPage(page.getPages())
                .setCountSize(page.getTotal());
    }

    @Override
    public void saveConditionGuestInterval(ConditionGuestInterval conditionGuestInterval) {
        //优秀
        Integer yx = 0;
        //良好
        Integer lh = 0;
        //提升
        Integer ts = 0;
        //合格
        Integer hl = 0;

        //-- 通过id查询标准三角形该项目下所有品牌客销度之和
        BrandTriangleRequestDTO brandTriangleRequestDTO = new BrandTriangleRequestDTO();
        brandTriangleRequestDTO.setProjectId(conditionGuestInterval.getProjectId());
        brandTriangleRequestDTO.setConditionId(conditionGuestInterval.getConditionId());
        brandTriangleRequestDTO.setMajoId(conditionGuestInterval.getMajoId());
        BrandTriangleResponseDTO brandTriangleResponseDTO  =  triangleCQRSService.findBrandTriangleByFloorId(brandTriangleRequestDTO);
        BigDecimal standardGuest = brandTriangleResponseDTO.getStandardGuest();
        //区间最大值
        BigDecimal maxvalue = conditionGuestInterval.getMaxvalue();
        //区间增长百分比
        BigDecimal intervalRate = conditionGuestInterval.getIntervalRate();
        // 标准三角形客销度为X，那么合理区间为（Z-X）*Y%,客销度只需要导入Z、Y；Z为区间最大值、Y为每个区间的百分比数值,每次增长10%
        ts = maxvalue.subtract(standardGuest).multiply(intervalRate.add(new BigDecimal(0.1))).add(standardGuest).intValue();
        lh = maxvalue.subtract(standardGuest).multiply(intervalRate.add(new BigDecimal(0.2))).add(standardGuest).intValue();
        yx = maxvalue.subtract(standardGuest).multiply(intervalRate.add(new BigDecimal(0.3))).add(standardGuest).intValue();
        conditionGuestInterval.setId(UuidUtil.randomUUID());//id
        conditionGuestInterval.setYx(yx);
        conditionGuestInterval.setLh(lh);
        conditionGuestInterval.setTs(ts);
        conditionGuestInterval.setHl(hl);

        conditionGuestIntervalMapper.saveConditionGuestInterval(conditionGuestInterval);
    }

    @Override
    public ConditionGuestInterval findConditionById(String id) {
        return  conditionGuestIntervalMapper.findConditionGuestIntervalByProjectIdAndConditionId(id);
    }

    @Override
    public void editConditionGuestInterval(ConditionGuestInterval conditionGuestInterval) {
        conditionGuestIntervalMapper.editConditionGuestInterval(conditionGuestInterval);
    }


}
