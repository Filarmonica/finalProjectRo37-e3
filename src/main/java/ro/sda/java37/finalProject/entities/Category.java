package ro.sda.java37.finalProject.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
@Entity
@Getter
@Setter

public class Category {
    @Id
    @GeneratedValue
    private Long id;
    @ManyToOne
    @JoinColumn(name = "parent_category_id")
    private Category parentCategory;

}



