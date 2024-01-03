/**
 * Controller class for managing inventory-related operations.
 */
package com.java.inventoryservice.controller;

import com.java.inventoryservice.dto.InventoryResponse;
import com.java.inventoryservice.service.InventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/inventory")
@RequiredArgsConstructor
public class InventoryController {

    private  final InventoryService inventoryService;
    @GetMapping("/")
    @ResponseStatus(HttpStatus.OK)
    public List<InventoryResponse> isInStock(@RequestParam List<String> productCodes){
        return inventoryService.isInStock(productCodes);
    }


}
