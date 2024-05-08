package com.example.controller.spring.mvc.test.doa.Entities;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

@Entity
@Table(name = "Tasks")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProjectTask {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id

    private long id;

    @NotEmpty
    private String summary;
    private String acceptanceCriteria;
    private String status;

}
