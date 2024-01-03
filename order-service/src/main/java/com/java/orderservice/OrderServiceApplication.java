/**
 * The main class for the Order Service application.
 * 
 * This class is responsible for starting the Order Service application.
 * It uses the Spring Boot framework and enables service discovery.
 * 
 * To start the application, run the main method in this class.
 */
package com.java.orderservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
public class OrderServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrderServiceApplication.class, args);
	}

}
