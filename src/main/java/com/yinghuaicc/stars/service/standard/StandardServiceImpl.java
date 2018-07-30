package com.yinghuaicc.stars.service.standard;//package com.yinghuaicc.stars.service.standard;
//
//import com.yinghuaicc.stars.common.utils.exception.ExceptionUtil;
//import com.yinghuaicc.stars.common.utils.mapper.MapperFactoryUtil;
//import com.yinghuaicc.stars.common.utils.uuid.UuidUtil;
//import com.yinghuaicc.stars.config.base.BusinessNum;
//import com.yinghuaicc.stars.repository.mapper.base.BaseMapper;
//import com.yinghuaicc.stars.repository.mapper.standard.StandardMapper;
//import com.yinghuaicc.stars.repository.model.standard.IntervalConf;
//import com.yinghuaicc.stars.repository.model.standard.Triangle;
//import com.yinghuaicc.stars.service.standard.dto.request.EditIntervalConfRequestDTO;
//import com.yinghuaicc.stars.service.standard.dto.request.EditTriangleRequestDTO;
//import com.yinghuaicc.stars.service.standard.dto.request.SaveIntervalConfRequestDTO;
//import com.yinghuaicc.stars.service.standard.dto.request.SaveTriangleRequestDTO;
//import com.yinghuaicc.stars.service.standard.dto.response.FindIntervalByIdResponse;
//import com.yinghuaicc.stars.service.standard.dto.response.FindTriangleByIdResponse;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.time.LocalDateTime;
//import java.util.Objects;
//import java.util.stream.Collectors;
//import java.util.stream.Stream;
//
///**
// * @Author:Fly
// * @Date:Create in 2018/7/9 下午8:52
// * @Description: 区间设置服务
// * @Modified:
// */
//@Service
//public class StandardServiceImpl implements StandardService {
//
//    @Autowired
//    private ExceptionUtil exceptionUtil;
//
//    @Autowired
//    private StandardMapper standardMapper;
//
//    @Autowired
//    private BaseMapper baseMapper;
//
//
//    /**
//     *@Author:Fly Created in 2018/7/9 下午9:20
//     *@Description: 添加区间
//     */
//    @Transactional(rollbackFor = Exception.class)
//    @Override
//    public void saveIntervalConf(SaveIntervalConfRequestDTO saveIntervalConfRequestDTO, String loginEmployeeId) {
//
//        if (Objects.isNull(baseMapper.findBusinessFormById(saveIntervalConfRequestDTO.getBusinessFormId()))){
//
//            throw exceptionUtil.throwCustomException("STANDARD_SAVE_INTERVAL_CONF_010");
//        }
//
//        if (Objects.isNull(baseMapper.findBusinessSpeciesById(saveIntervalConfRequestDTO.getBusinessSpeciesId()))){
//
//            throw exceptionUtil.throwCustomException("STANDARD_SAVE_INTERVAL_CONF_011");
//        }
//
//        IntervalConf intervalConf = MapperFactoryUtil.mapperObject(saveIntervalConfRequestDTO, IntervalConf.class);
//
//        if (standardMapper.countIntervalConfByDimensionAndTypeAndBusinessFormIdAndBusinessSpeciesId(intervalConf) > 0){
//
//            throw exceptionUtil.throwCustomException("STANDARD_SAVE_INTERVAL_CONF_012");
//        }
//
//        standardMapper.saveIntervalConf(
//                Stream.of(intervalConf
//                        .setId(UuidUtil.randomUUID())
//                        .setNum(BusinessNum.INTERVAL_CONF+UuidUtil.randomUUID())
//                        .setModifyTime(LocalDateTime.now())
//                        .setCreateUser(loginEmployeeId)
//                        .setModifyUser(loginEmployeeId)
//                        .setCreateTime(LocalDateTime.now())).collect(Collectors.toList()));
//    }
//
//    /**
//     *@Author:Fly Created in 2018/7/9 下午9:59
//     *@Description: 编辑区间设置
//     */
//    @Transactional(rollbackFor = Exception.class)
//    @Override
//    public void editIntervalConf(EditIntervalConfRequestDTO editIntervalConfRequestDTO, String loginEmployeeId) {
//
//        IntervalConf intervalConf = standardMapper.findIntervalConfById(editIntervalConfRequestDTO.getId());
//
//        if (Objects.isNull(intervalConf)){
//
//            throw exceptionUtil.throwCustomException("STANDARD_EDIT_INTERVAL_CONF_011");
//        }
//
//        if (Objects.isNull(baseMapper.findBusinessFormById(editIntervalConfRequestDTO.getBusinessFormId()))){
//
//            throw exceptionUtil.throwCustomException("STANDARD_EDIT_INTERVAL_CONF_012");
//        }
//
//        if (Objects.isNull(baseMapper.findBusinessSpeciesById(editIntervalConfRequestDTO.getBusinessSpeciesId()))){
//
//            throw exceptionUtil.throwCustomException("STANDARD_EDIT_INTERVAL_CONF_013");
//        }
//
//        if (standardMapper.countIntervalConfByDimensionAndTypeAndBusinessFormIdAndBusinessSpeciesId(intervalConf) > 0){
//
//            throw exceptionUtil.throwCustomException("STANDARD_EDIT_INTERVAL_CONF_014");
//        }
//
//        standardMapper.editIntervalConf(
//                intervalConf
//                        .setDimension(editIntervalConfRequestDTO.getDimension())
//                        .setType(editIntervalConfRequestDTO.getType())
//                        .setBusinessFormId(editIntervalConfRequestDTO.getBusinessFormId())
//                        .setBusinessSpeciesId(editIntervalConfRequestDTO.getBusinessSpeciesId())
//                        .setYx(editIntervalConfRequestDTO.getYx())
//                        .setLh(editIntervalConfRequestDTO.getLh())
//                        .setHl(editIntervalConfRequestDTO.getHl())
//                        .setTs(editIntervalConfRequestDTO.getTs())
//                        .setKs(editIntervalConfRequestDTO.getKs())
//                        .setModifyUser(loginEmployeeId)
//                        .setModifyTime(LocalDateTime.now()));
//
//    }
//
//    /**
//     *@Author:Fly Created in 2018/7/9 下午9:59
//     *@Description: 删除区间设置
//     */
//    @Transactional(rollbackFor = Exception.class)
//    @Override
//    public void removeIntervalConf(String id) {
//
//        standardMapper.removeIntervalById(id);
//    }
//
//    /**
//     *@Author:Fly Created in 2018/7/9 下午11:30
//     *@Description: 区间设置详情
//     */
//    @Override
//    public FindIntervalByIdResponse findIntervalById(String id) {
//
//        IntervalConf intervalConf =
//                standardMapper.findIntervalConfById(id);
//
//        if (Objects.isNull(intervalConf)){
//
//            throw exceptionUtil.throwCustomException("STANDARD_FIND_INTERVAL_CONF_BY_ID_001");
//        }
//
//        return MapperFactoryUtil.mapperObject(intervalConf, FindIntervalByIdResponse.class);
//    }
//
//    /**
//     *@Author:Fly Created in 2018/7/10 下午3:48
//     *@Description: 添加标准三角形
//     */
//    @Transactional(rollbackFor = Exception.class)
//    @Override
//    public void saveTriangle(SaveTriangleRequestDTO saveTriangleRequestDTO, String loginEmployeeId) {
//
//        if (Objects.isNull(baseMapper.findBusinessFormById(saveTriangleRequestDTO.getBusinessFormId()))){
//
//            throw exceptionUtil.throwCustomException("STANDARD_SAVE_TRIANGLE_008");
//        }
//
//        if (Objects.isNull(baseMapper.findBusinessSpeciesById(saveTriangleRequestDTO.getBusinessSpeciesId()))){
//
//            throw exceptionUtil.throwCustomException("STANDARD_SAVE_TRIANGLE_009");
//        }
//
//        Triangle triangle =
//                MapperFactoryUtil.mapperObject(saveTriangleRequestDTO, Triangle.class);
//
//        if (standardMapper.countTriangleByDimensionAndBusinessFormIdAndBusinessSpeciesId(triangle) > 0){
//
//            throw exceptionUtil.throwCustomException("STANDARD_SAVE_TRIANGLE_010");
//        }
//
//        standardMapper.saveTriangle(
//                Stream.of(
//                        triangle
//                                .setId(UuidUtil.randomUUID())
//                                .setNum(BusinessNum.TRIANGLE+UuidUtil.randomUUID())
//                                .setGpDegree()
//                                .setModifyUser(loginEmployeeId)
//                                .setCreateUser(loginEmployeeId)
//                                .setModifyTime(LocalDateTime.now())
//                                .setCreateTime(LocalDateTime.now()))
//                        .collect(Collectors.toList()));
//
//    }
//
//    /**
//     *@Author:Fly Created in 2018/7/10 下午3:49
//     *@Description: 编辑标准三角形
//     */
//    @Transactional(rollbackFor = Exception.class)
//    @Override
//    public void editTriangle(EditTriangleRequestDTO editTriangleRequestDTO, String loginEmployeeId) {
//
//    }
//
//    /**
//     *@Author:Fly Created in 2018/7/10 下午3:49
//     *@Description: 删除标准三角形
//     */
//    @Transactional(rollbackFor = Exception.class)
//    @Override
//    public void removeTriangle(String id) {
//
//    }
//
//    /**
//     *@Author:Fly Created in 2018/7/10 下午3:49
//     *@Description: 查询标准三角形详情
//     */
//    @Override
//    public FindTriangleByIdResponse findTriangleById(String id) {
//        return null;
//    }
//}
