package com.practice.jms_jpa_websocket_practice.controllers;

import com.practice.jms_jpa_websocket_practice.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerSender {

    @Autowired
    CustomerService customerService;

//    @GetMapping(value = "/customers")
//    public void sendCustomers() {
//
//    }

}
