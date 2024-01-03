/**
 * Represents an item in an order.
 *
 * This class is an entity mapped to the "orderItems" table in the database.
 * It contains information about the price, quantity, and product code of the item.
 *
 * @param id The unique identifier of the order item.
 * @param price The price of the item.
 * @param quantity The quantity of the item.
 * @param productCode The code of the product associated with the item.
 */
package com.java.orderservice.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name="`orderItems`")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderItems {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private BigDecimal price;
    private int quantity;
    private String productCode;
}
