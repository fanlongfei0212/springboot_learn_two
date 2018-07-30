package com.yinghuaicc.stars.controller.business.common;

import com.yinghuaicc.stars.common.utils.upload.FileUpload;
import com.yinghuaicc.stars.config.response.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


/**
 * @Author:Fly
 * @Date:Create in 2018/7/12 下午5:54
 * @Description: 文件上传
 * @Modified:
 */
@RestController
@RequestMapping(value = "/file/upload")
public class FileUploadController {

    @Autowired
    private FileUpload fileUpload;

    /**
     *@Author:Fly Created in 2018/7/12 下午5:56
     *@Description: 将文件上传到本地指定目录
     */
    @PostMapping(value = "/localhost")
    public JsonResult localhost(@RequestParam("file")MultipartFile file){

        return JsonResult.success(fileUpload.localhost(file));
    }
}
