package ro.sda.java37.finalProject.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ro.sda.java37.finalProject.dto.OrderDto;
import ro.sda.java37.finalProject.entities.Order;
import ro.sda.java37.finalProject.repository.OrderRepository;

@AllArgsConstructor
@Service
public class OrderMapper implements Mapper<Order, OrderDto> {
  private final OrderRepository orderRepository;

  @Override
  public OrderDto convertToDto(Order entity) {
    OrderDto orderForm = new OrderDto();
    orderForm.setId(entity.getId());
    orderForm.setUserName(entity.getUserName());
    orderForm.setTotalCost(entity.getTotalCost());
    orderForm.setDeliveryAddress(entity.getDeliveryAddress());
    orderForm.setUserAddress(entity.getUserAddress());
    orderForm.setDateOfSubmission(entity.getDateOfSubmission());
//        orderForm.setOrderLine(entity.getOrderLine());
    orderForm.setStatus(entity.getStatus());
    orderForm.setUserClient(entity.getUserClient());
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
    order.setUserName(dto.getUserName());
    order.setTotalCost(dto.getTotalCost());
    order.setDeliveryAddress(dto.getDeliveryAddress());
    order.setUserAddress(dto.getUserAddress());
    order.setDateOfSubmission(dto.getDateOfSubmission());
//        order.setOrderLine(dto.getOrderLine());
    order.setStatus(dto.getStatus());
    order.setUserClient(dto.getUserClient());
    return order;
  }
}
