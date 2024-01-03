/**
 * This class contains unit tests for the ProductServiceApplication.
 * It tests the functionality of creating a product, fetching all products, and fetching a product by its ID.
 * The tests are performed using a mocked MVC environment and a MongoDB container for testing the database operations.
 * 
 * @see ProductServiceApplication
 */
package com.java.productservice;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.java.productservice.dto.ProductRequest;
import com.java.productservice.model.Product;
import com.java.productservice.repository.ProductRepository;
import org.junit.Before;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.testcontainers.containers.MongoDBContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.shaded.com.fasterxml.jackson.databind.ObjectMapper;
import org.testcontainers.utility.DockerImageName;

import java.math.BigDecimal;
import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@Testcontainers
@AutoConfigureMockMvc
class ProductServiceApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private com.fasterxml.jackson.databind.ObjectMapper objectMapper;

	@Autowired
	private ProductRepository productRepository;
	@Container
	static MongoDBContainer mongoDBContainer = new MongoDBContainer(DockerImageName.parse("mongo:5.0.21"));


	@DynamicPropertySource
	static  void setProperties(DynamicPropertyRegistry dynamicPropertyRegistry){
		dynamicPropertyRegistry.add("spring.data.mongodb.uri",mongoDBContainer::getReplicaSetUrl);
	}
	@Test
	void shouldCreateProduct() throws Exception {
		ProductRequest productRequest = getProductRequest();
		String req = objectMapper.writeValueAsString(productRequest);
		mockMvc.perform(MockMvcRequestBuilders.post("/api/product").contentType(MediaType.APPLICATION_JSON).content(req)).andExpect(status().isCreated());
		Assertions.assertEquals(2, productRepository.findAll().size());
	}

	@Test
	void shouldFetchAllProducts() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/api/product").contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
		Assertions.assertEquals(1, productRepository.findAll().size());
	}

	@Test
	void shouldFetchProductById() throws Exception {
		List<Product> testProducts = productRepository.findAll();
		if (testProducts.isEmpty()) {
			Assertions.fail("No products found in the database to test fetching by ID.");
		}
		Product testProduct = testProducts.get(0);
		mockMvc.perform(MockMvcRequestBuilders.get("/api/product/"+testProduct.getId()).contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
		Assertions.assertEquals(1, productRepository.findAll().size());
	}

	private ProductRequest getProductRequest() {
		return ProductRequest.builder()
				.name("Iphone-15")
				.description("Iphone-15")
				.price(150000L).build();
	}

	@BeforeEach
	public void createMockData(){
		Product product1 = new Product();
		product1.setName("TestProduct1");
		product1.setPrice(100L);
		product1.setDescription("Dummy Product");
		productRepository.save(product1);
	}

	@AfterEach
	public void cleanUp(){
		productRepository.deleteAll();
	}

}
