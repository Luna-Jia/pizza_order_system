package edu.mejia.wcc.pizzaOrder6.dao;

import edu.mejia.wcc.pizzaOrder6.entity.Pizza;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PizzaRepository extends JpaRepository<Pizza,Integer> {



}
