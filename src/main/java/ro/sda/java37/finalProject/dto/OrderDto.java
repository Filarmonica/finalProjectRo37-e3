package ro.sda.java37.finalProject.dto;

import lombok.Data;
import ro.sda.java37.finalProject.entities.OrderLine;
import ro.sda.java37.finalProject.entities.Status;
import ro.sda.java37.finalProject.entities.User;

import java.util.Date;

@Data
public class OrderDto {
  private Long id;
  private String userName;
  private Long totalCost;
  private String deliveryAddress;
  private String userAddress;
  private Date dateOfSubmission;
  private OrderLine orderLine;
  private Status status;
  private User userClient;
}
