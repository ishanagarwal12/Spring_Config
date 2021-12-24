package com.example.User_OrderService.ServiceImp;
import com.example.User_OrderService.Entity.*;

import com.example.User_OrderService.Model.CheckoutResponseModel;
import com.example.User_OrderService.Model.DTO;
import com.example.User_OrderService.Model.FeedBackRequestModel;
import com.example.User_OrderService.Model.OrderResponse;
import com.example.User_OrderService.Shared.UserEntity;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;


@Service
public class OrderService implements OrderImpl  {
@Autowired
    OrderRepository repository;
    @Autowired
    private SequenceGeneratorService orderIdSequenceGenerator;
@Autowired
private RestTemplate restTemplate;
    @Autowired
    MongoOperations mongoOperations;

@Autowired
private MongoTemplate mongoTemplate;


    @Override
    public OrderEntity checkoutOrder(List<UserEntity> list, DTO ud) {
        DTO orderDto=new ModelMapper().map(ud,DTO.class);
        orderDto.setUserEntity(list);
        orderDto.setItemName(ud.getItemName());
        orderDto.setOrderId(orderIdSequenceGenerator.getNextSequence(OrderEntity.sequence_name));
        orderDto.setQuantity(ud.getQuantity());
        orderDto.setItemCode(ud.getItemCode());
        orderDto.setAmount(ud.getAmount());
        DTO dto=new ModelMapper().map(orderDto,DTO.class);
        OrderEntity orderEntity=new ModelMapper().map(dto,OrderEntity.class);
        repository.save(orderEntity);
        return orderEntity;
    }

    @Override
    public String feedBackOrder(FeedBack ud, OrderEntity value){
        value.setFeedBack(ud);
        repository.save(value);
        return "FeedBack Saved ";

    }
}



