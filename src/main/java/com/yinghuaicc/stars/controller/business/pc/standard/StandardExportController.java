package com.yinghuaicc.stars.controller.business.pc.standard;

import com.yinghuaicc.stars.config.response.JsonResult;
import com.yinghuaicc.stars.service.cqrs.standard.StandardExportService;
import com.yinghuaicc.stars.service.cqrs.standard.dto.request.StandardExportDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

/**
 * Created by 你看见过我吗？你想一想在回答。 on 2018/7/29.
 */
@RestController
@RequestMapping(value="/standardexport")
public class StandardExportController {

    @Autowired
    StandardExportService standardExportService;

    /**
     *
     * @param standardExportDTO
     * @param response
     * @return
     * @throws Exception
     * 标准三角形客销度
     */
    @RequestMapping(value = "/excel", method = RequestMethod.POST)
    public JsonResult excel(@RequestBody StandardExportDTO standardExportDTO, HttpServletResponse response) throws Exception {
        standardExportService.getStandardExportList(response,standardExportDTO);
        return JsonResult.success("OK");
    }


    /**
     *
     * @param standardExportDTO
     * @param response
     * @return
     * 标准三角形适配值
     * @throws Exception
     */
    @RequestMapping(value = "/excel/spz", method = RequestMethod.POST)
    public JsonResult excel1(@RequestBody StandardExportDTO standardExportDTO, HttpServletResponse response) throws Exception {
        standardExportService.getStandardExportList1(response,standardExportDTO);
        return JsonResult.success("OK");
    }


    /**
     *
     * @param
     * @param response
     * @return
     * 准三角形_溢租率
     * @throws Exception
     */
    @RequestMapping(value = "/excel/yzl", method = RequestMethod.POST)
    public JsonResult excel2(@RequestBody StandardExportDTO standardExportDTO,HttpServletResponse response) throws Exception {
        standardExportService.getStandardyzlExportList(response,standardExportDTO);
        return JsonResult.success("OK");
    }

    /**
     *
     * @param
     * @param response
     * @return
     * 动态三角形_客销度
     * @throws Exception
     */
    @RequestMapping(value = "/excel/dtkxd", method = RequestMethod.POST)
    public JsonResult excel3(@RequestBody StandardExportDTO standardExportDTO,HttpServletResponse response) throws Exception {
        standardExportService.getFittedExportList(response,standardExportDTO);
        return JsonResult.success("OK");
    }


    /**
     *动态三角形_适配值
     * @param
     * @param response
     * @return
     * 动态三角形_客销度
     * @throws Exception
     */
    @RequestMapping(value = "/excel/dtspz", method = RequestMethod.POST)
    public JsonResult excel4(@RequestBody StandardExportDTO standardExportDTO,HttpServletResponse response) throws Exception {
        standardExportService.getFittedExportList1(response,standardExportDTO);
        return JsonResult.success("OK");
    }


    /**
     * 动态三角形_溢租率
     * @param
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/excel/dtyzl", method = RequestMethod.POST)
    public JsonResult excel5(@RequestBody StandardExportDTO standardExportDTO,HttpServletResponse response) throws Exception {
        standardExportService.getFittedExportList2(response,standardExportDTO);
        return JsonResult.success("OK");
    }


    /**
     * 区间设置_客销度
     * @param
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/excel/qjszkxd", method = RequestMethod.POST)
    public JsonResult excel6(@RequestBody StandardExportDTO standardExportDTO,HttpServletResponse response) throws Exception {
        standardExportService.getFittedExportList3(response,standardExportDTO);
        return JsonResult.success("OK");
    }
}
