package com.kaishengit.controller;

import com.kaishengit.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * Created by 20330 on 2016/7/12.
 */
public class FilePreviewController {

    @Value("${imagePath}")
    private String filePath;
    @RequestMapping(value = "/preview/{fileName}")
    public ResponseEntity<InputStreamResource> previewFile(@PathVariable String fileName, HttpServletResponse response) throws IOException{
        File file=new File(filePath,fileName);
        if(!file.exists()){
            throw new NotFoundException();
        }
        FileInputStream inputStream=new FileInputStream(file);
        return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG)
                .body(new InputStreamResource(inputStream));
    }
}
