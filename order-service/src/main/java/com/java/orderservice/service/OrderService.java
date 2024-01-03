/**
"""
This class represents the service layer for managing orders. It handles the logic for placing an order, checking inventory, and saving the order details.
 */
package com.java.orderservice.service;

import com.java.orderservice.dto.InventoryResponse;
import com.java.orderservice.dto.OrderItemsRequest;
import com.java.orderservice.dto.OrderRequest;
import com.java.orderservice.event.OrderPlacedEvent;
import com.java.orderservice.model.Order;
import com.java.orderservice.model.OrderItems;
import com.java.orderservice.repository.OrderRepository;
import io.micrometer.tracing.Span;
import io.micrometer.tracing.Tracer;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.el.parser.BooleanNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
@Slf4j
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private WebClient.Builder webClientBuilder;

    @Autowired
    private Tracer tracer;

    @Autowired
    private KafkaTemplate<String, OrderPlacedEvent> kafkaTemplate;

    //private RestTemplate restTemplate;

    
    public String placeOrder(OrderRequest orderRequest){
        Order order = new Order();
        order.setOrderNumber(UUID.randomUUID().toString());
        order.setOrderItemsList(orderRequest.getOrderItems().stream().map(this::mapToDto).toList());
        List<String> productCodes =  orderRequest.getOrderItems().stream().map(OrderItemsRequest::getProductCode).toList();

        Span inventoryLookup = tracer.nextSpan().name("inventoryLookup");

        try(Tracer.SpanInScope spanInScope = tracer.withSpan(inventoryLookup.start())){
              InventoryResponse[] res = webClientBuilder.build().get().uri("http://inventory-service/api/inventory/", uriBuilder -> uriBuilder.queryParam("productCodes", productCodes).build()).retrieve().bodyToMono(InventoryResponse[].class).block();

            //InventoryResponse[] res = restTemplate.getForObject("http://inventory-service/api/inventory/", InventoryResponse[].class);
            boolean allProductsInStock =  Arrays.stream(res).allMatch(InventoryResponse::isInStock);
            if(allProductsInStock){
                orderRepository.save(order);
                kafkaTemplate.send("notificationTopic", new OrderPlacedEvent(order.getOrderNumber()));
                return "Order Placed Successfully!";
            }
            else{
                throw new IllegalArgumentException("Product is not in stock, Please try again!");
            }
        }
        /*catch (Exception exc){
            log.info("In catch block ***********");
            log.info("{}", exc.toString());
            return "In Catch Block";
        }*/
        finally {
            inventoryLookup.end();
        }
    }

    private OrderItems mapToDto(OrderItemsRequest orderItemsRequest) {
        OrderItems orderItem = new OrderItems();
        orderItem.setProductCode(orderItemsRequest.getProductCode());
        orderItem.setPrice(orderItemsRequest.getPrice());
        orderItem.setQuantity(orderItemsRequest.getQuantity());
        return orderItem;
    }
}
