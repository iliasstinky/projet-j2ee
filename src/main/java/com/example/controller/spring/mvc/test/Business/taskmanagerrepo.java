package com.example.controller.spring.mvc.test.Business;

import com.example.controller.spring.mvc.test.doa.Entities.Product;
import com.example.controller.spring.mvc.test.doa.Entities.ProjectTask;

import java.util.List;

public interface taskmanagerrepo {

    public List<ProjectTask> projecttaskshow();


    public ProjectTask getProjecttaskbyId(int id);


    public boolean deleteTaskbyid(int id);



}
