package com.springMVChibernateCRUD.demoproject.dao;

import com.springMVChibernateCRUD.demoproject.entity.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class CustomerDAOImpl implements ICustomerDAO{
    //dependency Injection
    //inject Session factory dependency
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Customer> getCustomers() {

        //get the current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();;

        //create query...sort by last name
        Query<Customer> theQuery = currentSession.createQuery("from Customer"
                +" order by lastName",Customer.class);

        //execute query and get result list
        List<Customer> customerList = theQuery.getResultList();

        //return the list
        return customerList;
    }

    @Override
    public void saveCustomer(Customer theCustomer) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.saveOrUpdate(theCustomer);

    }

    @Override
    public Customer getCustomer(int theId) {
        Session currentSession = sessionFactory.getCurrentSession();

        Customer customer = currentSession.get(Customer.class,theId);

        return customer;
    }

    @Override
    public void deleteCustomer(int theId) {
        Session currentSession = sessionFactory.getCurrentSession();

        Query theQuery = currentSession.createQuery("delete from Customer where id=: theCustomerId");
        theQuery.setParameter("theCustomerId",theId);
        theQuery.executeUpdate();
    }
}
