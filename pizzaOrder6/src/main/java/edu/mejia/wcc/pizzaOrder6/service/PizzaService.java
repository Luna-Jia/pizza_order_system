package edu.mejia.wcc.pizzaOrder6.service;

import edu.mejia.wcc.pizzaOrder6.entity.Pizza;

import java.util.List;

public interface PizzaService {

    List<Pizza> findAll();

    Pizza findById(int id);

    void save(Pizza thePizza);

    void deleteById(int theId);


}
