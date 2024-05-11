package edu.mejia.wcc.pizzaOrder6.rest;

import edu.mejia.wcc.pizzaOrder6.dao.PizzaOrderRepository;
import edu.mejia.wcc.pizzaOrder6.entity.Customer;
import edu.mejia.wcc.pizzaOrder6.entity.Pizza;
import edu.mejia.wcc.pizzaOrder6.entity.PizzaOrder;
import edu.mejia.wcc.pizzaOrder6.service.PizzaOrderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class PizzaOrderRestController {

    // define endpoint for "/orders" - return a list of orders

    @GetMapping("/orders")
    public List<PizzaOrder> getOrders() {

        Customer tempCustomer1 = new Customer("Meng", "Jia","1234 Street","Ann Arbor","MI","48105");
        Customer tempCustomer2 = new Customer("Tom", "Estes","5678 Street","Orlando","FL","98760");

        List<PizzaOrder> theOrders = new ArrayList<>();
        PizzaOrder order1 = new PizzaOrder(tempCustomer1);
        PizzaOrder order2 = new PizzaOrder(tempCustomer2);


        Pizza tempPizza1 = new Pizza("Small","Onion");
        Pizza tempPizza2 = new Pizza("Party","Salami, Pepper, Chicken");
        Pizza tempPizza3 = new Pizza("Large","Beef, Olive");

        order1.add(tempPizza2);
        order2.add(tempPizza3);
        order1.add(tempPizza1);

        theOrders.add(order2);
        theOrders.add(order1);


        return theOrders;

    }
}
