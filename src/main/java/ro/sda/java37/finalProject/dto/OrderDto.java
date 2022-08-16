package ro.sda.java37.finalProject.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import ro.sda.java37.finalProject.entities.OrderLine;
import ro.sda.java37.finalProject.enums.Status;
import ro.sda.java37.finalProject.entities.User;

import javax.validation.constraints.NotEmpty;
import java.util.Date;

@Data
public class OrderDto {
  private Long id;
  @NotEmpty
  private String userName;
  private Long totalCost;
  @NotEmpty
  private String deliveryAddress;
  @NotEmpty
  private String userAddress;
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM/dd/yyyy")
  private Date dateOfSubmission;
  private OrderLine orderLine;
  private Status status;
  private User userClient;
}
