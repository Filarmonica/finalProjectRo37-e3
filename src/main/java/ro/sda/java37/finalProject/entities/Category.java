package ro.sda.java37.finalProject.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Category {
  @Id
  @GeneratedValue
  private Long id;
  @ManyToOne
  @JoinColumn(name = "parent_category_id")
  private Category parentCategory;
  @OneToMany(mappedBy = "parentCategory")
  private List<Category> subCategories = new ArrayList<>();
  private String name;
  private String description;
}



