package edu.mejia.wcc.pizzaOrder6.service;

import edu.mejia.wcc.pizzaOrder6.dao.CustomerRepository;
import edu.mejia.wcc.pizzaOrder6.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService{

    private CustomerRepository customerRepository;

    @Autowired
    public CustomerServiceImpl(CustomerRepository theCustomerRepository) {
        this.customerRepository = theCustomerRepository;
    }

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public Customer findById(int theId) {
        Optional<Customer> result = customerRepository.findById(theId);

        Customer theCustomer = null;
        if (result.isPresent()){
            theCustomer = result.get();
        } else {
            // we didn't find the customer
            throw new RuntimeException("Did not find customer id - " + theId);
        }
        return theCustomer;
    }

    @Override
    public void save(Customer theCustomer) {
        customerRepository.save(theCustomer);
    }

    @Override
    public void deleteById(int theId) {
        customerRepository.deleteById(theId);
    }
}
