package com.practice.jms_jpa_websocket_practice.controllers;

import com.practice.jms_jpa_websocket_practice.entities.Customer;
import com.practice.jms_jpa_websocket_practice.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

@Component
public class CustomerWebSocketHandler extends TextWebSocketHandler {
    private final List<WebSocketSession> sessions = new CopyOnWriteArrayList<>();
    private final Map<Long, Customer> customers = new ConcurrentHashMap<>();

    @Autowired
    CustomerRepository customerRepository;

    public CustomerWebSocketHandler() {
        // for each customer in the database, add {customer.id: customer} to the map

    }
}
