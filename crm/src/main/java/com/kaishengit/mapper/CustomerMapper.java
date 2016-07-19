package com.kaishengit.mapper;

import com.kaishengit.pojo.Customer;

import java.util.List;
import java.util.Map;

/**
 * Created by 20330 on 2016/7/14.
 */

public interface CustomerMapper {
    List<Customer> findByType(String type);

    Customer findById(Integer id);

    void save(Customer customer);

    List<Customer> findByParam(Map<String, Object> params);

    Long countByParam(Map<String, Object> params);

    Long count();

    List<Customer> findByCompanyId(Integer id);

    void update(Customer cust);

    void del(Integer id);

    List<Customer> findAllCustomers();
}
