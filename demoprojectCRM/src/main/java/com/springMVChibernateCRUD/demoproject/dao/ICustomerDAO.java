package com.springMVChibernateCRUD.demoproject.dao;

import com.springMVChibernateCRUD.demoproject.entity.Customer;

import java.util.List;

public interface ICustomerDAO {
    public List<Customer> getCustomers();

    void saveCustomer(Customer theCustomer);

    Customer getCustomer(int theId);

    void deleteCustomer(int theId);
}
