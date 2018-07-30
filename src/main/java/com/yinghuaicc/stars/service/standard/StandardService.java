package com.yinghuaicc.stars.service.standard;//package com.yinghuaicc.stars.service.standard;
//
//import com.yinghuaicc.stars.service.standard.dto.request.EditIntervalConfRequestDTO;
//import com.yinghuaicc.stars.service.standard.dto.request.EditTriangleRequestDTO;
//import com.yinghuaicc.stars.service.standard.dto.request.SaveIntervalConfRequestDTO;
//import com.yinghuaicc.stars.service.standard.dto.request.SaveTriangleRequestDTO;
//import com.yinghuaicc.stars.service.standard.dto.response.FindIntervalByIdResponse;
//import com.yinghuaicc.stars.service.standard.dto.response.FindTriangleByIdResponse;
//
///**
// * @Author:Fly
// * @Date:Create in 2018/7/9 下午8:51
// * @Description: 区间设置服务
// * @Modified:
// */
//public interface StandardService {
//
//    /**
//     *@Author:Fly Created in 2018/7/9 下午9:20
//     *@Description: 添加区间设置
//     */
//    void saveIntervalConf(SaveIntervalConfRequestDTO saveIntervalConfRequestDTO, String loginEmployeeId);
//
//    /**
//     *@Author:Fly Created in 2018/7/9 下午9:48
//     *@Description: 编辑区间设置
//     */
//    void editIntervalConf(EditIntervalConfRequestDTO editIntervalConfRequestDTO, String loginEmployeeId);
//
//    /**
//     *@Author:Fly Created in 2018/7/9 下午9:51
//     *@Description: 删除区间设置
//     */
//    void removeIntervalConf(String id);
//
//    /**
//     *@Author:Fly Created in 2018/7/9 下午11:29
//     *@Description: 区间设置详情
//     */
//    FindIntervalByIdResponse findIntervalById(String id);
//
//    /**
//     *@Author:Fly Created in 2018/7/10 下午3:36
//     *@Description: 添加标准三角形
//     */
//    void saveTriangle(SaveTriangleRequestDTO saveTriangleRequestDTO, String loginEmployeeId);
//
//    /**
//     *@Author:Fly Created in 2018/7/10 下午3:44
//     *@Description: 编辑标准三角形
//     */
//    void editTriangle(EditTriangleRequestDTO editTriangleRequestDTO, String loginEmployeeId);
//
//    /**
//     *@Author:Fly Created in 2018/7/10 下午3:45
//     *@Description: 删除标准三角形
//     */
//    void removeTriangle(String id);
//
//    /**
//     *@Author:Fly Created in 2018/7/10 下午3:47
//     *@Description: 查询标准三角形详情
//     */
//    FindTriangleByIdResponse findTriangleById(String id);
//
//}
