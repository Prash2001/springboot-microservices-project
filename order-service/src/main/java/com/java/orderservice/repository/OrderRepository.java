/**
 * Repository interface for managing Order entities.
 * Extends JpaRepository to inherit basic CRUD operations and querying capabilities.
 *
 * @see org.springframework.data.jpa.repository.JpaRepository
 */
package com.java.orderservice.repository;

import com.java.orderservice.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
