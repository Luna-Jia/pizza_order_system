package edu.mejia.wcc.pizzaOrder6.service;

import edu.mejia.wcc.pizzaOrder6.entity.PizzaOrder;

import java.util.List;

public interface PizzaOrderService {

    List<PizzaOrder> findAll();

    PizzaOrder findById(Integer id);

    void save(PizzaOrder thePizzaOrder);

    void deleteById(int theId);



}
