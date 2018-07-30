package com.yinghuaicc.stars.service.cqrs.standard;

import com.yinghuaicc.stars.service.cqrs.standard.dto.response.StandardFittedImportExcelResponseDTO;
import org.springframework.web.multipart.MultipartFile;

/**
 * 标准三角形数据导入
 */
public interface StandardImportExcelService {


    /**
     * 导入标准三角形适配值
     * @param file
     * @return
     */
    StandardFittedImportExcelResponseDTO standardFittedImportExcelMultSheet(MultipartFile file);

}
