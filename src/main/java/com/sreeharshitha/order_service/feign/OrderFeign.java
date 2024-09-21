package com.sreeharshitha.order_service.feign;

import com.sreeharshitha.order_service.model.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient("PRODUCT-SERVICE")
public interface OrderFeign {
    @PostMapping("product/getproductsById")
    public ResponseEntity<List<Product>> getProductsById(@RequestBody List<Integer> productIds);

    @PostMapping("product/getamount")
    public ResponseEntity<Double> getAmount(@RequestBody List<Integer> productIds);



}
