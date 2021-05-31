package org.smart4j.chapter2.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.smart4j.chapter2.model.Customer;
import org.smart4j.chapter2.util.PropsUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;

public class CustomerService {

    private static  final Logger LOGGER= LoggerFactory.getLogger(CustomerService.class);



    public List<Customer> getCustomerList(String keyword){
            String sql="SELECT * FROM CUSTOMER";
            return DatabaseHelper.queryEntityList(Customer.class,sql);
    }

    public Customer getCustomer(long id){
        return null;
    }

    public boolean createCustomer(Map<String,Object> fieldMap){
        return DatabaseHelper.insertEntity(Customer.class,fieldMap);

    }

    public boolean updateCustomer(long id , Map<String,Object> fieldMap){
        return DatabaseHelper.updateEntity(Customer.class,id,fieldMap);

    }

    public boolean deleteCustomer(long id){
        return DatabaseHelper.deleteEntity(Customer.class,id);
    }
}
