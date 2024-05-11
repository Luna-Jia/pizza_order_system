package edu.mejia.wcc.pizzaOrder6.service;

import edu.mejia.wcc.pizzaOrder6.entity.Customer;

import java.util.List;

public interface CustomerService {

    List<Customer> findAll();

    Customer findById(int theId);

    void save(Customer theCustomer);

    void deleteById(int theId);
}
