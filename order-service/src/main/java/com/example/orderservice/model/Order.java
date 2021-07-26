package com.example.orderservice.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "my_order_details_table")
@Data
@NoArgsConstructor
public class Order {
    @Id
    @GeneratedValue
    private Integer orderId;
    private String itemName;
    private String customerName;

    public Order(String itemName, String customerName) {
        this.itemName = itemName;
        this.customerName = customerName;
    }
}
