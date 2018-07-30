package com.yinghuaicc.stars.controller.business.pc.intervalset;

import com.yinghuaicc.stars.common.utils.excel.ExcelImportUtil;
import com.yinghuaicc.stars.config.response.JsonResult;
import com.yinghuaicc.stars.repository.model.Intervalset.ConditionGuestInterval;
import com.yinghuaicc.stars.repository.model.Intervalset.FloorGuestInterval;
import com.yinghuaicc.stars.repository.model.Intervalset.ProjectGuestInterval;
import com.yinghuaicc.stars.repository.model.Intervalset.mult.IntervalConditionGuestImportExcel;
import com.yinghuaicc.stars.repository.model.Intervalset.mult.IntervalFloorGuestImportExcel;
import com.yinghuaicc.stars.repository.model.Intervalset.mult.IntervalProjectGuestImportExcel;
import com.yinghuaicc.stars.service.cqrs.Intervalset.ConditionGuestIntervalService;
import com.yinghuaicc.stars.service.cqrs.Intervalset.FloorGuestIntervalService;
import com.yinghuaicc.stars.service.cqrs.Intervalset.ProjectGuestIntervalService;
import com.yinghuaicc.stars.service.cqrs.Intervalset.dto.response.IntervalGuestImportExcelResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.math.BigDecimal;
import java.util.List;

/**
 * 区间设置导入Controller
 */
@RestController
@RequestMapping(value="/intervalimportexcel")
public class IntervalImportExcelController {

    @Autowired
    private ExcelImportUtil excelImportUtil;

    @Autowired
    private ProjectGuestIntervalService projectGuestIntervalService;

    @Autowired
    private FloorGuestIntervalService floorGuestIntervalService;

    @Autowired
    private ConditionGuestIntervalService conditionGuestIntervalService;

    /**
     *@Description: 区间设置客销度多Sheet导入
     */
    @PostMapping(value = "/excel/intervalguestimport/sheet")
    public JsonResult IntervalGuestExcelImportSheet(@RequestParam("file")MultipartFile file) {

        IntervalGuestImportExcelResponseDTO intervalGuestImportExcelResponseDTO = excelImportUtil.getExcelDataToListMultiSheet(file, IntervalGuestImportExcelResponseDTO.class);

        List<IntervalProjectGuestImportExcel> intervalProjectGuestImportExcels =  intervalGuestImportExcelResponseDTO.getIntervalProjectGuestImportExcelList();
        intervalProjectGuestImportExcels.forEach(intervalProjectGuestImportExcel->{
            //id
             String constractId = intervalProjectGuestImportExcel.getConstractId();
            ProjectGuestInterval projectGuestInterval = projectGuestIntervalService.findProjectByProjectId(constractId);
            //项目名称
             String projcetName;
            //区间最大值
             BigDecimal maxvalue;
            //区间增长百分比
             BigDecimal intervalRate;

            if(projectGuestInterval!=null){
                projectGuestIntervalService.editProject(projectGuestInterval);
            }else{
                projectGuestIntervalService.saveProject(projectGuestInterval);
            }
        });

        List<IntervalFloorGuestImportExcel> intervalFloorGuestImportExcels =  intervalGuestImportExcelResponseDTO.getIntervalFloorGuestImportExcelList();

        intervalFloorGuestImportExcels.forEach(intervalFloorGuestImportExcel->{

            //id
            String constractId = intervalFloorGuestImportExcel.getConstractId();

            FloorGuestInterval floorGuestInterval = floorGuestIntervalService.findProjectByProjectId(constractId);
            //项目名称
            String projcetName;
            //区间最大值
            BigDecimal maxvalue;
            //区间增长百分比
            BigDecimal intervalRate;

            if(floorGuestInterval!=null){
                floorGuestIntervalService.editFloorGuestInterval(floorGuestInterval);
            }else{
                floorGuestIntervalService.saveFloorGuestInterval(floorGuestInterval);
            }

        });

        List<IntervalConditionGuestImportExcel> intervalConditionGuestImportExcelLists =  intervalGuestImportExcelResponseDTO.getIntervalConditionGuestImportExcelList();
        //TODO----
        intervalConditionGuestImportExcelLists.forEach(intervalConditionGuestImportExcelList->{
            //id
            String constractId = intervalConditionGuestImportExcelList.getConstractId();

            ConditionGuestInterval conditionGuestInterval = conditionGuestIntervalService.findConditionById(constractId);
            //项目名称
            String projcetName;
            //区间最大值
            BigDecimal maxvalue;
            //区间增长百分比
            BigDecimal intervalRate;

            if(conditionGuestInterval!=null){
                conditionGuestIntervalService.editConditionGuestInterval(conditionGuestInterval);
            }else{
                conditionGuestIntervalService.saveConditionGuestInterval(conditionGuestInterval);
            }
        });

        return JsonResult.success(intervalGuestImportExcelResponseDTO);
    }


}
