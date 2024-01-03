/**
 * Represents an inventory item.
 *
 * This class is an entity mapped to the "inventory" table in the database.
 * It contains information about the product code and quantity of the item.
 *
 * @Entity - Specifies that this class is an entity to be mapped to a database table.
 * @Table - Specifies the name of the table in the database.
 * @Getter - Generates getter methods for all fields.
 * @Setter - Generates setter methods for all fields.
 * @AllArgsConstructor - Generates a constructor with all fields as parameters.
 * @NoArgsConstructor - Generates a constructor with no parameters.
 */
package com.java.inventoryservice.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "inventory")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Inventory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String productCode;
    private Integer quantity;
}
