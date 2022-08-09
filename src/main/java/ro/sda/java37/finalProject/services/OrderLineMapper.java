package ro.sda.java37.finalProject.services;

import ro.sda.java37.finalProject.dto.OrderLineDto;
import ro.sda.java37.finalProject.entities.Order;
import ro.sda.java37.finalProject.entities.OrderLine;
import ro.sda.java37.finalProject.repository.OrderLineRepository;

public class OrderLineMapper implements Mapper<OrderLine, OrderLineDto> {
    private final OrderLineRepository orderLineRepository;

    public OrderLineMapper(OrderLineRepository orderLineRepository) {
        this.orderLineRepository = orderLineRepository;
    }

    @Override
    public OrderLineDto convertToDto(OrderLine entity) {
        OrderLine orderLineForm = new OrderLine();
        orderLineForm.setId(entity.getId());
        return orderLineForm;
    }

    @Override
    public OrderLine convertToEntity(OrderLineDto dto) {
        OrderLine orderLine;
        if (dto.getId() != null) {
            orderLine = orderLineRepository.findById(dto.getId()).orElse(new OrderLine());
        } else {
            orderLine = new Order();
        }
        orderLine.setId(dto.getId());
        return orderLine;
    }
}
