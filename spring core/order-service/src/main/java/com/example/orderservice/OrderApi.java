package com.example.orderservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController 
public class OrderApi {
    @GetMapping ("/order/{pid}/{q}")
    public Order order( @PathVariable int pid,
         @PathVariable  int q){
            String url="http://localhost:8001/api/products/"+pid;
            RestTemplate template=new RestTemplate();
            Order order= template.getForObject(url, Order.class);
            return order;
    }
    @Autowired 
    private RestTemplate template;
     @GetMapping ("/order/loadbal/{pid}/{q}")
    public Order orderLoadBalancing( @PathVariable int pid,
         @PathVariable  int q){
            String url="http://product-service/api/products/"+pid;
            Order order= template.getForObject(url, Order.class);
            return order;
    }
    @Autowired 
    private ProductServiceProxy proxy;

     @GetMapping ("/order/feign/{pid}/{q}")
    public Order orderFeign( @PathVariable int pid,
         @PathVariable  int q){
            Order order= proxy.getProduct(pid);
            order.setQuantity(q);
            order.setPrice(order.getPrice()*q);
         return order;
    } 
}
