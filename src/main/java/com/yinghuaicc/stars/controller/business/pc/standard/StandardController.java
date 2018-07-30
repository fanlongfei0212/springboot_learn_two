package com.yinghuaicc.stars.controller.business.pc.standard;//package com.yinghuaicc.stars.controller.business.pc.standard;
//
//import com.yinghuaicc.stars.config.page.PageParam;
//import com.yinghuaicc.stars.config.response.JsonResult;
//import com.yinghuaicc.stars.controller.config.aop.pc.AopResourceEmployeeBean;
//import com.yinghuaicc.stars.service.cqrs.standard.StandardCQRSService;
//import com.yinghuaicc.stars.service.standard.StandardService;
//import com.yinghuaicc.stars.service.standard.dto.request.EditIntervalConfRequestDTO;
//import com.yinghuaicc.stars.service.standard.dto.request.SaveIntervalConfRequestDTO;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.ApplicationContext;
//import org.springframework.validation.annotation.Validated;
//import org.springframework.web.bind.annotation.*;
//
///**
// * @Author:Fly
// * @Date:Create in 2018/7/9 下午10:34
// * @Description: 标准设置Controller
// * @Modified:
// */
//@RestController
//@RequestMapping(value = "/standard")
//public class StandardController {
//
//    @Autowired
//    private ApplicationContext applicationContext;
//
//    @Autowired
//    private StandardCQRSService standardCQRSService;
//
//    @Autowired
//    private StandardService standardService;
//
//    /**
//     *@Author:Fly Created in 2018/7/9 下午10:36
//     *@Description: 添加区间设置
//     */
//    @PostMapping(value = "/save/interval/conf")
//    public JsonResult saveIntervalConf(@Validated @RequestBody SaveIntervalConfRequestDTO saveIntervalConfRequestDTO){
//
//        standardService.saveIntervalConf(
//                saveIntervalConfRequestDTO, applicationContext.getBean(AopResourceEmployeeBean.class).getId());
//
//        return JsonResult.success("OK");
//    }
//
//    /**
//     *@Author:Fly Created in 2018/7/9 下午11:05
//     *@Description: 修改区间设置
//     */
//    @PostMapping(value = "/edit/interval/conf")
//    public JsonResult editIntervalConf(@Validated @RequestBody EditIntervalConfRequestDTO editIntervalConfRequestDTO){
//
//        standardService.editIntervalConf(
//                editIntervalConfRequestDTO, applicationContext.getBean(AopResourceEmployeeBean.class).getId());
//
//        return JsonResult.success("OK");
//    }
//
//    /**
//     *@Author:Fly Created in 2018/7/9 下午11:06
//     *@Description: 删除区间设置
//     */
//    @GetMapping(value = "/remove/interval/conf/{id}")
//    public JsonResult removeIntervalConf(@PathVariable String id){
//
//        standardService.removeIntervalConf(id);
//
//        return JsonResult.success("OK");
//    }
//
//    /**
//     *@Author:Fly Created in 2018/7/9 下午11:08
//     *@Description: 区间设置列表
//     */
//    @GetMapping(value = "/find/interval/conf/list")
//    public JsonResult findIntervalConfList(@ModelAttribute PageParam pageParam){
//
//        return JsonResult.success(
//                standardCQRSService.findIntervalList(pageParam));
//    }
//
//    /**
//     *@Author:Fly Created in 2018/7/9 下午11:35
//     *@Description: 根据区间设置id查询区间设置信息
//     */
//    @GetMapping(value = "/find/interval/conf/by/{id}")
//    public JsonResult finIntervalConfById(@PathVariable String id){
//
//        return JsonResult.success(standardService.findIntervalById(id));
//    }
//}
