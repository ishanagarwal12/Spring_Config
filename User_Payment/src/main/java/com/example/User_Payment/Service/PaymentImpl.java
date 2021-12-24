package com.example.User_Payment.Service;
import com.example.User_Payment.Entity.PaymentEntity;
import com.example.User_Payment.Entity.PaymentRepository;
import com.example.User_Payment.Model.DTO;
import com.example.User_Payment.Model.OrderEntity;
import com.example.User_Payment.Model.PaymentRequest;
import com.example.User_Payment.Model.PaymentResponse;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
//import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.UUID;

@Service
public class PaymentImpl implements  PaymentImpService {
    @Autowired
    private PaymentRepository repository;


    @Override
    public PaymentEntity paymentData(List<OrderEntity> orderEntity) {
        DTO userDTO=new ModelMapper().map(orderEntity,DTO.class);
        userDTO.setTid(UUID.randomUUID().toString());
        userDTO.setOrderEntity(orderEntity);
        PaymentEntity paymentEntity=new ModelMapper().map(userDTO,PaymentEntity.class);
        repository.save(paymentEntity);
        return paymentEntity;
    }
}

