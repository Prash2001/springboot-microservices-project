/**
 * Represents the response from the inventory service regarding the availability of a product.
 * Contains the product code and a flag indicating whether the product is in stock or not.
 *
 * @param productCode The code of the product
 * @param isInStock   Flag indicating whether the product is in stock or not
 */
package com.java.orderservice.dto;

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
