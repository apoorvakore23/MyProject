package com.ecom.homedecorfrontend.service;

import com.ecom.homedecorfrontend.models.CustomerOrder;

public interface CustomerOrderService {

    void addCustomerOrder(CustomerOrder customerOrder);

    double getCustomerOrderGrandTotal(int cartId);
}
