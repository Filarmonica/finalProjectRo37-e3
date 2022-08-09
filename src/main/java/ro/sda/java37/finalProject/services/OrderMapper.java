package ro.sda.java37.finalProject.services;

import ro.sda.java37.finalProject.dto.OrderDto;
import ro.sda.java37.finalProject.entities.Order;
import ro.sda.java37.finalProject.repository.OrderRepository;

public class OrderMapper implements Mapper<Order, OrderDto> {
    private final OrderRepository orderRepository;

    public OrderMapper(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public OrderDto convertToDto(Order entity) {
        OrderDto orderForm = new OrderDto();
        orderForm.setId(entity.getId());
        return orderForm;
    }

    @Override
    public Order convertToEntity(OrderDto dto) {
        Order order;
        if (dto.getId() != null) {
            order = orderRepository.findById(dto.getId()).orElse(new Order());
        } else {
            order = new Order();
        }
        order.setId(dto.getId());
        return order;
    }
}
