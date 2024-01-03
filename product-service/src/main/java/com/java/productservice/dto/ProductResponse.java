/**
 * Represents a response object for a product.
 * This class is used to transfer product information between different layers of the application.
 *
 * @param id          The unique identifier of the product.
 * @param name        The name of the product.
 * @param description The description of the product.
 * @param price       The price of the product.
 */
package com.java.productservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductResponse implements Serializable {
    private String id;
    private String name;
    private String description;
    private Long price;
}
