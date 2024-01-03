/**
 * Configuration class for WebClient.
 * 
 * This class provides a bean for WebClient.Builder with LoadBalanced annotation.
 * 
 * The LoadBalanced annotation enables client-side load balancing for WebClient requests.
 * 
 * @return An instance of WebClient.Builder with load balancing enabled.
 */
package com.java.orderservice.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {

    @Bean
    @LoadBalanced
    public WebClient.Builder webClientBuilder(){

        return WebClient.builder();
    }

    /*@Bean
    @LoadBalanced
    public RestTemplate restTemplate(){

        return new RestTemplate();
    }*/
}
