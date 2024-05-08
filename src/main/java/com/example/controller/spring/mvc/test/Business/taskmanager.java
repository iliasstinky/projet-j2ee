package com.example.controller.spring.mvc.test.Business;

import com.example.controller.spring.mvc.test.doa.Entities.Product;
import com.example.controller.spring.mvc.test.doa.Entities.ProjectTask;
import com.example.controller.spring.mvc.test.doa.repositories.ProjectTaskrepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service

public class taskmanager implements taskmanagerrepo {


    @Autowired
    private ProjectTaskrepo rp;

    @Autowired
    private taskmanagerrepo taskmanagerrepo;


    @Override
    public List<ProjectTask> projecttaskshow() {

        List<ProjectTask> list_projectTask = rp.findAll();
            return  list_projectTask;



    }

    @Override
    public ProjectTask getProjecttaskbyId(int id) {

        return rp.findById(id);
    }

    @Override
    public boolean deleteTaskbyid(int id) {
        try {
            rp.deleteById(id);
            return true;
        } catch (Exception exception) {
            return false;
        }
    }

}
