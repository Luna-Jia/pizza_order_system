package edu.mejia.wcc.pizzaOrder6.service;

import edu.mejia.wcc.pizzaOrder6.dao.PizzaOrderRepository;
import edu.mejia.wcc.pizzaOrder6.entity.Pizza;
import edu.mejia.wcc.pizzaOrder6.entity.PizzaOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PizzaOrderServiceImpl implements PizzaOrderService{

    private PizzaOrderRepository pizzaOrderRepository;

    @Autowired
    public PizzaOrderServiceImpl(PizzaOrderRepository thePizzaOrderRepository) {
        this.pizzaOrderRepository = thePizzaOrderRepository;
    }

    @Override
    public List<PizzaOrder> findAll() {
        return pizzaOrderRepository.findAll();
    }

    @Override
    public PizzaOrder findById(Integer id) {

        Optional<PizzaOrder> result = pizzaOrderRepository.findById(id);

        PizzaOrder thePizzaOrder = null;
        if (result.isPresent()){
            thePizzaOrder = result.get();
        } else {
            // we didn't find the customer
            throw new RuntimeException("Did not find pizza order id - " + id);
        }
        return thePizzaOrder;
    }

    @Override
    public void save(PizzaOrder thePizzaOrder) {
        pizzaOrderRepository.save(thePizzaOrder);

    }

    @Override
    public void deleteById(int theId) {
        pizzaOrderRepository.deleteById(theId);

    }


}
