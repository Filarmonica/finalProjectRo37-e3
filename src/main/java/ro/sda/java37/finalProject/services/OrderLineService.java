package ro.sda.java37.finalProject.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ro.sda.java37.finalProject.dto.OrderLineDto;
import ro.sda.java37.finalProject.entities.OrderLine;
import ro.sda.java37.finalProject.exceptions.EntityNotFoundError;
import ro.sda.java37.finalProject.repository.OrderLineRepository;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class OrderLineService {
    private final OrderLineRepository orderLineRepository;
    private final OrderLineMapper orderLineMapper;

    public List<OrderLineDto> findAllOrderLines() {
        return orderLineRepository.findAll().stream().map(orderLine -> orderLineMapper.convertToDto(orderLine)).collect(Collectors.toList());
    }

    public OrderLineDto createOrderLine(OrderLineDto form) {
        OrderLine orderLine = orderLineMapper.convertToEntity(form);
        orderLineRepository.save(orderLine);
        return form;
    }

    public OrderLineDto findById(long id) {
        OrderLine entityOrderLine =orderLineRepository.findById(id).orElseThrow(() -> new EntityNotFoundError(String.format("OrderLine with %s does not exist", id)));
        return orderLineMapper.convertToDto(entityOrderLine);
    }

    public void deleteById(long id) {
        orderLineRepository.findById(id).orElseThrow(() -> new EntityNotFoundError(String.format("OrderLine with %s does not exist", id)));
        orderLineRepository.deleteById(id);
    }
}
