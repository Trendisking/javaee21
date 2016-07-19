package com.kaishengit.service;

import com.google.common.collect.Maps;
import com.kaishengit.mapper.CustomerMapper;
import com.kaishengit.mapper.SalesFileMapper;
import com.kaishengit.mapper.SalesLogMapper;
import com.kaishengit.mapper.SalesMapper;
import com.kaishengit.pojo.Sales;
import com.kaishengit.pojo.SalesLog;
import com.kaishengit.util.ShiroUtil;
import org.apache.commons.io.IOUtils;
import com.kaishengit.pojo.SalesFile;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import javax.inject.Named;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * Created by 20330 on 2016/7/16.
 */
@Named
public class SalesService {
    @Inject
    private SalesMapper salesMapper;
    @Inject
    private SalesFileMapper salesFileMapper;
    @Inject
    private SalesLogMapper salesLogMapper;
    @Inject
    private CustomerMapper customerMapper;
    @Value("${imagePath}")
    private String savePath;
    //新增销售机会
    @Transactional
    public void saveSales(Sales sales) {
        sales.setUserid(ShiroUtil.getCurrentUserID());
        sales.setUsername(ShiroUtil.getCurrentRealName());
        sales.setCustomername(customerMapper.findById(sales.getCustomerid()).getName());
        salesMapper.save(sales);

        //自动创建日志
        SalesLog saleslog=new SalesLog();
        saleslog.setType(SalesLog.LOG_TYPE_AUTO);
        saleslog.setContext(ShiroUtil.getCurrentRealName()+"创建了该销售机会");
        saleslog.setSalesid(sales.getId());
        salesLogMapper.save(saleslog);


    }

    public List<Sales> findSalesByParam(Map<String, Object> params) {
        if(ShiroUtil.isEmployee()){
            params.put("userid",ShiroUtil.getCurrentUserID());
        }

        return salesMapper.findByParam(params);
    }

    public Long count() {
        Map<String,Object> params= Maps.newHashMap();
        if(ShiroUtil.isEmployee()){
            params.put("userid",ShiroUtil.getCurrentUserID());
        }
        return salesMapper.countByParam(params);
    }

    public Long countByParam(Map<String,Object> params) {
        if(ShiroUtil.isEmployee()){
            params.put("userid",ShiroUtil.getCurrentUserID());

        }
        return salesMapper.countByParam(params);
    }

    /**
     * 根据ID查找销售机会
     * @param id
     * @return
     */
    public Sales findSalesById(Integer id) {
        return salesMapper.findById(id);
    }

    /**
     * 根据主键删除销售机会
     * @param id
     */
    @Transactional
    public void delSales(Integer id) {
        Sales sales=salesMapper.findById(id);
        if(sales!=null){
            //删除对应的文件
            List<SalesFile> salesFileList=salesFileMapper.findBySalesId(id);
            if(!salesFileList.isEmpty()){
                salesFileMapper.del(salesFileList);
            }
            //删除对应的跟进
            List<SalesLog> salesLogList=salesLogMapper.findBySalesId(id);
            if(!salesLogList.isEmpty()){
                salesLogMapper.del(salesLogList);
            }
            salesMapper.del(id);
        }

    }

    //保存新的跟进日志
    @Transactional
    public void saveLog(SalesLog salesLog) {
        salesLog.setType(SalesLog.LOG_TYPE_INPUT);
        salesLogMapper.save(salesLog);

        //修改机会的最后跟进时间
        Sales sales=salesMapper.findById(salesLog.getSalesid());
        sales.setLasttime(DateTime.now().toString("YYYY-MM-dd"));
        salesMapper.update(sales);

    }

    //根据销售ID查找对应的跟进日志
    public List<SalesLog> findSalesLogBySalesId(Integer salesid) {
        return salesLogMapper.findBySalesId(salesid);
    }

    /**
     *修改机会的进度
     * @param id
     * @param progress
     */
    @Transactional
    public void editSalesProgress(Integer id, String progress) {
        Sales sales=salesMapper.findById(id);
        sales.setProgress(progress);
        //修改最后的跟进时间
        sales.setLasttime(DateTime.now().toString("yyyy-MM-dd"));
        //判断是否完成
        if("完成交易".equals(progress)){
            sales.setSuccesstime(DateTime.now().toString("yyyy-MM-dd"));
        }
        salesMapper.update(sales);
        //添加跟进日志
        SalesLog salesLog=new SalesLog();
        salesLog.setType(SalesLog.LOG_TYPE_INPUT);
        salesLog.setContext(ShiroUtil.getCurrentRealName()+"更改进度为:"+progress);
        salesLog.setSalesid(sales.getId());
        salesLogMapper.save(salesLog);

    }
    @Transactional
    public void updateFile(InputStream inputStream, String originalFilename, String contentType, long size, Integer salesid) {
        String newName= UUID.randomUUID().toString();
        if(originalFilename.lastIndexOf(".")!=-1){
            newName=newName+originalFilename.substring(originalFilename.lastIndexOf("."));
        }
        try{
            FileOutputStream outputStream = new FileOutputStream(new File(savePath,newName));
            IOUtils.copy(inputStream,outputStream);
            outputStream.flush();
            outputStream.close();
            inputStream.close();
        }catch (IOException e){
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        SalesFile salesFile = new SalesFile();
        salesFile.setSalesid(salesid);
        salesFile.setContenttype(contentType);
        salesFile.setFilename(newName);
        salesFile.setName(originalFilename);
        salesFile.setSize(size);

        salesFileMapper.save(salesFile);

    }

    /**
     * 根据机会ID查找对应的文件列表
     * @param salseid
     * @return
     */
    public List<SalesFile> findSalesFileBySalesId(Integer salseid) {
        return salesFileMapper.findBySalesId(salseid);

    }

    /**
     * 根据主键获取文件
     * @param id
     * @return
     */
    public SalesFile findSalesFileById(Integer id) {
        return salesFileMapper.findById(id);
    }

}
