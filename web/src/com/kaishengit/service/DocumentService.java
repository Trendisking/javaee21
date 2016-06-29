package com.kaishengit.service;

import com.kaishengit.dao.DocumentDao;
import com.kaishengit.entity.Document;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.UUID;

/**
 * Created by 20330 on 2016/6/16.
 */
public class DocumentService {
    private DocumentDao documentDao=new DocumentDao();
    public void updateFile(String fileName,Long size,InputStream inputStream) throws IOException{
        String md5= DigestUtils.md5Hex(inputStream);
        Document document=DocumentDao.findByMd5(md5);
        if(document==null){
            String saveFileName=saveFile(fileName, inputStream);
            document=new Document();
            document.setFilename(fileName);
            document.setSavename(saveFileName);
            document.setExtname(fileName.substring(fileName.indexOf(".")));
            document.setMd5(md5);
            document.setSize(size);
            document.setDisplaysize(FileUtils.byteCountToDisplaySize(size));
            documentDao.save(document);
        }




        saveFile(fileName,inputStream);

    }

     private String saveFile(String fileName,InputStream inputStream) throws IOException {
         File dir = new File("F:/upload");
         System.out.println(dir.exists());
         if (!dir.exists()) {
             dir.mkdirs();
         }


         String extName = fileName.substring(fileName.indexOf("."));
         String uuid = UUID.randomUUID().toString();
         fileName = uuid + extName;


         FileOutputStream outputStream = new FileOutputStream(new File(dir, fileName));
         IOUtils.copy(inputStream, outputStream);
         outputStream.flush();
         outputStream.close();
         inputStream.close();
         return fileName;
     }

    public List<Document> findAllDocument() {
        return documentDao.findAll();
    }

    public Document findDocumentByMd5(String md5) {
        return documentDao.findByMd5(md5);
    }
}
