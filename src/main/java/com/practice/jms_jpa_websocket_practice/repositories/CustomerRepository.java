package com.practice.jms_jpa_websocket_practice.repositories;

import com.practice.jms_jpa_websocket_practice.entities.Customer;

import java.util.List;

public interface CustomerRepository {

    List<Customer> findByLastName(String lastName);

    Customer findById(long id);
}
