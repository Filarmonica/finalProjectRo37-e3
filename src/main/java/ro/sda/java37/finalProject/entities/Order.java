package ro.sda.java37.finalProject.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@AllArgsConstructor
@Getter
@Setter
public class Order {
    private String userName;
    private Long totalCost;
    private String deliveryAddress;
    private String userAddress;
    private Date dateOfSubmission;
    private OrderLine orderLine;

}