package com.example.User_OrderService.Controller;
import com.example.User_OrderService.Entity.*;
import com.example.User_OrderService.Model.*;
import com.example.User_OrderService.ServiceImp.OrderImpl;
import com.example.User_OrderService.Shared.UserEntity;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.Type;
import java.util.List;
@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private Environment env;
    @Autowired
    private OrderImpl orderService;
    @Autowired
    private ItemRepository itemRepository;

    @GetMapping("/status")
    public String getStatus() {
        return "Working on Port " + env.getProperty("local.server.port");

    }

    @Autowired
    private ItemRepository repository;
    @Autowired
    OrderImpl service;
    @Autowired
    private MongoTemplate mongoTemplate;
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private MongoOperations mongoOperations;
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private FeignClient client;


    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            path = "/{fname}/{itemName}")
    public OrderEntity itemsListed(@PathVariable("fname") String fname, @PathVariable ("itemName") String itemName
    ,@RequestBody DTO ud) {
        List<UserEntity> list = client.getByfName(fname);
        List<ListItems>listItemsList=repository.findAll();
        for(ListItems listItems:listItemsList) {
            if (listItems.getItemName().equals(itemName)) {
                ud.setItemName(itemName);
                ud.setFirstName(fname);
                ud.setItemCode(listItems.getItemCode());
                return service.checkoutOrder(list,ud);
            }
        }
        return null;
    }

    @GetMapping(produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE}, path = "/list")
    public List<ListItems> ListedItems() {
        return itemRepository.findAll();
    }

    @GetMapping(value = "/testDD", produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<String> doTest() {
        ResponseEntity<String> rv;
        rv = (restTemplate.getForEntity("http://UserDataDetail/abc/getAllUsers", String.class));
        return rv;
    }

    @GetMapping(produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE},
            path = "/getOrders/{orderId}")
    public Object getByOrder(@PathVariable int orderId) {
        OrderEntity list = findByOrderId(orderId);
        if (list != null)
            return list;
        else
            return new ResponseEntity<OrderEntity>(HttpStatus.NO_CONTENT);

    }
    @GetMapping(produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE},
            path = "/checkout/{firstName}")
    public ResponseEntity<List<OrderEntity>> orderCheckout(@PathVariable("firstName") String firstName) {
        List<OrderEntity> list = findByfName(firstName);

        if (list != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(list);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }
@GetMapping(produces = {MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE},
        path="/{fname}")
public List<UserEntity>test(@PathVariable String fname)
{
    return client.getByfName(fname);
}

    @GetMapping("/getAllOrders")
    public List<OrderEntity> getAllOrders(){
        return mongoTemplate.findAll(OrderEntity.class);
    }

@PostMapping(produces = {MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE},
        consumes = {MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE},
        path="/feedBack/{orderId}")
public String orderFeedBack(@PathVariable("orderId")int orderId,@RequestBody FeedBack ud){
        OrderEntity value=findByOrderId(orderId);
        if(value!=null){
            return service.feedBackOrder(ud,value);
        }
        else
        {
            return "Please Enter a Valid Order ID";
        }

}






    //Methods
    public ListItems findByName(String itemName){
        Query query=new Query();
        query.addCriteria(Criteria.where("itemName").is(itemName));
//      query.addCriteria(Criteria.where("itemCode").is(itemName));
        return  mongoTemplate.findOne(query,ListItems.class);
    }
    public OrderEntity findByOrderId(int orderId){
        Query query=new Query();
        query.addCriteria(Criteria.where("orderId").is(orderId));
        return mongoTemplate.findOne(query,OrderEntity.class);
    }
    public List<OrderEntity> findByfName(String firstName){
        Query query=new Query();
        query.addCriteria(Criteria.where("firstName").is(firstName));
        return  mongoTemplate.find(query,OrderEntity.class);
    }

}