package ro.sda.java37.finalProject.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ro.sda.java37.finalProject.enums.Status;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
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
  @NotEmpty
  private String userName;
  private Long totalCost;
  @NotEmpty
  private String deliveryAddress;
  @NotEmpty
  private String userAddress;
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM/dd/yyyy")
  private Date dateOfSubmission;
  @OneToMany(mappedBy = "order")
  private List<OrderLine> orderLine = new ArrayList<>();
  private Status status;
  @ManyToOne
  private User userClient;
}
