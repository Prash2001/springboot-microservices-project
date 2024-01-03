/**
 * The main class for the Product Service application.
 * 
 * This class is responsible for starting the Spring Boot application and enabling caching and service discovery.
 * 
 * The ProductServiceApplication class is annotated with @SpringBootApplication, which is a convenience annotation that combines 
 * @Configuration, @EnableAutoConfiguration, and @ComponentScan annotations. It enables the Spring Boot auto-configuration mechanism 
 * and component scanning for this application.
 * 
 * The @EnableCaching annotation enables caching support in the application. This allows methods to be annotated with caching 
 * annotations such as @Cacheable, @CachePut, and @CacheEvict to cache the results of method calls.
 * 
 * The @EnableDiscoveryClient annotation enables service discovery for this
 */
package com.java.productservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableCaching
public class ProductServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductServiceApplication.class, args);
	}

}
