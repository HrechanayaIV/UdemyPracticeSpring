package com.web_customer_tracker.springmvc_demo.dao;

import com.web_customer_tracker.springmvc_demo.entity.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class CustomerDaoImpl implements CustomerDAO {
    @Autowired
    private SessionFactory sessionFactory;

    public List<Customer> getCustomers() {
        //get the current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();
        //create a query , sorted by last Name
        Query<Customer> theQuery = currentSession.createQuery("from Customer order by lastName", Customer.class);
        //get the result list
        List<Customer> customers = theQuery.getResultList();

        return customers;
    }

    public void saveCustomer(Customer theCustomer) {
        //get the current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();
        // save/update the customer to the database
        currentSession.saveOrUpdate(theCustomer);
    }

    public Customer getCustomer(int theId) {
        //get the current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();
        //get the customer from the database
        Customer theCustomer = currentSession.get(Customer.class,theId);

        return theCustomer;
    }

    public void deleteCustomer(int theId) {
        //get the current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();
        //delete the customer from the database
        Query theQuery = currentSession.createQuery(
                "delete from Customer where id=:customerId");
        theQuery.setParameter("customerId",theId);

        theQuery.executeUpdate();
    }
}