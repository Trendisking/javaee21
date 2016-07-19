package com.kaishengit.service;

import com.google.common.collect.Maps;

import com.kaishengit.mapper.CustomerMapper;
import com.kaishengit.pojo.Customer;
import com.kaishengit.util.ShiroUtil;
import com.kaishengit.util.Strings;
import com.sun.org.apache.regexp.internal.RE;
import org.apache.commons.lang3.StringEscapeUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;
import java.util.Map;

/**
 * Created by 20330 on 2016/7/14.
 */
@Named
public class CustomerService {
    @Inject
    private CustomerMapper customerMapper;

    public List<Customer> findAllCompany() {
        return customerMapper.findByType(Customer.CUSTOMER_TYPE_COMPANY);
    }

    /**
     * 保存新客户
     * @param customer
     */
    public void saveCustomer(Customer customer) {
        if(customer.getCompanyid()!=null){
            Customer company=customerMapper.findById(customer.getCompanyid());
            company.setCompanyname(company.getCompanyname());
        }
        customer.setUserid(ShiroUtil.getCurrentUserID());
        customer.setPinyin(Strings.toPinyin(customer.getName()));
        customerMapper.save(customer);
    }

    public List<Customer> findCustomerByParams(Map<String, Object> params) {
        if(ShiroUtil.isEmployee()){
            params.put("userid",ShiroUtil.getCurrentUserID());//查看自己的客户
        }
        return customerMapper.findByParam(params);
    }

    public Long count() {
        Map<String,Object> params = Maps.newHashMap();
        if(ShiroUtil.isEmployee()){
            params.put("userid",ShiroUtil.getCurrentUserID());
            return customerMapper.countByParam(params);
        }
        return customerMapper.count();
    }

    public Long countByParam(Map<String, Object> params) {
        if(ShiroUtil.isEmployee()){
            params.put("userid",ShiroUtil.getCurrentUserID());
        }
        return customerMapper.countByParam(params);
    }

    /**
     * 根据ID删除客户
     * @param id
     */
    @Transactional
    public void delCustomer(Integer id) {
        Customer customer=customerMapper.findById(id);
        if(customer!=null){
            if(customer.getType().equals(customer.CUSTOMER_TYPE_COMPANY)){
                //被删除客户是公司，查找是否有关联客户，如果有，则将公司名称和ID设置为空。
                List<Customer> customerList=customerMapper.findByCompanyId(id);
                for(Customer cust:customerList){
                    cust.setCompanyname(null);
                    cust.setCompanyid(null);
                    customerMapper.update(cust);
                }
            }
            //TODO 删除关联的项目
            //TODO 删除待办的事项
            customerMapper.del(id);
        }

    }

    /**
     * 根据ID查找客户
     * @param id
     * @return
     */
    public Customer findCustomerById(Integer id) {
        return customerMapper.findById(id);
    }

    /**
     * 修改客户
     * @param customer
     */
    @Transactional
    public void editCustomer(Customer customer) {
        if(customer.getType().equals(Customer.CUSTOMER_TYPE_COMPANY)){
            //找到关联的客户修改名字
            List<Customer> customerList=customerMapper.findByCompanyId(customer.getId());
            for(Customer cust:customerList){
                cust.setCompanyname(customer.getName());
                cust.setCompanyid(customer.getId());
                customerMapper.update(cust);
            }
        }else{
            if(customer.getCompanyid()!=null){
                Customer company=customerMapper.findById(customer.getCompanyid());
                customer.setCompanyname(company.getName());
            }
        }
        customer.setPinyin(Strings.toPinyin(customer.getName()));
        customerMapper.update(customer);
    }

    /**
     * 根据公司ID查找所有客户
     * @param id
     * @return
     */
    public List<Customer> findCustomerByCompanyId(Integer id) {
        return customerMapper.findByCompanyId(id);
    }

    /**
     * 公开客户信息
     * @param customer
     */
    public void openCustomer(Customer customer) {
        customer.setUserid(null);
        customerMapper.update(customer);
    }

    /**
     * 转移客户
     * @param customer
     * @param userid
     */
    public void moveCust(Customer customer, Integer userid) {
        customer.setUserid(userid);
        customerMapper.update(customer);
    }

    /**
     * 将客户信息生成MeCard格式
     * @param id
     * @return
     */
    public String makeMeCard(Integer id){
        Customer customer=customerMapper.findById(id);
        StringBuilder mecard=new StringBuilder("MECARD:");
        if(StringUtils.isNotEmpty(customer.getName())){
            mecard.append("N:"+customer.getName()+";");
        }
        if(StringUtils.isNotEmpty(customer.getTel())){
            mecard.append("TEL:"+customer.getTel()+";");
        }
        if(StringUtils.isNotEmpty(customer.getEmail())){
            mecard.append("EMAIL:"+customer.getEmail()+";");
        }
        if(StringUtils.isNotEmpty(customer.getAddress())){
            mecard.append("ADR:"+customer.getAddress()+";");
        }
        if(StringUtils.isNotEmpty(customer.getCompanyname())){
            mecard.append("ORG:"+customer.getCompanyname()+";");
        }
        mecard.append(";");
        return mecard.toString();

    }

    public  List<Customer> findAllCustomers() {
        return customerMapper.findAllCustomers();
    }
}
