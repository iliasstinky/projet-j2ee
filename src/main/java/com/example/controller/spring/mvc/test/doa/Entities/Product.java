package com.example.controller.spring.mvc.test.doa.Entities;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

@Entity
@Table(name = "products")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Data


public class Product {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)

  int id ;
  @NotEmpty
  @Size(max = 100)
    String description;

    int price;

    @NotNull
    @Min(0)
    int quantity;



}
