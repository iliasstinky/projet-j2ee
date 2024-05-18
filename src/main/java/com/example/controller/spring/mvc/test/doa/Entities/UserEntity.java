package com.example.controller.spring.mvc.test.doa.Entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Entity
@Table(name = "users")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder


public class UserEntity{
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)

private Long id ;

private String username;

private String password;

    private String name;


    private String role;




}