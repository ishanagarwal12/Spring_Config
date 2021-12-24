package com.example.UserDetails.Controller;

import com.ctc.wstx.msv.W3CMultiSchemaFactory;
import com.example.UserDetails.Entity.UserEntity;
import com.example.UserDetails.Entity.UserEntityRepository;
import com.example.UserDetails.Model.LoginRequestModel;
import com.example.UserDetails.Model.LoginResponseModel;
import com.example.UserDetails.Model.UserRequestModel;
import com.example.UserDetails.Model.UserResponseModel;

import com.example.UserDetails.ServiceIMp.UserServiceImp;
import com.example.UserDetails.Shared.DTO;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;


@RestController
@RequestMapping("/abc")
public class UserController {
    @Autowired
    private Environment env;
    @Autowired
    private UserServiceImp userService;
    @Autowired
    private MongoOperations mongoOperations;
    @Autowired private UserEntityRepository repository;
    @GetMapping("/user/check")
    public String StatusCheck() {
        return "Working";
    }
    @GetMapping("/user/status")
    public String PortCheck() {
   return "Working on Port " + env.getProperty("local.server.port");
    }
    @PostMapping("/users/detail")
    public String test(){

        return "Working";

    }

    @PostMapping (produces = {MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE},
            consumes = {MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE},path="/signup")
    public ResponseEntity<UserResponseModel> userCreate(@RequestBody UserRequestModel ud) {
        ModelMapper modelmapper = new ModelMapper();
        modelmapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        DTO userDto = modelmapper.map(ud, DTO.class);
        DTO createUser = userService.createUser(userDto);
        UserResponseModel userResponseModel = modelmapper.map(userDto, UserResponseModel.class);
        return ResponseEntity.status(HttpStatus.CREATED).body(userResponseModel);
    }
    @GetMapping(produces = {MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE},
            path="/getAllUsers")
    public List<UserEntity> allUsers(){
        List<UserEntity> list=repository.findAll();
        return list;
    }

@GetMapping(produces = {MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE},
        path="/{fname}")
    public List<UserEntity> getByfName(@PathVariable String fname){
    Query query=new Query();
    query.addCriteria(Criteria.where("fname").is(fname));
    return mongoOperations.find(query,UserEntity.class);

}

}
