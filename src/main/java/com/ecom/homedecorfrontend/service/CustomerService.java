package com.ecom.homedecorfrontend.service;



import java.util.List;

import com.ecom.homedecorfrontend.models.Customer;

public interface CustomerService {

    void addCustomer(Customer customer);

    Customer getCustomerById(int customerId);

    List<Customer> getAllCustomers();

    Customer getCustomerByUsername(String username);

}
