package edu.mejia.wcc.pizzaOrder6.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="customer")
public class Customer {

    // field/attributes/colum
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    @Column(name = "street")
    private String street;

    @Column(name = "city")
    private String city;

    @Column(name="state")
    private String state;

    @Column(name = "zip")
    private String zip;

    @OneToMany(mappedBy = "customer",fetch = FetchType.EAGER,cascade = {CascadeType.ALL})
    private List<PizzaOrder> pizzaOrders = new ArrayList<PizzaOrder>();

    public Customer() {
    }

    public Customer(String firstName, String lastName, String street, String city, String state, String zip) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.street = street;
        this.city = city;
        this.state = state;
        this.zip = zip;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public List<PizzaOrder> getPizzaOrders() {
        return pizzaOrders;
    }

    public void setPizzaOrders(List<PizzaOrder> pizzaOrders) {
        this.pizzaOrders = pizzaOrders;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", zip='" + zip + '\'' +
                ", pizzaOrders=" + pizzaOrders +
                '}';
    }

    public void add(PizzaOrder tempPizzaOrder) {
        if (pizzaOrders == null) {
            pizzaOrders = new ArrayList<>();
        }

        pizzaOrders.add(tempPizzaOrder);

        tempPizzaOrder.setCustomer(this);
    }
}
