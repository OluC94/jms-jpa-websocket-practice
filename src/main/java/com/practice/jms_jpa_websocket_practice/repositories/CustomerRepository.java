package com.practice.jms_jpa_websocket_practice.repositories;

import java.util.List;

import com.practice.jms_jpa_websocket_practice.entities.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

    List<Customer> findByLastName(String lastName);

    Customer findById(long id);
}
