package ro.sda.java37.finalProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.sda.java37.finalProject.entities.OrderLine;

public interface OrderLineRepository extends JpaRepository<OrderLine, Long> {
}
