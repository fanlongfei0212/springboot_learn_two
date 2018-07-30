package com.yinghuaicc.stars.controller.business.pc.standard;

import com.yinghuaicc.stars.common.utils.excel.ExcelImportUtil;
import com.yinghuaicc.stars.common.utils.uuid.UuidUtil;
import com.yinghuaicc.stars.config.response.JsonResult;
import com.yinghuaicc.stars.repository.model.standard.*;
import com.yinghuaicc.stars.repository.model.standard.mult.*;
import com.yinghuaicc.stars.service.cqrs.standard.*;
import com.yinghuaicc.stars.service.cqrs.standard.dto.response.StandardFittedImportExcelResponseDTO;
import com.yinghuaicc.stars.service.cqrs.standard.dto.response.StandardRentImportExcelResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;
import java.util.List;


/**
 * 标准三角形导入
 */
@RestController
@RequestMapping(value = "/standimport")
public class StandImportExcelController {

    @Autowired
    private ExcelImportUtil excelImportUtil;
    @Autowired
    private StandardProjectFittedService standardProjectFittedService;

    @Autowired
    private StandardFloorFittedService standardFloorFittedService;

    @Autowired
    private StandardConditionFittedService standardConditionFittedService;
    @Autowired
    private StandardProjectRentService standardProjectRentService;

    @Autowired
    private StandardFloorRentService standardFloorRentService;

    @Autowired
    private StandardConditionRentService standardConditionRentService;

    @Autowired
    private StandardBrandSaleService standardBrandSaleService;
    /**
     *@Description: 标准三角形适配值多Sheet导入
     */
    @PostMapping(value = "/excel/standfittedimport/sheet")
    public JsonResult standFittedExcelImportSheet(@RequestParam("file")MultipartFile file) {

        StandardFittedImportExcelResponseDTO standardFittedImportExcelResponseDTO = excelImportUtil.getExcelDataToListMultiSheet(file, StandardFittedImportExcelResponseDTO.class);
        //TODO---新增项目记录
        //项目适配值
        List<StandProjectFittedExcel> standardProjectFitteds = standardFittedImportExcelResponseDTO.getStandardProjectFitteds();
        for(StandProjectFittedExcel standProjectFittedExcel :standardProjectFitteds){

            StandardProjectFitted standardProjectFitted = new StandardProjectFitted();
            //id
            standardProjectFitted.setId(UuidUtil.randomUUID());
            //版本id
            standardProjectFitted.setStandardVerssionId(UuidUtil.randomUUID());
            //版本名称
            standardProjectFitted.setStandardVerssionName(LocalDateTime.now()+"项目适配值");
            //项目id
            standardProjectFitted.setProjectId(standProjectFittedExcel.getProjectId());
            //项目名称
            standardProjectFitted.setProjectName(standProjectFittedExcel.getProjectName());
            //适配值
            standardProjectFitted.setFitted(standProjectFittedExcel.getFitted());

            standardProjectFitted.setCreateTime(LocalDateTime.now());
            standardProjectFitted.setModifyTime(LocalDateTime.now());
            /*standardProjectFitted.setCreateUser();
            standardProjectFitted.setModifyUser();*/
            standardProjectFitted.setStatus("启用");

            standardProjectFittedService.saveStandardProjectFitted(standardProjectFitted);

        }
        //TODO---新增楼层记录

        //楼层适配值
        List<StandFloorFittedExcel> standardFloorFitteds = standardFittedImportExcelResponseDTO.getStandardFloorFitteds();
        for(StandFloorFittedExcel standFloorFittedExcel :standardFloorFitteds){

            StandardFloorFitted standardFloorFitted = new StandardFloorFitted();

            //id
            standardFloorFitted.setId(UuidUtil.randomUUID());
            //版本id
            standardFloorFitted.setStandardVerssionId(UuidUtil.randomUUID());
            //版本名称
            standardFloorFitted.setStandardVerssionName(LocalDateTime.now()+"项目适配值");
            //项目id
            standardFloorFitted.setProjectId(standFloorFittedExcel.getProjectId());
            //项目名称
            standardFloorFitted.setProjectName(standFloorFittedExcel.getProjectName());
           /* //楼层id
            standardFloorFitted.setFloorId(standFloorFittedExcel.get);*/
            //楼层名称
            standardFloorFitted.setFloorName(standFloorFittedExcel.getFloorName());
            //适配值
            standardFloorFitted.setFitted(standFloorFittedExcel.getFitted());

            standardFloorFitted.setCreateTime(LocalDateTime.now());
            standardFloorFitted.setModifyTime(LocalDateTime.now());
            /*standardProjectFitted.setCreateUser();
            standardProjectFitted.setModifyUser();*/
            standardFloorFitted.setStatus("启用");
            standardFloorFittedService.saveStandardFloorFitted(standardFloorFitted);

        }

        //业态适配值
        List<StandConditionFittedExcel> standardConditionFitteds = standardFittedImportExcelResponseDTO.getStandardConditionFitteds();
        for(StandConditionFittedExcel standConditionFittedExcel :standardConditionFitteds){

            StandardConditionFitted standardConditionFitted = new StandardConditionFitted();

            //id
            standardConditionFitted.setId(UuidUtil.randomUUID());
            //版本id
            standardConditionFitted.setStandardVerssionId(UuidUtil.randomUUID());
            //版本名称
            standardConditionFitted.setStandardVerssionName(LocalDateTime.now()+"项目适配值");
            //项目id
            standardConditionFitted.setProjectId(standConditionFittedExcel.getProjectId());
            //项目名称
            standardConditionFitted.setProjectName(standConditionFittedExcel.getProjectName());
           //业态id
            /*standardConditionFitted.setConditionId(standConditionFittedExcel.getConditionName());*/

            //业态名称
            standardConditionFitted.setConditionId(standConditionFittedExcel.getConditionName());

            //业种名称
            /*standardConditionFitted.setMajoId(standConditionFittedExcel.getMajoId());*/
            //业种名称
            standardConditionFitted.setMajoName(standConditionFittedExcel.getMajoName());

            //适配值
            standardConditionFitted.setFitted(standConditionFittedExcel.getFitted());

            standardConditionFitted.setCreateTime(LocalDateTime.now());
            standardConditionFitted.setModifyTime(LocalDateTime.now());
            /*standardProjectFitted.setCreateUser();
            standardProjectFitted.setModifyUser();*/
            standardConditionFitted.setStatus("启用");
            standardConditionFittedService.saveStandardConditionFitted(standardConditionFitted);

        }
        //TODO---新增业态记录

        return JsonResult.success("success");
    }

    /**
     *@Description: 标准三角形溢租率多Sheet导入
     */
    @PostMapping(value = "/excel/standrentimport/sheet")
    public JsonResult standRentExcelImportSheet(@RequestParam("file")MultipartFile file) {

        StandardRentImportExcelResponseDTO standardRentImportExcelResponseDTO = excelImportUtil.getExcelDataToListMultiSheet(file, StandardRentImportExcelResponseDTO.class);
        //项目溢租率
        List<StandProjectRentExcel> standardProjectFitteds = standardRentImportExcelResponseDTO.getStandProjectRentExcels();
        //TODO---新增项目记录
        for(StandProjectRentExcel standProjectRentExcel :standardProjectFitteds){
            StandardProjectRent standardProjectRent = new StandardProjectRent();
            //id
            standardProjectRent.setId(UuidUtil.randomUUID()) ;
            //版本id
            standardProjectRent.setStandardVerssionId(UuidUtil.randomUUID());
            //版本名称
            standardProjectRent.setStandardVerssionName(LocalDateTime.now()+"项目溢租率");
            //项目id
            standardProjectRent.setProjectId(standProjectRentExcel.getProjectId());
            //项目名称
            standardProjectRent.setProjectName(standProjectRentExcel.getProjectName());
            //溢租率
            standardProjectRent.setRent(standProjectRentExcel.getRent());
            standardProjectRent.setCreateTime(LocalDateTime.now());
            standardProjectRent.setModifyTime(LocalDateTime.now());
           /* standardProjectRent.setCreateUser();
            standardProjectRent.setModifyUser();*/
            standardProjectRent.setStatus("已启用");

            standardProjectRentService.saveStandardProjectRent(standardProjectRent);

        }
        //楼层溢租率
        List<StandFloorRentExcel> standardFloorFitteds = standardRentImportExcelResponseDTO.getStandFloorRentExcels();

        //TODO---新增楼层记录
        for(StandFloorRentExcel standFloorRentExcel :standardFloorFitteds){
            StandardFloorRent standardFloorRent = new StandardFloorRent();
            //id
            standardFloorRent.setId(UuidUtil.randomUUID()) ;
            //版本id
            standardFloorRent.setStandardVerssionId(UuidUtil.randomUUID());
            //版本名称
            standardFloorRent.setStandardVerssionName(LocalDateTime.now()+"项目溢租率");
            //项目id
            standardFloorRent.setProjectId(standFloorRentExcel.getProjectId());
            //项目名称
            standardFloorRent.setProjectName(standFloorRentExcel.getProjectName());
            /*standardFloorRent.setFloorId();*/
            //楼层名称
            standardFloorRent.setFloorName(standFloorRentExcel.getFloorName());
            //溢租率
            standardFloorRent.setRent(standFloorRentExcel.getRent());
            standardFloorRent.setCreateTime(LocalDateTime.now());
            standardFloorRent.setModifyTime(LocalDateTime.now());
           /* standardProjectRent.setCreateUser();
            standardProjectRent.setModifyUser();*/
            standardFloorRent.setStatus("已启用");

            standardFloorRentService.saveStandardFloorRent(standardFloorRent);
        }



        //业态溢租率
        List<StandConditionRentExcel> standardConditionFitteds = standardRentImportExcelResponseDTO.getStandConditionRentExcels();

        //TODO---新增业态记录
        for(StandConditionRentExcel standConditionRentExcel :standardConditionFitteds){
            StandardConditionRent standardConditionRent = new StandardConditionRent();
            //id
            standardConditionRent.setId(UuidUtil.randomUUID()) ;
            //版本id
            standardConditionRent.setStandardVerssionId(UuidUtil.randomUUID());
            //版本名称
            standardConditionRent.setStandardVerssionName(LocalDateTime.now()+"项目溢租率");
            //项目id
            standardConditionRent.setProjectId(standConditionRentExcel.getProjectId());
            //项目名称
            standardConditionRent.setProjectName(standConditionRentExcel.getProjectName());
            /*standardFloorRent.setFloorId();*/
         /*   //楼层名称
            standardConditionRent.setFloorName(standConditionRentExcel.getFloorName());*/

            //业态名称
            standardConditionRent.setConditionName(standConditionRentExcel.getConditionName());
            //业种名称
            standardConditionRent.setMajoName(standConditionRentExcel.getMajoName());
            //溢租率
            standardConditionRent.setRent(standConditionRentExcel.getRent());
            standardConditionRent.setCreateTime(LocalDateTime.now());
            standardConditionRent.setModifyTime(LocalDateTime.now());
           /* standardProjectRent.setCreateUser();
            standardProjectRent.setModifyUser();*/
            standardConditionRent.setStatus("已启用");

            standardConditionRentService.saveStandardConditionRent(standardConditionRent);
        }

        return JsonResult.success("success");
    }

    /**
     *@Description: 标准三角形客销度导入
     */
    @PostMapping(value = "/excel/standguestimport/sheet")
    public JsonResult standGuestExcelImportSheet(@RequestParam("file")MultipartFile file) {

        List<StandConditionGuestExcel> standConditionGuestExcels = excelImportUtil.getExcelDataToList(file, StandConditionGuestExcel.class);

        for (StandConditionGuestExcel standConditionGuestExcel :standConditionGuestExcels){
            StandardBrandSale standardBrandSale= new StandardBrandSale();
            //id
            standardBrandSale.setId(UuidUtil.randomUUID());
            //版本名称
            standardBrandSale.setSaleVessionId(UuidUtil.randomUUID());
            //版本名称
            standardBrandSale.setSaleVessionName(LocalDateTime.now()+"业态客销度");
            //签约id
            standardBrandSale.setContractId(standConditionGuestExcel.getConstractId());
            /*standardBrandSale.setProjectId();*/
            standardBrandSale.setProjectName(standConditionGuestExcel.getProjectName());
            //品牌名称
            standardBrandSale.setContractName(standConditionGuestExcel.getBrandName());
            //业态id
//            standardBrandSale.setConditionId();
            standardBrandSale.setConditionName(standConditionGuestExcel.getConditionName());
            //业种id
           /* standardBrandSale.setMajoId();*/
            standardBrandSale.setMajoName(standConditionGuestExcel.getMajoName());
            //毛利率
            standardBrandSale.setGrossRate(standConditionGuestExcel.getGrossRate());
            //客单价
            standardBrandSale.setPerSale(standConditionGuestExcel.getPerSale());
            //签约状态
            standardBrandSale.setSignStatus(standConditionGuestExcel.getSignStatus());
            standardBrandSale.setCreateTime(LocalDateTime.now());
            standardBrandSale.setModifyTime(LocalDateTime.now());
         /*   standardBrandSale.setCreateUser();
            standardBrandSale.setModifyUser();*/
            standardBrandSaleService.saveStandardBrandSale(standardBrandSale);
        }
            //TODO---新增标准三角形客销度记录


        //TODO---新增客销度版本记录

        return JsonResult.success("success");
    }


}
