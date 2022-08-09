package ro.sda.java37.finalProject.services;

import ro.sda.java37.finalProject.dto.OrderDto;
import ro.sda.java37.finalProject.entities.Order;
import ro.sda.java37.finalProject.exceptions.EntityNotFoundError;
import ro.sda.java37.finalProject.repository.OrderRepository;

import java.util.List;
import java.util.stream.Collectors;

public class OrderService {
    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;

    public OrderService(OrderRepository orderRepository, OrderMapper orderMapper) {
        this.orderRepository = orderRepository;
        this.orderMapper = orderMapper;
    }

    public List<OrderDto> findAllOrders() {
        return orderRepository.findAll().stream().map(order -> orderMapper.convertToDto(order)).collect(Collectors.toList());
    }

    public void createOrder(OrderDto form) {
        Order order = orderMapper.convertToEntity(form);
        orderRepository.save(order);
    }

    public OrderDto findById(long id) {
        Order entityOrder =orderRepository.findById(id).orElseThrow(() -> new EntityNotFoundError(String.format("Order with %s does not exist", id)));
        return orderMapper.convertToDto(entityOrder);
    }

    public void deleteById(long id) {
        orderRepository.findById(id).orElseThrow(() -> new EntityNotFoundError(String.format("Order with %s does not exist", id)));
        orderRepository.deleteById(id);
    }
}
