package ro.sda.java37.finalProject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ro.sda.java37.finalProject.repository.UserRepository;
import ro.sda.java37.finalProject.services.ProductService;
import ro.sda.java37.finalProject.services.UserService;

@SpringBootApplication
public class FinalProjectApplication {

    public static void main(String[] args) {
      SpringApplication.run(FinalProjectApplication.class, args);
    }
}
