package edu.mejia.wcc.pizzaOrder6.service;

import edu.mejia.wcc.pizzaOrder6.dao.PizzaRepository;
import edu.mejia.wcc.pizzaOrder6.entity.Pizza;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PizzaServiceImpl implements PizzaService{

    private PizzaRepository pizzaRepository;

    @Autowired
    public PizzaServiceImpl(PizzaRepository thePizzaRepository) {
        this.pizzaRepository = thePizzaRepository;
    }

    @Override
    public List<Pizza> findAll() {
        return pizzaRepository.findAll();
    }

    @Override
    public Pizza findById(int id) {
        Optional<Pizza> result = pizzaRepository.findById(id);

        Pizza thePizza = null;
        if (result.isPresent()){
            thePizza = result.get();
        } else {
            // we didn't find the customer
            throw new RuntimeException("Did not find pizza id - " + id);
        }
        return thePizza;
    }

    @Override
    public void save(Pizza thePizza) {
        pizzaRepository.save(thePizza);

    }

    @Override
    public void deleteById(int theId) {
        pizzaRepository.deleteById(theId);

    }
}
