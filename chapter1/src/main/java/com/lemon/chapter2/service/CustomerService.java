package com.lemon.chapter2.service;

import com.lemon.chapter2.model.Customer;

import java.util.List;
import java.util.Map;

/**
 *
 * Created by lemoon on 20/1/20 下午5:12
 */
public class CustomerService {
    /**
     * 获取客户列表
     * @param keyword
     * @return
     */
    public List<Customer> getCustomerList(String keyword){
        //TODO
        return null;
    }


    /**
     * 获取客户
     */
    public Customer getCustomer(long id){
        //TODO
        return null;
    }

    /**
     * 创建客户
     */
    public boolean createCustomer(Map<String,Object> fieldMap){
        //TODO
        return false;
    }

    /**
     * 更新客户
     */
    public boolean updateCustomer(long id,Map<String,Object> fieldMap){
        //TODO
        return false;
    }

    /**
     * 删除客户
     */
    public boolean deleteCustomer(long id){
        //TODO
        return false;
    }

}
