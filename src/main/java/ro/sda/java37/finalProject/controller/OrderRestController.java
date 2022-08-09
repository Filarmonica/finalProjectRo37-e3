package ro.sda.java37.finalProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ro.sda.java37.finalProject.dto.OrderDto;
import ro.sda.java37.finalProject.dto.ProductDto;
import ro.sda.java37.finalProject.services.OrderService;
import java.util.List;

@RestController
@RequestMapping("/api/order")
public class OrderRestController {
    @Autowired
    private OrderService orderService;
    @GetMapping
    public List<OrderDto> getAllOrders(){
        return orderService.findAllOrders();
    }
    @PostMapping
    public OrderDto createOrder(@RequestBody OrderDto orderDto){
        return orderService.createOrder(orderDto);
    }

}
