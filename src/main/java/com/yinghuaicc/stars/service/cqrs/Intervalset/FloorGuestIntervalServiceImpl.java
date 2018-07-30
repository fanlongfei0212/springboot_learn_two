package com.yinghuaicc.stars.service.cqrs.Intervalset;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.yinghuaicc.stars.common.utils.mapper.MapperFactoryUtil;
import com.yinghuaicc.stars.common.utils.uuid.UuidUtil;
import com.yinghuaicc.stars.config.page.PageParam;
import com.yinghuaicc.stars.config.page.ResultPageList;
import com.yinghuaicc.stars.repository.mapper.Intervalset.FloorGuestIntervalMapper;
import com.yinghuaicc.stars.repository.model.Intervalset.FloorGuestInterval;
import com.yinghuaicc.stars.service.cqrs.Intervalset.dto.request.FloorGuestIntervalRequestDTO;
import com.yinghuaicc.stars.service.cqrs.Intervalset.dto.response.FloorGuestIntervalResponseDTO;
import com.yinghuaicc.stars.service.cqrs.triangle.TriangleCQRSService;
import com.yinghuaicc.stars.service.cqrs.triangle.dto.request.BrandTriangleRequestDTO;
import com.yinghuaicc.stars.service.cqrs.triangle.dto.response.BrandTriangleResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class FloorGuestIntervalServiceImpl implements FloorGuestIntervalService {

    @Autowired
    private FloorGuestIntervalMapper floorGuestIntervalMapper;

    @Autowired
    private TriangleCQRSService triangleCQRSService;

    @Override
    public ResultPageList<FloorGuestIntervalResponseDTO> findFloorGuestIntervalByFloorGuestIntervalCQRS(FloorGuestIntervalRequestDTO floorGuestIntervalRequestDTO, PageParam pageParam) {
        Page page = PageHelper.startPage(pageParam.getP(), pageParam.getC());

        List<FloorGuestIntervalResponseDTO> result = MapperFactoryUtil.mapperList(floorGuestIntervalMapper.findFloorGuestIntervalByFloorGuestIntervalCQRS(floorGuestIntervalRequestDTO), FloorGuestIntervalResponseDTO.class);

        return new ResultPageList<FloorGuestIntervalResponseDTO>()
                .setResultList(result)
                .setPage(pageParam.getP())
                .setSize(pageParam.getC())
                .setCountPage(page.getPages())
                .setCountSize(page.getTotal());
    }

    @Override
    public void saveFloorGuestInterval(FloorGuestInterval floorGuestInterval) {
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
        brandTriangleRequestDTO.setProjectId(floorGuestInterval.getProjectId());
        brandTriangleRequestDTO.setFloorId(floorGuestInterval.getFloorId());

        BrandTriangleResponseDTO brandTriangleResponseDTO  =  triangleCQRSService.findBrandTriangleByFloorId(brandTriangleRequestDTO);
        BigDecimal standardGuest = brandTriangleResponseDTO.getStandardGuest();
        //区间最大值
        BigDecimal maxvalue = floorGuestInterval.getMaxvalue();
        //区间增长百分比
        BigDecimal intervalRate = floorGuestInterval.getIntervalRate();
        // 标准三角形客销度为X，那么合理区间为（Z-X）*Y%,客销度只需要导入Z、Y；Z为区间最大值、Y为每个区间的百分比数值,每次增长10%
        ts = maxvalue.subtract(standardGuest).multiply(intervalRate.add(new BigDecimal(0.1))).add(standardGuest).intValue();
        lh = maxvalue.subtract(standardGuest).multiply(intervalRate.add(new BigDecimal(0.2))).add(standardGuest).intValue();
        yx = maxvalue.subtract(standardGuest).multiply(intervalRate.add(new BigDecimal(0.3))).add(standardGuest).intValue();
        floorGuestInterval.setId(UuidUtil.randomUUID());//id
        floorGuestInterval.setYx(yx);
        floorGuestInterval.setLh(lh);
        floorGuestInterval.setTs(ts);
        floorGuestInterval.setHl(hl);
        floorGuestIntervalMapper.saveFloorGuestInterval(floorGuestInterval);
    }

    @Override
    public FloorGuestInterval findProjectByProjectId(String id) {
       return   MapperFactoryUtil.mapperObject(floorGuestIntervalMapper.findFloorGuestIntervalById(id),FloorGuestInterval.class) ;
    }

    @Override
    public void editFloorGuestInterval(FloorGuestInterval floorGuestInterval) {
        floorGuestIntervalMapper.editFloorGuestInterval(floorGuestInterval);
    }
}
