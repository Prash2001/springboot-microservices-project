/**
 * Repository interface for managing Inventory entities.
 * Extends JpaRepository to inherit basic CRUD operations.
 */
package com.java.inventoryservice.repository;

import com.java.inventoryservice.model.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface InventoryRepository extends JpaRepository<Inventory, Long> {

    List<Inventory> findByProductCodeIn(List<String> orderCodes);
}
