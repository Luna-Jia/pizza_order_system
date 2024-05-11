package edu.mejia.wcc.pizzaOrder6.dao;

import edu.mejia.wcc.pizzaOrder6.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,Integer> {

}
