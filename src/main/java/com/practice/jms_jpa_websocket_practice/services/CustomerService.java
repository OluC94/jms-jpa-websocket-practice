package com.practice.jms_jpa_websocket_practice.services;

import com.practice.jms_jpa_websocket_practice.entities.Customer;
import com.practice.jms_jpa_websocket_practice.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    public List<Customer> getAllCustomers(){
        List<Customer> customers = new ArrayList<>();
        customerRepository.findAll().forEach(customers::add);
        return customers;
    }

    public Customer getCustomerById(long id){
        return customerRepository.findById(id);
    }

    public Customer saveCustomer(Customer customer){

        return customerRepository.save(customer);
    }

    public String deleteCustomer(long id){
        customerRepository.deleteById(id);
        return "Customer with id: " + id + " deleted";
    }

}
