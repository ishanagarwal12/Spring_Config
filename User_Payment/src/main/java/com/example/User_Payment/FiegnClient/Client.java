package com.example.User_Payment.FiegnClient;

import com.example.User_Payment.Entity.PaymentEntity;
import com.example.User_Payment.Model.OrderEntity;
import com.example.User_Payment.Model.PaymentResponse;
import org.aspectj.weaver.ast.Or;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


import java.util.List;

@FeignClient(url = "http://192.168.29.106:8083/order/checkout",name = "OrderDetails")
public interface Client {

    @GetMapping("{firstName}")
    public List<OrderEntity> getByfName(@PathVariable ("firstName")String firstName);

}
