package ro.sda.java37.finalProject.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ro.sda.java37.finalProject.dto.OrderDto;
import ro.sda.java37.finalProject.entities.Order;
import ro.sda.java37.finalProject.exceptions.EntityNotFoundError;
import ro.sda.java37.finalProject.repository.OrderRepository;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class OrderService {
    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;

    public List<OrderDto> findAllOrders() {
        return orderRepository.findAll().stream().map(order -> orderMapper.convertToDto(order)).collect(Collectors.toList());
    }

    public OrderDto createOrder(OrderDto form) {
        Order order = orderMapper.convertToEntity(form);
        orderRepository.save(order);
        return form;
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
