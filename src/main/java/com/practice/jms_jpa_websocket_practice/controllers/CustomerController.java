package com.practice.jms_jpa_websocket_practice.controllers;

import com.practice.jms_jpa_websocket_practice.entities.Customer;
import com.practice.jms_jpa_websocket_practice.services.CustomerService;
import com.practice.jms_jpa_websocket_practice.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @Autowired
    JmsTemplate jmsTemplate;

    @GetMapping("/customers")
    public List<Customer> getCustomers() {
        return customerService.getAllCustomers();
    }

    @GetMapping("/customers/{id}")
    public Customer getCustomer(@PathVariable long id) {
        return customerService.getCustomerById(id);
    }

    @PostMapping("customer")
    public Customer createCustomer(@RequestParam String firstName, @RequestParam String lastName) {
        Customer customer = new Customer(firstName, lastName);
        Utils.sendNewCustomerMessage(jmsTemplate, customer);
        return customerService.saveCustomer(customer);
    }

    @DeleteMapping("/customers/{id}")
    public String deleteCustomer(@PathVariable long id) {
        return customerService.deleteCustomer(id);
    }
}
