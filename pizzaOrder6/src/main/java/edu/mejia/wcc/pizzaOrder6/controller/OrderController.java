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
@RequestMapping("/orders")
public class OrderController {
    private PizzaOrderService pizzaOrderService;
    private PizzaService pizzaService;


    @Autowired
    public OrderController(PizzaOrderService thePizzaOrderService, PizzaService thePizzaService) {
        this.pizzaOrderService = thePizzaOrderService;
        this.pizzaService = thePizzaService;
    }

    @GetMapping("/orderList")
    public String listOrders(Model theModel) {

        List<PizzaOrder> thePizzaOrders = pizzaOrderService.findAll();
        List<Pizza> thePizzas = pizzaService.findAll();


        // add to the spring model
        theModel.addAttribute("orders", thePizzaOrders);
        theModel.addAttribute("pizzas",thePizzas);

        return "orders/orders-form";
    }

    @GetMapping("/addOrderForm")
    public String addOrderForm(Model theModel) {

        // create model attribute to bind from data
        Customer theCustomer = new Customer();
        PizzaOrder thePizzaOrder = new PizzaOrder(theCustomer);
        Pizza thePizza = new Pizza();
        thePizzaOrder.add(thePizza);


        theModel.addAttribute("pizzaOrder", thePizzaOrder);
        //theModel.addAttribute("pizza", thePizza);
       // theModel.addAttribute("customer",theCustomer);

        return "orders/orders-form";

    }

    @GetMapping("/delete")
    public String delete(@RequestParam("orderId") int theId) {

        // delete the order
        pizzaOrderService.deleteById(theId);

        // redirect to the order list
        return "redirect:/orders/orderList";
    }

    @PostMapping("/save")
    public String saveOrder(@ModelAttribute("pizzaOrder") PizzaOrder thePizzaOrder,@ModelAttribute("pizza") Pizza thePizza) {

        // save the order
        pizzaOrderService.save(thePizzaOrder);
        pizzaService.save(thePizza);


        // use a redirect to prevent duplicate submission
        return "redirect:/orders/orderList";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("orderId") int theId, Model theModel) {

        // get the order from the service
        PizzaOrder thePizzaOrder = pizzaOrderService.findById(theId);

        // set pizza order in the model to prepopulate the form
        theModel.addAttribute("pizzaOrder", thePizzaOrder);

        // send over to our form
        return "orders/orders-form";
    }

}
