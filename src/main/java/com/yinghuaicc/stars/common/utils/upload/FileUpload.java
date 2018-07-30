package com.yinghuaicc.stars.common.utils.upload;

import com.yinghuaicc.stars.common.utils.exception.ExceptionUtil;
import com.yinghuaicc.stars.common.utils.uuid.UuidUtil;
import com.yinghuaicc.stars.config.base.SystemNum;
import com.yinghuaicc.stars.controller.config.system.SystemResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Author:Fly
 * @Date:Create in 2018/7/12 下午5:50
 * @Description: 文件上传
 * @Modified:
 */
@Component
public class FileUpload {

    @Autowired
    private SystemResource systemResource;

    @Autowired
    private ExceptionUtil exceptionUtil;

    /**
     *@Author:Fly Created in 2018/7/12 下午5:52
     *@Description: 将文件上传到本地
     */
    public String localhost(MultipartFile file){

        if (Objects.isNull(file)){

            throw exceptionUtil.throwCustomException("COMMON_FILE_UPLOAD_LOCALHOST_001");
        }

        Map<String, String> fileInfoMap = this.fileInfo(file.getOriginalFilename());

        String fileName = fileInfoMap.get("fileName");

        String fileDir = fileInfoMap.get("fileDir");

        File targetFile = new File(fileDir);

        if(!targetFile.exists()){

            targetFile.mkdirs();
        }

        FileOutputStream out = null;

        try {

            out = new FileOutputStream(fileName);

            out.write(file.getBytes());

        } catch (Exception e) {

            e.printStackTrace();

        }finally {

            try {
                out.flush();
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        return fileInfoMap.get("type").equals(SystemNum.IMAGE)
                ?
                systemResource.getFileImageUrl()+fileInfoMap.get("accessName")
                :(fileInfoMap.get("type").equals(SystemNum.EXCEL)
                    ?
                    systemResource.getFileExcelUrl()+fileInfoMap.get("accessName")
                    :
                    systemResource.getFileOtherUrl()+fileInfoMap.get("accessName"));
    }

    /**
     *@Author:Fly Created in 2018/7/12 下午6:30
     *@Description: 生成文件名称，保证文件名称唯一，
     * 将不同种类的文件上传至不同的文件目录
     */
    private Map<String, String> fileInfo(String fileName){

        String sourceFileNameSuffix = fileName.substring(fileName.indexOf("."), fileName.length());

        Map<String, String> result = new HashMap<String, String>();

        if (this.allImageSuffix().stream().anyMatch(str -> sourceFileNameSuffix.contains(str))
                ||
                this.allImageSuffix().stream().map(String::toUpperCase).anyMatch(str -> sourceFileNameSuffix.contains(str))){

            String accessName = SystemNum.IMAGE+UuidUtil.randomUUID()+sourceFileNameSuffix;

            result.put("fileDir", systemResource.getFileUploadImagePathUrl());

            result.put("fileName", systemResource.getFileUploadImagePathUrl() + accessName);

            result.put("type", SystemNum.IMAGE);

            result.put("accessName", accessName);

        }else if (this.allExcelSuffix().stream().anyMatch(str -> sourceFileNameSuffix.contains(str))
                ||
                this.allExcelSuffix().stream().map(String::toUpperCase).anyMatch(str -> sourceFileNameSuffix.contains(str))){

            String accessName = SystemNum.EXCEL+UuidUtil.randomUUID()+sourceFileNameSuffix;

            result.put("fileDir", systemResource.getFileUploadExcelPathUrl());

            result.put("fileName", systemResource.getFileUploadExcelPathUrl() + accessName);

            result.put("type", SystemNum.EXCEL);

            result.put("accessName", accessName);
        }else {

            String accessName = SystemNum.OTHER+UuidUtil.randomUUID()+sourceFileNameSuffix;

            result.put("fileDir", systemResource.getFileUploadOtherPathUrl());

            result.put("fileName", systemResource.getFileUploadOtherPathUrl() + accessName);

            result.put("type", SystemNum.OTHER);

            result.put("accessName", accessName);
        }

        return result;
    }

    /**
     *@Author:Fly Created in 2018/7/12 下午6:36
     *@Description: 所有图片后缀
     */
    private List<String> allImageSuffix(){

        return Stream.of(
                ".bmp",".jpg",".jpeg",".png",".tiff",".gif",".pcx",
                ".tga",".exif",".fpx",".svg",".psd",".cdr",".pcd",
                ".dxf",".ufo",".eps",".ai",".raw",".WMF",".webp")
                .collect(Collectors.toList());
    }

    /**
     *@Author:Fly Created in 2018/7/12 下午6:41
     *@Description: 所有Excel后缀
     */
    private List<String> allExcelSuffix(){

        return Stream.of(
                ".xls",".xlsx")
                .collect(Collectors.toList());
    }
}
