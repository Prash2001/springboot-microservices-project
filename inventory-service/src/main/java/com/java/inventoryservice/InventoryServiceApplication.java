/**
 * The main class for the Inventory Service application.
 * This class initializes and runs the Spring Boot application.
 * It also contains a method to load initial data into the inventory repository.
 */
package com.java.inventoryservice;

import com.java.inventoryservice.model.Inventory;
import com.java.inventoryservice.repository.InventoryRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class InventoryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventoryServiceApplication.class, args);
	}

	@Bean
	public CommandLineRunner loadData(InventoryRepository inventoryRepository){
		return args ->{
			Inventory inventory = new Inventory();
			inventory.setProductCode("Iphone-14");
			inventory.setQuantity(10);

			Inventory inventory1 = new Inventory();
			inventory1.setProductCode("Iphone-14-red");
			inventory1.setQuantity(0);
			inventoryRepository.save(inventory);
			inventoryRepository.save(inventory1);
		};
	}
}
