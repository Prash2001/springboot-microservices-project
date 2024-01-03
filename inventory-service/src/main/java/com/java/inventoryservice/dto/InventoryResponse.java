/**
 * Represents the response for an inventory request.
 * Contains information about the product code and its availability.
 */
package com.java.inventoryservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class InventoryResponse {
    private String productCode;
    private boolean isInStock;
}
