package ro.sda.java37.finalProject.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ro.sda.java37.finalProject.dto.OrderLineDto;
import ro.sda.java37.finalProject.entities.OrderLine;
import ro.sda.java37.finalProject.repository.OrderLineRepository;

@AllArgsConstructor
@Service
public class OrderLineMapper implements Mapper<OrderLine, OrderLineDto> {
  private final OrderLineRepository orderLineRepository;

  @Override
  public OrderLineDto convertToDto(OrderLine entity) {
    OrderLineDto orderLineForm = new OrderLineDto();
    orderLineForm.setProduct(entity.getProduct());
    orderLineForm.setNumberOfProducts(entity.getNumberOfProducts());
    orderLineForm.setPrice(entity.getPrice());
    return orderLineForm;
  }

  @Override
  public OrderLine convertToEntity(OrderLineDto dto) {
    OrderLine orderLine;
    if (dto.getId() != null) {
      orderLine = orderLineRepository.findById(dto.getId()).orElse(new OrderLine());
    } else {
      orderLine = new OrderLine();
    }
    orderLine.setId(dto.getId());
    orderLine.setProduct(dto.getProduct());
    orderLine.setNumberOfProducts(dto.getNumberOfProducts());
    orderLine.setPrice(dto.getPrice());
    return orderLine;
  }
}
