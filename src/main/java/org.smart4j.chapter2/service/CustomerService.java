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


    private static final String DRIVER;
    private static final String URL;
    private static final String USERNAME;
    private static final String PASSWORD;

   static{
       Properties conf= PropsUtil.loadProps("config.properties");
       DRIVER=conf.getProperty("jdbc.driver");
       URL=conf.getProperty("jdbc.url");
       USERNAME=conf.getProperty("jdbc.username");
       PASSWORD=conf.getProperty("jdbc.password");
   }




    public List<Customer> getCustomerList(String keyword){
        Connection conn=null;
        try {
            List<Customer> customerList=new ArrayList<Customer>();
            String sql="SELECT * FROM CUSTOMER";
            conn= DriverManager.getConnection(URL,USERNAME,PASSWORD);
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()){
                Customer customer=new Customer();
                customer.setId(rs.getLong("id"));
                customer.setName(rs.getString("name"));
                customer.setContact(rs.getString("contact"));
                customer.setTelephone(rs.getString("telephone"));
                customer.setEmail(rs.getString("email"));
                customer.setRemark(rs.getString("remark"));
                customerList.add(customer);
            }
                return customerList;
        } catch (SQLException e) {
           LOGGER.error("execute sql failure",e);
        }finally {
            if(conn!=null){
                try{
                    conn.close();
                }catch (SQLException e){
                    LOGGER.error("close connection failure",e);
                }
            }
        }


        return null;
    }

    public Customer getCustomer(long id){
        return null;
    }

    public boolean createCustomer(Map<String,Object> fieldMap){
        return false;
    }

    public boolean updateCustomer(long id , Map<String,Object> fieldMap){
        return false;
    }

    public boolean deleteCustomer(long id){
        return false;
    }
}
