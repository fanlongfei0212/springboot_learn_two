package com.yinghuaicc.stars.common.utils.excel;

import com.yinghuaicc.stars.common.utils.exception.ExceptionUtil;
import com.yinghuaicc.stars.common.utils.json.GsonUtil;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @Author:Fly
 * @Date:Create in 2018/7/13 上午10:43
 * @Description:
 * @Modified:
 */
@Component
public class ExcelImportUtil {

    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    private final static String excel2003L =".xls";    //2003- 版本的excel
    private final static String excel2007U =".xlsx";   //2007+ 版本的excel

    @Autowired
    private ExceptionUtil exceptionUtil;

    @Autowired
    private GsonUtil gsonUtil;

    public <D> D getExcelDataToList(MultipartFile file, Class<?> target){

        D result = null;

        try {

            result = this.getExcelDataToList(
                    file.getInputStream(),
                    file.getOriginalFilename().substring(
                            file.getOriginalFilename().indexOf("."),
                            file.getOriginalFilename().length()),
                    target);
        } catch (IOException e) {

            e.printStackTrace();
        }

        return result;
    }

    public <T> T getExcelDataToListMultiSheet(MultipartFile file, Class<T> target){

        T result = null;

        try {

            result = this.getExcelDataToListultiMultiSheet(
                    file.getInputStream(),
                    file.getOriginalFilename().substring(
                            file.getOriginalFilename().indexOf("."),
                            file.getOriginalFilename().length()),
                    target);
        } catch (IOException e) {

            e.printStackTrace();
        }

        return result;
    }

    /**
     *@Author:Fly Created in 2018/7/13 上午11:05
     *@Description: 获取流中的数据（所有sheet页数据存储在一个泛型中）
     */
    public <D> D getExcelDataToList(InputStream in,String fileSuffix, Class<?> target){

        List<Map<String, Object>> resultListMap = new ArrayList<Map<String, Object>>();

        Workbook work = this.getWorkbook(in,fileSuffix);

        if (Objects.isNull(work)){

            throw exceptionUtil.throwCustomException("COMMON_EXCEL_IMPORT_GET_WORK_BOOK_002");
        }

        Sheet sheet = null;
        Row row = null;
        Cell cell = null;

        //遍历Excel中所有的sheet
        for (int i = 0; i < work.getNumberOfSheets(); i++) {
            sheet = work.getSheetAt(i);
            if(sheet==null){
                continue;
            }
            //遍历当前sheet中的所有行，去除标题行
            for (int j = sheet.getFirstRowNum()+1; j < sheet.getLastRowNum()+1; j++) {
                row = sheet.getRow(j);
                //遍历所有的列,获取要转换的DTO属性，属性的排列顺序要与Excel的单元格值顺序一致
                Field[] fields = target.getDeclaredFields();
                Map <String, Object> map = new HashMap<String, Object>();
                for (int y = row.getFirstCellNum(); y < row.getLastCellNum(); y++) {

                    cell = row.getCell(y);

                    if (Objects.isNull(cell)){

                        map.put(fields[y].getName(), null);
                    }else if (cell.getCellType() == Cell.CELL_TYPE_BLANK){

                        map.put(fields[y].getName(), null);
                    }else if (cell.getCellType() == Cell.CELL_TYPE_BOOLEAN){

                        map.put(fields[y].getName(), cell.getBooleanCellValue());
                    }else if (cell.getCellType() == Cell.CELL_TYPE_ERROR){

                        map.put(fields[y].getName(), cell.getErrorCellValue());
                    }else if (cell.getCellType() == Cell.CELL_TYPE_FORMULA){

                        map.put(fields[y].getName(), cell.getCellFormula().toString());
                    }else if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC){

                        if (HSSFDateUtil.isCellDateFormatted(cell)){

                            double d = cell.getNumericCellValue();
                            Date date = HSSFDateUtil.getJavaDate(d);

                            map.put(fields[y].getName(), sdf.format(date));
                        }else{

                            map.put(fields[y].getName(), cell.getNumericCellValue());
                        }

                    }else if (cell.getCellType() == Cell.CELL_TYPE_STRING){

                        map.put(fields[y].getName(), cell.getStringCellValue());
                    }
                }
                resultListMap.add(map);
            }
        }
        try {
            work.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return gsonUtil.toCollection(gsonUtil.toJson(resultListMap), target);
    }

    /**
     *@Author:Fly Created in 2018/7/13 上午11:05
     *@Description: 获取流中的数据（多Sheet、多泛型）
     */
    public <T> T getExcelDataToListultiMultiSheet(InputStream in,String fileSuffix, Class<T> target){

        Map<String, Object> result = new HashMap<>();

        List<Map<String, Object>> resultListMap = null;

        Workbook work = this.getWorkbook(in,fileSuffix);

        if (Objects.isNull(work)){

            throw exceptionUtil.throwCustomException("COMMON_EXCEL_IMPORT_GET_WORK_BOOK_002");
        }

        Sheet sheet = null;
        Row row = null;
        Cell cell = null;

        //遍历Excel中所有的sheet
        for (int i = 0; i < work.getNumberOfSheets(); i++) {
            sheet = work.getSheetAt(i);
            if(sheet==null){
                continue;
            }

            //获取各个属性的list泛型
            Field[] fields = target.getDeclaredFields();

            //获取泛型中的属性泛型
            ParameterizedType parameterizedType =  (ParameterizedType)fields[i].getGenericType();

            Class<?> genericClazz = (Class<?>)parameterizedType.getActualTypeArguments()[0];

            Field[] propertyFields = genericClazz.getDeclaredFields();

            resultListMap = new ArrayList<Map<String, Object>>();

            //遍历当前sheet中的所有行，去除标题行
            for (int j = sheet.getFirstRowNum()+1; j < sheet.getLastRowNum()+1; j++) {
                row = sheet.getRow(j);
                //遍历所有的列,获取要转换的DTO属性，属性的排列顺序要与Excel的单元格值顺序一致

                Map <String, Object> map = new HashMap<String, Object>();

                for (int y = row.getFirstCellNum(); y < row.getLastCellNum(); y++) {

                    cell = row.getCell(y);

                    if (Objects.isNull(cell)){

                        map.put(propertyFields[y].getName(), null);
                    }else if (cell.getCellType() == Cell.CELL_TYPE_BLANK){

                        map.put(propertyFields[y].getName(), null);
                    }else if (cell.getCellType() == Cell.CELL_TYPE_BOOLEAN){

                        map.put(propertyFields[y].getName(), cell.getBooleanCellValue());
                    }else if (cell.getCellType() == Cell.CELL_TYPE_ERROR){

                        map.put(propertyFields[y].getName(), cell.getErrorCellValue());
                    }else if (cell.getCellType() == Cell.CELL_TYPE_FORMULA){

                        map.put(propertyFields[y].getName(), cell.getCellFormula().toString());
                    }else if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC){

                        if (HSSFDateUtil.isCellDateFormatted(cell)){

                            double d = cell.getNumericCellValue();
                            Date date = HSSFDateUtil.getJavaDate(d);

                            map.put(propertyFields[y].getName(), sdf.format(date));
                        }else{

                            map.put(propertyFields[y].getName(), cell.getNumericCellValue());
                        }

                    }else if (cell.getCellType() == Cell.CELL_TYPE_STRING){

                        map.put(propertyFields[y].getName(), cell.getStringCellValue());
                    }
                }
                resultListMap.add(map);
            }

            result.put(fields[i].getName(), resultListMap);
        }
        try {
            work.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return gsonUtil.toBean(gsonUtil.toJson(result), target);
    }

    /**
     *@Author:Fly Created in 2018/7/13 上午10:49
     *@Description: 获取Workbook
     */
    public Workbook getWorkbook(InputStream inStr, String fileType) {

        Workbook wb = null;
        try {

            if(excel2003L.equals(fileType)){

                wb = new HSSFWorkbook(inStr);  //2003-

            }else if(excel2007U.equals(fileType)){

                wb = new XSSFWorkbook(inStr);  //2007+
            }else{

                throw exceptionUtil.throwCustomException("COMMON_EXCEL_IMPORT_GET_WORK_BOOK_001");
            }
        } catch (IOException e) {

            e.printStackTrace();
        }
        return wb;
    }

}
