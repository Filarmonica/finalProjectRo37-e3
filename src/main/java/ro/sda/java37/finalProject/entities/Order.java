package ro.sda.java37.finalProject.entities;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.util.Date;
@Entity
@Getter
@Setter
public class Order {
    @Id
    @GeneratedValue
    private Long id;
    private String userName;
    private Long totalCost;
    private String deliveryAddress;
    private String userAddress;
    private Date dateOfSubmission;
    @ManyToOne
    @JoinColumn
    private OrderLine orderLine;
    private Status status;
    @ManyToOne
    @JoinColumn(name = "user_client_id")
    private User userClient;

}