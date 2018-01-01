package com.web_customer_tracker.springmvc_demo.service;


import com.web_customer_tracker.springmvc_demo.entity.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> getCustomers();
    void saveCustomer(Customer theCustomer);
    Customer getCustomer(int theId);
    void deleteCustomer(int theId);
}