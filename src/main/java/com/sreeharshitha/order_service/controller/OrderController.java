package com.sreeharshitha.order_service.controller;


import com.sreeharshitha.order_service.model.Product;
import com.sreeharshitha.order_service.model.ProductOrder;
import com.sreeharshitha.order_service.service.ProductOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("order")
public class OrderController {

    @Autowired
    ProductOrderService orderService;

    @PostMapping("add")
    public ResponseEntity<String> addOrder(@RequestBody ProductOrder order){

        return orderService.addOrder(order);
    }

    @GetMapping("get")
    public ResponseEntity<List<ProductOrder>> getAllOrders(){
        return orderService.getAllOrders();
    }

    @GetMapping("get/{id}")
    public ResponseEntity<ProductOrder> getOrderById(@PathVariable Integer id){

        return orderService.getOrderById(id);
    }

    @GetMapping("getproductsDetailsByOrderId/{id}")
    public ResponseEntity<List<Product>> getProductDetailsByOrderId(@PathVariable Integer id ){
        return orderService.getProductDetailsByOrderId(id);
    }

    @GetMapping("getamount/{id}")
    public ResponseEntity<Double> getScorebyOrderId(@PathVariable Integer id){
        return orderService.getScorebyOrderId(id);
    }






}
