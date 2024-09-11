package com.practice.jms_jpa_websocket_practice.services;

import com.practice.jms_jpa_websocket_practice.entities.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Service
public class CustomerSender {

    @Autowired
    JmsTemplate jmsTemplate;

    public static final String DESTINATION = "customer";

    public void sendMessage(Customer customer) {
        jmsTemplate.convertAndSend(DESTINATION, customer);
        System.out.println("Customer message sent: " + customer);
    }

}
