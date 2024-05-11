package edu.mejia.wcc.pizzaOrder6.dao;

import edu.mejia.wcc.pizzaOrder6.entity.PizzaOrder;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PizzaOrderRepository extends JpaRepository<PizzaOrder, Integer> {

}
