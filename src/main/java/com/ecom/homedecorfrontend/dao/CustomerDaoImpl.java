package com.ecom.homedecorfrontend.dao;


import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ecom.homedecorfrontend.models.Cart;
import com.ecom.homedecorfrontend.models.Customer;
import com.ecom.homedecorfrontend.models.UserDetails;
import com.ecom.homedecorfrontend.models.UserRoles;

import java.util.List;

@Repository
@Transactional
public class CustomerDaoImpl implements CustomerDao{

    @Autowired
    private SessionFactory sessionFactory;

    public void addCustomer(Customer customer){
        Session session = sessionFactory.getCurrentSession();       
        customer.getShippingAddress().setUsersDetail(customer);
        session.saveOrUpdate(customer);
              session.saveOrUpdate(customer.getShippingAddress());
        UserDetails newUser = new UserDetails();
        newUser.setUsername(customer.getUsername());
        newUser.setPassword(customer.getPassword());
        newUser.setEnabled(true);
        newUser.setCustomerId(customer.getCutomerId());
        session.saveOrUpdate(newUser);
        UserRoles ur=new UserRoles();
        ur.setAuthority("ROLE_USER");
        ur.setId(newUser.getUsersId());
        session.saveOrUpdate(ur);
        

        Cart newCart = new Cart();
        newCart.setUsersDetail(customer);
        customer.setCart(newCart);

        session.saveOrUpdate(customer);
        session.saveOrUpdate(newCart);

        session.flush();
    }

    public Customer getCustomerById(int customerId){
        Session session = sessionFactory.getCurrentSession();
        return session.get(Customer.class, customerId);
    }

    public List<Customer> getAllCustomers(){
        Session session = sessionFactory.openSession();
        Query<Customer> query = session.createQuery("from Customer");
        @SuppressWarnings("unchecked")
        List<Customer> customerList = query.list();

        return customerList;

    }

    public Customer getCustomerByUsername(String username){
        Session session = sessionFactory.openSession();
        Query<Customer> query = session.createQuery("from Customer where username = ?");
        query.setString(0, username);


        return query.uniqueResult();
    }


} // The End of Class;
