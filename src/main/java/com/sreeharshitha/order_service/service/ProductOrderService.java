package com.sreeharshitha.order_service.service;

import com.sreeharshitha.order_service.feign.OrderFeign;
import com.sreeharshitha.order_service.model.Product;
import com.sreeharshitha.order_service.model.ProductOrder;
import com.sreeharshitha.order_service.respository.ProductOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductOrderService {

    @Autowired
    ProductOrderRepository orderRepository;

    @Autowired
    OrderFeign orderFeign;


    public ResponseEntity<String> addOrder(ProductOrder order) {
       orderRepository.save(order);
        return new ResponseEntity<>("created order",HttpStatus.CREATED);
    }

    public ResponseEntity<List<ProductOrder>> getAllOrders() {
        return new ResponseEntity<>(orderRepository.findAll(),HttpStatus.OK);
    }

    public ResponseEntity<ProductOrder> getOrderById(Integer id) {
        return new ResponseEntity<>(orderRepository.findById(id).get(),HttpStatus.OK);

    }

    public ResponseEntity<List<Product>> getProductDetailsByOrderId(Integer id) {
        ProductOrder order=orderRepository.findById(id).get();
        List<Integer> productIds=order.getProductIds();
        return orderFeign.getProductsById(productIds);


    }

    public ResponseEntity<Double> getScorebyOrderId(Integer id) {
        ProductOrder order=orderRepository.findById(id).get();
        List<Integer> productIds=order.getProductIds();
        return orderFeign.getAmount(productIds);

    }
}
