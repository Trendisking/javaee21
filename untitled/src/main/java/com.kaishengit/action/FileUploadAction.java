package com.kaishengit.action;

import org.apache.commons.io.IOUtils;

import java.io.*;
import java.util.List;

/**
 * Created by 20330 on 2016/8/3.
 */
public class FileUploadAction extends BaseAction {
    private String name;
    private List<File> photo;
    private List<String> photoFileName;
    private List<String> photoContentType;

    private String downloadType;
    private String downloadFileName;
    private Long downloadFileSize;
    @Override
    public String execute() throws Exception{
        return SUCCESS;
    }

    public String upload() throws IOException {
        for(int i=0;i<photo.size();i++) {
            System.out.println("Name:" + name);
            System.out.println("Photo:" + photo.get(i).getName());

            System.out.println("PhotoFileName:" + photoFileName.get(i));
            System.out.println("PhotoContentType:" + photoContentType.get(i));

            FileInputStream inputStream = new FileInputStream(photo.get(i));
            FileOutputStream outputStream = new FileOutputStream("D:/" + photoFileName.get(i));
            IOUtils.copy(inputStream, outputStream);
            outputStream.flush();
            outputStream.close();
            inputStream.close();
        }
        return SUCCESS;
    }

    public String download(){
        File file=new File("E:/download/1.jpg");
        downloadType="img/jpg";
        downloadFileSize=file.length();
        downloadFileName="1.jpg";

        return SUCCESS;
    }

    public InputStream getInputStream() throws IOException {
        return new FileInputStream(new File("E:/download/1.jpg"));
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<File> getPhoto() {
        return photo;
    }

    public void setPhoto(List<File> photo) {
        this.photo = photo;
    }

    public List<String> getPhotoFileName() {
        return photoFileName;
    }

    public void setPhotoFileName(List<String> photoFileName) {
        this.photoFileName = photoFileName;
    }

    public List<String> getPhotoContentType() {
        return photoContentType;
    }

    public void setPhotoContentType(List<String> photoContentType) {
        this.photoContentType = photoContentType;
    }

    public String getDownloadType() {
        return downloadType;
    }

    public void setDownloadType(String downloadType) {
        this.downloadType = downloadType;
    }

    public String getDownloadFileName() {
        return downloadFileName;
    }

    public void setDownloadFileName(String downloadFileName) {
        this.downloadFileName = downloadFileName;
    }

    public Long getDownloadFileSize() {
        return downloadFileSize;
    }

    public void setDownloadFileSize(Long downloadFileSize) {
        this.downloadFileSize = downloadFileSize;
    }
}
