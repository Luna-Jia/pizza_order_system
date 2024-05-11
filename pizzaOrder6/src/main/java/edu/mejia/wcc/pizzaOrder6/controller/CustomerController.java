package edu.mejia.wcc.pizzaOrder6.controller;

import edu.mejia.wcc.pizzaOrder6.entity.Customer;
import edu.mejia.wcc.pizzaOrder6.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/customers")
public class CustomerController {

    private CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;

    }

    // first page with 3 links
    @GetMapping("/linksPage")
    public String linkPage(Model theModel) {
        return "customers/linksPage";
    }

    // add mapping for "/list"
    @GetMapping("/list")
    public String listCustomers(Model theModel) {

        // get the customers from db
        List<Customer> theCustomers = customerService.findAll();

        // add to the spring model
        theModel.addAttribute("customers",theCustomers);

        return "customers/list-customers";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd (Model theModel) {

        // create model attribute to bind from data
        Customer theCustomer = new Customer();

        theModel.addAttribute("customer",theCustomer);

        return "customers/customer-form";

    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("customerId") int theId, Model theModel) {

        // get the customer from the service
        Customer theCustomer = customerService.findById(theId);

        // set customer in the model to prepopulate the form
        theModel.addAttribute("customer",theCustomer);

        // send over to our form
        return "customers/customer-form";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("customerId") int theId) {

        // delete the customer
        customerService.deleteById(theId);

        // redirect to the /customers/list
        return "redirect:/customers/list";
    }

    @PostMapping("/save")
    public String saveCustomer(@ModelAttribute("customer") Customer theCustomer) {

        // save the customer
        customerService.save(theCustomer);

        // use a redirect to prevent duplicate submission
        return "redirect:/customers/list";
    }


}
