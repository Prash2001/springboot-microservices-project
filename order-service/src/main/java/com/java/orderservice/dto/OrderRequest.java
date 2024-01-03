/**
 * Represents a request to create an order.
 *
 * This class is used to transfer data from the client to the server when creating an order.
 * It contains a list of order items.
 *
 * @param orderItems The list of order items included in the order request.
 */
package com.java.orderservice.dto;

import com.java.orderservice.model.OrderItems;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderRequest {
    private List<OrderItemsRequest> orderItems;
}
