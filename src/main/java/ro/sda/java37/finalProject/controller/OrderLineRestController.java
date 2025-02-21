package ro.sda.java37.finalProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ro.sda.java37.finalProject.dto.OrderLineDto;
import ro.sda.java37.finalProject.services.OrderLineService;

import java.util.List;

@RestController
@RequestMapping("/api/orderLine")
public class OrderLineRestController {

  @Autowired
  private OrderLineService orderLineService;

  @GetMapping
  public List<OrderLineDto> getAllOrderLines() {
    return orderLineService.findAllOrderLines();
  }

  @PostMapping
  public OrderLineDto createOrderLine(@RequestBody OrderLineDto orderLineDto) {
    return orderLineService.createOrderLine(orderLineDto);
  }

  @GetMapping("/delete/{id}")
  public void deleteOrderLineById(@PathVariable("id") Long id) {
    orderLineService.deleteById(id);
  }

  @PutMapping("/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void updateOrderLineById(@RequestBody OrderLineDto orderLineDto, @PathVariable Long id) {
    orderLineService.updateById(id, orderLineDto);
  }
}
