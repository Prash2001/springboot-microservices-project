/**
 * Represents a request for order items.
 * 
 * This class is used to transfer data related to order items between different layers of the application.
 * It contains information such as the price, quantity, and product code of an order item.
 * 
 * @param price The price of the order item.
 * @param quantity The quantity of the order item.
 * @param productCode The product code of the order item.
 */
package com.java.orderservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderItemsRequest {
    private BigDecimal price;
    private int quantity;
    private String productCode;
}
