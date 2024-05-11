package edu.mejia.wcc.pizzaOrder6.controller;

import edu.mejia.wcc.pizzaOrder6.entity.Customer;
import edu.mejia.wcc.pizzaOrder6.entity.Pizza;
import edu.mejia.wcc.pizzaOrder6.entity.PizzaOrder;
import edu.mejia.wcc.pizzaOrder6.service.PizzaOrderService;
import edu.mejia.wcc.pizzaOrder6.service.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/pizzas")
public class PizzaController {

    private PizzaService pizzaService;
    private PizzaOrderService pizzaOrderService;

    @Autowired
    public PizzaController(PizzaService thePizzaService, PizzaOrderService thePizzaOrderService) {
        this.pizzaService = thePizzaService;
        this.pizzaOrderService = thePizzaOrderService;
    }

    @GetMapping("/addPizzaForm")
    public String addPizzaForm(Model theModel){

        Pizza thePizza = new Pizza();
        PizzaOrder theOrder = new PizzaOrder();
        theOrder.add(thePizza);
        Customer customer = new Customer();
        customer.add(theOrder);

        theModel.addAttribute("pizza",thePizza);

        return "pizzas/pizza-order-form";
    }

    @GetMapping("/listPizza")
    public String listPizzas(Model theModel) {

        // get the pizzas from db
        List<Pizza> thePizzas = pizzaService.findAll();


        // add to the spring model
        theModel.addAttribute("pizzas",thePizzas);

        return "pizzas/list-pizzas";
    }

    @GetMapping("/updatePizzaForm")
    public String updatePizzaForm(@RequestParam("pizzaId") int theId, Model theModel) {

        // get the pizza from the service
        Pizza thePizza = pizzaService.findById(theId);

        // set customer in the model to prepopulate the form
        theModel.addAttribute("pizza",thePizza);

        // send over to our form
        return "pizzas/pizza-order-form";
    }

    @GetMapping("/deletePizza")
    public String deletePizza(@RequestParam("pizzaId") int theId) {

        // delete the pizza
        pizzaService.deleteById(theId);

        // redirect to the /pizzas/listPizza
        return "redirect:/pizzas/listPizza";
    }

    @PostMapping("/savePizza")
    public String savePizza(@ModelAttribute("pizza") Pizza thePizza) {

        // save the pizza
        pizzaService.save(thePizza);

        PizzaOrder theOrder = new PizzaOrder();
        theOrder.add(thePizza);
        Customer customer = new Customer();
        customer.add(theOrder);
        pizzaOrderService.save(theOrder);


        // use a redirect to prevent duplicate submission
        return "redirect:/pizzas/listPizza";
    }

    @GetMapping("/orderPizzaForm")
    public String orderPizzaForm(Model theModel){

        PizzaOrder thePizzaOrder = new PizzaOrder();

        theModel.addAttribute("pizzaOrder",thePizzaOrder);

        return "pizzas/order-pizza-form";
    }

    @PostMapping("/savePizzaOrder")
    public String savePizzaOrder(@ModelAttribute("pizzaOrder") PizzaOrder thePizzaOrder) {

        // save the pizza order
        pizzaOrderService.save(thePizzaOrder);

        // use a redirect to prevent duplicate submission
        return "redirect:/orders/orderList?customerId=" + thePizzaOrder.getCustomerId();
    }

}
