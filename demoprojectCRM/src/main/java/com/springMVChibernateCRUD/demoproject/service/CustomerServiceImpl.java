package com.springMVChibernateCRUD.demoproject.service;

import com.springMVChibernateCRUD.demoproject.dao.ICustomerDAO;
import com.springMVChibernateCRUD.demoproject.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class CustomerServiceImpl implements ICustomerService{

    //need to inject customer DAO
    @Autowired
    private ICustomerDAO customerDAO;

    @Override
    @Transactional
    public List<Customer> getCustomers() {
        return customerDAO.getCustomers();

    }

    @Override
    @Transactional
    public void saveCustomer(Customer theCustomer) {
        customerDAO.saveCustomer(theCustomer);
    }

    @Override
    @Transactional
    public Customer getCustomer(int theId) {
        return customerDAO.getCustomer(theId);
    }

    @Override
    @Transactional
    public void deleteCustomer(int theId) {
            customerDAO.deleteCustomer(theId);
    }
}
