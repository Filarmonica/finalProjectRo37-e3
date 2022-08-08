package ro.sda.java37.finalProject.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.util.Date;
@AllArgsConstructor
@Getter
@Setter

@Entity
@Data
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

}