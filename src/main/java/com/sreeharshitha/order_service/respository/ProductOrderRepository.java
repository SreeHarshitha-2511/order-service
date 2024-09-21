package com.sreeharshitha.order_service.respository;


import com.sreeharshitha.order_service.model.ProductOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductOrderRepository extends JpaRepository<ProductOrder,Integer> {
}
