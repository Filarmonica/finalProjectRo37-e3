package ro.sda.java37.finalProject.dto;

import lombok.Data;
import ro.sda.java37.finalProject.entities.Status;
import java.util.Date;

@Data
public class OrderDto {
    private Long id;
    private String userName;
    private Long totalCost;
    private String deliveryAddress;
    private String userAddress;
    private Date dateOfSubmission;
    private OrderLineDto orderLine;
    private Status status;
}
