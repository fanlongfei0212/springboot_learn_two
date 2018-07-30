package com.yinghuaicc.stars.controller.business.common.test;

import com.yinghuaicc.stars.common.utils.excel.ExcelExportUtils;
import com.yinghuaicc.stars.common.utils.excel.ExcelImportUtil;
import com.yinghuaicc.stars.common.utils.mapper.MapperFactoryUtil;
import com.yinghuaicc.stars.config.response.JsonResult;
import com.yinghuaicc.stars.controller.business.common.test.dept.Dept;
import com.yinghuaicc.stars.controller.business.common.test.dept.TestDept;
import com.yinghuaicc.stars.controller.business.common.test.multi.ListTestDTO;
import com.yinghuaicc.stars.repository.mapper.tissue.TissueMapper;
import com.yinghuaicc.stars.repository.model.tissue.Department;
import com.yinghuaicc.stars.repository.model.tissue.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @Author:Fly
 * @Date:Create in 2018/7/13 上午10:55
 * @Description: ExcelController
 * @Modified:
 */
@RestController
@RequestMapping(value = "/excel")
public class ExcelController {

    @Autowired
    private ExcelImportUtil excelImportUtil;

    @Autowired
    private TissueMapper tissueMapper;

    /**
     *@Author:Fly Created in 2018/7/13 上午10:57
     *@Description: 导入
     */
    @PostMapping(value = "/excel/import")
    public JsonResult excelImport(@RequestParam("file")MultipartFile file){

        List<TestDTO> result = excelImportUtil.getExcelDataToList(file, TestDTO.class);

        return JsonResult.success(result);
    }

    /**
     *@Author:Fly Created in 2018/7/22 下午4:59
     *@Description: 多Sheet导入
     */
    @PostMapping(value = "/excel/import/sheet")
    public JsonResult excelImportSheet(@RequestParam("file")MultipartFile file){

        return JsonResult.success(excelImportUtil.getExcelDataToListMultiSheet(file, ListTestDTO.class));
    }

    /**
     *@Author:Fly Created in 2018/7/23 下午5:53
     *@Description: 导出Excel
     */
    @GetMapping(value = "/excel/export")
    public JsonResult excelExport(){

        List<Department> list = tissueMapper.findDepartmentAll();


        try {
            ExcelExportUtils.writeToFile(MapperFactoryUtil.mapperList(list, Dept.class),null,"/Users/fanlongfei/Desktop/fileTest/excel/测试导出单页"+ LocalDateTime.now()+".xlsx");
        } catch (Exception e) {
            e.printStackTrace();
        }

        return JsonResult.success("OK");
    }

    /**
     *@Author:Fly Created in 2018/7/23 下午5:53
     *@Description: 导出多SheetExcel
     */
    @GetMapping(value = "/excel/export/sheet")
    public JsonResult excelExportSheet(){

        TestDept testDept = new TestDept()
                .setA(MapperFactoryUtil.mapperList(tissueMapper.findDepartmentAll(), Dept.class))
                .setB(MapperFactoryUtil.mapperList(tissueMapper.findDepartmentAll(), Dept.class))
        .setC(MapperFactoryUtil.mapperList(tissueMapper.findDepartmentAll(), Dept.class))
        .setD(MapperFactoryUtil.mapperList(tissueMapper.findDepartmentAll(), Dept.class))
        .setE(MapperFactoryUtil.mapperList(tissueMapper.findDepartmentAll(), Dept.class));


        try {
            ExcelExportUtils.getWorkBookSheet(testDept,null,"/Users/fanlongfei/Desktop/fileTest/excel/测试导出单页"+ LocalDateTime.now()+".xlsx");
        } catch (Exception e) {
            e.printStackTrace();
        }

        return JsonResult.success("OK");
    }
}
