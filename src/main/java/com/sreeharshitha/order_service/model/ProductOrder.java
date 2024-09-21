package com.sreeharshitha.order_service.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer orderId;
    private String username;
    private LocalDate orderDate;
   // private Double totalAmount;
    private String orderStatus;




    @ElementCollection
    private List<Integer> productIds;
}
