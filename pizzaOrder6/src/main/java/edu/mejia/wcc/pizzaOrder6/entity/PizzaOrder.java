package edu.mejia.wcc.pizzaOrder6.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "pizza_order")
public class PizzaOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @OneToMany(fetch = FetchType.EAGER,mappedBy = "pizzaOrder", cascade = {CascadeType.ALL})
    private List<Pizza> pizzas = new ArrayList<Pizza>();

    public PizzaOrder() {
    }

    public PizzaOrder(Customer customer) {
        this.customer = customer;
    }

    public PizzaOrder(int id, Customer customer, List<Pizza> pizzas) {
        this.id = id;
        this.customer = customer;
        this.pizzas = pizzas;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<Pizza> getPizzas() {
        return pizzas;
    }

    public void setPizzas(List<Pizza> pizzas) {
        this.pizzas = pizzas;
    }

    public int getCustomerId() {
        return customer.getId();
    }

    @Override
    public String toString() {
        return "PizzaOrder{" +
                "id=" + id +
                ", customer=" + customer +
                ", pizzas=" + pizzas +
                '}';
    }

    public void add(Pizza tempPizza) {
        if (pizzas == null) {
            pizzas = new ArrayList<>();
        }

        pizzas.add(tempPizza);

        tempPizza.setPizzaOrder(this);
    }
}
