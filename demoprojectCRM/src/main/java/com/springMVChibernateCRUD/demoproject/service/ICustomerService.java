package com.springMVChibernateCRUD.demoproject.service;

import com.springMVChibernateCRUD.demoproject.entity.Customer;

import java.util.List;

public interface ICustomerService {
    public List<Customer> getCustomers();

    void saveCustomer(Customer theCustomer);

    Customer getCustomer(int theId);

    void deleteCustomer(int theId);
}
