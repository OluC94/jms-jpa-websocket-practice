package com.practice.jms_jpa_websocket_practice.utils;

import com.practice.jms_jpa_websocket_practice.entities.Customer;
import org.springframework.jms.core.JmsTemplate;


public class Utils {

    private Utils(){}

    public static void sendNewCustomerMessage(JmsTemplate jmsTemplate, Customer customer) {
        final String DESTINATION = "customer";

        jmsTemplate.convertAndSend(DESTINATION, customer.toString());
        System.out.println("New customer: " + customer);
    }


}
