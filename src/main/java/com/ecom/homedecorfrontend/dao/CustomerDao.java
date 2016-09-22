package com.ecom.homedecorfrontend.dao;




import java.util.List;

import com.ecom.homedecorfrontend.models.Customer;

public interface CustomerDao {

    void addCustomer(Customer customer);

    Customer getCustomerById(int customerId);

    List<Customer> getAllCustomers();

    Customer getCustomerByUsername(String username);
}
