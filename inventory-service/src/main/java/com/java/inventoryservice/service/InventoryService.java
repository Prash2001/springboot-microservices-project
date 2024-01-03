/**
 * Service class for managing inventory related operations.
 */
package com.java.inventoryservice.service;

import com.java.inventoryservice.dto.InventoryResponse;
import com.java.inventoryservice.model.Inventory;
import com.java.inventoryservice.repository.InventoryRepository;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class InventoryService {
    private final InventoryRepository inventoryRepository;

    @Transactional(readOnly = true)
    @SneakyThrows
    public List<InventoryResponse> isInStock(List<String> orderCodes){
//        log.info("Wait Started");
//        Thread.sleep(10000);
//        log.info("Wait Ended");
       return inventoryRepository.findByProductCodeIn(orderCodes).stream().map(this::mapToDto).toList();
    }

    private InventoryResponse mapToDto(Inventory inventory) {
        InventoryResponse inventoryResponse = new InventoryResponse();
        inventoryResponse.setInStock(inventory.getQuantity()>0);
        inventoryResponse.setProductCode(inventory.getProductCode());
        return inventoryResponse;
    }
}
