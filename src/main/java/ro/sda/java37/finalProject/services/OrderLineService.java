package ro.sda.java37.finalProject.services;

import ro.sda.java37.finalProject.dto.OrderLineDto;
import ro.sda.java37.finalProject.entities.OrderLine;
import ro.sda.java37.finalProject.exceptions.EntityNotFoundError;
import ro.sda.java37.finalProject.repository.OrderLineRepository;
import java.util.List;

public class OrderLineService {
    private final OrderLineRepository orderLineRepository;
    private final OrderLineMapper orderLineMapper;

    public OrderLineService(OrderLineRepository orderLineRepository, OrderLineMapper orderLineMapper) {
        this.orderLineRepository = orderLineRepository;
        this.orderLineMapper = orderLineMapper;
    }

    public List<OrderLine> findAllOrderLines() {
        return orderLineRepository.findAll();
    }

    public void createOrderLine(OrderLineDto form) {
        OrderLine orderLine = orderLineMapper.convertToEntity(form);
        orderLineRepository.save(orderLine);
    }

    public OrderLineDto findById(long id) {
        OrderLine entityOrder =orderLineRepository.findById(id).orElseThrow(() -> new EntityNotFoundError(String.format("OrderLine with %s does not exist", id)));
        return orderLineMapper.convertToDto(entityOrderLine);
    }

    public void deleteById(long id) {
        orderLineRepository.findById(id).orElseThrow(() -> new EntityNotFoundError(String.format("OrderLine with %s does not exist", id)));
        orderLineRepository.deleteById(id);
    }
}
