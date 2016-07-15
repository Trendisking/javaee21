package com.kaishengit.controller;

import com.google.common.collect.Maps;
import com.kaishengit.dto.DataTablesResult;
import com.kaishengit.exception.ForbiddenException;
import com.kaishengit.exception.NotFoundException;
import com.kaishengit.pojo.Customer;
import com.kaishengit.pojo.User;
import com.kaishengit.service.CustomerService;
import com.kaishengit.service.UserService;
import com.kaishengit.util.ShiroUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * Created by 20330 on 2016/7/14.
 */
@Controller
@RequestMapping("/customer")
public class CustomerController {
    @Inject
    private CustomerService customerService;
    @Inject
    private UserService userService;
    @RequestMapping(method = RequestMethod.GET)
    public String customerList(Model model){
        model.addAttribute("companyList",customerService.findAllCompany());
        return "customer/list";
    }

    /**
     * 添加新客户
     * @param customer
     * @return
     */
    @RequestMapping(value = "/new",method = RequestMethod.POST)
    @ResponseBody
    public String save(Customer customer){
        customerService.saveCustomer(customer);
        return "success";

    }
    @RequestMapping(value = "/load",method = RequestMethod.GET)
    @ResponseBody
    public DataTablesResult<Customer> load(HttpServletRequest request) {
        String draw = request.getParameter("draw");
        String start = request.getParameter("start");
        String length = request.getParameter("length");
        String keyword = request.getParameter("search[value]");

        Map<String,Object> params = Maps.newHashMap();
        params.put("start",start);
        params.put("length",length);
        params.put("keyword",keyword);

        List<Customer> customerList = customerService.findCustomerByParams(params);
        Long count = customerService.count();
        Long filterCount = customerService.countByParam(params);

        return new DataTablesResult<>(draw,customerList,count,filterCount);

    }

    /**
     * 删除客户
     * @param id
     * @return
     */
    @RequestMapping(value = "/del/{id:\\d+}",method = RequestMethod.GET)
    @ResponseBody
    public String del(@PathVariable Integer id){
        customerService.delCustomer(id);
        return "success";
    }
    @RequestMapping(value = "/company.json",method = RequestMethod.GET)
    @ResponseBody
    public List<Customer> showAllCompanyJson(){
        return customerService.findAllCompany();

    }

    @RequestMapping(value = "/edit/{id:\\d+}.json",method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> editCustomer(@PathVariable Integer id){
        Customer customer=customerService.findCustomerById(id);
        Map<String,Object> result =Maps.newHashMap();
        if(customer==null){
            result.put("state","error");
            result.put("message","找不到相应的客户");
        }else{
            List<Customer> companyList=customerService.findAllCompany();

            result.put("state","success");
            result.put("customer",customer);
            result.put("companyList",companyList);
        }
        return result;
    }

    @RequestMapping(value = "/edit",method=RequestMethod.POST)
    @ResponseBody
    public String edit(Customer customer){
        customerService.editCustomer(customer);
        return "success";
    }

    /**
     * 显示客户信息
     * @param id
     * @param model
     * @return
     */
    @RequestMapping(value = "/{id:\\d+}",method = RequestMethod.GET)
     public String viewCustomer(@PathVariable Integer id,Model model){
        Customer customer=customerService.findCustomerById(id);
        if(customer==null){
            throw new NotFoundException();
        }
        if(customer.getUserid()!=null &&!customer.getUserid().equals(ShiroUtil.getCurrentUserID())&&!ShiroUtil.isManager()){
            throw new ForbiddenException();
        }
        model.addAttribute("customer",customer);
        if(customer.getType().equals(Customer.CUSTOMER_TYPE_COMPANY)){
            List<Customer> customerList=customerService.findCustomerByCompanyId(id);
            model.addAttribute("customerList",customerList);
        }
        List<User> userList=userService.findAllUser();
        model.addAttribute("userList",userList);
        return "customer/view";

     }
    @RequestMapping(value = "/open/{id:\\d+}",method = RequestMethod.GET)
    public String openCustomer(@PathVariable Integer id){
        Customer customer=customerService.findCustomerById(id);
        if(customer==null){
            throw new NotFoundException();
        }
        if(customer.getUserid()!=null &&!customer.getUserid().equals(ShiroUtil.getCurrentUserID())&&!ShiroUtil.isManager()){
            throw new ForbiddenException();
        }
        customerService.openCustomer(customer);
        return "redirect:/customer/"+id;
    }
    @RequestMapping(value = "/move",method = RequestMethod.POST)
    public String moveCust(Integer id,Integer userid){
        Customer customer=customerService.findCustomerById(id);
        if(customer==null){
            throw new NotFoundException();
        }
        if(customer.getUserid()!=null &&!customer.getUserid().equals(ShiroUtil.getCurrentUserID())&&!ShiroUtil.isManager()){
            throw new ForbiddenException();
        }
        customerService.moveCust(customer,userid);
        return "redirect:/customer";


    }
}
