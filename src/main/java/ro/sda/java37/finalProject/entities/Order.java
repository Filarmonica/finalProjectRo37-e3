package ro.sda.java37.finalProject.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "orders")
public class Order {
  @Id
  @GeneratedValue
  private Long id;
  private String userName;
  private Long totalCost;
  private String deliveryAddress;
  private String userAddress;
  private Date dateOfSubmission; // TBD
  @OneToMany(mappedBy = "order")
  private List<OrderLine> orderLine = new ArrayList<>();
  private Status status;
  @ManyToOne
  private User userClient;
}
