package com.example.controller.spring.mvc.test.doa.repositories;

import com.example.controller.spring.mvc.test.doa.Entities.ProjectTask;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectTaskrepo  extends JpaRepository<ProjectTask, Integer> {
    ProjectTask findById(int id);

}