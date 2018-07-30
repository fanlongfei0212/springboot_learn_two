package com.yinghuaicc.stars.service.cqrs.standard;

import com.yinghuaicc.stars.common.utils.excel.ExcelData;
import com.yinghuaicc.stars.common.utils.excel.ExcelZjj;
import com.yinghuaicc.stars.repository.mapper.standard.StandardExportMapper;
import com.yinghuaicc.stars.service.cqrs.standard.dto.request.StandardExportDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 你看见过我吗？你想一想在回答。 on 2018/7/29.
 */
@Service
public class StandardExportServiceImpl implements StandardExportService {
    @Autowired
    StandardExportMapper standardExportMapper;

    /**
     * 标准三角形客销度
     * @param response
     * @param standardExportDTO
     * @throws Exception
     */
    @Override
    public void getStandardExportList(HttpServletResponse response,StandardExportDTO standardExportDTO) throws Exception {
        List<ExcelData> list = new ArrayList<>();
        ExcelData data = new ExcelData();
        data.setName("品牌客销度");
        List<String> title = new ArrayList();
        title.add("签约id");
        title.add("项目名称");
        title.add("楼层");
        title.add("铺位号");
        title.add("品牌名称");
        title.add("业态名称");
        title.add("签约状态");
        title.add("毛利率");
        title.add("客单价");
        data.setTitles(title);
        List<List<Object>> rows = new ArrayList();
        standardExportMapper.getStandardExportList(standardExportDTO).forEach(p->{
            List<Object> row = new ArrayList();
            row.add(p.getContractId());
            row.add(p.getProjectName());
            row.add(p.getFloorName());
            row.add(p.getRoomName());
            row.add(p.getBrandName());
            row.add(p.getBusinessFormName());
            row.add(p.getState());
            rows.add(row);
        });
        data.setRows(rows);
        list.add(data);
        ExcelZjj excelZjj = new ExcelZjj();
        excelZjj.exportExcel(response,"标准三角形客销度.xlsx",list);
    }

    /**
     * 标准三角形_适配值
     */
    @Override
    public void getStandardExportList1(HttpServletResponse response, StandardExportDTO standardExportDTO) throws Exception {

        //todo 下面这一大串可以优化，由于时间紧后期再做处理,zjj

        List<ExcelData> list = new ArrayList<>();
        ExcelData data = new ExcelData();
        data.setName("项目适配值");
        List<String> title = new ArrayList();
        title.add("项目id");
        title.add("项目名称");
        title.add("适配值");
        data.setTitles(title);
        List<List<Object>> rows = new ArrayList();
        standardExportMapper.getStandardExportList1(standardExportDTO).forEach(p->{
            List<Object> row = new ArrayList();
            row.add(p.getProjectId());
            row.add(p.getProjectName());
            rows.add(row);
        });
        data.setRows(rows);
        list.add(data);


        ExcelData data1 = new ExcelData();
        data1.setName("楼层适配值");
        List<String> title1 = new ArrayList();
        title1.add("关联id");
        title1.add("项目名称");
        title1.add("楼层名称");
        title1.add("适配值");
        data1.setTitles(title1);
        List<List<Object>> rows1 = new ArrayList();
        standardExportMapper.getStandardExportList2(standardExportDTO).forEach(p->{
            List<Object> row = new ArrayList();
            row.add(p.getId());
            row.add(p.getProjectName());
            row.add(p.getFloorName());
            rows1.add(row);
        });
        data1.setRows(rows1);
        list.add(data1);


        ExcelData data2 = new ExcelData();
        data2.setName("业态适配值");
        List<String> title2 = new ArrayList();
        title2.add("关联id");
        title2.add("项目名称");
        title2.add("业态名称");
        title2.add("业种名称");
        title2.add("适配值");
        data2.setTitles(title2);
        List<List<Object>> rows2 = new ArrayList();
        standardExportMapper.getStandardExportList3(standardExportDTO).forEach(p->{
            List<Object> row = new ArrayList();
            row.add(p.getId());
            row.add(p.getProjectName());
            row.add(p.getBusinessName());
            row.add(p.getSpeciesName());
            rows2.add(row);
        });
        data2.setRows(rows2);
        list.add(data2);

        ExcelZjj excelZjj = new ExcelZjj();
        excelZjj.exportExcel(response,"标准三角形适配值.xlsx",list);
    }

    /**
     * 标准三角形溢租率
     * @param response
     * @param standardExportDTO
     * @throws Exception
     */
    @Override
    public void getStandardyzlExportList(HttpServletResponse response, StandardExportDTO standardExportDTO) throws Exception {
        //todo 下面这一大串可以优化，由于时间紧后期再做处理,zjj

        List<ExcelData> list = new ArrayList<>();
        ExcelData data = new ExcelData();
        data.setName("项目适配值");
        List<String> title = new ArrayList();
        title.add("项目id");
        title.add("项目名称");
        title.add("溢租率");
        data.setTitles(title);
        List<List<Object>> rows = new ArrayList();
        standardExportMapper.getStandardExportList1(standardExportDTO).forEach(p->{
            List<Object> row = new ArrayList();
            row.add(p.getProjectId());
            row.add(p.getProjectName());
            rows.add(row);
        });
        data.setRows(rows);
        list.add(data);


        ExcelData data1 = new ExcelData();
        data1.setName("楼层适配值");
        List<String> title1 = new ArrayList();
        title1.add("关联id");
        title1.add("项目名称");
        title1.add("楼层名称");
        title1.add("溢租率");
        data1.setTitles(title1);
        List<List<Object>> rows1 = new ArrayList();
        standardExportMapper.getStandardExportList2(standardExportDTO).forEach(p->{
            List<Object> row = new ArrayList();
            row.add(p.getId());
            row.add(p.getProjectName());
            row.add(p.getFloorName());
            rows1.add(row);
        });
        data1.setRows(rows1);
        list.add(data1);


        ExcelData data2 = new ExcelData();
        data2.setName("业态适配值");
        List<String> title2 = new ArrayList();
        title2.add("关联id");
        title2.add("项目名称");
        title2.add("业态名称");
        title2.add("业种名称");
        title2.add("溢租率");
        data2.setTitles(title2);
        List<List<Object>> rows2 = new ArrayList();
        standardExportMapper.getStandardExportList3(standardExportDTO).forEach(p->{
            List<Object> row = new ArrayList();
            row.add(p.getId());
            row.add(p.getProjectName());
            row.add(p.getBusinessName());
            row.add(p.getSpeciesName());
            rows2.add(row);
        });
        data2.setRows(rows2);
        list.add(data2);

        ExcelZjj excelZjj = new ExcelZjj();
        excelZjj.exportExcel(response,"标准三角形溢租率.xlsx",list);
    }

    /**
     * 动态三角形_客销度
     */

    @Override
    public void getFittedExportList(HttpServletResponse response, StandardExportDTO standardExportDTO) throws Exception {
        //todo 下面这一大串可以优化，由于时间紧后期再做处理,zjj

        List<ExcelData> list = new ArrayList<>();
        ExcelData data = new ExcelData();
        data.setName("项目客销度");
        List<String> title = new ArrayList();
        title.add("签约id");
        title.add("项目名称");
        title.add("客流量");
        data.setTitles(title);
        List<List<Object>> rows = new ArrayList();
        standardExportMapper.getFittedExportList(standardExportDTO).forEach(p->{
            List<Object> row = new ArrayList();
            row.add(p.getId());
            row.add(p.getProjectName());
            rows.add(row);
        });
        data.setRows(rows);
        list.add(data);


        ExcelData data1 = new ExcelData();
        data1.setName("楼层客销度");
        List<String> title1 = new ArrayList();
        title1.add("签约id");
        title1.add("项目名称");
        title1.add("楼层名称");
        title1.add("客流量");
        data1.setTitles(title1);
        List<List<Object>> rows1 = new ArrayList();
        standardExportMapper.getFittedExportList1(standardExportDTO).forEach(p->{
            List<Object> row = new ArrayList();
            row.add(p.getId());
            row.add(p.getProjectName());
            row.add(p.getFloorName());
            rows1.add(row);
        });
        data1.setRows(rows1);
        list.add(data1);


        ExcelData data2 = new ExcelData();
        data2.setName("品牌客销度");
        List<String> title2 = new ArrayList();
        title2.add("签约id");
        title2.add("项目名称");
        title2.add("楼层名称");
        title2.add("铺位名称");
        title2.add("品牌名称");
        title2.add("业态名称");
        title2.add("签约状态");
        title2.add("客流量");
        title2.add("销售额");
        data2.setTitles(title2);
        List<List<Object>> rows2 = new ArrayList();
        standardExportMapper.getFittedExportList2(standardExportDTO).forEach(p->{
            List<Object> row = new ArrayList();
            row.add(p.getId());
            row.add(p.getProjectName());
            row.add(p.getBusinessName());
            row.add(p.getRoomName());
            row.add(p.getBrandName());
            row.add(p.getBusinessName());
            row.add(p.getSate());
            rows2.add(row);
        });
        data2.setRows(rows2);
        list.add(data2);

        ExcelZjj excelZjj = new ExcelZjj();
        excelZjj.exportExcel(response,"动态三角形客销度.xlsx",list);
    }

    /**
     * 动态三角形_适配值
     * @param response
     * @param standardExportDTO
     * @throws Exception
     */
    @Override
    public void getFittedExportList1(HttpServletResponse response, StandardExportDTO standardExportDTO) throws Exception {
        List<ExcelData> list = new ArrayList<>();
        ExcelData data = new ExcelData();
        data.setName("适配值");
        List<String> title = new ArrayList();
        title.add("签约id");
        title.add("项目名称");
        title.add("楼层名称");
        title.add("铺位名称");
        title.add("品牌名称");
        title.add("业态名称");
        title.add("签约状态");
        title.add("市场地位");
        title.add("品牌定位");
        title.add("品牌形象");
        title.add("租费收缴率");
        title.add("连锁跟进度");
        title.add("客服投诉率");
        title.add("企划配合度");
        data.setTitles(title);
        List<List<Object>> rows = new ArrayList();
        standardExportMapper.getFittedExportList2(standardExportDTO).forEach(p->{
            List<Object> row = new ArrayList();
            row.add(p.getId());
            row.add(p.getProjectName());
            row.add(p.getBusinessName());
            row.add(p.getRoomName());
            row.add(p.getBrandName());
            row.add(p.getBusinessName());
            row.add(p.getSate());
            rows.add(row);
        });
        data.setRows(rows);
        list.add(data);

        ExcelZjj excelZjj = new ExcelZjj();
        excelZjj.exportExcel(response,"动态三角形适配值.xlsx",list);
    }

    /**
     * 动态三角形_溢租率
     * @param response
     * @param standardExportDTO
     * @throws Exception
     */
    @Override
    public void getFittedExportList2(HttpServletResponse response, StandardExportDTO standardExportDTO) throws Exception {

        List<ExcelData> list = new ArrayList<>();
        ExcelData data = new ExcelData();
        data.setName("租金");
        List<String> title = new ArrayList();
        title.add("签约id");
        title.add("项目名称");
        title.add("楼层名称");
        title.add("铺位名称");
        title.add("品牌名称");
        title.add("业态名称");
        title.add("签约状态");
        for(int i =1;i<13;i++){
            title.add(i+"月");
        }

        data.setTitles(title);
        List<List<Object>> rows = new ArrayList();
        standardExportMapper.getFittedExportList2(standardExportDTO).forEach(p->{
            List<Object> row = new ArrayList();
            row.add(p.getId());
            row.add(p.getProjectName());
            row.add(p.getBusinessName());
            row.add(p.getRoomName());
            row.add(p.getBrandName());
            row.add(p.getBusinessName());
            row.add(p.getSate());
            rows.add(row);
        });
        data.setRows(rows);
        list.add(data);


        ExcelData data1 = new ExcelData();
        data1.setName("物业费");
        data1.setTitles(title);
        data1.setRows(rows);
        list.add(data1);


        ExcelData data2 = new ExcelData();
        data2.setName("装修折旧");
        data2.setTitles(title);
        data2.setRows(rows);
        list.add(data2);


        ExcelData data3 = new ExcelData();
        data3.setName("代理费");
        data3.setTitles(title);
        data3.setRows(rows);
        list.add(data3);

        ExcelData data4 = new ExcelData();
        data4.setName("人工成本");
        data4.setTitles(title);
        data4.setRows(rows);
        list.add(data4);

        ExcelZjj excelZjj = new ExcelZjj();
        excelZjj.exportExcel(response,"动态三角形溢租率.xlsx",list);
    }

    /**
     * 区间设置_客销度
     * @param response
     * @param standardExportDTO
     * @throws Exception
     */
    @Override
    public void getFittedExportList3(HttpServletResponse response, StandardExportDTO standardExportDTO) throws Exception {
        List<ExcelData> list = new ArrayList<>();
        ExcelData data = new ExcelData();
        data.setName("区间项目客销度");
        List<String> title = new ArrayList();
        title.add("签约id");
        title.add("项目名称");
        title.add("最大区间值");
        title.add("区间增长百分比");
        data.setTitles(title);
        List<List<Object>> rows = new ArrayList();
        standardExportMapper.getFittedExportList(standardExportDTO).forEach(p->{
            List<Object> row = new ArrayList();
            row.add(p.getId());
            row.add(p.getProjectName());
            rows.add(row);
        });
        data.setRows(rows);
        list.add(data);

        ExcelData data1 = new ExcelData();
        data1.setName("区间楼层客销度");
        List<String> title1 = new ArrayList();
        title1.add("关联id");
        title1.add("项目名称");
        title1.add("楼层名称");
        title1.add("最大区间值");
        title1.add("区间增长百分比");
        data1.setTitles(title1);
        List<List<Object>> rows1 = new ArrayList();
        standardExportMapper.getStandardExportList2(standardExportDTO).forEach(p->{
            List<Object> row = new ArrayList();
            row.add(p.getId());
            row.add(p.getProjectName());
            row.add(p.getFloorName());
            rows1.add(row);
        });
        data1.setRows(rows1);
        list.add(data1);

        ExcelData data2 = new ExcelData();
        data2.setName("区间业态客销度");
        List<String> title2 = new ArrayList();
        title2.add("关联id");
        title2.add("项目名称");
        title2.add("业态名称");
        title2.add("业种名称");
        title2.add("最大区间值");
        title2.add("区间增长百分比");
        data2.setTitles(title2);
        List<List<Object>> rows2 = new ArrayList();
        standardExportMapper.getStandardExportList3(standardExportDTO).forEach(p->{
            List<Object> row = new ArrayList();
            row.add(p.getId());
            row.add(p.getProjectName());
            row.add(p.getBusinessName());
            row.add(p.getSpeciesName());
            rows2.add(row);
        });
        data2.setRows(rows2);
        list.add(data2);

        ExcelZjj excelZjj = new ExcelZjj();
        excelZjj.exportExcel(response,"区间业态客销度.xlsx",list);
    }

}
