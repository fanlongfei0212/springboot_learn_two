package com.yinghuaicc.stars.controller.business.pc.triangle;

import com.yinghuaicc.stars.common.utils.date.LocalDateTimeUtils;
import com.yinghuaicc.stars.common.utils.excel.ExcelImportUtil;
import com.yinghuaicc.stars.common.utils.mapper.MapperFactoryUtil;
import com.yinghuaicc.stars.common.utils.uuid.UuidUtil;
import com.yinghuaicc.stars.config.response.JsonResult;
import com.yinghuaicc.stars.repository.model.triangle.*;
import com.yinghuaicc.stars.repository.model.triangle.mult.*;
import com.yinghuaicc.stars.service.cqrs.triangle.*;
import com.yinghuaicc.stars.service.cqrs.triangle.dto.response.GuestImportExcelResponseDTO;
import com.yinghuaicc.stars.service.cqrs.triangle.dto.response.QuarterFittedResponseDTO;
import com.yinghuaicc.stars.service.cqrs.triangle.dto.response.RentImportExcelResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 *动态三角形数据导入
 */
@RestController
@RequestMapping(value = "/importexcel")
public class ImportExcelController {

    @Autowired
    private ExcelImportUtil excelImportUtil;

    @Autowired
    private FittedVerssionService fittedVerssionService;

    @Autowired
    private QuarterFittedService quarterFittedService;

    @Autowired
    private MoonRentService moonRentService;

    @Autowired
    private DayRentService dayRentService;

    @Autowired
    private RentVerssionService rentVerssionService;

    @Autowired
    private GuestVerssionService guestVerssionService;

    @Autowired
    private ProjectGuestService projectGuestService;

    @Autowired
    private FloorGuestService floorGuestService;

    @Autowired
    private DayGuestService dayGuestService;

    /**
     *@Description: 动态三角形适配值导入
     */
    @PostMapping(value = "/excel/fittedimport/sheet")
    public JsonResult fittedExcelImportSheet(@RequestParam("file")MultipartFile file) {

        List<ConditionFittedExcel> conditionFittedExcels = excelImportUtil.getExcelDataToList(file,ConditionFittedExcel.class);

        //指标总数
        Integer sumTarget = 0;
        //已录入指标个数
        Integer targetcount = 0;
        //未录入指标个数
        Integer untargetcount = 0;

        FittedVerssion fittedVerssion = new FittedVerssion();
        fittedVerssion.setId(UuidUtil.randomUUID());//版本id
        fittedVerssion.setFittedVerssionName(LocalDateTime.now() +"适配值");

        try{
            for(ConditionFittedExcel conditionFittedExcel :conditionFittedExcels){
                sumTarget+=1;
                QuarterFittedResponseDTO quarterFittedResponseDTO = quarterFittedService.findQuarterFittedResponseDTOByContractId(conditionFittedExcel.getConstractId(),LocalDateTime.now());
                if(quarterFittedResponseDTO!=null){
                    quarterFittedService.saveQuarterFitted(MapperFactoryUtil.mapperObject(conditionFittedExcel,QuarterFitted.class));
                }else{
                    quarterFittedService.editQuarterFitted(MapperFactoryUtil.mapperObject(conditionFittedExcel,QuarterFitted.class));
                }
                targetcount+=1;
            }
        }catch (Exception e){
            untargetcount+=1;
        }
            //TODO---新增适配值记录  yhcc_quarter_fitted

        fittedVerssion.setSumTarget(sumTarget);
        fittedVerssion.setTargetcount(targetcount);
        fittedVerssion.setUntargetcount(untargetcount);
        fittedVerssion.setCreateTime(LocalDateTime.now());
        //TODO---新增适配值版本记录
        fittedVerssionService.saveFittedVerssion(fittedVerssion);

        return JsonResult.success(conditionFittedExcels);
    }

    /**
     *@Description: 动态三角形溢租率多Sheet导入
     */
    @PostMapping(value = "/excel/rentimport/sheet")
    public JsonResult rentExcelImportSheet(@RequestParam("file")MultipartFile file) {

        RentImportExcelResponseDTO rentImportExcelResponseDTO = excelImportUtil.getExcelDataToListMultiSheet(file, RentImportExcelResponseDTO.class);

        //分别按月保存
        //租金
        List<RentalRentExcel> rentalRentExcels = rentImportExcelResponseDTO.getRentalRentExcels();
        //物业费
        List<PropertyRentExcel> propertyRentExcels = rentImportExcelResponseDTO.getPropertyRentExcels();
        //装修折旧
        List<DecorateRentExcel> decorateRentExcels = rentImportExcelResponseDTO.getDecorateRentExcels();
        //代理
        List<LabourRentExcel> labourRentExcels = rentImportExcelResponseDTO.getLabourRentExcels();
        //人工
        List<AgentRentExcel> agentRentExcels = rentImportExcelResponseDTO.getAgentRentExcels();

        //获取条数
        Integer sizes = rentalRentExcels.size();

        //导入版本id
        String rentVerssionId = UuidUtil.randomUUID();

            for(int j = 0;j<sizes;j++){
                for(int i=0 ;i<12;i++){
                MoonRent moonRent = new MoonRent();
                String moonRentId = UuidUtil.randomUUID();
                moonRent.setId(moonRentId);
                //签约id
                String signId = "";
                switch (i){
                    case 0:{
                        //签约id
                        signId = rentalRentExcels.get(j).getSignId();
                        moonRent.setContractId(signId);
                        //版本id
                        moonRent.setRentVerssionId(rentVerssionId);
                        //租金
                        moonRent.setRent(rentalRentExcels.get(j).getJan());
                        //物业费
                        moonRent.setPropertyFee(propertyRentExcels.get(j).getJan());
                        //员工成本
                        moonRent.setStaffEmp(agentRentExcels.get(j).getJan());
                        //装修折旧
                        moonRent.setFitment(decorateRentExcels.get(j).getJan());
                        //代理费
                        moonRent.setAgencyFee(labourRentExcels.get(j).getJan());
                        LocalDateTime nowTime = LocalDateTime.now();
                        moonRent.setCreateTime(nowTime);
                        //溢租率年月
                        LocalDateTime localDateTime2 = LocalDateTime.of(LocalDateTime.now().getYear(),1,1,0,0 );
                        moonRent.setYearsmoon(localDateTime2);

                        //TODO----保存-----
                        moonRentService.saveMoonRent(moonRent);
                        //TODO----再按天保存

                        Calendar cal = Calendar.getInstance();
                        cal.setTime(new Date(1));//month 为指定月份任意日期
                        int dayNumOfMonth = LocalDateTimeUtils.getDaysByYearMonth(LocalDateTime.now().getYear(), 1);
                        cal.set(Calendar.DAY_OF_MONTH, 1);// 从一号开始
                        //每个月按30天计算
                        BigDecimal day_rentalRent = rentalRentExcels.get(j).getTwe().divide(new BigDecimal(30));
                        BigDecimal day_propertyRent = propertyRentExcels.get(j).getTwe().divide(new BigDecimal(30));
                        BigDecimal day_agentRent = agentRentExcels.get(j).getTwe().divide(new BigDecimal(30));
                        BigDecimal day_decorateRent = decorateRentExcels.get(j).getTwe().divide(new BigDecimal(30));
                        BigDecimal day_labourRent = labourRentExcels.get(j).getTwe().divide(new BigDecimal(30));

                        for (int t = 0; t < dayNumOfMonth; t++, cal.add(Calendar.DATE, 1)) {
                            Date d = cal.getTime();
                            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
                            String df = simpleDateFormat.format(d);
                            DayRent dayRent = new DayRent();
                            dayRent.setId(UuidUtil.randomUUID());

                            //签约id
                            dayRent.setContractId(signId);

                            // 月溢租率id
                            dayRent.setMoonRentid(moonRentId);
                            //租金
                            dayRent.setRent(day_rentalRent);
                            //物业费
                            dayRent.setPropertyFee(day_propertyRent);
                            //员工成本
                            dayRent.setStaffEmp(day_agentRent);
                            //装修折旧
                            dayRent.setFitment(day_decorateRent);
                            //代理费
                            dayRent.setAgencyFee(day_labourRent);
                            //净利润
                            // BigDecimal profit;
                            //dayRent.setProfit();
                            //状态 1：未审核，2：审核成功，3：审核失败
                            dayRent.setStatus(rentalRentExcels.get(j).getSignState());
                            LocalDateTime createTime = LocalDateTime.parse(df);
                            dayRent.setCreateTime(createTime);
                            dayRent.setModifyTime(createTime);
                            // String createUser;
                            //String modifyUser;
                            dayRentService.saveDayRent(dayRent);
                        }


                    };
                    case 1:{
                        //签约id
                        signId = rentalRentExcels.get(j).getSignId();
                        moonRent.setContractId(signId);
                        //版本id
                        moonRent.setRentVerssionId(rentVerssionId);
                        //租金
                        moonRent.setRent(rentalRentExcels.get(j).getFeb());
                        //物业费
                        moonRent.setPropertyFee(propertyRentExcels.get(j).getFeb());
                        //员工成本
                        moonRent.setStaffEmp(agentRentExcels.get(j).getFeb());
                        //装修折旧
                        moonRent.setFitment(decorateRentExcels.get(j).getFeb());
                        //代理费
                        moonRent.setAgencyFee(labourRentExcels.get(j).getFeb());
                        LocalDateTime nowTime = LocalDateTime.now();
                        moonRent.setCreateTime(nowTime);
                        //溢租率年月
                        LocalDateTime localDateTime2 = LocalDateTime.of(LocalDateTime.now().getYear(),2,1,0,0 );
                        moonRent.setYearsmoon(localDateTime2);

                        //TODO----保存-----
                        moonRentService.saveMoonRent(moonRent);
                        //TODO----再按天保存

                        Calendar cal = Calendar.getInstance();
                        cal.setTime(new Date(2));//month 为指定月份任意日期
                        int dayNumOfMonth = LocalDateTimeUtils.getDaysByYearMonth(LocalDateTime.now().getYear(), 2);
                        cal.set(Calendar.DAY_OF_MONTH, 1);// 从一号开始
                        //每个月按30天计算
                        BigDecimal day_rentalRent = rentalRentExcels.get(j).getTwe().divide(new BigDecimal(30));
                        BigDecimal day_propertyRent = propertyRentExcels.get(j).getTwe().divide(new BigDecimal(30));
                        BigDecimal day_agentRent = agentRentExcels.get(j).getTwe().divide(new BigDecimal(30));
                        BigDecimal day_decorateRent = decorateRentExcels.get(j).getTwe().divide(new BigDecimal(30));
                        BigDecimal day_labourRent = labourRentExcels.get(j).getTwe().divide(new BigDecimal(30));

                        for (int t = 0; t < dayNumOfMonth; t++, cal.add(Calendar.DATE, 2)) {
                            Date d = cal.getTime();
                            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
                            String df = simpleDateFormat.format(d);
                            DayRent dayRent = new DayRent();
                            dayRent.setId(UuidUtil.randomUUID());

                            //签约id
                            dayRent.setContractId(signId);

                            // 月溢租率id
                            dayRent.setMoonRentid(moonRentId);
                            //租金
                            dayRent.setRent(day_rentalRent);
                            //物业费
                            dayRent.setPropertyFee(day_propertyRent);
                            //员工成本
                            dayRent.setStaffEmp(day_agentRent);
                            //装修折旧
                            dayRent.setFitment(day_decorateRent);
                            //代理费
                            dayRent.setAgencyFee(day_labourRent);
                            //净利润
                            // BigDecimal profit;
                            //dayRent.setProfit();
                            //状态 1：未审核，2：审核成功，3：审核失败
                            dayRent.setStatus(rentalRentExcels.get(j).getSignState());
                            LocalDateTime createTime = LocalDateTime.parse(df);
                            dayRent.setCreateTime(createTime);
                            dayRent.setModifyTime(createTime);
                            // String createUser;
                            //String modifyUser;
                            dayRentService.saveDayRent(dayRent);
                        }

                    };
                    case 2:{
                        //签约id
                        signId = rentalRentExcels.get(j).getSignId();
                        moonRent.setContractId(signId);
                        //版本id
                        moonRent.setRentVerssionId(rentVerssionId);
                        //租金
                        moonRent.setRent(rentalRentExcels.get(j).getMar());
                        //物业费
                        moonRent.setPropertyFee(propertyRentExcels.get(j).getMar());
                        //员工成本
                        moonRent.setStaffEmp(agentRentExcels.get(j).getMar());
                        //装修折旧
                        moonRent.setFitment(decorateRentExcels.get(j).getMar());
                        //代理费
                        moonRent.setAgencyFee(labourRentExcels.get(j).getMar());
                        LocalDateTime nowTime = LocalDateTime.now();
                        moonRent.setCreateTime(nowTime);
                        //溢租率年月
                        LocalDateTime localDateTime2 = LocalDateTime.of(LocalDateTime.now().getYear(),3,1,0,0 );
                        moonRent.setYearsmoon(localDateTime2);

                        //TODO----保存-----
                        moonRentService.saveMoonRent(moonRent);
                        //TODO----再按天保存

                        Calendar cal = Calendar.getInstance();
                        cal.setTime(new Date(3));//month 为指定月份任意日期
                        int dayNumOfMonth = LocalDateTimeUtils.getDaysByYearMonth(LocalDateTime.now().getYear(), 3);
                        cal.set(Calendar.DAY_OF_MONTH, 1);// 从一号开始
                        //每个月按30天计算
                        BigDecimal day_rentalRent = rentalRentExcels.get(j).getTwe().divide(new BigDecimal(30));
                        BigDecimal day_propertyRent = propertyRentExcels.get(j).getTwe().divide(new BigDecimal(30));
                        BigDecimal day_agentRent = agentRentExcels.get(j).getTwe().divide(new BigDecimal(30));
                        BigDecimal day_decorateRent = decorateRentExcels.get(j).getTwe().divide(new BigDecimal(30));
                        BigDecimal day_labourRent = labourRentExcels.get(j).getTwe().divide(new BigDecimal(30));

                        for (int t = 0; t < dayNumOfMonth; t++, cal.add(Calendar.DATE, 3)) {
                            Date d = cal.getTime();
                            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
                            String df = simpleDateFormat.format(d);
                            DayRent dayRent = new DayRent();
                            dayRent.setId(UuidUtil.randomUUID());

                            //签约id
                            dayRent.setContractId(signId);

                            // 月溢租率id
                            dayRent.setMoonRentid(moonRentId);
                            //租金
                            dayRent.setRent(day_rentalRent);
                            //物业费
                            dayRent.setPropertyFee(day_propertyRent);
                            //员工成本
                            dayRent.setStaffEmp(day_agentRent);
                            //装修折旧
                            dayRent.setFitment(day_decorateRent);
                            //代理费
                            dayRent.setAgencyFee(day_labourRent);
                            //净利润
                            // BigDecimal profit;
                            //dayRent.setProfit();
                            //状态 1：未审核，2：审核成功，3：审核失败
                            dayRent.setStatus(rentalRentExcels.get(j).getSignState());
                            LocalDateTime createTime = LocalDateTime.parse(df);
                            dayRent.setCreateTime(createTime);
                            dayRent.setModifyTime(createTime);
                            // String createUser;
                            //String modifyUser;
                            dayRentService.saveDayRent(dayRent);
                        }


                    };
                    case 3:{
                        //签约id
                        signId = rentalRentExcels.get(j).getSignId();
                        moonRent.setContractId(signId);
                        //版本id
                        moonRent.setRentVerssionId(rentVerssionId);
                        //租金
                        moonRent.setRent(rentalRentExcels.get(j).getApril());
                        //物业费
                        moonRent.setPropertyFee(propertyRentExcels.get(j).getApril());
                        //员工成本
                        moonRent.setStaffEmp(agentRentExcels.get(j).getApril());
                        //装修折旧
                        moonRent.setFitment(decorateRentExcels.get(j).getApril());
                        //代理费
                        moonRent.setAgencyFee(labourRentExcels.get(j).getApril());
                        LocalDateTime nowTime = LocalDateTime.now();
                        moonRent.setCreateTime(nowTime);
                        //溢租率年月
                        LocalDateTime localDateTime2 = LocalDateTime.of(LocalDateTime.now().getYear(),4,1,0,0 );
                        moonRent.setYearsmoon(localDateTime2);

                        //TODO----保存-----
                        moonRentService.saveMoonRent(moonRent);
                        //TODO----再按天保存

                        Calendar cal = Calendar.getInstance();
                        cal.setTime(new Date(4));//month 为指定月份任意日期
                        int dayNumOfMonth = LocalDateTimeUtils.getDaysByYearMonth(LocalDateTime.now().getYear(), 4);
                        cal.set(Calendar.DAY_OF_MONTH, 1);// 从一号开始
                        //每个月按30天计算
                        BigDecimal day_rentalRent = rentalRentExcels.get(j).getTwe().divide(new BigDecimal(30));
                        BigDecimal day_propertyRent = propertyRentExcels.get(j).getTwe().divide(new BigDecimal(30));
                        BigDecimal day_agentRent = agentRentExcels.get(j).getTwe().divide(new BigDecimal(30));
                        BigDecimal day_decorateRent = decorateRentExcels.get(j).getTwe().divide(new BigDecimal(30));
                        BigDecimal day_labourRent = labourRentExcels.get(j).getTwe().divide(new BigDecimal(30));

                        for (int t = 0; t < dayNumOfMonth; t++, cal.add(Calendar.DATE, 4)) {
                            Date d = cal.getTime();
                            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
                            String df = simpleDateFormat.format(d);
                            DayRent dayRent = new DayRent();
                            dayRent.setId(UuidUtil.randomUUID());

                            //签约id
                            dayRent.setContractId(signId);

                            // 月溢租率id
                            dayRent.setMoonRentid(moonRentId);
                            //租金
                            dayRent.setRent(day_rentalRent);
                            //物业费
                            dayRent.setPropertyFee(day_propertyRent);
                            //员工成本
                            dayRent.setStaffEmp(day_agentRent);
                            //装修折旧
                            dayRent.setFitment(day_decorateRent);
                            //代理费
                            dayRent.setAgencyFee(day_labourRent);
                            //净利润
                            // BigDecimal profit;
                            //dayRent.setProfit();
                            //状态 1：未审核，2：审核成功，3：审核失败
                            dayRent.setStatus(rentalRentExcels.get(j).getSignState());
                            LocalDateTime createTime = LocalDateTime.parse(df);
                            dayRent.setCreateTime(createTime);
                            dayRent.setModifyTime(createTime);
                            // String createUser;
                            //String modifyUser;
                            dayRentService.saveDayRent(dayRent);
                        }

                    };
                    case 4:{
                        //签约id
                        signId = rentalRentExcels.get(j).getSignId();
                        moonRent.setContractId(signId);
                        //版本id
                        moonRent.setRentVerssionId(rentVerssionId);
                        //租金
                        moonRent.setRent(rentalRentExcels.get(j).getMay());
                        //物业费
                        moonRent.setPropertyFee(propertyRentExcels.get(j).getMay());
                        //员工成本
                        moonRent.setStaffEmp(agentRentExcels.get(j).getMay());
                        //装修折旧
                        moonRent.setFitment(decorateRentExcels.get(j).getMay());
                        //代理费
                        moonRent.setAgencyFee(labourRentExcels.get(j).getMay());
                        LocalDateTime nowTime = LocalDateTime.now();
                        moonRent.setCreateTime(nowTime);
                        //溢租率年月
                        LocalDateTime localDateTime2 = LocalDateTime.of(LocalDateTime.now().getYear(),5,1,0,0 );
                        moonRent.setYearsmoon(localDateTime2);

                        //TODO----保存-----
                        moonRentService.saveMoonRent(moonRent);
                        //TODO----再按天保存

                        Calendar cal = Calendar.getInstance();
                        cal.setTime(new Date(5));//month 为指定月份任意日期
                        int dayNumOfMonth = LocalDateTimeUtils.getDaysByYearMonth(LocalDateTime.now().getYear(), 5);
                        cal.set(Calendar.DAY_OF_MONTH, 1);// 从一号开始
                        //每个月按30天计算
                        BigDecimal day_rentalRent = rentalRentExcels.get(j).getTwe().divide(new BigDecimal(30));
                        BigDecimal day_propertyRent = propertyRentExcels.get(j).getTwe().divide(new BigDecimal(30));
                        BigDecimal day_agentRent = agentRentExcels.get(j).getTwe().divide(new BigDecimal(30));
                        BigDecimal day_decorateRent = decorateRentExcels.get(j).getTwe().divide(new BigDecimal(30));
                        BigDecimal day_labourRent = labourRentExcels.get(j).getTwe().divide(new BigDecimal(30));

                        for (int t = 0; t < dayNumOfMonth; t++, cal.add(Calendar.DATE, 5)) {
                            Date d = cal.getTime();
                            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
                            String df = simpleDateFormat.format(d);
                            DayRent dayRent = new DayRent();
                            dayRent.setId(UuidUtil.randomUUID());

                            //签约id
                            dayRent.setContractId(signId);

                            // 月溢租率id
                            dayRent.setMoonRentid(moonRentId);
                            //租金
                            dayRent.setRent(day_rentalRent);
                            //物业费
                            dayRent.setPropertyFee(day_propertyRent);
                            //员工成本
                            dayRent.setStaffEmp(day_agentRent);
                            //装修折旧
                            dayRent.setFitment(day_decorateRent);
                            //代理费
                            dayRent.setAgencyFee(day_labourRent);
                            //净利润
                            // BigDecimal profit;
                            //dayRent.setProfit();
                            //状态 1：未审核，2：审核成功，3：审核失败
                            dayRent.setStatus(rentalRentExcels.get(j).getSignState());
                            LocalDateTime createTime = LocalDateTime.parse(df);
                            dayRent.setCreateTime(createTime);
                            dayRent.setModifyTime(createTime);
                            // String createUser;
                            //String modifyUser;
                            dayRentService.saveDayRent(dayRent);
                        }

                    };
                    case 5:{
                        //签约id
                        signId = rentalRentExcels.get(j).getSignId();
                        moonRent.setContractId(signId);
                        //版本id
                        moonRent.setRentVerssionId(rentVerssionId);
                        //租金
                        moonRent.setRent(rentalRentExcels.get(j).getJune());
                        //物业费
                        moonRent.setPropertyFee(propertyRentExcels.get(j).getJune());
                        //员工成本
                        moonRent.setStaffEmp(agentRentExcels.get(j).getJune());
                        //装修折旧
                        moonRent.setFitment(decorateRentExcels.get(j).getJune());
                        //代理费
                        moonRent.setAgencyFee(labourRentExcels.get(j).getJune());
                        LocalDateTime nowTime = LocalDateTime.now();
                        moonRent.setCreateTime(nowTime);
                        //溢租率年月
                        LocalDateTime localDateTime2 = LocalDateTime.of(LocalDateTime.now().getYear(),6,1,0,0 );
                        moonRent.setYearsmoon(localDateTime2);

                        //TODO----保存-----
                        moonRentService.saveMoonRent(moonRent);
                        //TODO----再按天保存

                        Calendar cal = Calendar.getInstance();
                        cal.setTime(new Date(6));//month 为指定月份任意日期
                        int dayNumOfMonth = LocalDateTimeUtils.getDaysByYearMonth(LocalDateTime.now().getYear(), 6);
                        cal.set(Calendar.DAY_OF_MONTH, 1);// 从一号开始
                        //每个月按30天计算
                        BigDecimal day_rentalRent = rentalRentExcels.get(j).getTwe().divide(new BigDecimal(30));
                        BigDecimal day_propertyRent = propertyRentExcels.get(j).getTwe().divide(new BigDecimal(30));
                        BigDecimal day_agentRent = agentRentExcels.get(j).getTwe().divide(new BigDecimal(30));
                        BigDecimal day_decorateRent = decorateRentExcels.get(j).getTwe().divide(new BigDecimal(30));
                        BigDecimal day_labourRent = labourRentExcels.get(j).getTwe().divide(new BigDecimal(30));

                        for (int t = 0; t < dayNumOfMonth; t++, cal.add(Calendar.DATE, 6)){
                            Date d = cal.getTime();
                            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
                            String df = simpleDateFormat.format(d);
                            DayRent dayRent = new DayRent();
                            dayRent.setId(UuidUtil.randomUUID());

                            //签约id
                            dayRent.setContractId(signId);

                            // 月溢租率id
                            dayRent.setMoonRentid(moonRentId);
                            //租金
                            dayRent.setRent(day_rentalRent);
                            //物业费
                            dayRent.setPropertyFee(day_propertyRent);
                            //员工成本
                            dayRent.setStaffEmp(day_agentRent);
                            //装修折旧
                            dayRent.setFitment(day_decorateRent);
                            //代理费
                            dayRent.setAgencyFee(day_labourRent);
                            //净利润
                            // BigDecimal profit;
                            //dayRent.setProfit();
                            //状态 1：未审核，2：审核成功，3：审核失败
                            dayRent.setStatus(rentalRentExcels.get(j).getSignState());
                            LocalDateTime createTime = LocalDateTime.parse(df);
                            dayRent.setCreateTime(createTime);
                            dayRent.setModifyTime(createTime);
                            // String createUser;
                            //String modifyUser;
                            dayRentService.saveDayRent(dayRent);
                        }

                    };
                    case 6:{
                        //签约id
                        signId = rentalRentExcels.get(j).getSignId();
                        moonRent.setContractId(signId);
                        //版本id
                        moonRent.setRentVerssionId(rentVerssionId);
                        //租金
                        moonRent.setRent(rentalRentExcels.get(j).getJuly());
                        //物业费
                        moonRent.setPropertyFee(propertyRentExcels.get(j).getJuly());
                        //员工成本
                        moonRent.setStaffEmp(agentRentExcels.get(j).getJuly());
                        //装修折旧
                        moonRent.setFitment(decorateRentExcels.get(j).getJuly());
                        //代理费
                        moonRent.setAgencyFee(labourRentExcels.get(j).getJuly());
                        LocalDateTime nowTime = LocalDateTime.now();
                        moonRent.setCreateTime(nowTime);
                        //溢租率年月
                        LocalDateTime localDateTime2 = LocalDateTime.of(LocalDateTime.now().getYear(),7,1,0,0 );
                        moonRent.setYearsmoon(localDateTime2);

                        //TODO----保存-----
                        moonRentService.saveMoonRent(moonRent);
                        //TODO----再按天保存

                        Calendar cal = Calendar.getInstance();
                        cal.setTime(new Date(7));//month 为指定月份任意日期
                        int dayNumOfMonth = LocalDateTimeUtils.getDaysByYearMonth(LocalDateTime.now().getYear(), 7);
                        cal.set(Calendar.DAY_OF_MONTH, 1);// 从一号开始
                        //每个月按30天计算
                        BigDecimal day_rentalRent = rentalRentExcels.get(j).getTwe().divide(new BigDecimal(30));
                        BigDecimal day_propertyRent = propertyRentExcels.get(j).getTwe().divide(new BigDecimal(30));
                        BigDecimal day_agentRent = agentRentExcels.get(j).getTwe().divide(new BigDecimal(30));
                        BigDecimal day_decorateRent = decorateRentExcels.get(j).getTwe().divide(new BigDecimal(30));
                        BigDecimal day_labourRent = labourRentExcels.get(j).getTwe().divide(new BigDecimal(30));

                        for (int t = 0; t < dayNumOfMonth; t++, cal.add(Calendar.DATE, 7)) {
                            Date d = cal.getTime();
                            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
                            String df = simpleDateFormat.format(d);
                            DayRent dayRent = new DayRent();
                            dayRent.setId(UuidUtil.randomUUID());

                            //签约id
                            dayRent.setContractId(signId);

                            // 月溢租率id
                            dayRent.setMoonRentid(moonRentId);
                            //租金
                            dayRent.setRent(day_rentalRent);
                            //物业费
                            dayRent.setPropertyFee(day_propertyRent);
                            //员工成本
                            dayRent.setStaffEmp(day_agentRent);
                            //装修折旧
                            dayRent.setFitment(day_decorateRent);
                            //代理费
                            dayRent.setAgencyFee(day_labourRent);
                            //净利润
                            // BigDecimal profit;
                            //dayRent.setProfit();
                            //状态 1：未审核，2：审核成功，3：审核失败
                            dayRent.setStatus(rentalRentExcels.get(j).getSignState());
                            LocalDateTime createTime = LocalDateTime.parse(df);
                            dayRent.setCreateTime(createTime);
                            dayRent.setModifyTime(createTime);
                            // String createUser;
                            //String modifyUser;
                            dayRentService.saveDayRent(dayRent);
                        }

                    };
                    case 7:{
                        //签约id
                        signId = rentalRentExcels.get(j).getSignId();
                        moonRent.setContractId(signId);
                        //版本id
                        moonRent.setRentVerssionId(rentVerssionId);
                        //租金
                        moonRent.setRent(rentalRentExcels.get(j).getAug());
                        //物业费
                        moonRent.setPropertyFee(propertyRentExcels.get(j).getAug());
                        //员工成本
                        moonRent.setStaffEmp(agentRentExcels.get(j).getAug());
                        //装修折旧
                        moonRent.setFitment(decorateRentExcels.get(j).getAug());
                        //代理费
                        moonRent.setAgencyFee(labourRentExcels.get(j).getAug());
                        LocalDateTime nowTime = LocalDateTime.now();
                        moonRent.setCreateTime(nowTime);
                        //溢租率年月
                        LocalDateTime localDateTime2 = LocalDateTime.of(LocalDateTime.now().getYear(),8,1,0,0 );
                        moonRent.setYearsmoon(localDateTime2);

                        //TODO----保存-----
                        moonRentService.saveMoonRent(moonRent);
                        //TODO----再按天保存

                        Calendar cal = Calendar.getInstance();
                        cal.setTime(new Date(8));//month 为指定月份任意日期
                        int dayNumOfMonth = LocalDateTimeUtils.getDaysByYearMonth(LocalDateTime.now().getYear(), 8);
                        cal.set(Calendar.DAY_OF_MONTH, 1);// 从一号开始
                        //每个月按30天计算
                        BigDecimal day_rentalRent = rentalRentExcels.get(j).getTwe().divide(new BigDecimal(30));
                        BigDecimal day_propertyRent = propertyRentExcels.get(j).getTwe().divide(new BigDecimal(30));
                        BigDecimal day_agentRent = agentRentExcels.get(j).getTwe().divide(new BigDecimal(30));
                        BigDecimal day_decorateRent = decorateRentExcels.get(j).getTwe().divide(new BigDecimal(30));
                        BigDecimal day_labourRent = labourRentExcels.get(j).getTwe().divide(new BigDecimal(30));

                        for (int t = 0; t < dayNumOfMonth; t++, cal.add(Calendar.DATE, 8)) {
                            Date d = cal.getTime();
                            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
                            String df = simpleDateFormat.format(d);
                            DayRent dayRent = new DayRent();
                            dayRent.setId(UuidUtil.randomUUID());

                            //签约id
                            dayRent.setContractId(signId);

                            // 月溢租率id
                            dayRent.setMoonRentid(moonRentId);
                            //租金
                            dayRent.setRent(day_rentalRent);
                            //物业费
                            dayRent.setPropertyFee(day_propertyRent);
                            //员工成本
                            dayRent.setStaffEmp(day_agentRent);
                            //装修折旧
                            dayRent.setFitment(day_decorateRent);
                            //代理费
                            dayRent.setAgencyFee(day_labourRent);
                            //净利润
                            // BigDecimal profit;
                            //dayRent.setProfit();
                            //状态 1：未审核，2：审核成功，3：审核失败
                            dayRent.setStatus(rentalRentExcels.get(j).getSignState());
                            LocalDateTime createTime = LocalDateTime.parse(df);
                            dayRent.setCreateTime(createTime);
                            dayRent.setModifyTime(createTime);
                            // String createUser;
                            //String modifyUser;
                            dayRentService.saveDayRent(dayRent);
                        }

                    };
                    case 8:{
                        //签约id
                        signId = rentalRentExcels.get(j).getSignId();
                        moonRent.setContractId(signId);
                        //版本id
                        moonRent.setRentVerssionId(rentVerssionId);
                        //租金
                        moonRent.setRent(rentalRentExcels.get(j).getSep());
                        //物业费
                        moonRent.setPropertyFee(propertyRentExcels.get(j).getSep());
                        //员工成本
                        moonRent.setStaffEmp(agentRentExcels.get(j).getSep());
                        //装修折旧
                        moonRent.setFitment(decorateRentExcels.get(j).getSep());
                        //代理费
                        moonRent.setAgencyFee(labourRentExcels.get(j).getSep());
                        LocalDateTime nowTime = LocalDateTime.now();
                        moonRent.setCreateTime(nowTime);
                        //溢租率年月
                        LocalDateTime localDateTime2 = LocalDateTime.of(LocalDateTime.now().getYear(),9,1,0,0 );
                        moonRent.setYearsmoon(localDateTime2);

                        //TODO----保存-----
                        moonRentService.saveMoonRent(moonRent);
                        //TODO----再按天保存

                        Calendar cal = Calendar.getInstance();
                        cal.setTime(new Date(9));//month 为指定月份任意日期
                        int dayNumOfMonth = LocalDateTimeUtils.getDaysByYearMonth(LocalDateTime.now().getYear(), 9);
                        cal.set(Calendar.DAY_OF_MONTH, 1);// 从一号开始
                        //每个月按30天计算
                        BigDecimal day_rentalRent = rentalRentExcels.get(j).getTwe().divide(new BigDecimal(30));
                        BigDecimal day_propertyRent = propertyRentExcels.get(j).getTwe().divide(new BigDecimal(30));
                        BigDecimal day_agentRent = agentRentExcels.get(j).getTwe().divide(new BigDecimal(30));
                        BigDecimal day_decorateRent = decorateRentExcels.get(j).getTwe().divide(new BigDecimal(30));
                        BigDecimal day_labourRent = labourRentExcels.get(j).getTwe().divide(new BigDecimal(30));

                        for (int t = 0; t < dayNumOfMonth; t++, cal.add(Calendar.DATE, 9)) {
                            Date d = cal.getTime();
                            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
                            String df = simpleDateFormat.format(d);
                            DayRent dayRent = new DayRent();
                            dayRent.setId(UuidUtil.randomUUID());

                            //签约id
                            dayRent.setContractId(signId);

                            // 月溢租率id
                            dayRent.setMoonRentid(moonRentId);
                            //租金
                            dayRent.setRent(day_rentalRent);
                            //物业费
                            dayRent.setPropertyFee(day_propertyRent);
                            //员工成本
                            dayRent.setStaffEmp(day_agentRent);
                            //装修折旧
                            dayRent.setFitment(day_decorateRent);
                            //代理费
                            dayRent.setAgencyFee(day_labourRent);
                            //净利润
                            // BigDecimal profit;
                            //dayRent.setProfit();
                            //状态 1：未审核，2：审核成功，3：审核失败
                            dayRent.setStatus(rentalRentExcels.get(j).getSignState());
                            LocalDateTime createTime = LocalDateTime.parse(df);
                            dayRent.setCreateTime(createTime);
                            dayRent.setModifyTime(createTime);
                            // String createUser;
                            //String modifyUser;
                            dayRentService.saveDayRent(dayRent);
                        }

                    };
                    case 9:{
                        //签约id
                        signId = rentalRentExcels.get(j).getSignId();
                        moonRent.setContractId(signId);
                        //版本id
                        moonRent.setRentVerssionId(rentVerssionId);
                        //租金
                        moonRent.setRent(rentalRentExcels.get(j).getOct());
                        //物业费
                        moonRent.setPropertyFee(propertyRentExcels.get(j).getOct());
                        //员工成本
                        moonRent.setStaffEmp(agentRentExcels.get(j).getOct());
                        //装修折旧
                        moonRent.setFitment(decorateRentExcels.get(j).getOct());
                        //代理费
                        moonRent.setAgencyFee(labourRentExcels.get(j).getOct());
                        LocalDateTime nowTime = LocalDateTime.now();
                        moonRent.setCreateTime(nowTime);
                        //溢租率年月
                        LocalDateTime localDateTime2 = LocalDateTime.of(LocalDateTime.now().getYear(),10,1,0,0 );
                        moonRent.setYearsmoon(localDateTime2);

                        //TODO----保存-----
                        moonRentService.saveMoonRent(moonRent);
                        //TODO----再按天保存

                        Calendar cal = Calendar.getInstance();
                        cal.setTime(new Date(10));//month 为指定月份任意日期
                        int dayNumOfMonth = LocalDateTimeUtils.getDaysByYearMonth(LocalDateTime.now().getYear(), 10);
                        cal.set(Calendar.DAY_OF_MONTH, 1);// 从一号开始
                        //每个月按30天计算
                        BigDecimal day_rentalRent = rentalRentExcels.get(j).getTwe().divide(new BigDecimal(30));
                        BigDecimal day_propertyRent = propertyRentExcels.get(j).getTwe().divide(new BigDecimal(30));
                        BigDecimal day_agentRent = agentRentExcels.get(j).getTwe().divide(new BigDecimal(30));
                        BigDecimal day_decorateRent = decorateRentExcels.get(j).getTwe().divide(new BigDecimal(30));
                        BigDecimal day_labourRent = labourRentExcels.get(j).getTwe().divide(new BigDecimal(30));

                        for (int t = 0; t < dayNumOfMonth; t++, cal.add(Calendar.DATE, 10)) {
                            Date d = cal.getTime();
                            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
                            String df = simpleDateFormat.format(d);
                            DayRent dayRent = new DayRent();
                            dayRent.setId(UuidUtil.randomUUID());

                            //签约id
                            dayRent.setContractId(signId);

                            // 月溢租率id
                            dayRent.setMoonRentid(moonRentId);
                            //租金
                            dayRent.setRent(day_rentalRent);
                            //物业费
                            dayRent.setPropertyFee(day_propertyRent);
                            //员工成本
                            dayRent.setStaffEmp(day_agentRent);
                            //装修折旧
                            dayRent.setFitment(day_decorateRent);
                            //代理费
                            dayRent.setAgencyFee(day_labourRent);
                            //净利润
                            // BigDecimal profit;
                            //dayRent.setProfit();
                            //状态 1：未审核，2：审核成功，3：审核失败
                            dayRent.setStatus(rentalRentExcels.get(j).getSignState());
                            LocalDateTime createTime = LocalDateTime.parse(df);
                            dayRent.setCreateTime(createTime);
                            dayRent.setModifyTime(createTime);
                            // String createUser;
                            //String modifyUser;
                            dayRentService.saveDayRent(dayRent);
                        }

                    };
                    case 10:{
                        //签约id
                        signId = rentalRentExcels.get(j).getSignId();
                        moonRent.setContractId(signId);
                        //版本id
                        moonRent.setRentVerssionId(rentVerssionId);
                        //租金
                        moonRent.setRent(rentalRentExcels.get(j).getNov());
                        //物业费
                        moonRent.setPropertyFee(propertyRentExcels.get(j).getNov());
                        //员工成本
                        moonRent.setStaffEmp(agentRentExcels.get(j).getNov());
                        //装修折旧
                        moonRent.setFitment(decorateRentExcels.get(j).getNov());
                        //代理费
                        moonRent.setAgencyFee(labourRentExcels.get(j).getNov());
                        LocalDateTime nowTime = LocalDateTime.now();
                        moonRent.setCreateTime(nowTime);
                        //溢租率年月
                        LocalDateTime localDateTime2 = LocalDateTime.of(LocalDateTime.now().getYear(),11,1,0,0 );
                        moonRent.setYearsmoon(localDateTime2);

                        //TODO----保存-----
                        moonRentService.saveMoonRent(moonRent);
                        //TODO----再按天保存

                        Calendar cal = Calendar.getInstance();
                        cal.setTime(new Date(11));//month 为指定月份任意日期
                        int dayNumOfMonth = LocalDateTimeUtils.getDaysByYearMonth(LocalDateTime.now().getYear(), 11);
                        cal.set(Calendar.DAY_OF_MONTH, 1);// 从一号开始
                        //每个月按30天计算
                        BigDecimal day_rentalRent = rentalRentExcels.get(j).getTwe().divide(new BigDecimal(30));
                        BigDecimal day_propertyRent = propertyRentExcels.get(j).getTwe().divide(new BigDecimal(30));
                        BigDecimal day_agentRent = agentRentExcels.get(j).getTwe().divide(new BigDecimal(30));
                        BigDecimal day_decorateRent = decorateRentExcels.get(j).getTwe().divide(new BigDecimal(30));
                        BigDecimal day_labourRent = labourRentExcels.get(j).getTwe().divide(new BigDecimal(30));

                        for (int t = 0; t < dayNumOfMonth; t++, cal.add(Calendar.DATE, 11)) {
                            Date d = cal.getTime();
                            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
                            String df = simpleDateFormat.format(d);
                            DayRent dayRent = new DayRent();
                            dayRent.setId(UuidUtil.randomUUID());

                            //签约id
                            dayRent.setContractId(signId);

                            // 月溢租率id
                            dayRent.setMoonRentid(moonRentId);
                            //租金
                            dayRent.setRent(day_rentalRent);
                            //物业费
                            dayRent.setPropertyFee(day_propertyRent);
                            //员工成本
                            dayRent.setStaffEmp(day_agentRent);
                            //装修折旧
                            dayRent.setFitment(day_decorateRent);
                            //代理费
                            dayRent.setAgencyFee(day_labourRent);
                            //净利润
                            // BigDecimal profit;
                            //dayRent.setProfit();
                            //状态 1：未审核，2：审核成功，3：审核失败
                            dayRent.setStatus(rentalRentExcels.get(j).getSignState());
                            LocalDateTime createTime = LocalDateTime.parse(df);
                            dayRent.setCreateTime(createTime);
                            dayRent.setModifyTime(createTime);
                            // String createUser;
                            //String modifyUser;
                            dayRentService.saveDayRent(dayRent);
                        }

                    };
                    case 11:{
                        //签约id
                        signId = rentalRentExcels.get(j).getSignId();
                        moonRent.setContractId(signId);
                        //版本id
                        moonRent.setRentVerssionId(rentVerssionId);
                        //租金
                        moonRent.setRent(rentalRentExcels.get(j).getTwe());
                        //物业费
                        moonRent.setPropertyFee(propertyRentExcels.get(j).getTwe());
                        //员工成本
                        moonRent.setStaffEmp(agentRentExcels.get(j).getTwe());
                        //装修折旧
                        moonRent.setFitment(decorateRentExcels.get(j).getTwe());
                        //代理费
                        moonRent.setAgencyFee(labourRentExcels.get(j).getTwe());
                        LocalDateTime nowTime = LocalDateTime.now();
                        moonRent.setCreateTime(nowTime);
                        //溢租率年月
                        LocalDateTime localDateTime2 = LocalDateTime.of(LocalDateTime.now().getYear(),12,1,0,0 );
                        moonRent.setYearsmoon(localDateTime2);

                        //TODO----按月保存-----
                        moonRentService.saveMoonRent(moonRent);
                        //TODO----再按天保存

                        Calendar cal = Calendar.getInstance();
                        cal.setTime(new Date(12));//month 为指定月份任意日期
                        int dayNumOfMonth = LocalDateTimeUtils.getDaysByYearMonth(LocalDateTime.now().getYear(), 12);
                        cal.set(Calendar.DAY_OF_MONTH, 1);// 从一号开始
                        //每个月按30天计算
                        BigDecimal day_rentalRent = rentalRentExcels.get(j).getTwe().divide(new BigDecimal(30));
                        BigDecimal day_propertyRent = propertyRentExcels.get(j).getTwe().divide(new BigDecimal(30));
                        BigDecimal day_agentRent = agentRentExcels.get(j).getTwe().divide(new BigDecimal(30));
                        BigDecimal day_decorateRent = decorateRentExcels.get(j).getTwe().divide(new BigDecimal(30));
                        BigDecimal day_labourRent = labourRentExcels.get(j).getTwe().divide(new BigDecimal(30));

                        for (int t = 0; t < dayNumOfMonth; t++, cal.add(Calendar.DATE, 12)) {
                            Date d = cal.getTime();
                            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
                            String df = simpleDateFormat.format(d);
                            DayRent dayRent = new DayRent();
                            dayRent.setId(UuidUtil.randomUUID());

                            //签约id
                            dayRent.setContractId(signId);

                            // 月溢租率id
                            dayRent.setMoonRentid(moonRentId);
                            //租金
                            dayRent.setRent(day_rentalRent);
                            //物业费
                            dayRent.setPropertyFee(day_propertyRent);
                            //员工成本
                            dayRent.setStaffEmp(day_agentRent);
                            //装修折旧
                            dayRent.setFitment(day_decorateRent);
                            //代理费
                            dayRent.setAgencyFee(day_labourRent);
                            //净利润
                            // BigDecimal profit;
                            //dayRent.setProfit();
                            //状态 1：未审核，2：审核成功，3：审核失败
                            dayRent.setStatus(rentalRentExcels.get(j).getSignState());
                            LocalDateTime createTime = LocalDateTime.parse(df);
                            dayRent.setCreateTime(createTime);
                            dayRent.setModifyTime(createTime);
                            // String createUser;
                            //String modifyUser;
                            dayRentService.saveDayRent(dayRent);
                        }
                    };
                }

            }
        }

        RentVerssion rentVerssion = new RentVerssion();
        rentVerssion.setId(rentVerssionId);
        //版本名称
        rentVerssion.setRentVerssionName(LocalDateTime.now()+"溢租率");
        //指标总数
        rentVerssion.setSumTarget(sizes*5);
        //已录入指标个数
        rentVerssion.setTargetcount(sizes*5);
        //未录入指标个数
        rentVerssion.setUntargetcount(0);

        rentVerssion.setCreateTime(LocalDateTime.now());

        rentVerssion.setModifyTime(LocalDateTime.now());

//        rentVerssion.setCreateUser();
//        rentVerssion.setModifyUser();

        //TODO  ---溢租率版本
        rentVerssionService.saveRentVerssion(rentVerssion);
        return JsonResult.success("success");
    }

    /**
     *@Description: 动态三角形客销度导入
     */
    @PostMapping(value = "/excel/guestimport/sheet")
    public JsonResult guestExcelImportSheet(@RequestParam("file")MultipartFile file) {

//        List<StandConditionGuestExcel> standConditionGuestExcels = excelImportUtil.getExcelDataToList(file, StandConditionGuestExcel.class);

        GuestImportExcelResponseDTO guestImportExcelResponseDTO = excelImportUtil.getExcelDataToListMultiSheet(file, GuestImportExcelResponseDTO.class);

        //分别按项目、楼层、业态保存客销度

        //项目客销度
        List<ProjectGuestExcel> projectGuestExcels  = guestImportExcelResponseDTO.getProjectGuestExcels();
        //楼层客销度
        List<FloorGuestExcel> floorGuestExcels = guestImportExcelResponseDTO.getFloorGuestExcels();
        //业态客销度
        List<ConditionGuestExcel> conditionGuestExcels  = guestImportExcelResponseDTO.getConditionGuestExcels();

        //获取条数
        Integer projectGuestExcelSize = projectGuestExcels.size();
        Integer floorGuestExcelsSize = projectGuestExcels.size();
        Integer conditionGuestExcelsSize = projectGuestExcels.size();

        //已录入指标个数
        Integer targetcount = 0;
        //未录入指标个数
        Integer untargetcount = 0;

        GuestVerssion  guestVerssion = new GuestVerssion();
        String guestVerssionId = UuidUtil.randomUUID();
        for(ProjectGuestExcel projectGuestExcel :projectGuestExcels){
            targetcount+=1;
            ProjectGuest projectGuest = new ProjectGuest();
            projectGuest.setId(UuidUtil.randomUUID());
            projectGuest.setContractId(projectGuestExcel.getConstractId());
            projectGuest.setProjectName(projectGuestExcel.getProjectName());
            projectGuest.setPassengerFlow(projectGuestExcel.getPassengerFlow());
            projectGuest.setGuestVerssionId(guestVerssionId);
            projectGuest.setCreateTime(LocalDateTime.now());
            try {
                projectGuestService.saveProjectGuest(projectGuest);
            } catch (Exception e) {
                untargetcount+=1;
                e.printStackTrace();
            }
        }
        //id
        guestVerssion.setId(guestVerssionId);
        //版本名称
        guestVerssion.setGuestVerssionName(LocalDateTime.now()+"项目客销度");
        //指标总数
        guestVerssion.setSumTarget(projectGuestExcelSize);
        //已录入指标个数
        guestVerssion.setTargetcount(targetcount);
        //未录入指标个数
        guestVerssion.setUntargetcount(untargetcount);
        guestVerssion.setCreateTime(LocalDateTime.now());
        guestVerssion.setModifyTime(LocalDateTime.now());
        //guestVerssion.setCreateUser("");
        //guestVerssion.setModifyUser("");
        //状态 1：未审核，2：审核成功，3：审核失败
        guestVerssion.setStatus("1");
        //类别：1、项目 2、楼层、3、品牌
        guestVerssion.setDifferent("1");
        //TODO--保存项目版本信息
        guestVerssionService.saveGuestVerssion(guestVerssion);


        //TODO---新增动态三角形楼层客销度记录
        GuestVerssion  guestVerssionFloor = new GuestVerssion();
        guestVerssionId = UuidUtil.randomUUID();
        targetcount = 0;
        untargetcount = 0;
        for(FloorGuestExcel floorGuestExcel :floorGuestExcels){
            targetcount+=1;
            FloorGuest floorGuest = new FloorGuest();
            floorGuest.setId(UuidUtil.randomUUID());
            floorGuest.setContractId(floorGuestExcel.getConstractId());
            floorGuest.setProjectName(floorGuestExcel.getProjectName());
            floorGuest.setFloorName(floorGuestExcel.getFloorName());
            floorGuest.setPassengerFlow(floorGuestExcel.getPassengerFlow());
            floorGuest.setGuestVerssionId(guestVerssionId);
            floorGuest.setCreateTime(LocalDateTime.now());

            try {
                floorGuestService.saveFloorGuest(floorGuest);
            } catch (Exception e) {
                untargetcount+=1;
                e.printStackTrace();
            }
        }
        //id
        guestVerssionFloor.setId(guestVerssionId);
        //版本名称
        guestVerssionFloor.setGuestVerssionName(LocalDateTime.now()+"楼层客销度");
        //指标总数
        guestVerssionFloor.setSumTarget(floorGuestExcelsSize);
        //已录入指标个数
        guestVerssionFloor.setTargetcount(targetcount);
        //未录入指标个数
        guestVerssionFloor.setUntargetcount(untargetcount);
        guestVerssionFloor.setCreateTime(LocalDateTime.now());
        guestVerssionFloor.setModifyTime(LocalDateTime.now());
        //guestVerssion.setCreateUser("");
        //guestVerssion.setModifyUser("");
        //状态 1：未审核，2：审核成功，3：审核失败
        guestVerssionFloor.setStatus("1");
        //类别：1、项目 2、楼层、3、品牌
        guestVerssionFloor.setDifferent("2");
        //TODO--保存项目版本信息
        guestVerssionService.saveGuestVerssion(guestVerssionFloor);

        //TODO---新增客销度版本记录

        GuestVerssion  guestVerssionDay = new GuestVerssion();
        guestVerssionId = UuidUtil.randomUUID();
        targetcount = 0;
        untargetcount = 0;
        for(ConditionGuestExcel conditionGuestExcel :conditionGuestExcels){
            targetcount+=1;
            DayGuest dayGuest = new DayGuest();
            dayGuest.setId(UuidUtil.randomUUID());
            dayGuest.setContractId(conditionGuestExcel.getConstractId());
            dayGuest.setProjectName(conditionGuestExcel.getProjectName());
            dayGuest.setFloorName(conditionGuestExcel.getFloorName());
            dayGuest.setRoomName(conditionGuestExcel.getRoomName());
            dayGuest.setContractName(conditionGuestExcel.getBrandName());//品牌名称
            dayGuest.setConditionName(conditionGuestExcel.getConditionName());
            //客流量
            dayGuest.setPassengerFlow(conditionGuestExcel.getPassengerFlow());
            //销售额
            dayGuest.setSaleroom(conditionGuestExcel.getSaleroom());
            dayGuest.setGuestVerssionId(guestVerssionId);
            dayGuest.setCreateTime(LocalDateTime.now());
            dayGuest.setStatus(conditionGuestExcel.getSignStatus());

            try {
                dayGuestService.saveDayGuest(dayGuest);
            } catch (Exception e) {
                untargetcount+=1;
                e.printStackTrace();
            }
        }
        //id
        guestVerssionDay.setId(guestVerssionId);
        //版本名称
        guestVerssionDay.setGuestVerssionName(LocalDateTime.now()+"品牌客销度");
        //指标总数
        guestVerssionDay.setSumTarget(conditionGuestExcelsSize);
        //已录入指标个数
        guestVerssionDay.setTargetcount(targetcount);
        //未录入指标个数
        guestVerssionDay.setUntargetcount(untargetcount);
        guestVerssionDay.setCreateTime(LocalDateTime.now());
        guestVerssionDay.setModifyTime(LocalDateTime.now());
        //guestVerssion.setCreateUser("");
        //guestVerssion.setModifyUser("");
        //状态 1：未审核，2：审核成功，3：审核失败
        guestVerssionDay.setStatus("1");
        //类别：1、项目 2、楼层、3、品牌
        guestVerssionDay.setDifferent("3");
        //TODO--保存项目版本信息
        guestVerssionService.saveGuestVerssion(guestVerssionDay);

        return JsonResult.success("success");
    }


}
