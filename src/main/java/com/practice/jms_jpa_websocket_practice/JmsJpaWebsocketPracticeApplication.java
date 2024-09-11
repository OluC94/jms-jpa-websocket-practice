package com.practice.jms_jpa_websocket_practice;

import com.practice.jms_jpa_websocket_practice.entities.Customer;
import com.practice.jms_jpa_websocket_practice.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class JmsJpaWebsocketPracticeApplication {

	@Autowired
	CustomerRepository customerRepository;

	public static void main(String[] args) {

		SpringApplication.run(JmsJpaWebsocketPracticeApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner() {
		return args -> {
			customerRepository.save(new Customer("John", "Doe"));
			customerRepository.save(new Customer("Jane", "Doe"));
			customerRepository.save(new Customer("Harry", "Kane"));
			customerRepository.save(new Customer("Sarah", "Smith"));
		};
	}

}
