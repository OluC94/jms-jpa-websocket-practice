package com.practice.jms_jpa_websocket_practice.controllers;

import com.practice.jms_jpa_websocket_practice.entities.Customer;
import com.practice.jms_jpa_websocket_practice.repositories.CustomerRepository;
import com.practice.jms_jpa_websocket_practice.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

@Component
public class CustomerWebSocketHandler extends TextWebSocketHandler {
    private final List<WebSocketSession> sessions = new CopyOnWriteArrayList<>();
    private final Map<Long, Customer> customerMap = new ConcurrentHashMap<>();

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    CustomerService customerService;

    public CustomerWebSocketHandler() {

    }

    public void populateCustomerMap(){
        List<Customer> customers = customerService.getAllCustomers();
        for (Customer customer : customers) {
            customerMap.put(customer.getId(), customer);
        }
    }

    public void addCustomer(Customer customer) {
        // call this when a post is made
        customerMap.put(customer.getId(), customer);
    }

    public void broadcastUpdatedCustomers() throws IOException {
        TextMessage message = new TextMessage(customerMap.toString());
        for (WebSocketSession session : sessions) {
            session.sendMessage(message);
        }
    }

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws IOException {
        populateCustomerMap();
        sessions.add(session);
        session.sendMessage(new TextMessage(customerMap.toString()));
    }

//    @Override
//    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws IOException {
//        if ("UPDATE".equals(message.getPayload())) {
//            broadcastUpdatedCustomers();
//        }
//    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws IOException {
        sessions.remove(session);
    }



}
