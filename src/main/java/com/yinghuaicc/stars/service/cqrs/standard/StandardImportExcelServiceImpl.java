package com.yinghuaicc.stars.service.cqrs.standard;

import com.yinghuaicc.stars.common.utils.excel.ExcelImportUtil;
import com.yinghuaicc.stars.service.cqrs.standard.dto.response.StandardFittedImportExcelResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 * 标准三角形数据导入
 */
@Service
public class StandardImportExcelServiceImpl implements  StandardImportExcelService{

    @Autowired
    private ExcelImportUtil excelImportUtil;


    @Override
    public StandardFittedImportExcelResponseDTO standardFittedImportExcelMultSheet(MultipartFile file) {



        return null;
    }
}
