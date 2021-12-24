package com.example.User_Payment.Controller;
import com.example.User_Payment.Entity.PaymentEntity;
import com.example.User_Payment.Entity.PaymentRepository;
import com.example.User_Payment.FiegnClient.Client;
import com.example.User_Payment.Model.*;
import com.example.User_Payment.Service.PaymentImpService;
import org.aspectj.weaver.ast.Or;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.Iterator;
import java.util.List;
import java.util.Locale;

@RestController
//@EnableFeignClients
@RequestMapping("/payment")
public class PaymentController {
    @Autowired
    private Environment env;
    @Autowired
    private MongoTemplate mongoTemplate;
    @Autowired
    private PaymentImpService service;
    @Autowired
    private PaymentRepository repository;

    @Autowired
    private Client client;
    @GetMapping("/status")
    public String getStatus() {
        return "Working on Port " + env.getProperty("local.server.port");
    }


    @GetMapping(produces = {MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE},
            path="/getOrders/{firstName}")
    public PaymentEntity getPaymentDetails(@PathVariable String firstName){
    List<OrderEntity>list=client.getByfName(firstName);
    return service.paymentData(list);
//    for(OrderEntity orderEntity:list){
//        if(orderEntity.getFname().equals(fname))
//            return service.paymentData(orderEntity);
//        else
//            return null;
//    }
//        while(iterator.hasNext()){
//            OrderEntity orderEntity=iterator.next();
//            if(orderEntity.getFname().equals(fname))
//                return service.paymentData(orderEntity);
//            else
//                return null;
//        }

//    return client.paymentProcess(fname);
    }
    }
