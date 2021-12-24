package com.example.User_Payment.Service;
import com.example.User_Payment.Entity.PaymentEntity;
import com.example.User_Payment.Model.OrderEntity;

import java.util.List;

public interface PaymentImpService {
  PaymentEntity paymentData(List<OrderEntity> orderEntity);


//    ResponseEntity<PaymentResponse> ProcessPayment(DTO ud);
}
